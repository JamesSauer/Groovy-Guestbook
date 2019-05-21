package zenjob_guestbook

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller:"index")
        "500"(view:'/error') // TODO: Replace these two templates with custom ones.
        "404"(view:'/notFound')
    }
}
