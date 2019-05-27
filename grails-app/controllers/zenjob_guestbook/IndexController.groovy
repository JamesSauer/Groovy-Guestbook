package zenjob_guestbook

class IndexController {
    Random random = new Random()

    def index() {
        def font = Constants.fontList[random.nextInt() % Constants.fontList.size()]

        respond([entries: Entry.findAllByIsSpam(false), font: font])
    }

    def addEntry(String author, String text, String email, String font) {

        // Fields required by Akismet are marked with /*R*/.
        Akismet.checkComment([
            is_test: Constants.env != 'PRODUCTION' ? '1' : null,

            comment_author: author,
            comment_author_email: null,
            comment_content: text,
            comment_type: 'guestbook-entry',

            blog: /*R*/ Constants.env == 'PRODUCTION' ? request.getSiteURL() : 'https://zenjobwillyouhire.me',
            blog_lang: 'en, de',
            blog_charset: 'UTF-8',

            user_ip: /*R*/ request.getRemoteAddr(),
            user_agent: /*R*/ request.getHeader("User-Agent"),
            referrer: request.getHeader("HTTP_REFERER")
        ], {isSpam ->
            /* TODO: Parse the entry text and replace emoji shortcodes like :rocket: with their respective symbols.
            Make use of this neat list in JSON format:
            https://gist.githubusercontent.com/oliveratgithub/0bf11a9aff0d6da7b46f1490f86a71eb/raw/ac8dde8a374066bcbcf44a8296fc0522c7392244/emojis.json
            */
            Map messages = [
                spam: '''\
                Your message has been identified as spam by our partner.
                If that was unjustified, I'm sorry! Do not hesitate to contact me:
                mail@jamessauer.com
                '''.stripIndent(),
                badData: '''\
                Sorry, something went wrong with the data you submitted!
                Please try again.
                '''.stripIndent(),
                success: '''\
                Thanks! Your message will now be displayed here for all of eternity.
                '''.stripIndent(),
            ]
            def success = new Entry(
                author:author,
                email:email,
                text:text,
                font:font,
                isSpam:isSpam)
            .save(flush:true)

            if(isSpam) {
                flash.message = messages.spam
            } else {
                if(success) {
                    flash.message = messages.success
                } else {
                    flash.message = messages.badData
                }
            }

            redirect(action: 'index')
        })
    }

    /* TODO: Final thing to do: Look through the Grails documentation for best practices you
    didn't catch and implement them. E.g. putting business logic in services.*/
}
