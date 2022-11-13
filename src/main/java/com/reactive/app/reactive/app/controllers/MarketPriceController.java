package com.reactive.app.reactive.app.controllers;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.app.reactive.app.models.MarketPriceModel;

import reactor.core.publisher.Flux;

/**
 * Rest controller Class for reactive endpoints
 *
 * @author iulian.timis
 */
@RestController
@RequestMapping("/forex")
public class MarketPriceController {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS Z");

    @GetMapping(value = "/marketPrice/EURUSD", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MarketPriceModel> priceModelFlux() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> new MarketPriceModel(getPrice(sequence), "EURUSD", ZonedDateTime.now().format(DATE_TIME_FORMATTER)));
    }

    private String getPrice(Long sequence) {
        int firstRandomNumber = (int)Math.floor(Math.random() * (sequence - 1) + 2);
        int secondRandomNumber = (int)Math.floor(Math.random() * (100 - 1) + 1);
        return "1.0" + firstRandomNumber + secondRandomNumber;
    }
}
