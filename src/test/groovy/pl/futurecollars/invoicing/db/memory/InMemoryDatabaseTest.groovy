package pl.futurecollars.invoicing.db.memory

import pl.futurecollars.invoicing.db.AbstractDatabaseTest
import pl.futurecollars.invoicing.db.Database
import pl.futurecollars.invoicing.memory.InMemoryDatabase

class InMemoryDatabaseTest extends AbstractDatabaseTest {

    @Override
    Database getDatabaseInstance() {
        return new InMemoryDatabase()
    }

}