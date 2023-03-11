package pl.futurecollars.invoicing.model;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class InvoiceEntry {

    private String description;
    private BigDecimal price;
    private BigDecimal vatValue;
    private Vat vatRate;

    public InvoiceEntry(String description, BigDecimal price, BigDecimal vatValue, Vat vatRate) {
        this.description = description;
        this.price = price;
        this.vatValue = vatValue;
        this.vatRate = vatRate;
    }

}
