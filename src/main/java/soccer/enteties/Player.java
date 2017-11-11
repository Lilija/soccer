package soccer.enteties;

import javax.persistence.*;

@Entity
public class Player{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String playerName;
    @ManyToOne
    private Team playerTeam;
    private int numOfPoints;

public int getNumOfPoints() {
    return this.numOfPoints;
    }
public Player(){}
    public Player( String playerName) {

        this.playerName = playerName;
    }

    public void incPlayerNumOfPoints (int numOfPoints){
        this.numOfPoints +=numOfPoints;
    }

    public void setTeam(Team playerTeam) {
        this.playerTeam = playerTeam;
    }

    public Team getPlayerTeam() {
        return playerTeam;
    }

    @Override
    public String toString() {
        return this.playerName +", points "+ this.numOfPoints;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerTeam(Team playerTeam) {
        this.playerTeam = playerTeam;
    }

        public long getId() {
            return id;
        }
}
