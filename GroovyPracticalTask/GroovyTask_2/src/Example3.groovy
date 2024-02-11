import java.util.Date

class Example3 {
    static void manipulateDates() {
        def date1 = new Date(115, 1, 28) // 28 февраля 2015 года
        def date2 = new Date(115, 0, 31) // 31 января 2015 года

        def difference = date1 - date2
        println "Разница между датами: $difference"

        // Вычитаем из 28 февраля 1 месяц
        date1.month -= 1
        // Прибавляем к результату 1 день и 1 месяц
        def resultDate = date1 + (1 << 32) + 1
        println "Результат: $resultDate"
    }
}
