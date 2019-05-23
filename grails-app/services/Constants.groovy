package zenjob_guestbook

class Constants {
    static String rootPath   = new File('').absolutePath 
    static String akismetKey = new File(rootPath, '/grails-app/conf/akismetKey.txt').getText('UTF-8')
}