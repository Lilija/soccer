package soccer.enteties;

import jdk.nashorn.internal.objects.annotations.Constructor;

import javax.persistence.*;

@Entity
public class Player{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String playerName;
    @ManyToOne
    private Team playerTeam;

    @ManyToOne
    private League playerLeague;
    private int numOfPoints;

    public long getId() {
        return id;
    }
    public int getNumOfPoints() {
        return this.numOfPoints;
        }
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Team getPlayerTeam() {
        return playerTeam;
    }

    public void setPlayerTeam(Team playerTeam) {
        this.playerTeam = playerTeam;
    }

    @Override
    public String toString() {
        return this.playerName +", points "+ this.numOfPoints;
    }
    public League getPlayerLeague() {
        return playerLeague;
    }

    public void setPlayerLeague(League playerLeague) {
        this.playerLeague = playerLeague;
    }

    public void incPlayerNumOfPoints (int numOfPoints){
        this.numOfPoints +=numOfPoints;
    }

    //Constructors
    Player(){}//for JPA

    public Player( String playerName) {
        this.playerName = playerName;
        this.numOfPoints = 0;
    }
    public Player(String playerName, Team team){
        this(playerName);
        this.playerTeam = team;
    }
}
