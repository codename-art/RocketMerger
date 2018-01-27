package com.codenameart.rocketmerger.envelope;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;

/**
 * Created by Artem on 18.12.2017.
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = MessagePokemon.class, name = "pokemon"),
        @JsonSubTypes.Type(value = MessageGym.class, name = "gym"),
        @JsonSubTypes.Type(value = MessageRaid.class, name = "raid"),
        @JsonSubTypes.Type(value = Message.class, name = "gym_details")
})
public class Message {
    @JsonProperty("type")
    String type;

    public WHData getMessage(){
        return null;
    };
}
