package io.kimmking.rpcfx.exception;

/**
 * @author wangtingting
 * @date 2021-02-26 17:19
 * -------------------------------------------------------------------------
 * Modified Date  Modified By   Why & What's modified
 * -------------------------------------------------------------------------
 */
public class RpcException extends RuntimeException {

    private String message;

    public RpcException(String message){
        this(message,null);
    }

    public RpcException(String message, Throwable cause) {
        super(message, cause);
    }
}
