
fun sayHello (
        getFirstName: (Int, Int) -> String,
        getLastName: (Int) -> String) {
    println("Hello " +
            getFirstName(10,11) +
            getLastName(12))
}


fun main(args: Array<String>) {
    val nameGetter: (Int) -> String = { "Gupta" }

    sayHello(
            {i,j -> "Arnav $i $j"},
            nameGetter)
}