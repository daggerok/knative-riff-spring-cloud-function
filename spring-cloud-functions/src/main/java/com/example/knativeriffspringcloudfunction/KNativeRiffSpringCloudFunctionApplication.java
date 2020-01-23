package com.example.knativeriffspringcloudfunction;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Log4j2
@SpringBootApplication
public class KNativeRiffSpringCloudFunctionApplication {

    @Bean
    Function<Map<String, String>, Map<String, String>> function() {
        return request -> {
            log.info(request);
            String name = request.getOrDefault("name", "");
            return Collections.singletonMap("upper", name.toUpperCase());
        };
    }

    @Bean
    Consumer<Map<String, String>> consumer() {
        return log::info;
    }

    @Bean
    Supplier<Map<String, String>> supplier() {
        return () -> Collections.singletonMap("now", ZonedDateTime.now().toString());
    }

    public static void main(String[] args) {
        SpringApplication.run(KNativeRiffSpringCloudFunctionApplication.class, args);
    }
}
