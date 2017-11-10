package soccer;

import javax.persistence.*;
import java.util.Arrays;
@Entity
public class Team implements  Comparable{
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String teamName;
    @OneToMany(mappedBy = "playerTeam") private Player[] playerArray;

    public int getNumOfPoints() {
        return Arrays.stream(this.playerArray).mapToInt(Player::getNumOfPoints).sum();
    }

    public Team (String pName){
        this.setTeamName(pName);


    }
    public Team (String pName, Player[] pPlayers){
        this(pName);
        this.setPlayerArray(pPlayers);
    }

    public Team (){ }

    public void setPlayerArray(Player[] playerArray) {
        this.playerArray = playerArray;
        for (Player item:playerArray)  {
            item.setTeam(this);


        }

    }

    public void getPlayernamelike (String matchingString){
        for (Player item : this.getPlayerArray()){
            if (item.getPlayerName().matches(matchingString)){
                System.out.println("Igraci koji imaju ime "+ matchingString + " je "+ item.toString());
            }
            else
                System.out.println("Igrac koji nema takvo ime je "+ item.getPlayerName().split(" ")[1]);
        }
    }

    @Override
    public int compareTo(Object o) {
        return  ( (this.getNumOfPoints()<=((Team)o).getNumOfPoints())? 1:-1);

    }

    public String toString() {
        return this.getTeamName() + ", points "+ this.getNumOfPoints();
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
}
