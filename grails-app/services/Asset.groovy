package zenjob_guestbook
import groovy.json.JsonSlurper

class Asset {
    // TODO: Pretty unelegant and fragile method, but works for now. Refactor later.
    public static get(String filename) {
        String extension = filename.findAll(~/\.[a-zA-Z0-9]+$/)[0]

        if(Constants.isJar) {
            String assetPath = "assets/${filename}"
            InputStream assetStream = BootStrap.class.getClassLoader().getResourceAsStream(assetPath);
            if(assetStream) {
                switch(extension) {
                    case '.json':
                        return handlers['json'](assetStream)
                    default:
                        return handlers['default'](assetStream)
                }
                
            }

        } else {
            String folder
            switch(extension) {
                case '.css':
                    folder = 'stylesheets'
                    break
                case '.js':
                    folder = 'javascripts'
                    break
                case '.jpg':
                    folder = 'images'
                    break
                case '.png':
                    folder = 'images'
                    break
                case '.ttf':
                    folder = 'fonts'
                    break
                default:
                    folder = 'misc'
                    break
            }
            String rootPath  = new File('.').absolutePath.replaceAll(~/\.$/, '')
            String assetPath = "${rootPath}grails-app/assets/${folder}/${filename}"
            String assetText = new File(assetPath).getText('UTF-8')
            switch(extension) {
                case '.json':
                    return handlers['json'](assetText)
                default:
                    return handlers['default'](assetText)
            }
        }
    }

    private static Map handlers = [
        'json': {input ->
            JsonSlurper slurper = new JsonSlurper()
            Map result
            switch(input.getClass()) {
                case InputStream:
                    result = slurper.parse(input)
                    break
                case String:
                    result = slurper.parseText(input)
                    break
            }
            return result
        },
        'default': {input ->
            String result
            switch(input.getClass()) {
                case InputStream:
                    result = input.text
                    break
                case String:
                    result = input
                    break
            }
            return result
        }
    ]

}