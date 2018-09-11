package com.markov;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        new Thread(()-> {
//            System.out.println("Printing from the Runnable");
//            System.out.println("Line 2");
//            System.out.format("This is line %d\n", 3);
//        }).start();

        Employee jack = new Employee("Jack Daniels", 30);
        Employee mary = new Employee("Mary Jane", 23);
        Employee jim = new Employee("Jim Beam", 27);
        Employee johnny = new Employee("Johnny Walker", 35);

        List<Employee> employees = new ArrayList<>();
        employees.add(jack);
        employees.add(mary);
        employees.add(jim);
        employees.add(johnny);

        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

//        for(Employee employee : employees) {
//            System.out.println(employee.getName());
//            new Thread(() -> System.out.println(employee.getAge())).start();
//        }



//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

//        Collections.sort(employees, (e1, e2) ->
//                e1.getName().compareTo(e2.getName()));
//
//        UpperConcat lambdaUC = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
//
//        String sillyString = doStringStuff(lambdaUC, employees.get(0).getName(), employees.get(1).getName());
//
//        for(Employee employee : employees) {
//            System.out.println(employee.getName());
//        }
//
//        System.out.println(sillyString);

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);

    }

    public static String doStringStuff(UpperConcat uc, String string1, String string2) {
        return uc.upperAndConcat(string1, string2);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat {
    String upperAndConcat(String s1, String s2);
}

class AnotherClass {

    public String doSomething() {

        System.out.println("The AnotherClass class's name is: " + this.getClass().getSimpleName());

        int i = 0;

        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression's class is: " + this.getClass().getSimpleName());
            System.out.println("i in the lambda expression = " + i);
            return s1.toUpperCase() + s2.toUpperCase();
        };

        return Main.doStringStuff(uc, "String1", "String2");

//        return Main.doStringStuff((s1, s2) -> {
//            System.out.println("The lambda expression's class is: " + this.getClass().getSimpleName());
//            return s1.toUpperCase() + s2.toUpperCase();
//        }, "String1", "String2");
    }

    public void printValue() {

    }
}

