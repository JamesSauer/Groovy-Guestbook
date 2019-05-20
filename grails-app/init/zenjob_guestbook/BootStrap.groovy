package zenjob_guestbook

class BootStrap {

    def init = { servletContext ->
        new Entry(author: 'Bilbo', font: 'Pacifico', version: 1, text: 'Huhuuuuuuuu!').save()
    }
    def destroy = {
    }
}
