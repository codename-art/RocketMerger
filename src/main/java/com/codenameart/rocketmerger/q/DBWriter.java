package com.codenameart.rocketmerger.q;

import com.codenameart.rocketmerger.envelope.*;
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
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    GymRepository gymRepository;
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    RaidRepository raidRepository;


    @Override
    public void run() {
        log.info("Starting queue DBWriter");
        while (true) {
            try {
                if (Thread.currentThread().isInterrupted()) {
                    return;
                }

                WHData whData = queue.poll();

                if (whData == null) { // queue is empty
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        return;
                    }
                } else {
                    log.info("Receive ["+whData.getClass().getSimpleName()+"], new queue length: " + queue.size());
                    if (whData instanceof Pokemon) {
                        Pokemon pokemon = (Pokemon) whData;
                        pokemon.setLast_modified(new Date());
                        pokemonRepository.save(pokemon);
                    } else if (whData instanceof Gym){
                        Gym gym = (Gym) whData;
                        gym.setLast_scanned(new Date());
                        gymRepository.save(gym);
                    } else if (whData instanceof Raid){
                        Raid raid = (Raid) whData;
                        raid.setLast_scanned(new Date());
                        raidRepository.save(raid);
                    }
                }

            } catch (Exception e) {
                log.error("Exception on db loop", e);
            }
        }
    }
}
