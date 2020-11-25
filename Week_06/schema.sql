CREATE TABLE `t_product` (
  `id` varchar(36) NOT NULL,
	`product_no` varchar(32) DEFAULT NULL COMMENT '商品编号',
  `name` varchar(200) DEFAULT NULL COMMENT '商品名称',
  `brand` varchar(100) DEFAULT NULL COMMENT '品牌名称',
	`species` varchar(100) DEFAULT NULL COMMENT '分类',
	`storage` int(5) DEFAULT NULL COMMENT '库存',
	`img_url` varchar(200) DEFAULT NULL COMMENT '商品图片链接',
	`description` varchar(200) DEFAULT NULL COMMENT '商品描述',
  `create_by` varchar(45) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(45) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `delete_ind` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品';


CREATE TABLE `t_user` (
  `id` varchar(36) NOT NULL,
  `user_name` varchar(200) DEFAULT NULL COMMENT '用户名',
	`password` varchar(10) DEFAULT NULL COMMENT '密码',
	`nick_name` varchar(200) DEFAULT NULL COMMENT '昵称',
  `phone_number` varchar(11) DEFAULT NULL COMMENT '电话号码',
  `create_by` varchar(45) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(45) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `delete_ind` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户';

CREATE TABLE `t_order` (
  `id` varchar(36) NOT NULL,
	`order_no` varchar(36) DEFAULT NULL COMMENT '订单编号',
  `user_id` varchar(36) DEFAULT NULL COMMENT '用户id',
	`product_id` varchar(36) DEFAULT NULL COMMENT '商品id',
	`quality` int(3) DEFAULT NULL COMMENT '商品数量',
  `amount` decimal(18,2) DEFAULT NULL COMMENT '金额',
	`status` int(1) DEFAULT NULL COMMENT '订单状态',
	`remarks` int(1) DEFAULT NULL COMMENT '订单备注',
  `create_by` varchar(45) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(45) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `delete_ind` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单';

CREATE TABLE `t_order_logistics` (
  `id` varchar(36) NOT NULL,
  `order_id` varchar(255) DEFAULT NULL COMMENT '订单id',
  `status` varchar(10) DEFAULT NULL COMMENT '物流状态',
	`description` varchar(255) DEFAULT NULL COMMENT '物流信息',
  `create_by` varchar(45) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(45) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `delete_ind` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单物流';

CREATE TABLE `t_shopping_cart` (
  `id` varchar(36) NOT NULL,
	`user_id` varchar(36) DEFAULT NULL COMMENT '用户id',
  `product_id` varchar(36) DEFAULT NULL COMMENT '商品id',
  `quality` int(3) DEFAULT NULL COMMENT '数量',
  `create_by` varchar(45) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(45) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `delete_ind` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='购物车';