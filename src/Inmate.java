public class Inmate extends Person {
    private int sentenceLength;
    private String crime;

    public Inmate(String firstName, String lastName, String phoneNumber, int sentenceLength, String crime) {
        super(firstName, lastName, phoneNumber);
        this.sentenceLength = sentenceLength;
        this.crime = crime;
    }
}
