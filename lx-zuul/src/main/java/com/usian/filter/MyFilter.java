package com.usian.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
@Component
public class MyFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //获取请求上下文
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest request = rc.getRequest();
        //获取表单中的token
        String token = request.getParameter("token");
        if (token==null){
            System.out.println("验证失败");
            rc.setSendZuulResponse(false);//代表请求结束
            rc.setResponseStatusCode(415);//添加一个响应码
            rc.setResponseBody("身份验证失败，请登录");//响应内容
            rc.getResponse().setContentType("text/html;charset=utf-8");// 响应类型

        }else {
            System.out.println("验证通过");
        }
        return null;
    }
}
