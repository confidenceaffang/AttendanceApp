import java.util.ArrayList;
import java.util.List;

/**
 * Use to keep track of the courses
 * @author Confidence Mawuli Affang
 * @version 1.0 beta
 * @see <a href="https://github.com/confidenceaffang/AttendanceApp.git">GitHub Repository</a>
 */
public class Course {

    /**
     * The Course's name.
     */
    private String name;

    /** The Course's players. */
    private final List<Student> allStudents;

    /** Sets the Course's name to "Unknown", and assigns allStudents to an empty new ArrayList */
    public Course() {
        name = "Unknown";
        allStudents = new ArrayList<>();
    }

    /**
     * Calls the default constructor, and then set's the Course's name using the setter for data validation.
     * @param name the Course's name
     * @throw Exception if the setName fails due to a blank name
     */
    public Course(String name) throws Exception {
        this();
        this.setName(name);
    }

    /**
     * Gets the Course's name.
     * @return The Course's name.
     */
    public String getName() { return this.name; }

    /**
     * Set the course's name.
     * @param name the course's name
     * @throws Exception if the course's name is blank (whitespace or empty)<br>
     * Error Example: Student name can not be blank.
     */
    public void setName(String name) throws Exception {
        name = name.trim(); // remove leading and trailing whitespace

        //isBlank checks for both empty or whitespace
        if (name.isBlank())
            throw new Exception("Course name can not be blank.");

        this.name = name;
    } // end of setName method

    /**
     * Get a Student by their seat number using the ArrayList.indexOf method<br>
     * If the indexOf method returns -1 then this method returns null otherwise,<br>
     * it returns the student object associated with the seat number.
     * @param seat The student's seat number.
     * @return If a Student is found, it will return the student object otherwise a null value.
     * @throws Exception Creating a student with an invalid seat number could throw an error
     */
    public Student getStudent(int seat) throws Exception {

        int index = this.allStudents.indexOf(new Student(seat));

        if (index == -1)
            return null;
        else
            return this.allStudents.get(index);

    }

    /**
     * Add a student to the course, by using the overload constructor that allows setting their name and seat number too.<br>
     * This method will verify that the seat number is not already used by another student by calling the Course.getStudent method.<br>
     * and if it is, then it will throw an exception back to the calling method
     * @param name The Student's name.
     * @param seat The Student's seat number.
     * @throws Exception Seat number # already assigned.
     */
    public void addStudent(String name, int seat) throws Exception {
        Student student = new Student(seat);
        if(student == null) {
            this.allStudents.add(new Student(seat, name));
        } else {
            throw new Exception("Seat #" + seat + " already assigned to " + student.getName() + "!");
        }
    }


    /**
     *Displays the totals for all students in the course
     *
     */
    public void displaySummaryReport() {
        Student student ;
        int totalOntime = 0;
        int totalLate= 0;
        int totalExcused = 0;
        int totalUnexcused = 0;

        for (Student value : allStudents) {
            student = value;
            totalOntime += student.getOnTime();
            totalLate += student.getLate();
            totalExcused += student.getExcused();
            totalUnexcused += student.getUnexcused();
        }


        System.out.println(this.name + ": " +  "Ontime=" + totalOntime + " Late=" + totalLate + " Excused=" + totalExcused + "  Unexcused=" + totalUnexcused);
    }

    /**
     * Displays each Student's detail stats for the entire Course using the Student's getter methods.<br>
     * Using an enhanced for loop to loop through all students
     *
     */

    public void displayDetailReport() {

        Student student;

        displaySummaryReport();

        System.out.println("Seat Name            OnTime Late Excused Unexcused");
        System.out.println("====== =============== ===== === === === =====");

        for (Student value : allStudents) {

            student = value;

            System.out.printf("%6d %-15s %5d %3d %3d %3d\n",
                    student.getSeat(),
                    student.getName(),
                    student.getOnTime(),
                    student.getLate(),
                    student.getExcused(),
                    student.getUnexcused());
        };

        System.out.println();
    }

    /**
     * Returns the course's name.
     * @return course name.
     */
    @Override
    public String toString(){
        return this.name;
    }
}
