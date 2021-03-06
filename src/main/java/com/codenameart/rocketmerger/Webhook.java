package com.codenameart.rocketmerger;

import com.codenameart.rocketmerger.envelope.Message;
import com.codenameart.rocketmerger.q.DBQueue;
import com.codenameart.rocketmerger.q.DBWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Artem on 18.12.2017.
 */
@Slf4j
@Controller
@EnableAutoConfiguration
@ComponentScan
public class Webhook {

    @Autowired
    DBQueue dbQueue;

    @Autowired
    DBWriter dbWriter;


    @Autowired
    private ApplicationContext context;


    @Value("${dbwriter.count}")
    int dbWriterCount;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Webhook.class, args);
    }

    @RequestMapping("/")
    @ResponseStatus(HttpStatus.OK)
    void process(@RequestBody List<Message> payload) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        log.debug("Message received");
        payload.stream().map(Message::getMessage).filter(Objects::nonNull).forEach(dbQueue::offer);
    }

    @PostConstruct
    public void startDBLoop() {
        ExecutorService executorService = Executors.newFixedThreadPool(dbWriterCount);
        for (int i = 0; i < dbWriterCount; i++) {
            DBWriter bean = context.getBean(DBWriter.class);
            executorService.execute(bean);
        }
    }
}
