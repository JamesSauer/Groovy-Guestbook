package zenjob_guestbook
import grails.util.Environment

class Constants {
    static String env           = grails.util.Environment.getCurrent()
    static Boolean isProduction = env == 'PRODUCTION'
    static Boolean isJar        = Constants.class.getResource("Constants.class").toString().startsWith('jar:')

    static String akismetKey    = System.getenv('AKISMET_KEY') ?: 'invalid_key'
    static List fontList        = ['Damion', 'IndieFlower', 'SueEllenFrancisco', 'Norican', 'GochiHand']
}