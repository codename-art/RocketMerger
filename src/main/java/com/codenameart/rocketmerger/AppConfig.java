package com.codenameart.rocketmerger;

import com.codenameart.rocketmerger.q.DBQueue;
import com.codenameart.rocketmerger.q.DBWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Artem on 18.12.2017.
 */
@Configuration
public class AppConfig {

    @Bean
    @Scope("singleton")
    DBQueue dbQueue() {
        return new DBQueue(new LinkedBlockingQueue<>(1000));
    }

    @Bean
    DBWriter dbWriter() {
        return new DBWriter();
    }
}
