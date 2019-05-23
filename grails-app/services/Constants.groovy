package zenjob_guestbook
import grails.util.Environment

class Constants {
    static String env        = grails.util.Environment.getCurrent()
    static String rootPath   = new File('').absolutePath 
    static String akismetKey = new File(rootPath, '/grails-app/conf/akismetKey.txt').getText('UTF-8')
}