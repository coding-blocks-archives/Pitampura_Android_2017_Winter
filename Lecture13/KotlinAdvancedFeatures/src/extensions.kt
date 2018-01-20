fun snakeCase(origString: String): String =
        origString.toLowerCase().replace(" ", "_")

fun String.makeSnakeCase (): String =
        this.toLowerCase().replace(" ", "_")

fun main(args: Array<String>) {
    println("This is a Sentence".makeSnakeCase())
    println("Hello World".makeSnakeCase())

}