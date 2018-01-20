
val x = 10;

class SomeClass {
    lateinit var data: String

    fun createData (givenData: String?) {
        data = givenData!!
    }
}

