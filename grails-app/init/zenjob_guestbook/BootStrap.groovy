package zenjob_guestbook

class BootStrap {

    def init = { servletContext ->
        String.metaClass.encodeURL = {
            java.net.URLEncoder.encode(delegate, "UTF-8")
        }

        javax.servlet.http.HttpServletRequest.metaClass.getSiteURL = {
            return ("${delegate.scheme}://${delegate.serverName}")
        }

        // TODO: Handle the case where the key is invalid.
        Akismet.verifyKey(
            blog: 'https://zenjobwillyouhire.me'
        )

        if(!Constants.isProduction) {
            Helper.populateDB()
        }
    }
    def destroy = {
    }
}
