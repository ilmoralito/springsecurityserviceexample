package package.name

import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.SpringSecurityService

class SecureController {

    SpringSecurityService springSecurityService

    @Secured('ROLE_ADMIN')
    def index() {
        User currentUser = springSecurityService.currentUser

        println "currentUser: $currentUser"
        println "currentUser username: $currentUser.username"
        println "currentUser store: $currentUser.store"
        println "currentUser store name: $currentUser.store.name"
        println "currentUser store isOpen: $currentUser.store.isOpen"

        render 'Please check the console'
    }
}
