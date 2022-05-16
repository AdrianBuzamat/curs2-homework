package ro.fasttrackit.fs02.curs2_homework.ex2.inheritance;

import java.io.IOException;

public class MainInheritance {
    public static void main(String[] args) throws IOException {
        FileReportGenerator generator = new FileReportGenerator("src/main/resources/people.txt");
        generator.generateReport("output.txt");
        InMemoryReportGenerator generator1 = new InMemoryReportGenerator();
        generator1.generateReport("output2.txt");
    }
}
