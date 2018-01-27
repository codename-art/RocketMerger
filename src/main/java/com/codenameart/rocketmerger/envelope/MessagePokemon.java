package com.codenameart.rocketmerger.envelope;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * Created by Artem on 26.01.2018.
 */
public class MessagePokemon extends Message {
    @Getter
    @JsonProperty("message")
    Pokemon message;
}
