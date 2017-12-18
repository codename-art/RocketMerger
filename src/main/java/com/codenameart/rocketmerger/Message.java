package com.codenameart.rocketmerger;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * Created by Artem on 18.12.2017.
 */
public class Message {
    @Getter
    @JsonProperty("message")
    Pokemon message;
    @JsonProperty("type")
    String type;
}
