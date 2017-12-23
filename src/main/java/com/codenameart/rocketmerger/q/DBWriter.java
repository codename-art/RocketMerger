package com.codenameart.rocketmerger.q;

import com.codenameart.rocketmerger.Pokemon;
import com.codenameart.rocketmerger.PokemonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by Artem on 23.12.2017.
 */
@Slf4j
public class DBWriter implements Runnable {
    @Autowired
    DBQueue queue;


    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    PokemonRepository pokemonRepository;


    @Override
    public void run() {
        log.info("Starting queue DBWriter");
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }

            Pokemon pokemon = queue.poll();
            if (pokemon == null) { // queue is empty
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    return;
                }
            } else {
                pokemon.setLast_modified(new Date());
                log.info("Queue length: " + queue.size());
                pokemonRepository.save(pokemon);
            }
        }
    }
}
