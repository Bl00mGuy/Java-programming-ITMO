import groovy.lang.Binding

class Main {
    static void main(String[] args) {
        def firstInstance = new FirstClass("John", 30)

        def binding = new Binding()
        binding.setVariable("name", "Alice")
        binding.setVariable("age", 25)

        def shell = new GroovyShell(binding)
        shell.evaluate('firstInstance = new FirstClass(name, age)')
        println "Name: ${binding.getVariable('name')}, Age: ${binding.getVariable('age')}"
        println "Name: ${binding.getVariable('firstInstance').name}, Age: ${binding.getVariable('firstInstance').age}"

        def str = "Hello"
        def num = 5

        println str instanceof String
        println num instanceof Integer

        someMethod()
    }

    static Integer someMethod() {
        Integer result
        return result ?: 0
    }
}