class OperationClosure {
    def operation = { a, b, c ->
        def divisionClosure = new DivisionClosure()
        def subtractionClosure = new SubtractionClosure()

        def divisionResult = divisionClosure.closure(a, b)
        return subtractionClosure.closure(c, divisionResult)
    }
}