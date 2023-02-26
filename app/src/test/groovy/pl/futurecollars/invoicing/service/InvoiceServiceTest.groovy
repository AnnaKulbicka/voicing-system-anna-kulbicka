package pl.futurecollars.invoicing.service

import pl.futurecollars.invoicing.model.Company
import pl.futurecollars.invoicing.model.Invoice
import spock.lang.Specification

class InvoiceServiceTest extends Specification {
    def "should save invoice to database"() {
        given:
        def invoice = new Invoice(id: 1, date: LocalDate.now(), from: new Company(), to: new Company(), entries: [])

        and:
        def databaseMock = Mock(Database)
        databaseMock.save(invoice) >> null

        and:
        def service = new InvoiceService(databaseMock)

        when:
        service.saveInvoice(invoice)

        then:
        1 * databaseMock.save(invoice)
    }

    def "should get invoice from database by id"() {
        given:
        def invoice = new Invoice(id: 1, date: LocalDate.now(), from: new Company(), to: new Company(), entries: [])

        and:
        def databaseMock = Mock(Database)
        databaseMock.getById(1) >> invoice

        and:
        def service = new InvoiceService(databaseMock)

        when:
        def result = service.getInvoiceById(1)

        then:
        1 * databaseMock.getById(1)
        result == invoice
    }

    def "should get all invoices from database"() {
        given:
        def invoice1 = new Invoice(id: 1, date: LocalDate.now(), from: new Company(), to: new Company(), entries: [])
        def invoice2 = new Invoice(id: 2, date: LocalDate.now(), from: new Company(), to: new Company(), entries: [])

        and:
        def databaseMock = Mock(Database)
        databaseMock.getAll() >> [invoice1, invoice2]

        and:
        def service = new InvoiceService(databaseMock)

        when:
        def result = service.getAllInvoices()

        then:
        1 * databaseMock.getAll()
        result == [invoice1, invoice2]
    }

    def "should update invoice in database"() {
        given:
        def invoice = new Invoice(id: 1, date: LocalDate.now(), from: new Company(), to: new Company(), entries: [])
        def updatedInvoice = new Invoice(id: 1, date: LocalDate.now(), from: new Company(), to: new Company(), entries: [])

        and:
        def databaseMock = Mock(Database)
        databaseMock.update(1, updatedInvoice) >> null

        and:
        def service = new InvoiceService(databaseMock)

        when:
        service.updateInvoice(1, updatedInvoice)

        then:
        1 * databaseMock.update(1, updatedInvoice)
    }

    def "should delete invoice from database"() {
        given:
        def invoice = new Invoice(id: 1, date: LocalDate.now(), from: new Company(), to: new Company(), entries: [])

        and:
        def databaseMock = Mock(Database)
        databaseMock.delete(1) >> null

        and:
        def service = new InvoiceService(databaseMock)

        when:
        service.deleteInvoice(1)

        then:
        1 * databaseMock.delete(1)
    }
}