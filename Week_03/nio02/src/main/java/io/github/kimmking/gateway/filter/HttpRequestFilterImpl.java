package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;

/**
 * @author wangtingting
 * @date 2020-11-06 21:21
 * -------------------------------------------------------------------------
 * Modified Date  Modified By   Why & What's modified
 * -------------------------------------------------------------------------
 */
public class HttpRequestFilterImpl implements HttpRequestFilter {

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx){
        if(fullRequest == null || fullRequest.headers() == null){
            return;
        }
        HttpHeaders httpHeaders =fullRequest.headers();
        httpHeaders.set("nio", "Tingting");
    }
}
