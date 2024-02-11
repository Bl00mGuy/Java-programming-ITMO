import groovy.sql.Sql

class OracleDatabase {
    /*def url = 'jdbc:oracle:thin:@//hostname:port/service_name'
    def usernamePrefix = 'hr'
    def password = 'your_password'

    def getConnection(username, password) {
        def connectionProps = ['user': username, 'password': password]
        DriverManager.getConnection(url, connectionProps)
    }

    def fetchDataFromEmployeesTable() {
        def employees = []

        (1..12).each { i ->
            def username = "${usernamePrefix}${String.format('%02d', i)}"
            def connection = getConnection(username, password)
            def sql = new Sql(connection)

            def resultSet = sql.rows("SELECT * FROM Item")
            employees.addAll(resultSet)

            sql.close()
            connection.close()
        }

        return employees
    }*/
}