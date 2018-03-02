package com.codenameart.rocketmerger.envelope;

import com.codenameart.rocketmerger.DissapearTimeDeserializer;
import com.codenameart.rocketmerger.LastModifiedTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Artem on 18.12.2017.
 */
@Data
@Entity
@AllArgsConstructor
public class Gym implements WHData {
    public Gym() {
    }

    @Id
    String gym_id;
    double latitude;
    double longitude;
    short team_id;
    boolean enabled;

    @JsonDeserialize(using = LastModifiedTimeDeserializer.class)
    Date last_modified;

    short guard_pokemon_id;
    short total_cp;
    short slots_available;
    Date last_scanned;

}
