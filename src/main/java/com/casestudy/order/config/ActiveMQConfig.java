package com.casestudy.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;


@Configuration
public class ActiveMQConfig {

    @Bean // Serialize message content to json using TextMessage
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        /*Map<String, Class<?>> typeIdMappings = new HashMap<>();
        //typeIdMappings.put(DealRequest.class.getName(), DealRequest.class);
        typeIdMappings.put(SwitchRequest.class.getName(), SwitchRequest.class);
        converter.setTypeIdMappings(typeIdMappings);*/
        return converter;
    }
}
