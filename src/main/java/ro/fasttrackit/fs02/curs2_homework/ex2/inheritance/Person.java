package ro.fasttrackit.fs02.curs2_homework.ex2.inheritance;

public record Person(String firstName, String lastName, int age) {
    public String fullName(String firstName, String lastName){
        return firstName + lastName;
    }
}
