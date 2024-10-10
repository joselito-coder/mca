using System;
using System.Collections.Generic;

class GoaUni
{
    public static void Main(string[] args)
    {
        Bachelor bca = new Bachelor("BCA", "Bachelor of Computer Applications");
        Master mca = new Master("MCA", "Master of Computer Applications", bca);

        Program[] programs = { bca, mca };

        Institutes institute = new Institutes();
        // Scanner sc = new Scanner(Console.In); // Replace Scanner with Console.In for C#

        string menu = "1) Show Programs\n2) Show Seats in MCA\n3) Show Seats in BCA\n4) Get Admission in MCA\n5) Get Admission in BCA\n6) Get All Institutes\n7) Print Info About Institute\n0) EXIT";

        int exit = 0;
        int userChoice;

        while (exit == 0)
        {
            Console.WriteLine(menu);
            userChoice = int.Parse(Console.ReadLine()); // Use int.Parse for user input

            Console.WriteLine();

            switch (userChoice)
            {
                case 1:
                    foreach (Program program in programs)
                    {
                        program.GetProgramName();
                    }
                    Console.WriteLine();
                    break;
                case 2:
                    Console.WriteLine($"Seats in MCA: {mca.SeatsAvailable}");
                    Console.WriteLine();
                break;
                case 3:
                    Console.WriteLine($"Seats in BCA: {bca.SeatsAvailable}");
                    Console.WriteLine();
                    break;
                case 4:
                    mca.GetAdmission();
                    Console.WriteLine();
                    break;
                case 5:
                    bca.GetAdmission();
                    Console.WriteLine();
                    break;
                case 6:
                    institute.GetAllInstitutes();
                    Console.WriteLine();
                    break;
                case 7:
                    institute.GetInstituteInfo();
                    Console.WriteLine();
                    break;
                case 0:
                    exit = 1;
                    break;
                default:
                    break;
            }
        }
    }
}

abstract class Program
{
    public string ProgramType { get; set; }
    public int Duration { get; set; }
    public string CollegeName { get; set; }
    public string CollegeAddress { get; set; }
    public string CollegePhoneNumber { get; set; }
    public bool HasCompleted { get; set; }
    public string CollegeFeeStructure { get; set; }
    public int SeatsAvailable { get; set; }
    public bool IsAdmissionOpen { get; set; }

    public virtual void GetAdmission()
    {
        if (IsAdmissionOpen)
        {
            Console.WriteLine("Admission is open.\nYou can visit https://nevergonnagiveuniup.ac.in to apply");
        }
    }

    public abstract void ShowSeats();

    public abstract void GetProgramName();
}

class Bachelor : Program
{
    public string Group { get; set; }
    public string Syllabus { get; set; }

    public Bachelor(string name, string group)
    {
        SeatsAvailable = 66;
        IsAdmissionOpen = SeatsAvailable > 0;
        ProgramType = name;
        Group = group;
        Syllabus = "Learn, Learn, Learn";
    }

    public override void ShowSeats()
    {
        Console.WriteLine($"The available seats are: {SeatsAvailable}");
    }

    public void GetSyllabus()
    {
        Console.WriteLine(Syllabus);
    }

    public override void GetProgramName()
    {
        Console.WriteLine(ProgramType);
    }
}

class Master : Program
{
    public string Group { get; set; }
    public Bachelor BachelorsDegree { get; set; }
    public string Syllabus { get; set; }

    public Master(string name, string group, Bachelor degree)
    {
        SeatsAvailable = 36;
        IsAdmissionOpen = SeatsAvailable > 0;
        ProgramType = name;
        Group = group;
        BachelorsDegree = degree;
    }

    public override void ShowSeats()
    {
        Console.WriteLine(SeatsAvailable);
    }

    public override void GetProgramName()
    {
        Console.WriteLine(ProgramType);
    }
}


class Institutes
{
    public string[] AllAvailableInstitutes =
    {
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
        "Zantye Brothers Educational Foundation's Narayan Zantye College of Commerce"
    };

    public string Address { get; set; }
    public string PhoneNumber { get; set; }
    public string Email { get; set; }
    public string Principal { get; set; }
    public string InstituteName { get; set; }

    public Institutes(string instituteName, string address, string phoneNumber, string email,
            string principal)
    {
        InstituteName = instituteName;
        Address = address;
        PhoneNumber = phoneNumber;
        Email = email;
        Principal = principal;
    }

    public Institutes()
    {
        // Default values
        InstituteName = AllAvailableInstitutes[3];
        Address = "Margao";
        Email = "princiapla@dempouni.ac.in";
        Principal = "Kamat";
        PhoneNumber = "93424238241";
    }

    public void GetAllInstitutes()
    {
        foreach (string institute in AllAvailableInstitutes)
        {
            Console.WriteLine(institute);
        }
    }

    public void GetInstituteInfo()
    {
        Console.WriteLine($"\n\nName: {InstituteName}\nAddress: {Address}\nEmail: {Email}\nPrincipal: {Principal}\nPhone Number: {PhoneNumber}\n\n");
    }
}