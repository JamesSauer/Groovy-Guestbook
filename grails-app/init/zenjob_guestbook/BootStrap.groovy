package zenjob_guestbook

class BootStrap {

    def init = { servletContext ->
        String.metaClass.encodeURL = {
            java.net.URLEncoder.encode(delegate, "UTF-8")
        }

        javax.servlet.http.HttpServletRequest.metaClass.getSiteURL = {
            return ("${delegate.scheme}://${delegate.serverName}")
        }

        Akismet.verifyKey(
            blog: 'https://zenjobwillyouhire.me'
        )

        if(Constants.env != 'PRODUCTION') {
            new Entry(
                author: 'Bilbo',
                font: 'Pacifico',
                text: 'Huhuuuuuuuu!',
                isSpam: false
            ).save()
            new Entry(
                author: 'Elon Musk',
                font: 'IndieFlower',
                text: 'Hey James, nice app you got there! Good luck with your job application!',
                isSpam: false
            ).save()
        }
    }
    def destroy = {
    }
}
