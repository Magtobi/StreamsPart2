package com.pluralsight.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("John", "Doe", 25));
        people.add(new Person("Travis", "Thompson", 22));
        people.add(new Person("Mac", "Miller", 26));
        people.add(new Person("Eva", "Johnson", 35));
        people.add(new Person("William", "Moore", 69));
        people.add(new Person("Alice", "Smith", 72));
        people.add(new Person("David", "Brown", 32));
        people.add(new Person("Olivia", "Taylor", 43));
        people.add(new Person("Capital", "Steez", 47));
        people.add(new Person("Sophia", "Jones", 50));

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter a first or last name to search: ");
        String searchName = myScanner.nextLine();

        List<Person> matchingPeople = people.stream()
                .filter(person -> person.getFirstName().equalsIgnoreCase(searchName) ||
                        person.getLastName().equalsIgnoreCase(searchName))
                        .toList();

        System.out.println("\nPeople matching the search name:");
        if (matchingPeople.isEmpty()) {
            System.out.println("No matches found.");
        } else {
            matchingPeople.forEach(person ->
                    System.out.println(person.getFirstName() + " " + person.getLastName()));
        }
        double averageAge = people.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);
        int oldestAge = people.stream()
                .mapToInt(Person::getAge)
                .max()
                .orElse(0);
        int youngestAge = people.stream()
                .mapToInt(Person::getAge)
                .min()
                .orElse(0);

        System.out.println("\nAge of the oldest person: " + oldestAge);
        System.out.println("\nAge of the youngest person: " + youngestAge);
    }
}
