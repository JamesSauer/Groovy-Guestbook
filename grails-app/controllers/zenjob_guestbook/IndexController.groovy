package zenjob_guestbook

class IndexController {
    Random random = new Random()
    // TODO: Create a domain class for fonts and generate the instances dynamically by reading the /assets/fonts directory.
    // TODO: Generate the CSS for applying the fonts dynamically as well.
    def fontList = ['Pacifico', 'Damion', 'IndieFlower']

    def index() {
        def font = fontList[random.nextInt() % fontList.size()]

        respond([entries: Entry.findAllByIsSpam(false), font: font])
    }

    def addEntry(String author, String text, String email, String font) {
        // TODO: Investigate whether manual input validation is necessary. Does the DB itself maybe do it well enough?

        Akismet.checkComment([
            is_test: Constants.env != 'PRODUCTION' ? '1' : null,

            comment_author: author,
            comment_author_email: null,
            comment_content: text,
            comment_type: 'guestbook-entry',

            /*required*/blog: Constants.env == 'PRODUCTION' ? request.getSiteURL() : 'https://zenjobwillyouhire.me',
            blog_lang: 'en, de',
            blog_charset: 'UTF-8',

            /*required*/user_ip: request.getRemoteAddr(),
            /*required*/user_agent: request.getHeader("User-Agent"),
            referrer: request.getHeader("HTTP_REFERER")
        ], {result ->
            println "The comment was...: ${result ? 'Spam!' : 'A nice message!'}"
            new Entry(
                author:author,
                email:email,
                text:text,
                font:font,
                isSpam:result)
            .save(flush:true)
            redirect action: 'index'
        })
    }

    /* TODO: Final thing to do: Look through the Grails documentation for best practices you
    didn't catch and implement them. E.g. putting business logic in services.*/
}
