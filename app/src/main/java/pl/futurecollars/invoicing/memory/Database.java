package pl.futurecollars.invoicing.memory;

import pl.futurecollars.invoicing.model.Invoice;

import java.util.List;

public interface Database {
    void save(Invoice invoice);

    Invoice getById(int id);

    List<Invoice> getAll();

    void update(int id, Invoice updatedInvoice);

    void delete(int id);
}