package com.casestudy.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
@JsonTypeInfo(
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "dealType",
        use = JsonTypeInfo.Id.NAME,
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Buy.class, name = "BUY"),
        @JsonSubTypes.Type(value = Sell.class, name = "SELL"),
        @JsonSubTypes.Type(value = Switch.class, name = "SWITCH")
})
@Data
public class Deal {

    private String memberCode;

    private double units;

    private DealType dealType;
}
