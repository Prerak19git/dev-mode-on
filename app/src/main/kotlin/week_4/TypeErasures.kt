package org.example.app.week_4


inline fun <reified T> printType(params: T) {

    println(T::class.simpleName)
}

inline fun <reified T> isOfType(typeToCheck: Any?): Boolean {

    return typeToCheck is T
}


fun main() {

    val justAString = "String"
    val justAInt = 12
    val justAList = listOf("sljdfl", "sklfj", "skfj")

    printType<String>(justAString)
    printType<Int>(justAInt)
    printType<List<String>>(justAList)

    println(isOfType<String>("sdlfkjsdf"))
    println(isOfType<Int>("sdfkjdsfk"))


}