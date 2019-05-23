package zenjob_guestbook

class Akismet {
    /*
    The following values are required for calling Akismet's API:
    blog (required)	
    user_ip (required)	
    user_agent (required)
    */

    static checkComment(values) {
        String url = "https://${Constants.akismetKey}.rest.akismet.com/1.1/comment-check"
        url += mapToQueryComponent(values)
        println url
        makePostRequest(url)
    }

    private static mapToQueryComponent(map) {
        def str = '?'
        map.each{key, value ->
            str += "${key}=${value.encodeURL()}&"
        }
        str = str.replaceAll(~/\&$/, '')
        return str
    }

    private static makePostRequest(String url) {
        def post = new URL(url).openConnection();
        post.setRequestMethod("POST")
        post.setDoOutput(true)
        def postRC = post.getResponseCode();
        println(postRC);
        if(postRC.equals(200)) {
            println post.getHeaderField('X-akismet-debug-help') //.getInputStream();
        }
    }
}