package com.casestudy.order.controller;

import com.casestudy.model.Deal;
import com.casestudy.order.error.MemberNotFoundExcepion;
import com.casestudy.order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Operation(summary = "Create Buy & Sell orders", description = "creates buy & sell instructions for a member")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "503", description = "Internal server error")})
    @PostMapping(path = "deal",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Deal> createDealOrder(@RequestBody Deal deal) {
        if (deal == null) {
            throw new MemberNotFoundExcepion("not found");
        } else {
            orderService.placeDealOrder(deal);
            log.info("deal {}", deal);
            return new ResponseEntity<>(deal, HttpStatus.CREATED);
        }
    }
}
