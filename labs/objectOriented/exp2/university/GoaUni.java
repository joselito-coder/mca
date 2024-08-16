package university;
/**
 * This class represents the main application for managing the Goa University programs.
 */
public class GoaUni {

    /**
     * The main method that runs the application.
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {

        Bachelors bca = new Bachelors("bca", "Bachlors in computer science");
        Masters mca = new Masters("Mca", "Masters in cs", bca);

        mca.getAdmission();
        mca.showSeats();
        
    }

}

/**
 * Abstract class representing a general university programme.
 */
abstract class Programmes {
    String programmeType;
    int duration;
    String collegeName;
    String collegeAddress;
    String collegePhoneNumber;
    boolean hasCompleted;
    String collegeFeeStructure;
    int seatsAvailable;
    Boolean isAdmissionOpen;

    /**
     * Prints the admission information if admission is open.
     */
    public void getAdmission() {
        if (this.isAdmissionOpen) {
            System.out.println("Admission is open\nYou can visit https://nevergonnagiveuniup.ac.in to apply");
        }
    }

    /**
     * Abstract method to show the number of seats available.
     * Must be implemented by subclasses.
     */
    abstract public void showSeats();
}

/**
 * Class representing a Bachelor's degree programme.
 */
class Bachelors extends Programmes {
    String group;
    String programmeName;
    String syllabus;

    /**
     * Constructor for the Bachelors class.
     * 
     * @param name The name of the programme
     * @param group The group or specialization of the programme
     */
    Bachelors(String name, String group) {
        this.seatsAvailable = 66;
        this.isAdmissionOpen = seatsAvailable > 0;
        this.programmeName = name;
        this.group = group;
        this.syllabus = "learn learn learn";
    }

    /**
     * Displays the number of seats available for the Bachelor's programme.
     */
    @Override
    public void showSeats() {
        System.out.printf("The seats available are: %d\n", this.seatsAvailable);
    }

    /**
     * Prints the syllabus for the Bachelor's programme.
     */
    public void getSyllabus() {
        System.out.println(this.syllabus);
    }
}

/**
 * Class representing a Master's degree programme.
 */
class Masters extends Programmes {
    String group;
    String programmeName;
    Bachelors bachelorsDegree;
    String syllabus;

    /**
     * Constructor for the Masters class.
     * 
     * @param name The name of the programme
     * @param group The group or specialization of the programme
     * @param degree The Bachelor's degree required for this Master's programme
     */
    Masters(String name, String group, Bachelors degree) {
        this.seatsAvailable = 36;
        this.isAdmissionOpen = seatsAvailable > 0;
        this.programmeName = name;
        this.group = group;
        this.bachelorsDegree = degree;
    }

    /**
     * Displays the number of seats available for the Master's programme.
     */
    @Override
    public void showSeats() {
        System.out.println(this.seatsAvailable);
    }
}
