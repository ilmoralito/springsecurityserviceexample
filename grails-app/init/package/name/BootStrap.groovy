package package.name

class BootStrap {

    def init = { servletContext ->
        Role adminRole = new Role(authority: 'ROLE_ADMIN').save()

        BookShop testBookShop = new BookShop(name: 'BookShop', isOpen: true).save()

        User testUser = new User(username: 'me', password: 'password', store: testBookShop).save()

        UserRole.create testUser, adminRole

        UserRole.withSession {
            it.flush()
            it.clear()
        }

        assert User.count() == 1
        assert Role.count() == 1
        assert UserRole.count() == 1
    }
    def destroy = {
    }
}
