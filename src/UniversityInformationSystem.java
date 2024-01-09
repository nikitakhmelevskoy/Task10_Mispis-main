import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class University {
    String name;
    List<Faculty> faculties;

    University(String name) {
        this.name = name;
        this.faculties = new ArrayList<>();
    }
}

class Faculty {
    String name;
    Dean dean;
    List<Institute> institutes;

    Faculty(String name) {
        this.name = name;
        this.institutes = new ArrayList<>();
    }
}

class Institute {
    String name;
    String address;

    Institute(String name, String address) {
        this.name = name;
        this.address = address;
    }
}

class Dean extends Employee {
    Dean(String socialSecurityNumber, String name, String email) {
        super(socialSecurityNumber, name, email);
    }
}

class Employee {
    String socialSecurityNumber;
    String name;
    String email;

    Employee(String socialSecurityNumber, String name, String email) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.name = name;
        this.email = email;
    }
}

class Researcher extends Employee {
    String researchArea;
    List<Project> projects;

    Researcher(String socialSecurityNumber, String name, String email, String researchArea) {
        super(socialSecurityNumber, name, email);
        this.researchArea = researchArea;
        this.projects = new ArrayList<>();
    }
}

class Project {
    String name;
    Date startDate;
    Date endDate;
    int hours;

    Project(String name, Date startDate, Date endDate, int hours) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.hours = hours;
    }
}

class AdministrativePersonal extends Employee {
    AdministrativePersonal(String socialSecurityNumber, String name, String email) {
        super(socialSecurityNumber, name, email);
    }
}

class Lecturer extends Researcher {
    List<Course> courses;

    Lecturer(String socialSecurityNumber, String name, String email, String researchArea) {
        super(socialSecurityNumber, name, email, researchArea);
        this.courses = new ArrayList<>();
    }
}

class Course {
    int uniqueNumber;
    String name;
    int weeklyDuration;

    Course(int uniqueNumber, String name, int weeklyDuration) {
        this.uniqueNumber = uniqueNumber;
        this.name = name;
        this.weeklyDuration = weeklyDuration;
    }
}

public class UniversityInformationSystem {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        // Ввод данных для университета
        System.out.println("Enter University name:");
        String universityName = scanner.nextLine();
        University university = new University(universityName);

        // Ввод данных для факультета
        System.out.println("Enter Faculty name:");
        String facultyName = scanner.nextLine();
        Faculty faculty = new Faculty(facultyName);

        // Ввод данных для декана
        System.out.println("Enter Dean's social security number:");
        String deanSSN = scanner.nextLine();
        System.out.println("Enter Dean's name:");
        String deanName = scanner.nextLine();
        System.out.println("Enter Dean's email:");
        String deanEmail = scanner.nextLine();
        Dean dean = new Dean(deanSSN, deanName, deanEmail);

        // Связываем декана с факультетом
        faculty.dean = dean;

        // Ввод данных для института
        System.out.println("Enter Institute name:");
        String instituteName = scanner.nextLine();
        System.out.println("Enter Institute address:");
        String instituteAddress = scanner.nextLine();
        Institute institute = new Institute(instituteName, instituteAddress);

        // Связываем институт с факультетом
        faculty.institutes.add(institute);

        // Ввод данных для научного сотрудника
        System.out.println("Enter Researcher's social security number:");
        String researcherSSN = scanner.nextLine();
        System.out.println("Enter Researcher's name:");
        String researcherName = scanner.nextLine();
        System.out.println("Enter Researcher's email:");
        String researcherEmail = scanner.nextLine();
        System.out.println("Enter Researcher's research area:");
        String researchArea = scanner.nextLine();
        Researcher researcher = new Researcher(researcherSSN, researcherName, researcherEmail, researchArea);

        // Ввод данных для проекта
        System.out.println("Enter Project name:");
        String projectName = scanner.nextLine();
        System.out.println("Enter Project start date (yyyy-MM-dd):");
        String startDateString = scanner.nextLine();
        Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateString);
        System.out.println("Enter Project end date (yyyy-MM-dd):");
        String endDateString = scanner.nextLine();
        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateString);
        System.out.println("Enter Project hours:");
        int projectHours = scanner.nextInt();
        Project project = new Project(projectName, startDate, endDate, projectHours);

        // Связываем научного сотрудника с проектом
        researcher.projects.add(project);

        // Вывод информации
        System.out.println("University: " + university.name);
        System.out.println("Faculty: " + faculty.name);
        System.out.println("Dean: " + dean.name);
        System.out.println("Institute: " + institute.name + ", Address: " + institute.address);
        System.out.println("Researcher: " + researcher.name + ", Research Area: " + researcher.researchArea);
        System.out.println("Project: " + project.name + ", Start Date: " + startDate + ", End Date: " + endDate + ", Hours: " + project.hours);

        // Закрываем сканнер
        scanner.close();
    }
}
