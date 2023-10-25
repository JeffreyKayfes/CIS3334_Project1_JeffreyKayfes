package cis3334.cis3334_project1;

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

    public Game() {

    }

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getRebounds() {
        return rebounds;
    }

    public void setRebounds(Integer rebounds) {
        this.rebounds = rebounds;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getSteals() {
        return steals;
    }

    public void setSteals(Integer steals) {
        this.steals = steals;
    }

    public Integer getBlocks() {
        return blocks;
    }

    public void setBlocks(Integer blocks) {
        this.blocks = blocks;
    }

    public Integer getFgm() {
        return fgm;
    }

    public void setFgm(Integer fgm) {
        this.fgm = fgm;
    }

    public Integer getFga() {
        return fga;
    }

    public void setFga(Integer fga) {
        this.fga = fga;
    }

    public Integer getThreePM() {
        return threePM;
    }

    public void setThreePM(Integer threePM) {
        this.threePM = threePM;
    }

    public Integer getThreePA() {
        return threePA;
    }

    public void setThreePA(Integer threePA) {
        this.threePA = threePA;
    }

    public Integer getFtm() {
        return ftm;
    }

    public void setFtm(Integer ftm) {
        this.ftm = ftm;
    }

    public Integer getFta() {
        return fta;
    }

    public void setFta(Integer fta) {
        this.fta = fta;
    }

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
