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
    private final Team homeTeam;
    /**
     * The away team playing.
     */
    private final Team awayTeam;
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
        homeTeam = new Team();
        awayTeam = new Team();
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
        homeTeam.setName(userInput);
        this.setupStudents(homeTeam);
        System.out.println();
        System.out.println(SINGLE_LINE);
        System.out.println();
        userInput = Input.getLine("Enter the AWAY TEAM name: ");
        this.awayTeam.setName(userInput);
        this.setupStudents(this.awayTeam);
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
     * 0 = End Game
     * 1 = Enter Wildcats Team's Stats
     * 2 = Enter Blue Devils Team's Stats
     * 3 = Display Game Stats
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
        System.out.println("Game Started!");
        System.out.println(DOUBLE_LINE);
        System.out.println();
        while (playGame) {
            System.out.println(SINGLE_LINE);
            System.out.println("Main Menu");
            System.out.println(SINGLE_LINE);
            System.out.println("0 = End Game");
            System.out.println("1 = Enter " + homeTeam.getName() + " Team's Stats");
                    System.out.println("2 = Enter " + awayTeam.getName() + " Team's Stats");
                            System.out.println("3 = Display Game Stats");
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
                        this.updateTeamStats(homeTeam);
                    else
                        this.updateTeamStats(awayTeam);
                    System.out.println();
                    this.updateScoreboard();
                    System.out.println();
                    break;
                case 3:
                    this.displayGameStatus();
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
            seat = Input.getIntRange("Enter " + student.getName() + "'s Jersey # ", 1, 55);
            student = course.getStudent(seat);
            if (student == null) {
                System.out.println("Invalid #, please try again!");
                continue;
            }
            this.updatePlayerStats(student);
            break;
        }
        System.out.println();
        System.out.println(SINGLE_LINE);
    } // end of updateTeam
    /**
     * Displays the player's name along with the stats menu. Example:
     * <pre>
     * -----------------------------------------
     * Enter #10 Billy Stats
     * -----------------------------------------
     * 0 = foul
     * 1 = free throw
     * 2 = 2pt field goal
     * 3 = 3pt field goal
     * -----------------------------------------
     * Enter Stat Type: 2
     * -----------------------------------------
     * #10 Billy Fouls=0 Points=2
     * -----------------------------------------
     * </pre>
     * @param student The student to enter stats for
     */
    private void StudentAttendance(Student student) {
        int type;
        System.out.println();
        System.out.println(SINGLE_LINE);
        System.out.println("Enter #" + student.getSeat() + " "
                +student.getName() + " Stats");
        System.out.println(SINGLE_LINE);
        System.out.println("0 = foul");
        System.out.println("1 = free throw");
        System.out.println("2 = 2pt field goal");
        System.out.println("3 = 3pt field goal");
        System.out.println(SINGLE_LINE);
        type = Input.getIntRange("Enter Stat Type: ", 0, 3);
        System.out.println(SINGLE_LINE);
        try {
            student.updateAttendance(type);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Unable to update player's stats!");
        }
        student.displayAttendance();
    }
    /**
     * Display the updated Scoreboard for both teams. Calls the Team's
     displayTeamStats
     * for both the home and away teams.
     */
    /*
    private void updateScoreboard() {
        this.homeTeam.displayTeamStats();
        this.awayTeam.displayTeamStats();
    }*/
    /**
     * Display all team player's detail stats. call the displayDetailsStats
     * for both the home and away teams.
     */
    private void displayDetailReports() {
        this.homeTeam.displayDetailStats();
        this.awayTeam.displayDetailStats();
    } // end of playGame
    /**
     * Main method that creates the BB_Stats_App object and then
     * setups up the teams and play the game via menu options.
     * <br>
     * 1) creates a new scoreboard<br>
     * 2) calls the displayAppHeading method<br>
     * 3) using a try-catch calls setupTeams and mainMenu methods<br>
     * <br>
     * @param args No command line input args are used for this application
     */
    public static void main(String[] args) {
        BB_Scoreboard scoreboard = new BB_Scoreboard();
        scoreboard.displayAppHeading();
        try {
            scoreboard.setupTeams();
            scoreboard.mainMenu();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Sorry but this program ended with an error.
                    Please contact Princess Debbie!");
        }
        Input.sc.close();
    } // end of main
} // end of BB_Stats_App class
