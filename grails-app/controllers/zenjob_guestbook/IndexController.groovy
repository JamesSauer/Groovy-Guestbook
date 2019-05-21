package zenjob_guestbook

class IndexController {
    Random random = new Random()
    // TODO: Create a domain class for fonts and generate the instances dyncamically by reading the /assets/fonts directory.
    def fontList = ['Pacifico', 'Damion', 'IndieFlower']

    def index() {
        def font = fontList[random.nextInt() % fontList.size()]
        respond([entries: Entry.list(), font: font])
    }

    def addEntry(String author, String text, String font) {
        // TODO: Implement spam protection. Akismet probably.

        // TODO: Investigate whether manual input validation is necessary. Does the DB itself maybe do it well enough?

        // TODO: Investigate what flush:true means and why it doesn't work without it.
        new Entry(author:author, text:text, font:font).save(flush:true)
        redirect action: 'index'
    }
}
