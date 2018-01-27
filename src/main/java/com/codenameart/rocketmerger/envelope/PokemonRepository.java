package com.codenameart.rocketmerger.envelope;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Artem on 18.12.2017.
 */
@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, String> {
}
