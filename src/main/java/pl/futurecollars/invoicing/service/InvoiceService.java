package pl.futurecollars.invoicing.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import pl.futurecollars.invoicing.db.Database;
import pl.futurecollars.invoicing.model.Invoice;

@Service
public class InvoiceService {

  private final Database database;

  public InvoiceService(Database database) {
    this.database = database;
  }

  public long save(Invoice invoice) {
    return database.save(invoice);
  }

  public Optional<Invoice> getById(long id) throws SQLException {
    return database.getById(id);
  }

  public List<Invoice> getAll() {
    return database.getAll();
  }

  public Optional<Invoice> update(long id, Invoice updatedInvoice) throws SQLException {
    return database.update(id, updatedInvoice);
  }

  public Optional<Invoice> delete(long id) throws SQLException {
    return database.delete(id);
  }

}
