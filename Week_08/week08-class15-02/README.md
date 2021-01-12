作业：
设计对前面的订单表数据进行水平分库分表，拆分 2 个库，每个库 16 张表。并在新结构在演示常见的增删改查操作。代码、sql 和配置文件，上传到 Github。

首先在 shardingsphere 官网下载 ShardingSphere-Proxy 包，网址：https://www.apache.org/dyn/closer.cgi/shardingsphere/5.0.0-alpha/apache-shardingsphere-5.0.0-alpha-shardingsphere-proxy-bin.tar.gz
这个 tar 包解压后就可以使用。
我们这里使用的是 mysql，因此把 mysql-connector-java-8.0.21.jar 包（其他版本也可以）复制一份到上面解压文件的 lib 目录下，如果是用 postgresql，可以不用放。
接下来就是修改 conf 文件夹下的 config-sharding.yaml 和 server.yaml 文件。


config-sharding.yaml 文件内容

schemaName: sharding_db
dataSourceCommon:
  username: root
  password:
  connectionTimeoutMilliseconds: 30000
  idleTimeoutMilliseconds: 60000
  maxLifetimeMilliseconds: 1800000
  maxPoolSize: 50
  minPoolSize: 1
  maintenanceIntervalMilliseconds: 30000

dataSources:
  ds_0:
    url: jdbc:mysql://127.0.0.1:3306/ds_0?serverTimezone=UTC&useSSL=false
  ds_1:
    url: jdbc:mysql://127.0.0.1:3306/ds_1?serverTimezone=UTC&useSSL=false

rules:
- !SHARDING
  tables:
    t_order:
      actualDataNodes: ds_${0..1}.t_order_${0..15}
      tableStrategy:
        standard:
          shardingColumn: order_id
          shardingAlgorithmName: t_order_inline
      keyGenerateStrategy:
        column: order_id
        keyGeneratorName: snowflake
#    t_order_item:
#      actualDataNodes: ds_${0..1}.t_order_item_${0..1}
#      tableStrategy:
#        standard:
#          shardingColumn: order_id
#          shardingAlgorithmName: t_order_item_inline
#      keyGenerateStrategy:
#        column: order_item_id
#        keyGeneratorName: snowflake
#  bindingTables:
#    - t_order
  defaultDatabaseStrategy:
    standard:
      shardingColumn: order_id
      shardingAlgorithmName: database_inline
  defaultTableStrategy:
    none:
  
  shardingAlgorithms:
    database_inline:
      type: INLINE
      props:
        algorithm-expression: ds_${order_id % 2}
    t_order_inline:
      type: INLINE
      props:
        algorithm-expression: t_order_${order_id % 16}
#    t_order_item_inline:
#      type: INLINE
#      props:
 #       algorithm-expression: t_order_item_${order_id % 2}
  
  keyGenerators:
    snowflake:
      type: SNOWFLAKE
      props:
        worker-id: 123



server.yaml 文件内容
authentication:
  users:
    root:
      password: root
#    sharding:
#      password: sharding 
#      authorizedSchemas: sharding_db

props:
  max-connections-size-per-query: 1
  acceptor-size: 16  # The default value is available processors count * 2.
  executor-size: 16  # Infinite by default.
  proxy-frontend-flush-threshold: 128  # The default value is 128.
#    # LOCAL: Proxy will run with LOCAL transaction.
#    # XA: Proxy will run with XA transaction.
#    # BASE: Proxy will run with B.A.S.E transaction.
  proxy-transaction-type: LOCAL
  proxy-opentracing-enabled: false
  proxy-hint-enabled: false
  query-with-cipher-column: true
  sql-show: true
  check-table-metadata-enabled: false
  
这些文件，根据文档上注释来就可以，注释写的很清楚。

以上配置完成后，进入 bin 目录，执行 start.bat，ShardingSphere-Proxy 就启动成功了，默认端口是 3307。
在 cmd 控制台，执行 mysql -h127.0.0.1 -P3307 -uroot -proot，就可以进入 proxy 数据库了。

首先在数据库执行建表语句 

CREATE TABLE IF NOT EXISTS `t_order` (
    `order_id` int(11) NOT NULL,
    `user_id` int(11) NOT NULL,
    PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

此时，真正的数据库，ds_0,ds_1 也建好了16张表。插入数据时，ShardingSphere-Proxy 就根据我们分表的规则，向对应表插入数据。


