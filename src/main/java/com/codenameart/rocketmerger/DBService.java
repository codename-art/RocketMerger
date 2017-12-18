package com.codenameart.rocketmerger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

/**
 * Created by Artem on 18.12.2017.
 */
@Service
@EnableAsync
public class DBService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired PokemonRepository pokemonRepository;
    public void savePokemon(Pokemon pokemon) {
        pokemonRepository.save(pokemon);
    }
}
