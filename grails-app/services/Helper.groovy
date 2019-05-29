package zenjob_guestbook

class Helper {
    private static Map emojiHashmap = Asset.get('emojis.json')
    public static String parseEmojis(String str, String type = 'symbol') {
        /*
        Available types:
        - symbol: Shortcodes get replaced with unicode characters.
        - html: Shortcodes get replaced with html entities.
        */
        return str.replaceAll(~/:\w+:/, {shortcode ->
            return emojiHashmap[shortcode] ? emojiHashmap[shortcode][type] : shortcode
        })
    }

    public static void populateDB() {
        new Entry(
            author: 'Bilbo',
            email: 'bilbo@mordor.io',
            font: 'Norican',
            text: 'Huhuuuuuuuu!',
            isSpam: false
        ).save()
        new Entry(
            author: 'Elon Musk',
            email: 'nole@alset.moc',
            font: 'IndieFlower',
            text: 'Hey James, nice app you got there! Good luck with your job application!',
            isSpam: false
        ).save()
    }
}