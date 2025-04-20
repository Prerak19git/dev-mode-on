package org.example.app.progress.week_1


abstract class Vehicle {

    companion object {
        private var count: Int = 0
    }

    init {
        count++;
        fun showTotal() = println("There are total $count vehicles.")
    }

    abstract val modelName: String
    abstract val price: Long
    abstract val carbonOutput: Long

    abstract fun move(kms: Int): Unit

}


interface Electric {

    fun chargeYourself(): Unit
    fun showBatteryStatus(): Unit
    fun showCapacity(): Unit
}


object Tesla : Vehicle(), Electric {
    override val carbonOutput: Long
        get() = 1000
    override val price: Long
        get() = 2500000
    override val modelName: String
        get() = "ABC-145BK"

    private const val CAPACITY: Int = 100
    private var charge: Int = 100;
    private var batteryStatus = { (charge * 1F / CAPACITY) * 100 }

    override fun chargeYourself() {
        println("my battery is ${batteryStatus()} %., I will charge now")
        charge = CAPACITY
        println("I have charged Myself, now my battery is ${batteryStatus()} %.")
    }

    override fun showBatteryStatus() {
        println("my battery is ${batteryStatus()} %.")
    }

    override fun showCapacity() {
        println("My capacity is $CAPACITY")
    }

    override fun move(kms: Int) {
        if (kms > charge) {
            println("I cant move sorry, charge is $charge , which is not adequate for journey.")
            return
        }
        charge -= kms
        println("Journey was successful, now my battery is ${batteryStatus()} %")
    }
}


fun main() {

    val teslaCar = Tesla
    with(teslaCar){
        showBatteryStatus()
        showCapacity()
        move(95)
        move(45)
        chargeYourself()
        move(36)
    }

}

