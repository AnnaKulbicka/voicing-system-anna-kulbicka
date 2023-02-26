package pl.futurecollars.invoicing.model;

import lombok.Data;

@Data
public class InvoiceEntry {
    private String description;
    private double price;
    private double vatValue;
    private double vatRate;

    public InvoiceEntry(String description, double price, double vatValue, double vatRate) {
        this.description = description;
        this.price = price;
        this.vatValue = vatValue;
        this.vatRate = vatRate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setVatValue(double vatValue) {
        this.vatValue = vatValue;
    }

    public void setVatRate(double vatRate) {
        this.vatRate = vatRate;
    }
}
