import java.util.ArrayList;
import java.util.List;

/**
 * Use to keep track of a basketball Team that is made up with multiple Players along with the Team's stats.
 * @author dejohns2
 * @since 2025.02.22
 * @version 1.0 beta
 * @see <a href="https://github.com/dejohns2/JavaSection3_BB_Scoreboard_Spring2025.git">GitHub Repository</a>
 */
public class Course {

    /**
     * The team's name.
     */
    private String name;

    /** The team's players. */
    private final List<Student> allStudents;

    /** Sets the team's name to "Unknown", and assigns players to an empty new ArrayList */
    public Course() {
        name = "Unknown";
        allStudents = new ArrayList<>();
    }

    /**
     * Calls the default constructor, and then set's the team's name using the setter for data validation.
     * @param name the team's name
     * @throw Exception if the setName fails due to a blank name
     */
    public Course(String name) throws Exception {
        this();
        this.setName(name);
    }

    /**
     * Gets the team's name.
     * @return The team's name.
     */
    public String getName() { return this.name; }

    /**
     * Set the teams's name.
     * @param name the teams's name
     * @throws Exception if the team's name is blank (whitespace or empty)<br>
     * Error Example: Student name can not be blank.
     */
    public void setName(String name) throws Exception {
        name = name.trim(); // remove leading and trailing whitespace

        //isBlank checks for both empty or whitespace
        if (name.isBlank())
            throw new Exception("Student name can not be blank.");

        this.name = name;
    } // end of setName method

    /**
     * Get a Player by their jersey number using the ArrayList.indexOf method<br>
     * If the indexOf method returns -1 then this method returns null otherwise,<br>
     * it returns the Player object associated with the jersey number.
     * @param seat The Player's jersey number.
     * @return If a Player is found, it will return the Player object otherwise a null value.
     * @throws Exception Creating a player with a invalid jersey number could throw an error
     */
    public Student getStudent(int seat) throws Exception {

        int index = this.allStudents.indexOf(new Student(seat));

        if (index == -1)
            return null;
        else
            return this.allStudents.get(index);

    }

    /**
     * Add a player to the Team, by using the overload constructor that allows setting their name and jersey number too.<br>
     * This method will verify that the jersey number is not already used by another player by calling the Team.getPlayer method.<br>
     * and if it is, then it will throw an exception back to the calling method
     * @param name The Player's name.
     * @param seat The Player's jersey number.
     * @throws Exception Jersey number # already assigned.
     */
    public void addStudent(String name, int seat) throws Exception {
        Student player = this.getSeat(seat);
        if(player == null) {
            this.allStudents.add(new Student(seat, name));
        } else {
            throw new Exception("Jersey #" + seat + " already assigned to " + player.getName() + "!");
        }
    }


    /**
     * Get the total number of points for the entire Team by calling the Player.getPoints method.
     * Uses a for loop to sum all the team's players points by calling the player's getPoints
     * method.
     * @return The Teams's points.
     */
    /*
    public int getTeamPoints() {
        int totalPoints = 0;

        for (Student player : this.allStudents) {
            totalPoints += player.getPoints();
        }

        return totalPoints;
    }
*/
    /**
     * Get the total number of fouls for the entire Team using the Player.getFouls method.
     * Uses a for loop to sum all the team's players fouls by calling the player's getFouls
     * method.
     * @return The total number of fouls for the Team.
     */
    /*
    public int getTeamFouls() {
        int totalFouls = 0;

        for (Student player : this.players) {
            totalFouls += player.getFouls();
        }

        return totalFouls;
    }
    */

    /**
     * Display the Team's summary stats using the Team.getTeamFouls and getTeamPoints methods.<br>
     * Example: <br>
     * <pre>Team Wildcats Fouls=4 Points=23</pre>
     */
    public void displaySummaryReport() {
        System.out.println("Team " + this.name + " Fouls=" + this.getTeamFouls() + " Points=" + this.getTeamPoints());
    }

    /**
     * Displays each Player's detail stats for the entire Team using the Player's getter methods.<br>
     * This method uses the printf method for proper stats alignment. Example:<br>
     * <pre>
     * Jersey Name            Fouls 1pt 2pt 3pt Total
     * ====== =============== ===== === === === =====
     *    10  Billy               1   2   3   1    10
     *    24  Tammy               0   0   2   0     4
     * </pre>
     */
    public void displayDetailReport() {

        Student student;

        displaySummaryReport();

        System.out.println("Jersey Name            Fouls 1pt 2pt 3pt Total");
        System.out.println("====== =============== ===== === === === =====");

        for (Student value : allStudents) {

            student = value;

            System.out.printf("%6d %-15s %5d %3d %3d %3d %5d\n",
                    student.getJersey(),
                    student.getName(),
                    student.getFouls(),
                    student.getFieldGoals_1pt(),
                    student.getFieldGoals_2pt(),
                    student.getFieldGoals_3pt(),
                    student.getPoints());
        }

        System.out.println();
    }

    /**
     * Returns the team's name.
     * @return Team name.
     */
    @Override
    public String toString(){
        return this.name;
    }
}
