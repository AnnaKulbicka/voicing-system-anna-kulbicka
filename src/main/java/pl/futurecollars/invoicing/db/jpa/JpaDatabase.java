package pl.futurecollars.invoicing.db.jpa;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import pl.futurecollars.invoicing.db.Database;
import pl.futurecollars.invoicing.model.Invoice;
import pl.futurecollars.invoicing.model.InvoiceEntry;

public class JpaDatabase implements Database {

  @Override
  public long save(Invoice invoice) {
    return 0;
  }

  @Override
  public Optional<Invoice> getById() {
    return Optional.empty();
  }

  @Override
  public Optional<Invoice> getById(long id) {
    return Optional.empty();
  }

  @Override
  public Optional<Invoice> getById(int id) {
    return Optional.empty();
  }

  @Override
  public List<Invoice> getAll() {
    return null;
  }

  @Override
  public Optional<Invoice> update(long id, Invoice updatedInvoice) {
    return Optional.empty();
  }

  @Override
  public Optional<Invoice> update() {
    return Optional.empty();
  }

  @Override
  public Optional<Invoice> update(int id, Invoice updatedInvoice) {
    return Optional.empty();
  }

  @Override
  public Optional<Invoice> delete(long id) {
    return Optional.empty();
  }

  @Override
  public Optional<Invoice> delete() {
    return Optional.empty();
  }

  @Override
  public Optional<Invoice> delete(int id) {
    return Optional.empty();
  }

  @Override
  public BigDecimal visit(Predicate<Invoice> invoicePredicate, Function<InvoiceEntry, BigDecimal> invoiceEntryToValue) {
    return Database.super.visit(invoicePredicate, invoiceEntryToValue);
  }
}
