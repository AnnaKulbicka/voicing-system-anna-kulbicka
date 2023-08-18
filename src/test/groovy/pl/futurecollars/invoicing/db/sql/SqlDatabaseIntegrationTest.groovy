package pl.futurecollars.invoicing.db.sql

import org.flywaydb.core.Flyway
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import pl.futurecollars.invoicing.db.AbstractDatabaseTest
import pl.futurecollars.invoicing.db.Database

import javax.sql.DataSource

class SqlDatabaseIntegrationTest extends AbstractDatabaseTest {

    @Override
    Database getDatabaseInstance() {
        DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build()
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource)

        Flyway flyway = Flyway.configure()
            .dataSource(dataSource)
            .locations("db/migration")
            .load()

        flyway.clean()
        flyway.migrate()

        def database = new SqlDatabase(jdbcTemplate)
        database.initVatRatesMap() // need to call explicitly because we do not create it as spring bean

        database
    }

}
