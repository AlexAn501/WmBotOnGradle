package ru.worldmac.wmbot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.worldmac.wmbot.feign.JavaRushClient;

@Configuration
public class FeignClientConfig {

    @Bean()
    public JavaRushClient javaRushClient() {
        JavaRushClient javaRushClient = FeignClientConfigBuilder.feignBuildJson(JavaRushClient.class);
        return javaRushClient;
    }
}
