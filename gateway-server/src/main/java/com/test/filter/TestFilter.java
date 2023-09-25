package com.test.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 *  除了针对于某一个路由配置过滤器之外，我们也可以自定义全局过滤器，它能够作用于全局。
 *  但是我们需要通过代码的方式进行编写，比如我们要实现拦截没有携带指定请求参数的请求：
 * @author Jungle 
 * @version 2023/09/24 16:00
**/
@Component
public class TestFilter implements GlobalFilter { //需要注册为Bean
    @Override
    public Mono<Void> filter(ServerWebExchange exchange
            , GatewayFilterChain chain) {   //只需要实现此方法
        //先获取ServerHttpRequest对象，注意不是HttpServletRequest
        ServerHttpRequest request = exchange.getRequest();
        //打印一下所有的请求参数
        System.out.println(request.getQueryParams());
        //判断是否包含test参数，且参数值为1
        List<String> value = request.getQueryParams().get("test");
        if(value != null && value.contains("1")) {
            //将ServerWebExchange向过滤链的下一级传递（跟JavaWeb中介绍的过滤器其实是差不多的）
            return chain.filter(exchange);
        }else {
            //直接在这里不再向下传递，然后返回响应
            return exchange.getResponse().setComplete();
        }
    }
}
