package pl.futurecollars.invoicing.service;

import pl.futurecollars.invoicing.memory.Database;
import pl.futurecollars.invoicing.model.Invoice;

import java.util.List;

public class InvoiceService {
    private Database database;

    public InvoiceService(Database database) {
        this.database = database;
    }

    public void saveInvoice(Invoice invoice) {
        database.save(invoice);
    }

    public Invoice getInvoiceById(int id) {
        return database.getById(id);
    }

    public List<Invoice> getAllInvoices() {
        return database.getAll();
    }

    public void updateInvoice(int id, Invoice updatedInvoice) {
        database.update(id, updatedInvoice);
    }

    public void deleteInvoice(int id) {
        database.delete(id);
    }
}