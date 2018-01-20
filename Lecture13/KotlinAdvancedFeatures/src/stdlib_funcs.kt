class Vehicle (
        var wheels: Int,
        val color: String,
        val hornSound: String
) {
    fun playHorn() {
        println(hornSound)
    }

    fun getAxles () = wheels / 2
}

var car = Vehicle(4, "red", "beep")
var truck = Vehicle(6, "brown", "honk")
var bicycle = Vehicle(2, "black", "tring")

fun main (args: Array<String>) {

    val x = run {
        val p = 1 + 2
        p - 1
    }
    println(x) // 2 ( x = p - 1 )

    with(car) {
        playHorn() //beep
    }
    // car.playHorn()

    var carAxles = with(car) {
        wheels = 10
        getAxles()
    }
    println("Car Axles = $carAxles")

    val axles = truck.run {
        getAxles()
    }
    println(axles) // 3 (axles = truck.getAxles() )

    val carWithSpare = car.apply {
        wheels += 1
    }
    println(carWithSpare.wheels) // 5 (car.wheels +=1; carWithSpare = car)

    val unicycle = bicycle.also {
        it.wheels -= 1
    }
    println(unicycle.wheels) // 1 (bicycle.wheels -= 1; unicycle = bicycle)

    val truckColor = truck.let {
        it.wheels = 8
        it.color
    }
    println(truckColor) // brown (truckColor = truck.color)

    val safeTruck = truck.takeIf {
        it.wheels == 9
    }
    println(safeTruck) // null (safeTruck = truck.wheels == 9 ? truck : null)

    val safeCar = car.takeIf {
        it.wheels == 5
    }
    println(safeCar?.wheels) // 5 (safeCar = car.wheels == 5 ? car : null)


//    a?.let {
//       it.b?.let {
//           it?. let {
//
//           } ?: println("c doesn't exist")
//       } ?: println("b doesn't exist")
//    } ?: println("a doesn't exist")


}