package com.reactive.app.reactive.app.models;

/**
 * Model price for response
 *
 * @author iulian.timis
 */
public class MarketPriceModel {

    private String price;
    private String symbol;
    private String dateTime;

    public MarketPriceModel(String price, String symbol, String dateTime) {
        this.price = price;
        this.symbol = symbol;
        this.dateTime = dateTime;
    }

    public String getPrice() {
        return price;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getDateTime() {
        return dateTime;
    }
}
