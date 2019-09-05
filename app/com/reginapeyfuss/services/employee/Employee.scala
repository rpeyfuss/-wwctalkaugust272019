package com.reginapeyfuss.services.employee

class Employee(var name: String, var salary: Double) {
    def changeSalary(amt: Double) {
        this.salary += amt
    } //setters, getters, equals, hashCode omitted
}

object Employee {
    var employees = List(
        new Employee("Bob", 70000),
        new Employee("Nancy", 75000))
    println(employees)
    employees.foreach(
        e => e.changeSalary(1000)
    )
    println(employees)
}

case class EmployeeFP(name: String, salary: Double)

object EmployeeFP {
    def changeSalary(employees: List[EmployeeFP], amt: Double): List[EmployeeFP] = {
        employees.map(e => e.copy(salary = e.salary + amt))
    }

    val employees = List(
        new EmployeeFP("Bob", 70000),
        new EmployeeFP("Nancy", 75000))
    val happierEmployees: List[EmployeeFP] = changeSalary(employees, 1000)
    println(employees)
    println(happierEmployees)
}



