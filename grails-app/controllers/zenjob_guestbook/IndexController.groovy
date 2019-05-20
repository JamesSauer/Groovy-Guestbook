package zenjob_guestbook

class IndexController {

    def index() {
        respond([entries: Entry.list()])
    }
}
