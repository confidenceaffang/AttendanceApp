/**
 * A Basketball Player and the player's stats.
 * @author dejohns2
 * @since 2025.02.22
 * @version 1.0 beta
 * @see <a href="https://github.com/dejohns2/JavaSection3_BB_Scoreboard_Spring2025.git">GitHub Repository</a>
 */
public class Student {

    /** The Player's jersey. */
    private int seat;

    /** The Player's name. */
    private String name;

    /** The player's number of fouls. */
    private int onTime;

    /** The Player's number of 1pt field goals. */
    private int late;

    /** The Player's number of 2pt field goals. Need to multiply by 2 when calculating total points. */
    private int excused;

    /** The Player's number of 3pt field goals. Need to multiply by 3 when calculating total points. */
    private int unexcused;

    /**
     * Set the Player's fields to default values null and zeroes.
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
     * to detect if a jersey number is already taken by overriding the equals method to test
     * if two players are equal based on their jersey number.
     * @param seat The Player's jersey number.
     * @throws Exception if the setJersey method throws a data validation error.
     */
    public Student(int seat) throws Exception {
        this();
        setSeat(seat);
    } // end of seat overload constructor

    /**
     * Allow creating a Player plus setting their name and jersey number.
     * The constructor first calls the default constructor and then
     * calls both the setName and setJersey methods for data validation.
     * @param name The Player's name
     * @param seat The Player's jersey #
     * @throws Exception if the name or jersey setters throws an error
     */
    public Student(int seat, String name) throws Exception {
        this();
        setSeat(seat);
        setName(name);
    } // end of jersey and name overload constructor

    /**
     * Get the Player's name.
     * @return The Player's name.
     */
    public int getSeat() { return seat;	}

    /**
     * Get the Player jersey number.
     * @return The Player's jersey number
     */
    public String getName() { return name; }

    /**
     * Get the Player's number of fouls.
     * @return the number of fouls by the Player.
     */
    public int getOnTime() {	return onTime; }

    /**
     * Get the Player's number of 1pt field goals made.
     * @return The number of 1pt field goals made by the Player.
     */
    public int getLate() { return late; }

    /**
     * Get the Player's number of 2pt field goals made.
     * @return The number of 2pt field goals made by the Player.
     */
    public int getExcused() { return excused; }

    /**
     * Get the Player's number of 3pt field goals made.
     * @return the number of 3pt field goals made by the Player.
     */
    public int getUnexcused() {return unexcused; }

    /**
     * Set the Player's jersey number if it's a positive number between 1 and 55
     * otherwise it throws an error.
     * @param seat the player's jersey number
     * @throws Exception if the jersey number isn't between 0 and 55 inclusively.<br>
     * Error Example: Invalid jersey number #10 for name Bob!
     */
    public void setSeat(int seat) throws Exception {
        if (seat >= 0 && seat <= 55)
                this.seat = seat;
        else
            throw new Exception("Invalid jersey number #" + seat + " for name " + name + "!");
    } // end of setJersey method

    /**
     * Set the Player's name. Uses the trim method to remove leading and trailing spaces
     * and then if the name is an empty string, it will throw an error
     * if not then it will set the player's name.
     * @param name The Player's name
     * @throw Exception if the player's name is blank (whitespace or empty)<br>
     * Error Example: Name cannot be blank for jersey number #10!
     */
    public void setName(String name) throws Exception {

        name = name.trim();

        if ( name.isBlank())
            throw new Exception("Name cannot be blank for jersey number #" + seat + "!");
        else
            this.name = name;
    } // end of setName method

    /**
     * Increment the appropriate field goal type, using a switch that also handles for invalid data.<br>
     * case 0 is received then increment fouls by 1<br>
     * case 1 is received then increment fieldGoal_1pt by 1<br>
     * case 2 is received then increment fieldGoal_2pt by 1<br>
     * case 3 is received then increment fieldGoal_3pt by 1<br>
     * default throw an exception displaying the invalid value that was received
     * @param status The stats type 0=foul, 1=1pt Field Goal Shot, 2=2pt Field Goal Shot, 3=3pt Field Goal
     * @throws Exception if an invalid statsType is received (valid 0-3)<br>
     * Error Example: Invalid statsType = 4
     */
    public void updateAttendance(int status) throws Exception {

        switch (status) {
            case 0:
                onTime++;
            case 1:
                late++;
                break;
            case 2:
                excused++;
                break;
            case 3:
                unexcused++;
                break;
            default:
                throw new Exception("Invalid statsType = " + status);
        }
    } // end of updateStats method

    /**
     * Display the Player's jersey number, name, # of fouls, and # of points via getPoints method<br>
     * Example:#10 Billy Fouls=1 Points=5
     */
    public void displayAttendance() {
        System.out.print("#" + seat + " " + name + " Fouls=" + fouls + " Points=" + getPoints());
    }

    /**
     * Instead of verifying two players are identical by equal identities.<br>
     * This method will verify two players are the same by ONLY their jersey number.<br>
     * This allows the ArrayList.getIndex() method to return a player's by only checking their jersey number.
     * @param object a player object to check equality of ONLY the jersey number
     * @return true if the two player's jersey are equal otherwise false
     */
    @Override
    public boolean equals(Object object) {

        if(!(object instanceof Student))
            return false;

        Student other = (Student)object;

        return this.seat == other.getSeat();
    } // end of override equals

    /**
     * Returns the jersey number and player name. Example:<br>
     * #10 Billy
     * @return The player's jersey and name
     */
    @Override
    public String toString(){
        return "#" + seat + " " + name;
    }
}
