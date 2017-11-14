package soccer.enteties;


import soccer.util.*;
import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
public class Game {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    private Team homeTeam;
    @OneToOne
    private Team awayTeam;
    @Transient
    private GameEvent[] gameEvents;
    private LocalDateTime theDateTime;
    private int homeTeamGoals = 0;
    private int awayTeamGoals = 0;
    @ManyToOne
    private League theLeague;

    public int getId() {
        return id;
    }

    public LocalDateTime getTheDateTime() {
        return theDateTime;
    }

    public void setTheDateTime(LocalDateTime theDateTime) {
        this.theDateTime = theDateTime;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    //Constructor
    public Game(){}
    public Game(Team pHomeTeam, Team pAwayTeam, League league) {
        this.homeTeam = pHomeTeam;
        this.awayTeam = pAwayTeam;
        this.theLeague = league;
        this.setHomeTeamGoals(0);
        this.setAwayTeamGoals(0);
        this.setTheDateTime(LocalDateTime.now());
    }

    public void playGame(int maxNumGoals) {
        this.setHomeTeamGoals(0);
        this.setAwayTeamGoals(0);
        GameUtils.addGameEvent(this, maxNumGoals);

    }

    public void playGame() {
        GameUtils.addGameEvent(this, 9);

    }
/*
    public String getForTeam(GameEvent theGameEvent) {
        String forTeam;

        forTeam = (this.homeTeam == theGameEvent.theTeam) ? "hometeam" : "away team";
        return forTeam;
    }

    public int getNumOfGoals(Team team) {
        int forTeam;
        forTeam = (team == this.homeTeam) ? getHomeTeamGoals() : getAwayTeamGoals();
        return forTeam;
    }
*/
    public void getDescription() {
        StringBuilder desc = new StringBuilder();
        for (GameEvent item : this.getGameEvents()) {
            desc = desc.delete(0, desc.length());
            desc = desc.append(item.toString());
            System.out.println(desc.toString());
        }
    }


    public String toString() {
        StringBuilder gameresult = new StringBuilder();
        gameresult = gameresult.append("Datum: ")
                .append(this.getTheDateTime().format(ProjectSettings.SoccerFormater))
                .append(" ")
                .append(this.homeTeam.getTeamName())
                .append(" vs ").append(this.awayTeam.getTeamName())
                .append(" rezultat je: ")
                .append(this.getHomeTeamGoals()).append(":").append(this.getAwayTeamGoals());

        return gameresult.toString();

    }

    public GameEvent[] getGameEvents() {
        return gameEvents;
    }

    public void setGameEvents(GameEvent[] gameEvents) {
        this.gameEvents = gameEvents;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public int getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public void setAwayTeamGoals(int awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
    }
}
