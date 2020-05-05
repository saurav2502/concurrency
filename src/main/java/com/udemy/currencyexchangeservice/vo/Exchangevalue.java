package com.udemy.currencyexchangeservice.vo;

import java.math.BigDecimal;

public class Exchangevalue {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private int port;
    private BigDecimal quantity;

    public Exchangevalue() {
    }

    public Exchangevalue(Long id, String from, String to, BigDecimal conversionMultiple, int port,
            BigDecimal quantity) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.port = port;
        this.quantity = quantity;
    }

    public Exchangevalue(long l, String from, String to, BigDecimal bigDecimal,int port) {
        this.id = l;
        this.from = from;
        this.to = to;
        this.conversionMultiple = bigDecimal;
        this.port = port;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Exchangevalue{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", conversionMultiple=" + conversionMultiple +
                ", port=" + port +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
