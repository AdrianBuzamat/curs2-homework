package ro.fasttrackit.fs02.curs2_homework.ex2.composition;

import ro.fasttrackit.fs02.curs2_homework.ex2.inheritance.Person;

import java.util.List;

public interface PersonProvider {
    List<Person> readPersons();
}
