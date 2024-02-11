class Main {
    static void main(String[] args) {
        DivisionClosure divisionClosure = new DivisionClosure()
        SubtractionClosure subtractionClosure = new SubtractionClosure()
        OperationClosure operationClosure = new OperationClosure()

        def a = 10
        def b = 2
        def c = 3
        def d = 5

        def divisionResult = divisionClosure.closure(a, b)
        println "Результат деления: $divisionResult"

        def subtractionResult = subtractionClosure.closure(c, d)
        println "Результат вычитания: $subtractionResult"

        def operationResult = operationClosure.operation(a, b, c)
        println "Результат операции: $operationResult"
    }
}