package ro.fasttrackit.fs02.curs2_homework.ex2.composition;

import java.io.IOException;

public class MainComposition {
    public static void main(String[] args) throws IOException {
        new PersonReportGenerator(getPersonProvider())
        .generateReport("output-composition.txt");

    }

    private static PersonProvider getPersonProvider(){
        return new FileCountryProvider("src/main/resources/people.txt");
    }
}
