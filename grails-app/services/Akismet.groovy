package zenjob_guestbook

class Akismet {
    static verifyKey(Map valuesMap, Closure callback = {String result -> println result}) {
        String url = 'https://rest.akismet.com/1.1/verify-key'

        valuesMap.key = Constants.akismetKey
        String valuesString = encodeRequestBody(valuesMap)

        makePostRequest(url, valuesString, callback)
    }

    static checkComment(Map valuesMap, Closure callback = {String result -> println result}) {
        String url = "https://${Constants.akismetKey}.rest.akismet.com/1.1/comment-check"

        String valuesString = encodeRequestBody(valuesMap)

        def modifiedCallback = {result -> callback(result == 'true' ? true : false)}
        makePostRequest(url, valuesString, modifiedCallback)
    }

    private static encodeRequestBody(Map map) {
        def str = ''
        map.each{key, value ->
            if(!value) {
                return
            }
            str += "${key}=${value.encodeURL()}&"
        }
        str = str.replaceAll(~/\&$/, '')
        return str
    }

    private static makePostRequest(String url, String values, Closure callback = {String result -> println result}) {
        def post = new URL(url).openConnection();
        post.setRequestMethod("POST")
        post.setDoOutput(true)
        post.getOutputStream().write(values.getBytes("UTF-8"));

        def postRC = post.getResponseCode();
        if(postRC.equals(200)) {
            def result = post.getInputStream().getText()
            callback(result)
        }
    }
}