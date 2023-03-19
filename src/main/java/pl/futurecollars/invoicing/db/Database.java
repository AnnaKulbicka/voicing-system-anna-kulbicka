
package pl.futurecollars.invoicing.db;

import java.util.List;
import java.util.Optional;
import pl.futurecollars.invoicing.model.Invoice;

public interface Database {

  int save(Invoice invoice);


  Optional<Invoice> getById(int id) throws RuntimeException;

  List<Invoice> getAll() throws RuntimeException;

  void update(int id, Invoice updatedInvoice) throws RuntimeException;

  Optional<Invoice> getById(int id);

  List<Invoice> getAll();

  void update(int id, Invoice updatedInvoice);


  void delete(int id);

}
