package com.cmcc.coc.gw.config;

import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
@Order(-Integer.MAX_VALUE)
public class ContextPathWebFilter implements WebFilter {
    private static final String CONTEXT_PATH = "/api";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getRawPath();
        if(path.startsWith(CONTEXT_PATH)){
            return chain.filter(exchange.mutate().request(request.mutate().contextPath(CONTEXT_PATH).build()).build());
        }
        return chain.filter(exchange);
    }
}
