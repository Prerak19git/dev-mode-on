package org.example.app.week_1


open class Person(val name: String) {

    companion object {
        private var countOrPersons: Int = 0

        public fun showCount() = println("There are total $countOrPersons persons")

    }

    init {
        countOrPersons++;
    }

    open fun printYourSelf(): Unit {
        println(" I am just a person, there are total $countOrPersons persons")
    }

}


class Student(name: String, val standard: Int) : Person(name) {

    companion object {
        private var countForStudents: Int = 0;
        public fun showCount() = println("There are total $countForStudents students")

    }

    init {
        countForStudents++;
    }

    override fun printYourSelf() {
        println("I am a person , specifically a Student, with id : $countForStudents ")
    }
}

class Employee(name: String, val companyName: String) : Person(name) {

    companion object {
        private var countForEmployees: Int = 0;
        public fun showCount() = println("There are total $countForEmployees employees")

    }

    init {
        countForEmployees++;
    }

    override fun printYourSelf() {
        println("I am a person , specifically an Employee, with id : $countForEmployees ")
    }
}



fun main() {

    val person = Person("Person_1")
    person.printYourSelf()
    Person.showCount()
    val student1 = Student("Student_1", 12)
    student1.printYourSelf()
    Person.showCount()
    val employee1 = Employee("Employee_1", "Google")
    employee1.printYourSelf()
    Person.showCount()
    val student2 = Student("Student_2", 11)
    student2.printYourSelf()
    Person.showCount()
    val employee2 = Employee("Employee_2", "Apple")
    employee2.printYourSelf()


    Person.showCount()
    Student.showCount()
    Employee.showCount()

}