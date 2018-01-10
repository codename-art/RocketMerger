package com.codenameart.rocketmerger;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by Artem on 18.12.2017.
 */
@Data
@Builder
@Entity
@AllArgsConstructor
public class Pokemon {
    public Pokemon() {
    }

    @Id
    BigInteger encounter_id;
    BigInteger spawnpoint_id;
    BigInteger pokemon_id;
    double latitude;
    double longitude;
    @JsonDeserialize(using = DisappearTimeDeserializer.class)
    Date disappear_time;
    short individual_attack;
    short individual_defense;
    short individual_stamina;
    short move_1;
    short move_2;
    short cp;
    float cp_multiplier;
    float weight;
    float height;
    short gender;
    short form;
    Date last_modified;

}
