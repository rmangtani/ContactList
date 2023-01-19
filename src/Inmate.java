public class Inmate extends Person {
    private String crime;
    private int sentenceLength;

    public Inmate(String firstName, String lastName, String phoneNumber, String crime, int sentenceLength) {
        super(firstName, lastName, phoneNumber);
        this.crime = crime;
        this.sentenceLength = sentenceLength;
    }

    public String getCrime() {
        return crime;
    }

    public int getSentenceLength() {
        return sentenceLength;
    }

    @Override
    public String toString() {
        return super.toString() + " " + crime + " " + sentenceLength +  " months";
    }
}
