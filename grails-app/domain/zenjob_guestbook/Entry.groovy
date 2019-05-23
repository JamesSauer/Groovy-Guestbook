package zenjob_guestbook

class Entry {

    String author
    String email = ''
    String text
    String font
    Date creationDate = new Date()
    Boolean isSpam

    static constraints = {
        author maxSize: 64
        email maxSize: 128
        text maxSize: 512
        font inList: ['Damion', 'IndieFlower', 'Pacifico']
    }
}
