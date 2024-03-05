package dev.mritunjay.productservicettsmrngfeb24.configs;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {

//    Method
    @Bean
    public RestTemplate createRestTemplate()
    {
        return new RestTemplate();
    }
}
