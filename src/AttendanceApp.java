/**
 * Basketball Stats Application
 *
 * @author Debbie Johnson
 * @version 1.0 beta
 * @since 2025.02.21
 * @see <a
href="https://github.com/dejohns2/JavaSection3_AttendanceApp_Spring2025.git">GitHub
Repository</a>
 */
public class AttendanceApp {
    /**
     * The home team playing.
     */
    private final Course section1;
    /**
     * The away team playing.
     */
    private final Course section2;
    /**
     * Use to display a double dash line.
     */
    private final static String DOUBLE_LINE =
            "=========================================";
    /**
     * Used to display a single dash line.
     */
    private final static String SINGLE_LINE =
            "-----------------------------------------";
    /**
     * Default constructor that instantiate both teams
     */
    public AttendanceApp() {
        section1 = new Course();
        section2 = new Course();
    } // end of default constructor
    /**
     * Displays the BB Stats App header. Example:<br>
     * <pre>
     * =========================================
     * Welcome to the BB Scoreboard App
     * =========================================
     * </pre>
     */
    private void displayAppHeading() {
        System.out.println(DOUBLE_LINE);
        System.out.println("Welcome to the BB Scoreboard App");
        System.out.println(DOUBLE_LINE);
        System.out.println();
    } // end of displayAppHeading
    /**
     * Sets the teams names and calls setupPlayers to setup each team's players.
     Example:<br>
     * <pre>
     * Enter the HOME Team name: user input
     * -----------------------------------------
     * Enter the AWAY Team name: user input
     * </pre>
     * @throw Exception if the setters throw an error back due to data
    validation.
     */
    private void setupCourses() throws Exception {
        String userInput;
        userInput = Input.getLine("Enter the HOME Team name: ");
        section1.setName(userInput);
        this.setupStudents(section1);
        System.out.println();
        System.out.println(SINGLE_LINE);
        System.out.println();
        userInput = Input.getLine("Enter the AWAY TEAM name: ");
        this.section2.setName(userInput);
        this.setupStudents(this.section2);
    } // end of setupTeams
    /**
     * Sets up the team's players.<br>
     * Calls Input.getLine to get the player's name<br>
     * Calls Input.getIntRange to get the player's jersery between 0 and 55<br>
     * Example:<br>
     * <pre>
     * Enter Wildcats player's name or 'q' to quit: user input
     * Enter Billy's jersey number: user input
     * </pre>
     * @param course The team to setup players for.
     */
    private void setupStudents(Course course) {
        String teamName = course.getName();
        String name;
        int seat;
        while (true) {
            System.out.println();
            name = Input.getLine("Enter " + teamName + " player's name or 'q' to quit: ");
            if (name.equals("q"))
                return;
            try {
                seat = Input.getIntRange("Enter " + name + "'s jersey number: ", 0, 55);
                course.addStudent(name, seat);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Unable to add player!");
            }
        }
    } // end of setupPlayers
    /**
     * Keeps the game running via menu options. Example:<br>
     * <pre>
     * -----------------------------------------
     * Main Menu
     * -----------------------------------------
     * 0 = End Attendance App
     * 1 = Take 9:00am's Attendance
     * 2 = Take 10:00am's Attendance
     * 3 = Display All Attendance Report
     * -----------------------------------------
     * Menu Choice:
     * </pre>
     * @throws Exception updateTeamStats could throw an error if an invalid option
    is selected
     */
    private void mainMenu() throws Exception {
        boolean playGame = true;
        int userInput;
        System.out.println();
        System.out.println(DOUBLE_LINE);
        System.out.println("Recording Attendance");
        System.out.println(DOUBLE_LINE);
        System.out.println();
        while (playGame) {
            System.out.println(SINGLE_LINE);
            System.out.println("Main Menu");
            System.out.println(SINGLE_LINE);
            System.out.println("0 = End Attendance App");
            System.out.println("1 = Take " + section1.getName() + " Attendance");
                    System.out.println("2 = Enter " + section2.getName() + " Atendance");
                            System.out.println("3 = Display All Attendance Report");
            System.out.println(SINGLE_LINE);
            userInput = Input.getIntRange("Menu Choice: ", 0, 3);
            System.out.println(SINGLE_LINE);
            System.out.println();
            switch (userInput) {
                case 0:
                    playGame = false;
                    this.updateScoreboard();
                    System.out.println();
                    break;
                case 1:
                case 2:
                    if (userInput == 1)
                        this.updateTeamStats(section1);
                    else
                        this.updateTeamStats(section2);
                    System.out.println();
                    this.updateScoreboard();
                    System.out.println();
                    break;
                case 3:
                    this.displayDetailReports();
                    break;
                default:
                    System.out.println("Invalid menu choice = " + userInput);
            } // end of switch
        }
    } // end of playGame
    /**
     * Update the select team's stats.<br>
     * Calls Input.getIntRange using range from 1 and 55.<br>
     * Example: <br>
     * <pre>
     * Enter Wildcats's Jersey # user input
     * </pre>
     * @param course The team to update stats for.
     * @throws Exception getPlayer could throw an invalid jersey error
     */
    private void CourseAttendance(Course course) throws Exception {
        int seat;
        Student student;
        while (true) {
            seat = Input.getIntRange("Enter " + course.getName() + "'s Student Seat # or 0 to quit", 1, 55);
            student = course.getStudent(seat);
            if (student == null) {
                System.out.println("Invalid #, please try again!");
                continue;
            }
            this.StudentAttendance(student);
            break;
        }
        System.out.println();
        System.out.println(SINGLE_LINE);
    } // end of updateTeam
    /**
     * Displays the student's name along with the attendance menu. Example:
     * <pre>
     * -----------------------------------------
     * Enter #10 Bob Attendance
     * -----------------------------------------
     * 1 = On Time
     * 2 = Late
     * 3 = Excused
     * 4 = unexcused
     * -----------------------------------------
     * Enter Status: 2
     * -----------------------------------------
     * Seat #10 Bob OnTime=1 Late=0 Excused=0 Unexcused=0
     * -----------------------------------------
     * </pre>
     * @param student The student to enter attendance for
     */
    private void StudentAttendance(Student student) {
        int type;
        System.out.println();
        System.out.println(SINGLE_LINE);
        System.out.println("Enter #" + student.getSeat() + " "+student.getName() + " Attendance");
        System.out.println(SINGLE_LINE);
        System.out.println("1 = On Time");
        System.out.println("2 = Late");
        System.out.println("3 = Excused");
        System.out.println("4 = unexcused");
        System.out.println(SINGLE_LINE);
        type = Input.getIntRange("Enter Status: ", 1, 4);
        System.out.println(SINGLE_LINE);
        try {
            student.updateAttendance(type);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Unable to update student's attendance!");
        }
        student.displayAttendance();
    }
    /**
     * Display all team student's detail stats. call the displayDetailReport
     * for both the section1 and section2 courses
     */
    private void displayDetailReports() {
        this.section1.displayDetailReport();
        this.section2.displayDetailReport();
    } // end of playGame
    /**
     * Main method that creates the attendanceApp  object and then
     * setups up the courses
     * <br>
     * 1) creates a new attendanceApp<br>
     * 2) calls the displayAppHeading method<br>
     * 3) using a try-catch calls setupCourses and mainMenu methods<br>
     * <br>
     * @param args No command line input args are used for this application
     */
    public static void main(String[] args) {
        AttendanceApp attendanceApp = new AttendanceApp();
        attendanceApp.displayAppHeading();
        try {
            attendanceApp.setupCourses();
            attendanceApp.mainMenu();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Sorry but this program ended with an error. Please contact Confidence Mawuli");
        }
        Input.sc.close();
    } // end of main
} // end of Attendance class
