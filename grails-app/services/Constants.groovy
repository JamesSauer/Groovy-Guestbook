package zenjob_guestbook
import grails.util.Environment

class Constants {
    static String env        = grails.util.Environment.getCurrent()
    static String akismetKey = System.getenv('AKISMET_KEY') ?: 'invalid_key'
    // TODO: Find out how to access ressources in packaged .war files and then read the fonts dynamically from there.
    static List fontList     = ['Damion', 'IndieFlower', 'Pacifico']
}