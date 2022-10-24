package ru.worldmac.wmbot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.worldmac.wmbot.feign.JavaRushClient;

@Configuration
public class FeignClientConfig {

    @Bean()
    public JavaRushClient javaRushClient() {
        final String jrUrl = "https://javarush.ru/api/1.0/rest";
        JavaRushClient javaRushClient = FeignClientConfigBuilder.feignBuildJson(JavaRushClient.class, jrUrl);
        return javaRushClient;
    }
}
