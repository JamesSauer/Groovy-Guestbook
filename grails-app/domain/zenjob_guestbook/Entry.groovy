package zenjob_guestbook

class Entry {

    UUID id

    String author

    Date creationDate

    String text

    String font

    static constraints = {
        author maxSize: 64
        text maxSize: 512
        font inList: ['Damion', 'IndieFlower', 'Pacifico']
    }
}
