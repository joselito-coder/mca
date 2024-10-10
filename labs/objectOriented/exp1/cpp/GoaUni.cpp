#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Programmes
{
public:
    string programmeType;
    int duration;
    string collegeName;
    string collegeAddress;
    string collegePhoneNumber;
    bool hasCompleted;
    string collegeFeeStructure;
    int seatsAvailable;
    bool isAdmissionOpen;

    virtual void showSeats() = 0;
    virtual void getProgrammeName() = 0;

    void getAdmission()
    {
        if (isAdmissionOpen)
        {
            cout << "Admission is open\nYou can visit https://nevergonnagiveuniup.ac.in to apply" << endl;
        }
    }
};

class Bachelors : public Programmes
{
public:
    string group;
    string programmeName;
    string syllabus;

    Bachelors(string name, string group)
    {
        this->seatsAvailable = 66;
        this->isAdmissionOpen = seatsAvailable > 0;
        this->programmeName = name;
        this->group = group;
        this->syllabus = "learn learn learn";
    }

    void showSeats() override
    {
        cout << "The seats available are: " << seatsAvailable << endl;
    }

    void getSyllabus()
    {
        cout << syllabus << endl;
    }

    void getProgrammeName() override
    {
        cout << programmeName << endl;
    }
};

class Masters : public Programmes
{
public:
    string group;
    string programmeName;
    Bachelors *bachelorsDegree;

    Masters(string name, string group, Bachelors *degree)
    {
        this->seatsAvailable = 36;
        this->isAdmissionOpen = seatsAvailable > 0;
        this->programmeName = name;
        this->group = group;
        this->bachelorsDegree = degree;
    }

    void showSeats() override
    {
        cout << seatsAvailable << endl;
    }

    void getProgrammeName() override
    {
        cout << programmeName << endl;
    }
};

class Institutes
{
private:
    vector<string> allAvailableInstitutes = {
        "Carmel College of Arts, Science & Commerce for Women",
        "Cuncolim Educational Society's College of Arts & Commerce",
        "Dempo Charities Trust Dhempe College of Arts & Science",
        "Dempo Charities Trust's S.S. Dempo College of Commerce & Economics",
        "Diocesan Society of Education’s Rosary College of Commerce & Arts",
        "Dnyan Prabodhini Mandal's Shree Mallikarjun and Shri Chetan Manju Desai College",
        "Dnyanprassarak Mandal's College of Arts, Sou. Sheela Premanand Vaidya College of Science & V. N. S. Bandekar College of Commerce",
        "Dnyanvardhini Divyang Training College", "Don Bosco Society for Higher Education's Don Bosco College",
        "Fr. Agnel College of Arts & Commerce", "Goa College of Agriculture", "Goa College of Home Science",
        "Goa College of Hospitality & Culinary Education",
        "Goa Vidyaprasarak Mandal's Gopal Govind Poy Raiturcar College of Commerce & Economics",
        "Government College of Arts, Science & Commerce, Khandola",
        "Government College of Arts, Science & Commerce, Quepem",
        "Government College of Arts, Science & Commerce, Sanquelim",
        "Government College of Commerce & Economics, Borda-Margao", "Kamaxi College of Culinary Arts",
        "M. E.S.’s Vasant Joshi College of Arts & Commerce",
        "Mandre College of Commerce, Economics and Management",
        "Parvatibai Chowgule College of Arts & Science (Autonomous)",
        "Ponda Education Society's Shri Ravi S. Naik College of Arts & Science",
        "Sant Sohirobanath Ambiye Govt. College of Arts & Commerce, Pernem",
        "Saraswat Vidyalaya's Sridora Caculo College of Commerce & Management Studies",
        "Sateri Pisani Education Society’s Gopal Gaonkar Memorial Goa Multi-Faculty College",
        "St. Joseph Vaz College", "St. Xavier's College", "Swami Brahmanand Mahavidyalayam",
        "Swami Vivekanand Vidyaprasarak Mandal's College of Commerce",
        "Vidya Prabodhini College of Commerce, Education, Computer & Management",
        "Vidya Vikas Mandal's Shree Damodar College of Commerce & Economics",
        "Zantye Brothers Educational Foundation's Narayan Zantye College of Commerce"};

public:
    string address;
    string phoneNumber;
    string email;
    string principal;
    string instituteName;

    Institutes(string instituteName = "Dempo Charities Trust's S.S. Dempo College of Commerce & Economics",
               string address = "Margao", string phoneNumber = "93424238241",
               string email = "principal@dempouni.ac.in", string principal = "Kamat")
    {
        this->address = address;
        this->phoneNumber = phoneNumber;
        this->email = email;
        this->principal = principal;
        this->instituteName = instituteName;
    }

    void getAllInstitutes()
    {
        for (const string &institute : allAvailableInstitutes)
        {
            cout << institute << endl;
        }
    }

    void getInstituteInfo()
    {
        cout << "\n\nName: " << instituteName
             << "\nAddress: " << address
             << "\nEmail: " << email
             << "\nPrincipal: " << principal
             << "\nPhone Number: " << phoneNumber << "\n\n";
    }
};

int main()
{
    Bachelors bca("BCA", "Bachelors in Computer Science");
    Masters mca("MCA", "Masters in CS", &bca);

    vector<Programmes *> programmes = {&bca, &mca};

    Institutes institute;
    int userChoice;
    bool exit = false;

    string menu = "1) show programmes\n2) show seats in mca\n3) show seats in bca\n4) get admission in mca\n5) get admission in bca\n6) get all institutes\n7) Print info about institute\n0) EXIT";

    while (!exit)
    {
        cout << menu << endl;
        cin >> userChoice;
        cout << endl;

        switch (userChoice)
        {
        case 1:
            for (Programmes *prog : programmes)
            {
                prog->getProgrammeName();
            }
            cout << endl;
            break;

        case 2:
            cout << "Seats in mca: " << mca.seatsAvailable << endl;
            cout << endl;
            break;

        case 3:
            cout << "Seats in bca: " << bca.seatsAvailable << endl;
            cout << endl;
            break;

        case 4:
            mca.getAdmission();
            cout << endl;
            break;

        case 5:
            bca.getAdmission();
            cout << endl;
            break;

        case 6:
            institute.getAllInstitutes();
            cout << endl;
            break;

        case 7:
            institute.getInstituteInfo();
            cout << endl;
            break;

        case 0:
            exit = true;
            break;

        default:
            break;
        }
    }

    return 0;
}
