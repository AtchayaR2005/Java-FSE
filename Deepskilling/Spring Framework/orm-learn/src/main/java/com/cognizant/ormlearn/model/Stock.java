package com.cognizant.ormlearn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_id")
    private int id;

    @Column(name = "st_code")
    private String stockCode;

    @Column(name = "st_date")
    private LocalDate stockDate;

    @Column(name = "st_open")
    private BigDecimal stockOpen;

    @Column(name = "st_close")
    private BigDecimal stockClose;

    @Column(name = "st_volume")
    private Long volume;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public LocalDate getStockDate() {
        return stockDate;
    }

    public void setStockDate(LocalDate stockDate) {
        this.stockDate = stockDate;
    }

    public BigDecimal getStockOpen() {
        return stockOpen;
    }

    public void setStockOpen(BigDecimal stockOpen) {
        this.stockOpen = stockOpen;
    }

    public BigDecimal getStockClose() {
        return stockClose;
    }

    public void setStockClose(BigDecimal stockClose) {
        this.stockClose = stockClose;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Stock [id=" + id + ", stockCode=" + stockCode + ", stockDate=" + stockDate + ", stockOpen="
                + stockOpen + ", stockClose=" + stockClose + ", volume=" + volume + "]";
    }
}
