class DivisionClosure {
    def closure = { a, b ->
        if (b != 0) {
            return a / b
        } else {
            throw new IllegalArgumentException("Деление на ноль невозможно.")
        }
    }
}