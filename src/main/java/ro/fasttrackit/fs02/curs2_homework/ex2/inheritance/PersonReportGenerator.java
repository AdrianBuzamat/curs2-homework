package ro.fasttrackit.fs02.curs2_homework.ex2.inheritance;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class PersonReportGenerator {
    abstract List<Person> readPersons();

    public void generateReport(String outputFile) throws IOException {
        List<Person> personList = readPersons();
        generateReport(personList, outputFile);

    }

    private void generateReport(List<Person> personList, String outputFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            personList.stream()
                    .collect(Collectors.groupingBy(person2Group, Collectors.mapping(Person::firstName, Collectors.toList())))
                    .entrySet().stream()
                    .map(e -> e.getKey() + ": " + e.getValue())
                    .sorted()
                    .forEach(line -> writeLine(writer, line));
        }
    }

    Function<Person, String> person2Group = person -> {
        if (person.age() >= 1 && person.age() < 30) {
            return "1-30";
        } else if (person.age() >= 30 && person.age() < 50) {
            return "30-50";
        } else {
            return "50+";
        }
    };

    private void writeLine(BufferedWriter writer, String line) {
        try {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
