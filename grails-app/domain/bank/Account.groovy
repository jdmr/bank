package bank

class Account {
    String name

    static belongsTo = [client: User, manager: User]

    static constraints = {
    }

    static mapping = {
        table 'accounts'
        name(name:'account_name', index: ['account_idx'])
    }
}
