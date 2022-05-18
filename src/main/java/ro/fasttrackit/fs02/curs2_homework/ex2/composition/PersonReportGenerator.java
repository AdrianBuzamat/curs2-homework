package ro.fasttrackit.fs02.curs2_homework.ex2.composition;

import lombok.RequiredArgsConstructor;
import ro.fasttrackit.fs02.curs2_homework.ex2.inheritance.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@RequiredArgsConstructor
public class PersonReportGenerator {
    private final PersonProvider personProvider;


    public void generateReport(String outputFile) throws IOException {
        List<Person> personList = personProvider.readPersons();
        generateReport(personList, outputFile);

    }

    private void generateReport(List<Person> personList, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            person2Group(personList).entrySet().stream()
                    .map(e -> e.getKey() + ": " + e.getValue())
                    .sorted()
                    .forEach(line -> writeLine(writer, line));
        }
    }

    private void writeLine(BufferedWriter writer, String line) {
        try {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<String, List<String>> person2Group(List<Person> persons) {
        Map<String, List<String>> result = new HashMap<>();

        result.put("1-10", new ArrayList<>());
        result.put("30-50", new ArrayList<>());
        result.put("50+", new ArrayList<>());

        for (Person person : persons) {
            if (person.age() >= 1 && person.age() < 30) {
                result.get("1-10").add(String.join(" ", person.firstName(), person.lastName()));
            } else if (person.age() >= 30 && person.age() < 50) {
                result.get("30-50").add(String.join(" ", person.firstName(), person.lastName()));
            } else {
                result.get("50+").add(String.join(" ", person.firstName(), person.lastName()));
            }
        }
        return result;
    }

}
