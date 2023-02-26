package pl.futurecollars.invoicing.model;

import lombok.Data;

@Data
public class Company {
    private int id;
    private String taxIdentificationNumber;
    private String address;
    private String name;

    public Company(int id, String taxIdentificationNumber, String address) {
        this.id = id;
        this.taxIdentificationNumber = taxIdentificationNumber;
        this.address = address;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setTaxIdentificationNumber(String taxIdentificationNumber) {
        this.taxIdentificationNumber = taxIdentificationNumber;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
