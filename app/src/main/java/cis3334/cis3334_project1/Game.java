package cis3334.cis3334_project1;

/**
 * The `Game` class represents statistical data for a basketball game.
 * It includes information about different aspects of a player's performance
 * in a game, such as points, rebounds, assists, steals, blocks, and more.
 */
public class Game {
    private String key;
    private Integer points;
    private Integer rebounds;
    private Integer assists;
    private Integer steals;
    private Integer blocks;
    private Integer fgm;
    private Integer fga;
    private Integer threePM;
    private Integer threePA;
    private Integer ftm;
    private Integer fta;

    /**
     * Default constructor for the `Game` class.
     */
    public Game() {

    }

    /**
     * Constructor for the `Game` class with complete information.
     *
     * @param key      The key identifying the game.
     * @param points   The number of points scored in the game.
     * @param rebounds The number of rebounds in the game.
     * @param assists  The number of assists in the game.
     * @param steals   The number of steals in the game.
     * @param blocks   The number of blocks in the game.
     * @param fgm      The number of field goals made in the game.
     * @param fga      The number of field goals attempted in the game.
     * @param threePM  The number of three-pointers made in the game.
     * @param threePA  The number of three-pointers attempted in the game.
     * @param ftm      The number of free throws made in the game.
     * @param fta      The number of free throws attempted in the game.
     */
    public Game(String key, Integer points, Integer rebounds, Integer assists, Integer steals, Integer blocks, Integer fgm, Integer fga, Integer threePM, Integer threePA, Integer ftm, Integer fta) {
        this.key = key;
        this.points = points;
        this.rebounds = rebounds;
        this.assists = assists;
        this.steals = steals;
        this.blocks = blocks;
        this.fgm = fgm;
        this.fga = fga;
        this.threePM = threePM;
        this.threePA = threePA;
        this.ftm = ftm;
        this.fta = fta;
    }

    /**
     * Constructor for the `Game` class with partial information (key not included).
     *
     * @param points   The number of points scored in the game.
     * @param rebounds The number of rebounds in the game.
     * @param assists  The number of assists in the game.
     * @param steals   The number of steals in the game.
     * @param blocks   The number of blocks in the game.
     * @param fgm      The number of field goals made in the game.
     * @param fga      The number of field goals attempted in the game.
     * @param threePM  The number of three-pointers made in the game.
     * @param threePA  The number of three-pointers attempted in the game.
     * @param ftm      The number of free throws made in the game.
     * @param fta      The number of free throws attempted in the game.
     */
    public Game(Integer points, Integer rebounds, Integer assists, Integer steals, Integer blocks, Integer fgm, Integer fga, Integer threePM, Integer threePA, Integer ftm, Integer fta) {
        this.points = points;
        this.rebounds = rebounds;
        this.assists = assists;
        this.steals = steals;
        this.blocks = blocks;
        this.fgm = fgm;
        this.fga = fga;
        this.threePM = threePM;
        this.threePA = threePA;
        this.ftm = ftm;
        this.fta = fta;
    }

    /**
     * Get the key identifying the game.
     *
     * @return The key identifying the game.
     */
    public String getKey() {
        return key;
    }

    /**
     * Set the key identifying the game.
     *
     * @param key The key identifying the game.
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Get the number of points scored in the game.
     *
     * @return The number of points scored in the game.
     */
    public Integer getPoints() {
        return points;
    }

    /**
     * Set the number of points scored in the game.
     *
     * @param points The number of points scored in the game.
     */
    public void setPoints(Integer points) {
        this.points = points;
    }

    /**
     * Get the number of rebounds in the game.
     *
     * @return The number of rebounds in the game.
     */
    public Integer getRebounds() {
        return rebounds;
    }

    /**
     * Set the number of rebounds in the game.
     *
     * @param rebounds The number of rebounds in the game.
     */
    public void setRebounds(Integer rebounds) {
        this.rebounds = rebounds;
    }

