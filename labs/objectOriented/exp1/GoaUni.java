/*
 * To identify entities in the website goauni
 * 
 */

class GoaUni{

    public static void main(String[] args) {

        Bachelors bca = new Bachelors("bca","Bachlors in computer science");
        Masters mca = new Masters("Mca", "Masters in cs", bca);

        mca.getAdmission();
        mca.showSeats();
        
    }

}

abstract class Programmes{
    String programmeType;
    int duration;
    String collegeName;
    String collegeAddress;
    String collegePhoneNumber;
    boolean hasCompleted;
    String collegeFeeStructure;
    int seatsAvailable;
    Boolean isAdmissionOpen;

    public void getAdmission() {
        if(this.isAdmissionOpen){

            System.out.println("Admission is open\nYou can visit https://nevergonnagiveuniup.ac.in to apply");
        }
    }


    abstract public void showSeats();
}

class Bachelors extends Programmes{
    String group;
    String programmeName;
    String syllabus;

    Bachelors(String name, String group){
        this.seatsAvailable = 66;
        this.isAdmissionOpen = seatsAvailable > 0;
        this.programmeName = name;
        this.group = group;
        this.syllabus = "learn learn learn";

    }


    @Override
    public void showSeats() {
        System.out.printf("The seats available are: %d\n",this.seatsAvailable);
    }
    public void getSyllabus(){
        System.out.println(this.syllabus);

    }
}

class Masters extends Programmes{

    String group;
    String programmeName;
    Bachelors bachelorsDegree;
    String syllabus;

    Masters(String name, String group,Bachelors degree){
        this.seatsAvailable = 36;
        this.isAdmissionOpen = seatsAvailable > 0;
        this.programmeName = name;
        this.group = group;
        this.bachelorsDegree = degree;

    }

    @Override
    public void showSeats() {
        System.out.println(this.seatsAvailable);
    }

}

