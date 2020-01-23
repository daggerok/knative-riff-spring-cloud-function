package com.example.knativeriffspringcloudfunction;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;

@Log4j2
@SpringBootApplication
public class GwApplication {

    @Bean
    RouteLocator gw(RouteLocatorBuilder builder,
                    @Value("${app.host:127.0.0.1}") String appHost) {
        return builder.routes()
                      // // 1)
                      // .route("supplier",
                      //        r -> r.path("/supplier")
                      //              .uri(String.format("http://%s:8000", appHost)))
                      // // 2)
                      // .route("rewrite-api-supplier",
                      //        r -> r.path("/api/**")
                      //              .filters(f -> f.rewritePath("/api/supplier", "/supplier")
                      //                             .rewritePath("/api/consumer", "/consumer")
                      //                             .rewritePath("/api/function", "/function"))
                      //              .uri(String.format("http://%s:8000", appHost)))
                      // 3)
                      .route("rewrite",
                             r -> r.path("/api/**")
                                   .filters(f -> f.rewritePath("/api/(?<segment>.*)",
                                                               "/${segment}")
                                                  // .addResponseHeader("Content-Type",
                                                  //                    MediaType.APPLICATION_JSON_VALUE)
                                   )
                                   .uri(String.format("http://%s:8000", appHost)))
                      .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(GwApplication.class, args);
    }
}
