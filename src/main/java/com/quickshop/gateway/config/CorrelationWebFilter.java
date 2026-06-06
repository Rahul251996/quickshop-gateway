package com.quickshop.gateway.config;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class CorrelationWebFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        String correlationId =
                exchange.getRequest()
                        .getHeaders()
                        .getFirst("X-Correlation-Id");

        if(correlationId == null) {
            correlationId =
                    UUID.randomUUID().toString();
        }

        exchange.getResponse()
                .getHeaders()
                .add(
                        "X-Correlation-Id",
                        correlationId);

        exchange.getRequest()
                .mutate()
                .header(
                        "X-Correlation-Id",
                        correlationId);

        MDC.put(
                "X-Correlation-Id",
                correlationId);

        return chain.filter(exchange);
    }
}
