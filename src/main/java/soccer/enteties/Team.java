package soccer.enteties;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Set;

@Entity
public class Team implements  Comparable{
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String teamName;
    @OneToMany(mappedBy = "playerTeam")
    @Transient
    private Player[] playerArray;

    public int getNumOfPoints() {
        return Arrays.stream(this.playerArray).mapToInt(Player::getNumOfPoints).sum();
    }

    public void setPlayerArray(Player[] playerArray) {
        this.playerArray = playerArray;
        for (Player item:playerArray)  {
            item.setPlayerTeam(this);
        }
    }
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Player[] getPlayerArray() {
        return playerArray;
    }
/*
    public void getPlayernamelike (String matchingString){
        for (Player item : this.getPlayerArray()){
            if (item.getPlayerName().matches(matchingString)){
                System.out.println("Igraci koji imaju ime "+ matchingString + " je "+ item.toString());
            }
            else
                System.out.println("Igrac koji nema takvo ime je "+ item.getPlayerName().split(" ")[1]);
        }
    }
*/
    @Override
    public int compareTo(Object o) {
        return  ( (this.getNumOfPoints()<=((Team)o).getNumOfPoints())? 1:-1);

    }

    public String toString() {
        return this.getTeamName() + ", points "+ this.getNumOfPoints();
    }

    Team (){ }
    public Team (String pName){
        this.setTeamName(pName);
    }
    public Team (String pName, Player[] pPlayers){
        this(pName);
        this.playerArray=pPlayers;
    }


}
