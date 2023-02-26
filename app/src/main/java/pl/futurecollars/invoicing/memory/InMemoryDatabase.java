package pl.futurecollars.invoicing.memory;

import pl.futurecollars.invoicing.model.Invoice;

import java.util.*;

public class InMemoryDatabase implements Database{

    private Map<Integer, Invoice> invoiceMap;

    public InMemoryDatabase() {
        invoiceMap = new HashMap<>();
    }

    @Override
    public void save(Invoice invoice) {
        invoiceMap.put(invoice.getId(), invoice);
    }

    @Override
    public Invoice getById(int id) {
        return invoiceMap.get(id);
    }

    @Override
    public List<Invoice> getAll() {
        return new ArrayList<>(invoiceMap.values());
    }

    @Override
    public void update(int id, Invoice updatedInvoice) {
        invoiceMap.put(id, updatedInvoice);
    }

    @Override
    public void delete(int id) {
        invoiceMap.remove(id);
    }
}