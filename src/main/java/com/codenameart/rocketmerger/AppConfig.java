package com.codenameart.rocketmerger;

import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Artem on 18.12.2017.
 */
@Configuration
public class AppConfig {

    @Bean
    DBService dbService() {
        return new DBService();
    }
}
