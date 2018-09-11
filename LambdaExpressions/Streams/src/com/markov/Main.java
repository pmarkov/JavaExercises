package com.markov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36", "B12", "B6",
                "G53", "G49", "G6", "G50", "g64",
                "I26", "I17", "I29", "071");

        List<String> gNumbers = new ArrayList<>();

        someBingoNumbers.forEach(number -> {
            if (number.toUpperCase().startsWith("G")) {
                gNumbers.add(number);
//                System.out.println(number);
            }
        });

//        gNumbers.sort((String s1, String s2) -> s1.compareToIgnoreCase(s2));
//        gNumbers.forEach(System.out::println);

        someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        Stream<String> ioNumbers = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumbers = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        Stream<String> concatStream = Stream.concat(ioNumbers, inNumbers);
        System.out.println("-----------------------------------------");
        System.out.println(concatStream
                .distinct()
                .peek(System.out::println)
                .count());

        Employee gosho = new Employee("Gosho Kuciq", 42);
        Employee pavel = new Employee("Mrusniq Pavel", 24);
        Employee ico = new Employee("Ico Dulgoto Oko", 25);
        Employee mitko = new Employee("Mitko Kioraviq", 30);

        Department hr = new Department("Human Resources");
        hr.addEmployee(pavel);
        hr.addEmployee(ico);
        hr.addEmployee(gosho);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(mitko);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        System.out.println("----------------------");
//        List<String> sortedGNumbers = someBingoNumbers
//                .stream()
//                .map(String::toUpperCase)
//                .filter(s -> s.startsWith("G"))
//                .sorted()
//                .collect(Collectors.toList());

        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        for (String number : sortedGNumbers) {
            System.out.println(number);
        }

        Map<Integer, List<Employee>> groupedByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(Employee::getAge));

        System.out.println("--------------------------------");
        for(Map.Entry<Integer, List<Employee>> entry : groupedByAge.entrySet()) {
            System.out.println(entry.getKey());
            for(Employee employee: entry.getValue()) {
                System.out.format("%s, %d\n", employee.getName(), employee.getAge());
            }
        }

        System.out.println("--------------------------------");
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);

        Stream.of("ABC", "AC", "USSR", "CCCP", "XY", "SS")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                })
                .count();


    }
}




























