package com.casestudy.order.service;

import com.casestudy.model.Deal;
import com.casestudy.order.jms.JMSSenderImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    JMSSenderImpl jmsSender;
    @Value("${deal.queue}")
    private String dealQueue;

    @Override
    public void placeDealOrder(Deal deal) {
        jmsSender.sendMessage(deal, dealQueue);
    }
}
