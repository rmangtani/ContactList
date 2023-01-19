/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList
{
    private ArrayList<Person> contacts;

    public ContactList() {
        contacts = new ArrayList<Person>();
    }

    public void printMenuOptions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    /**
     * Asks user for input to create and add a new Person
     * to the contact list
     */
    public void addContact() {
        Scanner input = new Scanner(System.in);
        System.out.println("Select a type of contact to add: ");
        System.out.println("1. Student");
        System.out.println("2. Inmate");
        int contactType = input.nextInt();
        input.nextLine();
        System.out.println("Please fill in the following information.");
        System.out.println("First Name:");
        String firstName = input.nextLine();
        System.out.println("Last Name:");
        String lastName = input.nextLine();
        System.out.println("Phone number:");
        String phoneNumber = input.nextLine();
        if (contactType == 1) {
            System.out.println("Grade: ");
            int grade = input.nextInt();
            contacts.add(new Student(firstName, lastName, phoneNumber, grade));
        }
        else if (contactType == 2) {
            System.out.println("Crime:");
            String crime = input.nextLine();
            System.out.println("Sentence length (in months):");
            int sentenceLength = input.nextInt();
            contacts.add(new Inmate(firstName, lastName, phoneNumber, crime, sentenceLength));
        }
    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println(contacts.get(i));
        }
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy) {
        int numContacts = contacts.size();
        Person temp;
        String compare1 = "";
        String compare2 = "";
        for (int i = 0; i < numContacts-1; i++) {
            for (int j = 0; j < numContacts-i-1; j++) {
                if (sortBy == 0) {
                    compare1 = contacts.get(j).getFirstName();
                    compare2 = contacts.get(j+1).getFirstName();
                }
                else if (sortBy == 1) {
                    compare1 = contacts.get(j).getLastName();
                    compare2 = contacts.get(j+1).getLastName();
                }
                else if (sortBy == 2) {
                    compare1 = contacts.get(j).getPhoneNumber();
                    compare2 = contacts.get(j+1).getPhoneNumber();
                }
                System.out.println(compare1.compareTo(compare2));
                if (compare1.compareTo(compare2) > 0) {
                    temp = contacts.get(j);
                    contacts.set(j, contacts.get(j+1));
                    contacts.set(j+1, temp);
                }
            }
        }
    }

    public Person searchByFirstName(String firstName) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getFirstName().equals(firstName)) {
                return contacts.get(i);
            }
        }
        return null;
    }

    public Person searchByLastName (String lastName) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getLastName().equals(lastName)) {
                return contacts.get(i);
            }
        }
        return null;
    }

    public Person searchByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber().equals(phoneNumber)) {
                return contacts.get(i);
            }
        }
        return null;
    }

    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents() {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i) instanceof Student) {
                System.out.println(contacts.get(i));
            }
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");
        while (true) {
            printMenuOptions();
            Scanner input = new Scanner(System.in);
            int userOption = input.nextInt();
            input.nextLine();
            if (userOption == 0) {
                break;
            }
            if (userOption == 1) {
                addContact();
            }
            else if (userOption == 2) {
                sort(0);
                printContacts();
            }
            else if (userOption == 3) {
                sort(1);
                printContacts();
            }
            else if (userOption == 4) {
                sort(2);
                printContacts();
            }
            else if (userOption == 5) {
                listStudents();
            }
            else if (userOption == 6) {
                System.out.println("Enter a name:");
                String firstName = input.nextLine();
                Person searchedPerson = searchByFirstName(firstName);
                if (searchedPerson == null) {
                    System.out.println(firstName + " is not in the list.");
                }
                else {
                    System.out.println(searchedPerson);
                }
            }
            else if (userOption == 7) {
                System.out.println("Enter a name:");
                String lastName = input.nextLine();
                Person searchedPerson = searchByLastName(lastName);
                if (searchedPerson == null) {
                    System.out.println(lastName + " is not in the list.");
                }
                else {
                    System.out.println(searchedPerson);
                }
            }
            else if(userOption == 8) {
                System.out.println("Enter a phone number:");
                String phoneNumber = input.nextLine();
                Person searchedPerson = searchByPhoneNumber(phoneNumber);
                if (searchedPerson == null) {
                    System.out.println(phoneNumber + " is not in the list.");
                }
                else {
                    System.out.println(searchedPerson);
                }
            }
            System.out.println("\n");
        }
    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
