class Main {
    static void main(String[] args) {
        println "Пример 1:"
        Integer result1 = Example1.methodWithIntegerParameter(null)
        int result2 = Example1.methodWithIntParameter(null)
        println "Результат выполнения метода с типом Integer: $result1"
        println "Результат выполнения метода с типом int: $result2"

        println "\nПример 2:"
        Example2.compareBigDecimals()

        println "\nПример 3:"
        Example3.manipulateDates()

        println "\nПример 4:"
        Example4.demonstrateVariableType()
    }
}
