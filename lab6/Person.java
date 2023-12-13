import java.util.ArrayList;
import java.util.Date;

public class Person {
    public String firstName;
    public String lastName;
    public Date dateOfBirth;
    public String gender;

    public Person(String firstName, String lastName, Date dateOfBirth, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    // Додано метод для виведення інформації про особу
    public void displayInfo() {
        System.out.println("Person: " + firstName + " " + lastName + ", Date of Birth: " + dateOfBirth + ", Gender: " + gender);
    }
}

class Student extends Person {
    public Student(String firstName, String lastName, Date dateOfBirth, String gender) {
        super(firstName, lastName, dateOfBirth, gender);
    }
}

class Course {
    private String title;
    private String description;

    public Course(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Додано метод для виведення інформації про курс
    public void displayInfo() {
        System.out.println("Course: " + title + ", Description: " + description);
    }
}

class CourseRegistration {
    private int numberOfStudents;
    private int numberOfCourses;
    private Date startDate;
    private Date endDate;

    public CourseRegistration(int numberOfStudents, int numberOfCourses, Date startDate, Date endDate) {
        this.numberOfStudents = numberOfStudents;
        this.numberOfCourses = numberOfCourses;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Додано метод для виведення інформації про реєстрацію курсу
    public void displayInfo() {
        System.out.println("Course Registration: Students: " + numberOfStudents + ", Courses: " + numberOfCourses + ", Start Date: " + startDate + ", End Date: " + endDate);
    }
}

class Staff extends Person {
    private String position;

    public Staff(String firstName, String lastName, Date dateOfBirth, String gender, String position) {
        super(firstName, lastName, dateOfBirth, gender);
        this.position = position;
    }

    // Додано метод для виведення інформації про персонал
    public void displayInfo() {
        System.out.println("Staff: " + firstName + " " + lastName + ", Date of Birth: " + dateOfBirth + ", Gender: " + gender + ", Position: " + position);
    }
}

class CourseManagement {
    private ArrayList<Person> personnel;
    private ArrayList<Course> courses;
    private String room;

    public CourseManagement(ArrayList<Person> personnel, ArrayList<Course> courses, String room) {
        this.personnel = personnel;
        this.courses = courses;
        this.room = room;
    }

    // Додано метод для виведення інформації про керівництво курсом
    public void displayInfo() {
        System.out.println("Course Management: Room: " + room);
        System.out.println("Personnel:");
        for (Person person : personnel) {
            person.displayInfo();
        }
        System.out.println();
        System.out.println("Courses:");
        for (Course course : courses) {
            course.displayInfo();
        }
    }
}

class Main {
    public static void main(String[] args) {
        // Створення об'єктів студентів
        Student student1 = new Student("John", "Doe", new Date(), "Male");
        Student student2 = new Student("Jane", "Smith", new Date(), "Female");

        // Створення об'єктів курсів
        Course course1 = new Course("Java Programming", "Learn Java programming language");
        Course course2 = new Course("Web Development", "Build websites and web applications");

        // Створення об'єкта реєстрації курсу
        CourseRegistration registration = new CourseRegistration(2, 2, new Date(), new Date());

        // Створення об'єктів персоналу
        Staff staff1 = new Staff("Alice", "Johnson", new Date(), "Female", "Instructor");
        Staff staff2 = new Staff("Bob", "Williams", new Date(), "Male", "Administrator");

        // Створення об'єкта керівництва курсом
        ArrayList<Person> personnel = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();
        personnel.add(staff1);
        personnel.add(staff2);
        courses.add(course1);
        courses.add(course2);

        CourseManagement courseManagement = new CourseManagement(personnel, courses, "Room 101");

        // Виведення інформації
        registration.displayInfo();
        System.out.println();
        courseManagement.displayInfo();
        System.out.println();
        System.out.println("Students:");
        System.out.println(student1.firstName + " " + student1.lastName + " " + student1.dateOfBirth + " " + student1.gender);
        System.out.println(student2.firstName + " " + student2.lastName + " " + student2.dateOfBirth + " " + student2.gender);
    }
}
