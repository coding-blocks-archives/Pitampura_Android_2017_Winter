
fun sayHello (
        getFirstName: (Int, Int) -> String,
        getLastName: (Int) -> String) {
    println("Hello " +
            getFirstName(10,11) +
            getLastName(12))
}


fun main(args: Array<String>) {
//    fun nameGetter (): String {
//        return "Arnav"
//    }
    sayHello(
            {i,j -> "Arnav $i $j"},
            {"Gupta" + it})
}