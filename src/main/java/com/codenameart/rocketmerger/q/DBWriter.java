package com.codenameart.rocketmerger.q;

import com.codenameart.rocketmerger.Pokemon;
import com.codenameart.rocketmerger.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import java.util.Date;

/**
 * Created by Artem on 23.12.2017.
 */
public class DBWriter {
    @Autowired
    DBQueue queue;


    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    PokemonRepository pokemonRepository;


    @Async
    public void startLoop(){
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
                pokemonRepository.save(pokemon);
            }
        }
    }
}
