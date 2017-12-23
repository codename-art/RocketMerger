package com.codenameart.rocketmerger;

import com.codenameart.rocketmerger.q.DBQueue;
import com.codenameart.rocketmerger.q.DBWriter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by Artem on 18.12.2017.
 */
@Log4j2
@Controller
@EnableAutoConfiguration
@ComponentScan
public class Webhook {

    @Autowired
    DBQueue dbQueue;

    @Autowired
    DBWriter dbWriter;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Webhook.class, args);
    }

    @RequestMapping("/")
    @ResponseStatus(HttpStatus.OK)
    void process(@RequestBody List<Message> payload) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        payload.stream().map(Message::getMessage).forEach(dbQueue::offer);
    }

    @PostConstruct
    public void startDBLoop() {
        for (int i = 0; i < 10; i++) {
            dbWriter.startLoop();
        }
    }
}
