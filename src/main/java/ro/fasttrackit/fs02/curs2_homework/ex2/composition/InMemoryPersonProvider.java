package ro.fasttrackit.fs02.curs2_homework.ex2.composition;

import ro.fasttrackit.fs02.curs2_homework.ex2.inheritance.Person;

import java.util.List;

public class InMemoryPersonProvider implements PersonProvider{
    @Override
    public List<Person> readPersons() {
        return List.of(
                new Person("Maria", "Patru", 22)
                , new Person("Dragos", "Baciu", 33)
                , new Person("Ciprian", "Axinte", 55)
                , new Person("Marius", "Dumitru", 14)
                , new Person("Sofia", "Patrusu", 4)
        );
    }
}
