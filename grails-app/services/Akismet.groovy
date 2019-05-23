package zenjob_guestbook

class Akismet {
    static verifyKey(values) {
        String url = 'https://rest.akismet.com/1.1/verify-key'

        values.key = Constants.akismetKey

        values = mapToQueryComponent(values)

        makePostRequest(url, values)
    }

    /*
    The following values are required for calling Akismet's comment check:
    blog (required)	
    user_ip (required)	
    user_agent (required)
    */

    static checkComment(values) {
        String url = "https://${Constants.akismetKey}.rest.akismet.com/1.1/comment-check"

        values = mapToQueryComponent(values)

        makePostRequest(url, values)
    }

    private static mapToQueryComponent(map) {
        def str = ''
        map.each{key, value ->
            str += "${key}=${value.encodeURL()}&"
        }
        str = str.replaceAll(~/\&$/, '')
        return str
    }

    private static makePostRequest(String url, String message) {
        def post = new URL(url).openConnection();
        post.setRequestMethod("POST")
        post.setDoOutput(true)
        post.getOutputStream().write(message.getBytes("UTF-8"));

        def postRC = post.getResponseCode();
        if(postRC.equals(200)) {
            println post.getInputStream().getText()
        }
    }
}