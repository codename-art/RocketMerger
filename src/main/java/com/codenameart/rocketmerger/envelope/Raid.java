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
public class Raid implements WHData {
    public Raid() {
    }

    @Id
    String gym_id;

    @JsonDeserialize(using = DissapearTimeDeserializer.class)
    Date spawn;

    @JsonDeserialize(using = DissapearTimeDeserializer.class)
    Date start;

    @JsonDeserialize(using = DissapearTimeDeserializer.class)
    Date end;

    short level;
    Short pokemon_id = null;
    Short move_1 = null;
    Short move_2 = null;
    Integer cp = null;
    Date last_scanned;
}
