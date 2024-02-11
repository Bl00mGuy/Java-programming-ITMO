class Example4 {
    static void demonstrateVariableType() {
        def variable = 10
        println "Тип переменной после присвоения значения 10: ${variable.getClass().getName()}"
        // Попытаемся присвоить переменной значение 'f' и 'First'
        variable = 'f'
        println "Тип переменной после присвоения значения 'f': ${variable.getClass().getName()}"
        variable = 'First'
        println "Тип переменной после присвоения значения 'First': ${variable.getClass().getName()}"
    }
}