package pl.futurecollars.invoicing.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Invoice {
    private int id;
    private Date date;
    private Company fromCompany;
    private Company toCompany;
    private List<InvoiceEntry> entries;

    public Invoice(int id, Date date, Company fromCompany, Company toCompany, List<InvoiceEntry> entries) {
        this.id = id;
        this.date = date;
        this.fromCompany = fromCompany;
        this.toCompany = toCompany;
        this.entries = entries;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public void setFromCompany(Company fromCompany) {
        this.fromCompany = fromCompany;
    }

    public void setToCompany(Company toCompany) {
        this.toCompany = toCompany;
    }
    public void setEntries(List<InvoiceEntry> entries) {
        this.entries = entries;
    }

}
