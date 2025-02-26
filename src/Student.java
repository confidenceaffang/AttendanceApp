/**
 * A Student and the student's attendance.
 * @author Confidence Mawuli Affang
 * @version 1.0 beta
 * @see <a href="https://github.com/confidenceaffang/AttendanceApp.git">GitHub Repository</a>
 */
public class Student {

    /** The Student's jersey. */
    private int seat;

    /** The Student's name. */
    private String name;

    /** The Student's number of ontime attendance. */
    private int onTime;

    /** The Student's number of late attendace. */
    private int late;

    /** The Student's number of excused attendance. */
    private int excused;

    /** The Student's number of unexcused attendance. */
    private int unexcused;

    /**
     * Set the Student's fields to default values null and zeroes.
     * The default constructor is PRIVATE, so it is ONLY called by the overload constructor.
     */
    private Student() {
        name = null;
        seat = 0;
        onTime = 0;
        late = 0;
        excused = 0;
        unexcused = 0;
    } // end of default constructor

    /**
     * This overload constructor should only be used by the ArrayList indexOf method
     * to detect if a seat number is already taken by overriding the equals method to test
     * if two students are equal based on their seat number.
     * @param seat The Student's seat number.
     * @throws Exception if the setSeat method throws a data validation error.
     */
    public Student(int seat) throws Exception {
        this();
        setSeat(seat);
    } // end of seat overload constructor

    /**
     * Allow creating a Student plus setting their name and seat number.
     * The constructor first calls the default constructor and then
     * calls both the setName and setSeat methods for data validation.
     * @param name The Student's name
     * @param seat The Student's seat number
     * @throws Exception if the name or seat setters throws an error
     */
    public Student(int seat, String name) throws Exception {
        this();
        setSeat(seat);
        setName(name);
    } // end of seat and name overload constructor

    /**
     * Get the Student's name.
     * @return The Student's name.
     */
    public int getSeat() { return seat;	}

    /**
     * Get the Student seat number.
     * @return The Student's seat number
     */
    public String getName() { return name; }

    /**
     * Get the Student's number of on-time attendance.
     * @return the number of on-time attendance by the student.
     */
    public int getOnTime() {	return onTime; }

    /**
     * Get the Student's number of late attendance.
     * @return The number of late attendance by the Student.
     */
    public int getLate() { return late; }

    /**
     * Get the Student's number of excused attendance.
     * @return The number of excused attendance by the student.
     */
    public int getExcused() { return excused; }

    /**
     * Get the Student's number of unexcused attendance.
     * @return the number of unexcused attendance by the student.
     */
    public int getUnexcused() {return unexcused; }

    /**
     * Set the Student's seat number if it's a positive number
     * otherwise it throws an error.
     * @param seat the student's seat number
     * @throws Exception if the seat number
     * Error Example: Invalid seat number
     */
    public void setSeat(int seat) throws Exception {
        if (seat >= 0)
                this.seat = seat;
        else
            throw new Exception("Seat cannot be negative");
    } // end of setSeat method

    /**
     * Set the Student's name. Uses the trim method to remove leading and trailing spaces
     * and then if the name is an empty string, it will throw an error
     * if not then it will set the player's name.
     * @param name The Student's name
     * @throw Exception if the student's name is blank (whitespace or empty)<br>
     * Error Example: Name cannot be blank for seat number
     */
    public void setName(String name) throws Exception {

        name = name.trim();

        if ( name.isBlank())
            throw new Exception("Student name cannot be blank!");
        else
            this.name = name;
    } // end of setName method

    /**
     * Increment the appropriate field goal type, using a switch that also handles for invalid data.<br>
     * case 0 is received then increment the on-time attendance
     * case 1 is received then increment the late attendance
     * case 2 is received then increment the excused attendance
     * case 3 is received then increment the unexcused attendance
     * default throw an exception displaying the invalid value that was received
     * @param type The stats type 0=foul, 1=1pt Field Goal Shot, 2=2pt Field Goal Shot, 3=3pt Field Goal
     * @throws Exception if an invalid statsType is received (valid 0-3)<br>
     * Error Example: Invalid statsType = 4
     */
    public void updateAttendance(int type) throws Exception {

        switch (type) {
            case 1:
                onTime++;
                break;
            case 2:
                late++;
                break;
            case 3:
                excused++;
                break;
            case 4:
                unexcused++;
                break;
            default:
                throw new Exception("Invalid attendance type = " + type);
        }
    } // end of updateAttendance method

    /**
     * Display the Player's jersey number, name, # of fouls, and # of points via getPoints method<br>
     * Example:#10 Billy Fouls=1 Points=5
     */
    public void displayAttendance() {
        System.out.println("Seat #" + seat +" " + name);
        System.out.println("OnTime= " + onTime + ", Late= " + late + ", Excused= " + excused + ", Unexcused= " + unexcused);
    }

    /**
     * Instead of verifying two students seats are the same.<br>
     * This method will verify two students are the same by ONLY their seat number.<br>
     * This allows the ArrayList.getIndex() method to return a student's by only checking their seat number.
     * @param object a student object to check equality of ONLY the seat number
     * @return true if the two student's seat are equal otherwise false
     */
    @Override
    public boolean equals(Object object) {

        if(!(object instanceof Student))
            return false;

        Student other = (Student)object;

        return this.seat == other.getSeat();
    } // end of override equals

    /**
     * Returns the seat number and student name. Example:<br>
     * @return The student's seat and name
     */
    @Override
    public String toString(){
        return "#" + seat + " " + name;
    }
}