    /**
     * Get the number of assists in the game.
     *
     * @return The number of assists in the game.
     */
    public Integer getAssists() {
        return assists;
    }

    /**
     * Set the number of assists in the game.
     *
     * @param assists The number of assists in the game.
     */
    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    /**
     * Get the number of steals in the game.
     *
     * @return The number of steals in the game.
     */
    public Integer getSteals() {
        return steals;
    }

    /**
     * Set the number of steals in the game.
     *
     * @param steals The number of steals in the game.
     */
    public void setSteals(Integer steals) {
        this.steals = steals;
    }

    /**
     * Get the number of blocks in the game.
     *
     * @return The number of blocks in the game.
     */
    public Integer getBlocks() {
        return blocks;
    }

    /**
     * Set the number of blocks in the game.
     *
     * @param blocks The number of blocks in the game.
     */
    public void setBlocks(Integer blocks) {
        this.blocks = blocks;
    }

    /**
     * Get the number of field goals made in the game.
     *
     * @return The number of field goals made in the game.
     */
    public Integer getFgm() {
        return fgm;
    }

    /**
     * Set the number of field goals made in the game.
     *
     * @param fgm The number of field goals made in the game.
     */
    public void setFgm(Integer fgm) {
        this.fgm = fgm;
    }

    /**
     * Get the number of field goals attempted in the game.
     *
     * @return The number of field goals attempted in the game.
     */
    public Integer getFga() {
        return fga;
    }

    /**
     * Set the number of field goals attempted in the game.
     *
     * @param fga The number of field goals attempted in the game.
     */
    public void setFga(Integer fga) {
        this.fga = fga;
    }

    /**
     * Get the number of three pointers made in the game.
     *
     * @return The number of three pointers made in the game.
     */
    public Integer getThreePM() {
        return threePM;
    }

    /**
     * Set the number of three pointers made in the game.
     *
     * @param threePM The number of three pointers made in the game.
     */
    public void setThreePM(Integer threePM) {
        this.threePM = threePM;
    }

    /**
     * Get the number of three pointers attempted in the game.
     *
     * @return The number of three pointers attempted in the game.
     */
    public Integer getThreePA() {
        return threePA;
    }

    /**
     * Set the number of three pointers attempted in the game.
     *
     * @param threePA The number of three pointers attempted in the game.
     */
    public void setThreePA(Integer threePA) {
        this.threePA = threePA;
    }

    /**
     * Get the number of free throws made in the game.
     *
     * @return The number of free throws made in the game.
     */
    public Integer getFtm() {
        return ftm;
    }

    /**
     * Set the number of free throws made in the game.
     *
     * @param ftm The number of free throws made in the game.
     */
    public void setFtm(Integer ftm) {
        this.ftm = ftm;
    }

    /**
     * Get the number of free throws attempted in the game.
     *
     * @return The number of free throws attempted in the game.
     */
    public Integer getFta() {
        return fta;
    }

    /**
     * Set the number of free throws attempted in the game.
     *
     * @param fta The number of free throws attempted in the game.
     */
    public void setFta(Integer fta) {
        this.fta = fta;
    }

    /**
     * Returns a string representation of the `Game` object, including its attributes and values.
     *
     * @return A string in the format "Game{points='value', rebounds='value', assists='value', steals='value',
     * blocks='value', FGM='value', FGA='value', 3PM='value', 3PA='value', ftm='value', fta='value'}" where
     * 'value' represents the actual values of the respective attributes.
     */
    @Override
    public String toString() {
        return "Game{" +
                "points='" + points + '\'' +
                ", rebounds='" + rebounds + '\'' +
                ", assists='" + assists + '\'' +
                ", steals='" + steals + '\'' +
                ", blocks='" + blocks + '\'' +
                ", FGM='" + fgm + '\'' +
                ", FGA='" + fga + '\'' +
                ", 3PM='" + threePM + '\'' +
                ", 3PA='" + threePA + '\'' +
                ", ftm='" + ftm + '\'' +
                ", fta='" + fta + '\'' +
                '}';
    }
}
