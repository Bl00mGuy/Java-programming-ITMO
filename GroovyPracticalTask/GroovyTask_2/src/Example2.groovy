import java.math.BigDecimal

class Example2 {
    static void compareBigDecimals() {
        def bd1 = new BigDecimal("10")
        def bd2 = new BigDecimal("10")

        println "Значение переменной bd1: $bd1"
        println "Значение переменной bd2: $bd2"
        println "Сравнение значений переменных: ${bd1.equals(bd2)}"

        def sum = bd1.add(bd2)
        def division = bd1.divide(bd2)
        def multiplication = bd1.multiply(bd2)

        println "Сумма: $sum"
        println "Деление: $division"
        println "Умножение: $multiplication"

        def sum2 = bd1 + bd2
        def division2 = bd1 / bd2
        def multiplication2 = bd1 * bd2

        println "Сумма (используя операнд): $sum2"
        println "Деление (используя операнд): $division2"
        println "Умножение (используя операнд): $multiplication2"
    }
}
