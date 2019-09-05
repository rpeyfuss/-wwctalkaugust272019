package com.reginapeyfuss.services.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class EmployeeJava {
        private String name;
        private double salary;

        EmployeeJava(String _name, double _salary) {
            this.name = _name;
            this.salary = _salary;
        }

        void changeSalary(double amt) {
             this.salary += amt;
        }
        //setters, getters, equals, hashCode omitted
}

class EmployeeJavaFP{
    private final String name;
    private final double salary;

    EmployeeJavaFP(String _name, double _salary) {
        this.name = _name;
        this.salary = _salary;
    }
    final String getName(){return this.name;}
    final double getSalary(){return this.salary;}
    //equals, hashCode omitted
}

class EmployeeRunner {

    public static void main (String[] args) {
        //fp
        ArrayList<EmployeeJavaFP> employeesFP = new ArrayList<>();
        employeesFP.add(new EmployeeJavaFP("Bob", 70000));
        employeesFP.add(new EmployeeJavaFP("Nancy", 75000));
        System.out.println(employeesFP);

        List<EmployeeJavaFP> happierEmployees =
                changeSalary(employeesFP, 1000);
        System.out.println(employeesFP);
        System.out.println(happierEmployees);

    }

    static List<EmployeeJavaFP> changeSalary (
            List<EmployeeJavaFP> employees, double amt) {
        return employees.stream().map(e ->
                new EmployeeJavaFP(e.getName(), e.getSalary() + amt)
        ).collect(Collectors.toList());
    }
}
