import pl.futurecollars.invoicing.App
import spock.lang.Specification

class AppTest extends Specification {
    def "application has a greeting"() {


        setup:
        def app = new App()

        when:
        def result = app.greeting

        then:
        result != null
    }

    def "dummy test to cover main"() {
        setup:
        def app = new App();

        and:
        app.main()
    }
}


