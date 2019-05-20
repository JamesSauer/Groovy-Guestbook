package zenjob_guestbook

class Entry {

    String author
    String text
    String font
    Date creationDate = new Date()

    static constraints = {
        author maxSize: 64
        text maxSize: 512
        font inList: ['Damion', 'IndieFlower', 'Pacifico']
    }
}
