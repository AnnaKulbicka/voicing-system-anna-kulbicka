package pl.futurecollars.invoicing.memory

import pl.futurecollars.invoicing.model.Company
import pl.futurecollars.invoicing.model.Invoice
import spock.lang.Specification

class InMemoryDatabaseTest extends Specification {
    def "saving and getting invoice works correctly"() {
        given:
        def database = new InMemoryDatabase()
        def invoice = new Invoice(1, new Date(), new Company("123456789", "Company A"), new Company("987654321", "Company B"), [])


        when:
        database.save(invoice)
        def result = database.getById(invoice.getId())

        then:
        result == invoice
    }

    def "getting all invoices returns all saved invoices"() {
        given:
        def database = new InMemoryDatabase()
        def invoice1 = new Invoice(1, new Date(), new Company("123456789", "Company A"), new Company("987654321", "Company B"), [])
        def invoice2 = new Invoice(2, new Date(), new Company("111111111", "Company C"), new Company("222222222", "Company D"), [])
        database.save(invoice1)
        database.save(invoice2)

        when:
        def result = database.getAll()

        then:
        result.size() == 2
        result.contains(invoice1)
        result.contains(invoice2)
    }

    def "updating invoice works correctly"() {
        given:
        def database = new InMemoryDatabase()
        def invoice = new Invoice(1, new Date(), new Company("123456789", "Company A"), new Company("987654321", "Company B"), [])
        database.save(invoice)
        def updatedInvoice = new Invoice(1, new Date(), new Company("123456789", "Company A"), new Company("222222222", "Company D"), [])

        when:
        database.update(invoice.getId(), updatedInvoice)
        def result = database.getById(invoice.getId())

        then:
        result == updatedInvoice
    }

    def "deleting invoice works correctly"() {
        given:
        def database = new InMemoryDatabase()
        def invoice = new Invoice(1, new Date(), new Company("123456789", "Company A"), new Company("987654321", "Company B"), [])
        database.save(invoice)

        when:
        database.delete(invoice.getId())
        def result = database.getById(invoice.getId())

        then:
        result == null
    }

}