package ro.fasttrackit.fs02.curs2_homework.ex2.inheritance;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@RequiredArgsConstructor
public class FileReportGenerator extends PersonReportGenerator {
    private final String sourceFile;

    @Override
    List<Person> readPersons() {
        try {
            return Files.lines(Path.of(sourceFile))
                    .map(this::toPersons)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Person toPersons(String line) {
        String[] tokens = line.split(",");
        return new Person(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
    }
}
