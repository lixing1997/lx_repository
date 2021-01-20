package com.usian.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

@Component
public class RateLimitFilter extends ZuulFilter {
    private static final  RateLimiter RATE_LIMIT = RateLimiter.create(2);
    @Override
    public String filterType() {

        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;//数越小，优先级越高
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        if (!RATE_LIMIT.tryAcquire()){
            RequestContext rc = RequestContext.getCurrentContext();
            rc.setSendZuulResponse(false);//请求结束，不在向下响应
            rc.setResponseStatusCode(403);
            rc.setResponseBody("限流了，稍后再访问");//响应内容
            rc.getResponse().setContentType("text/html;charset=utf-8");
        }
        return null;
    }
}
