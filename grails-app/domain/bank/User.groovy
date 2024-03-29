package bank

class User {

    transient springSecurityService

    String username
    String password
    boolean enabled = true
    boolean accountExpired = false
    boolean accountLocked = false
    boolean passwordExpired = false

    static hasMany = [accounts: Account]

    static mappedBy = [accounts: 'client']

    static constraints = {
        username blank: false, unique: true
        password blank: false
    }

    static mapping = {
        table 'users'
        password column: '`password`'
    }

    Set<Role> getAuthorities() {
        UserRole.findAllByUser(this).collect { it.role } as Set
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService.encodePassword(password)
    }

    String toString() {
        return username
    }
}
