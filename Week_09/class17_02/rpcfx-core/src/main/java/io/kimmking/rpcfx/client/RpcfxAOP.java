package io.kimmking.rpcfx.client;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author wangtingting
 * @date 2021-02-26 16:36
 * -------------------------------------------------------------------------
 * Modified Date  Modified By   Why & What's modified
 * -------------------------------------------------------------------------
 */
@Aspect
@Component
public class RpcfxAOP {

    @Pointcut("execution(public * io.kimmking.rpcfx.demo.api.*.*(..))")
    public void RpcfxAOP(){}


}
