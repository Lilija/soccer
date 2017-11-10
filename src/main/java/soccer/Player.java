package soccer;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

@Entity
public class Player{
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String playerName;
    @ManyToOne
    private Team playerTeam;
    private int numOfPoints;

public int getNumOfPoints() {
    return this.numOfPoints;
    }

    public Player(String playerName) {
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

        public int getId() {
            return id;
        }
}
