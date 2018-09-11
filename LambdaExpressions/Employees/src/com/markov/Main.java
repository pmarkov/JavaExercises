package com.markov;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        Employee jack = new Employee("Jack Daniels", 30);
        Employee mary = new Employee("Mary Jane", 23);
        Employee jim = new Employee("Jim Beam", 27);
        Employee johnny = new Employee("Johnny Walker", 35);
        Employee morgan = new Employee("Captain Morgan", 32);
        Employee red = new Employee("Red Wine", 24);

        List<Employee> employees = new ArrayList<>();
        employees.add(jack);
        employees.add(mary);
        employees.add(jim);
        employees.add(johnny);
        employees.add(morgan);
        employees.add(red);

        printEmployeesByAge(employees, "Employees over 30:", employee -> employee.getAge() > 30);
        printEmployeesByAge(employees, "Employees 30 and under:", employee -> employee.getAge() <= 30);
        printEmployeesByAge(employees, "Employees younger than 25:", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

//        IntPredicate greaterThan15 = i -> i > 15;
//        IntPredicate lessThan100 = i -> i < 100;
//        System.out.println(greaterThan15.and(lessThan100).test(50));
//        System.out.println(greaterThan15.and(lessThan100).test(10));
//
//        System.out.println(greaterThan15.test(10));
//        int a = 20;
//        System.out.println(greaterThan15.test(a + 5));
//
//        Random random = new Random();
//        Supplier<Integer> randSupplier = () -> random.nextInt(1000);
//        for(int i = 0; i < 10; i++) {
//            System.out.println(randSupplier.get());
//        }
//
//        employees.forEach(employee -> {
//            String lastName = employee.getName().substring(employee.getName().indexOf(' ') + 1);
//            System.out.println("Last name: " + lastName);
//        });

        Function<Employee, String> getLastName = (Employee employee) ->
                employee.getName().substring(employee.getName().indexOf(' ') + 1);

        String lastName = getLastName.apply(employees.get(1));
//        System.out.println(lastName);

        Function<Employee, String> getFirstName = (Employee employee) ->
                employee.getName().substring(0, employee.getName().indexOf(' '));

        Random random = new Random();
        for(Employee employee : employees) {
            if(random.nextBoolean()) {
                System.out.println(getAName(getFirstName, employee));
            } else {
                System.out.println(getAName(getLastName, employee));
            }
        }

        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(' '));
        Function<Employee, String> chainedFunction = upperCase.andThen(firstName);
        System.out.println(chainedFunction.apply(employees.get(0)));

        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) ->
                name.concat(" " + employee.getAge());

        String upperName = upperCase.apply(employees.get(0));
        System.out.println(concatAge.apply(upperName, employees.get(0)));

        IntUnaryOperator incBy5 = i -> i + 5;
        System.out.println(incBy5.applyAsInt(10));

        Consumer<String> c1 = String::toUpperCase;
        Consumer<String> c2 = System.out::println;

        c1.andThen(c2).accept("Hello World!");

    }

    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
    }

    private static void printEmployeesByAge(List<Employee> employees, String ageText,
                                            Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        for(Employee employee : employees) {
            if(ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
        System.out.println("----------------------------------");
    }
}
