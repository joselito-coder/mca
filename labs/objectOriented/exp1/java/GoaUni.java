/*
 * To identify entities in the website goauni
 * 
 */

import java.util.Scanner;

class GoaUni {

    public static void main(String[] args) {

        Bachelors bca = new Bachelors("bca", "Bachlors in computer science");
        Masters mca = new Masters("Mca", "Masters in cs", bca);

        Programmes programmes[] = { bca, mca };

        Institutes institute = new Institutes();
        Scanner sc = new Scanner(System.in);

        String menu = "1) show programmes\n2) show seats in mca\n3) show seats in bca\n4) get admission in mca\n5) get admission in bca\n6) get all institudes\n7) Print info about institute\n0) EXIT";

        // mca.getAdmission();
        // mca.showSeats();

        int exit = 0;
        int userChoice;

        while (exit == 0) {

            System.out.println(menu);
            userChoice = sc.nextInt();

            System.out.println();

            switch (userChoice) {
                case 1:
                    // System.out.println(bca.programmeName);
                    // System.out.println(mca.programmeName);
                    System.out.println();

                    for (Programmes prog : programmes) {

                        prog.getProgrammeName();
                    }
                    System.out.println();

                    break;
                case 2:
                    System.out.println();

                    System.out.printf("Seats in mca: %d\n", mca.seatsAvailable);
                    System.out.println();

                    break;
                case 3:
                    System.out.println();

                    System.out.printf("Seats in bca: %d\n", bca.seatsAvailable);
                    System.out.println();

                    break;
                case 4:
                    System.out.println();

                    mca.getAdmission();
                    System.out.println();

                    break;

                case 5:
                    System.out.println();

                    bca.getAdmission();
                    System.out.println();

                    break;

                case 6:
                    System.out.println();

                    institute.getAllInstitutes();
                    System.out.println();

                    break;
                case 7:
                    System.out.println();

                    institute.getInstituteInfo();
                    System.out.println();

                    break;
                case 0:

                    exit = 1;

                    break;

                default:
                    break;
            }

        }

        sc.close();
    }

}

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

    public void getAdmission() {
        if (this.isAdmissionOpen) {

            System.out.println("Admission is open\nYou can visit https://nevergonnagiveuniup.ac.in to apply");
        }
    }

    abstract public void showSeats();

    abstract public void getProgrammeName();
}

class Bachelors extends Programmes {
    String group;
    String programmeName;
    String syllabus;

    Bachelors(String name, String group) {
        this.seatsAvailable = 66;
        this.isAdmissionOpen = seatsAvailable > 0;
        this.programmeName = name;
        this.group = group;
        this.syllabus = "learn learn learn";

    }

    @Override
    public void showSeats() {
        System.out.printf("The seats available are: %d\n", this.seatsAvailable);
    }

    public void getSyllabus() {
        System.out.println(this.syllabus);

    }

    public void getProgrammeName() {
        System.out.println(this.programmeName);
    }
}

class Masters extends Programmes {

    String group;
    String programmeName;
    Bachelors bachelorsDegree;
    String syllabus;

    Masters(String name, String group, Bachelors degree) {
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

    public void getProgrammeName() {
        System.out.println(this.programmeName);
    }

}

class Institutes {

    String allAvailableInstitutes[] = { "Carmel College of Arts, Science &amp; Commerce for Women",
            "Cuncolim Educational Society's College of Arts &amp; Commerce",
            "Dempo Charities Trust Dhempe College of Arts &amp; Science",
            "Dempo Charities Trust's S.S. Dempo College of Commerce &amp; Economics",
            "Diocesan Society of Education’s Rosary College of Commerce &amp; Arts",
            "Dnyan Prabodhini Mandal's Shree Mallikarjun and Shri Chetan Manju Desai College",
            "Dnyanprassarak Mandal's College of Arts, Sou. Sheela Premanand Vaidya College of Science &amp; V. N. S. Bandekar College of Commerce",
            "Dnyanvardhini Divyang Training College", "Don Bosco Society for Higher Education's Don Bosco College",
            "Fr. Agnel College of Arts &amp; Commerce", "Goa College of Agriculture", "Goa College of Home Science",
            "Goa College of Hospitality &amp; Culinary Education",
            "Goa Vidyaprasarak Mandal's Gopal Govind Poy Raiturcar College of Commerce &amp; Economics",
            "Government College of Arts, Science &amp; Commerce, Khandola",
            "Government College of Arts, Science &amp; Commerce, Quepem",
            "Government College of Arts, Science &amp; Commerce, Sanquelim",
            "Government College of Commerce &amp; Economics, Borda-Margao", "Kamaxi College of Culinary Arts",
            "M. E.S.’s Vasant Joshi College of Arts &amp; Commerce",
            "Mandre College of Commerce, Economics and Management",
            "Parvatibai Chowgule College of Arts &amp; Science (Autonomous)",
            "Ponda Education Society's Shri Ravi S. Naik College of Arts &amp; Science",
            "Sant Sohirobanath Ambiye Govt. College of Arts &amp; Commerce, Pernem",
            "Saraswat Vidyalaya's Sridora Caculo College of Commerce &amp; Management Studies",
            "Sateri Pisani Education Society’s Gopal Gaonkar Memorial Goa Multi-Faculty College",
            "St. Joseph Vaz College", "St. Xavier's College", "Swami Brahmanand Mahavidyalayam",
            "Swami Vivekanand Vidyaprasarak Mandal's College of Commerce",
            "Vidya Prabodhini College of Commerce, Education, Computer &amp; Management",
            "Vidya Vikas Mandal's Shree Damodar College of Commerce &amp; Economics",
            "Zantye Brothers Educational Foundation's Narayan Zantye College of Commerce"
    };

    String address;
    String phoneNumber;
    String email;
    String principal;
    String instituteName;

    public Institutes(String instituteName, String address, String phoneNumber, String email,
            String principal) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.principal = principal;
        this.instituteName = instituteName;
    }

    public Institutes() {

        // default values
        this.instituteName = allAvailableInstitutes[3];
        this.address = "Margao";
        this.email = "princiapla@dempouni.ac.in";
        this.principal = "Kamat";
        this.phoneNumber = "93424238241";

    }

    public void getAllInstitutes() {
        for (String institute : allAvailableInstitutes) {
            System.out.println(institute);
        }
    }

    public void getInstituteInfo() {

        System.out.printf("\n\nName: %s\nAddress: %s\nEmail: %s\nPrincipal: %s\nPhone Number:%s\n\n",
                this.instituteName, this.address,
                this.email, this.principal,this.phoneNumber);

    }

}
