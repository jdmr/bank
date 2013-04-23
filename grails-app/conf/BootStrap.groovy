import bank.*

class BootStrap {

    def init = { servletContext ->
        Role roleAdmin = Role.findByAuthority('ROLE_ADMIN')
        if (!roleAdmin) {
            roleAdmin = new Role(authority: 'ROLE_ADMIN').save()
        }

        User admin = User.findByUsername('admin')
        if (!admin) {
            admin = new User(username: 'admin', password: 'admin').save()
            UserRole.create(admin, roleAdmin)
        }

        Role roleClient = Role.findByAuthority('ROLE_CLIENT')
        if (!roleClient) {
            roleClient = new Role(authority: 'ROLE_CLIENT').save()
        }

        User client = User.findByUsername('client')
        if (!client) {
            client = new User(username: 'client', password: 'client').save()
            UserRole.create(client, roleClient)
        }

    }

    def destroy = {
    }
}
