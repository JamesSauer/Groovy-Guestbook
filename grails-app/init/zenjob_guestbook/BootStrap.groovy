package zenjob_guestbook

class BootStrap {

    def init = { servletContext ->
        new Entry(author: 'Bilbo', font: 'Pacifico', text: 'Huhuuuuuuuu!').save()
        new Entry(author: 'Elon Musk', font: 'IndieFlower', text: 'Hey James, nice app you got there! Good luck with your job application!').save()
    }
    def destroy = {
    }
}
