package com.casestudy.order.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JMSSenderImpl {

    @Autowired
    JmsTemplate jmsTemplate;


    public void sendMessage(Object object, String queueName) {
        log.info("sending message {} to queue {}", object, queueName);
        jmsTemplate.convertAndSend(queueName, object);
        log.info("message {} sent to queue {}", object, queueName);
    }
}
