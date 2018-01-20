
open class X {
    val a = 10
}

// myObj is a singleton of itself
object myObj: X() {
    val b = 20
}

fun main(args: Array<String>) {
    println(myObj.a)
    println(myObj.b)
}