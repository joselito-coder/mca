class Programmes:
    def __init__(self, programme_type, duration, college_name, college_address, college_phone_number,
                 has_completed, college_fee_structure, seats_available, is_admission_open):
        self.programme_type = programme_type
        self.duration = duration
        self.college_name = college_name
        self.college_address = college_address
        self.college_phone_number = college_phone_number
        self.has_completed = has_completed
        self.college_fee_structure = college_fee_structure
        self.seats_available = seats_available
        self.is_admission_open = is_admission_open

    def get_admission(self):
        if self.is_admission_open:
            print("Admission is open\nYou can visit https://nevergonnagiveuniup.ac.in to apply")

    def show_seats(self):
        raise NotImplementedError

    def get_programme_name(self):
        raise NotImplementedError


class Bachelors(Programmes):
    def __init__(self, name, group):
        super().__init__(programme_type="Bachelors", duration=3, college_name="", college_address="",
                         college_phone_number="", has_completed=False, college_fee_structure="",
                         seats_available=66, is_admission_open=True)
        self.programme_name = name
        self.group = group
        self.syllabus = "learn learn learn"

    def show_seats(self):
        print(f"The seats available are: {self.seats_available}")

    def get_syllabus(self):
        print(self.syllabus)

    def get_programme_name(self):
        print(self.programme_name)


class Masters(Programmes):
    def __init__(self, name, group, bachelors_degree):
        super().__init__(programme_type="Masters", duration=2, college_name="", college_address="",
                         college_phone_number="", has_completed=False, college_fee_structure="",
                         seats_available=36, is_admission_open=True)
        self.programme_name = name
        self.group = group
        self.bachelors_degree = bachelors_degree

    def show_seats(self):
        print(self.seats_available)

    def get_programme_name(self):
        print(self.programme_name)


class Institutes:



    all_available_institutes = [
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
    ]

    def __str__(self) -> str:
        return "never gonna give you up"

    def __init__(self, institute_name=None, address=None, phone_number=None, email=None, principal=None):
        if institute_name is None:
            institute_name = self.all_available_institutes[3]
        if address is None:
            address = "Margao"
        if phone_number is None:
            phone_number = "93424238241"
        if email is None:
            email = "principal@dempouni.ac.in"
        if principal is None:
            principal = "Kamat"
        
        self.institute_name = institute_name
        self.address = address
        self.phone_number = phone_number
        self.email = email
        self.principal = principal

    def get_all_institutes(self):
        for institute in self.all_available_institutes:
            print(institute)

    def get_institute_info(self):
        print(f"\n\nName: {self.institute_name}\nAddress: {self.address}\nEmail: {self.email}\nPrincipal: {self.principal}\nPhone Number: {self.phone_number}\n\n")


def main():



    bca = Bachelors("BCA", "Bachelors in computer science")
    mca = Masters("MCA", "Masters in CS", bca)

    programmes = [bca, mca]

    institute = Institutes()

    menu = (
        "1) show programmes\n"
        "2) show seats in mca\n"
        "3) show seats in bca\n"
        "4) get admission in mca\n"
        "5) get admission in bca\n"
        "6) get all institutes\n"
        "7) Print info about institute\n"
        "0) EXIT"
    )

    exit_program = False

    while not exit_program:
        print(menu)
        user_choice = int(input())

        print()

        if user_choice == 1:
            for prog in programmes:
                prog.get_programme_name()
            print()
        elif user_choice == 2:
            print(f"Seats in MCA: {mca.seats_available}\n")
        elif user_choice == 3:
            print(f"Seats in BCA: {bca.seats_available}\n")
        elif user_choice == 4:
            mca.get_admission()
            print()
        elif user_choice == 5:
            bca.get_admission()
            print()
        elif user_choice == 6:
            institute.get_all_institutes()
            print()
        elif user_choice == 7:
            institute.get_institute_info()
            print()
        elif user_choice == 0:
            exit_program = True
        else:
            print("Invalid choice, please try again.")

if __name__ == "__main__":
    main()
