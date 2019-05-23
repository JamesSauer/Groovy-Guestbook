package zenjob_guestbook

class IndexController {
    Random random = new Random()
    // TODO: Create a domain class for fonts and generate the instances dynamically by reading the /assets/fonts directory.
    // TODO: Generate the CSS for applying the fonts dynamically as well.
    def fontList = ['Pacifico', 'Damion', 'IndieFlower']

    def index() {
        def font = fontList[random.nextInt() % fontList.size()]
        respond([entries: Entry.list(), font: font])
    }

    def addEntry(String author, String text, String font) {
        // TODO: Implement spam protection. Akismet probably.

        // TODO: Investigate whether manual input validation is necessary. Does the DB itself maybe do it well enough?

        new Entry(author:author, text:text, font:font).save(flush:true)
        redirect action: 'index'
    }

    /* TODO: Final thing to do: Look through the Grails documentation for best practices you
    didn't catch and implement them. E.g. putting business logic in services.*/
}
