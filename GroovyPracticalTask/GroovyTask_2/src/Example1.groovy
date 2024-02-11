class Example1 {
    static Integer methodWithIntegerParameter(Integer param) {
        return param
    }

    static int methodWithIntParameter(Integer param) {
        if (param != null) {
            return param.intValue()
        }
        return 0
    }
}