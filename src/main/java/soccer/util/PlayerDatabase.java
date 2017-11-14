/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package soccer.util;


import soccer.enteties.Player;
import soccer.enteties.Team;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Administrator
 */
public class PlayerDatabase {

    public ArrayList<Player> getPlayers() {
        return players;
    }

    private ArrayList<Player> players;

    public PlayerDatabase() {

        players = new ArrayList();

        for (String item : authorList.split(",")) {
            players.add(new Player(item));
        }
    }

    public Team getTeam(String name, int numOfPlayers ) throws CrTeamsException{
      Player[] teamPlayers = new Player[numOfPlayers];
      Team team = new  Team(name, teamPlayers);
try {
    for (int i = 0; i < numOfPlayers; i++) {
        int ind = (int) Math.random() * numOfPlayers;
        this.players.get(ind).setPlayerTeam(team);
        teamPlayers[i] = this.players.get(ind);
        this.players.remove(ind);
    }

}
catch (IndexOutOfBoundsException ie){
    throw new CrTeamsException("Not enought players");
}
        return team;
    }


    String authorList =
            "Agatha Christie," +
                    "Alan Patton," +
                    "Alexander Solzhenitsyn," +
                    "Arthur Conan Doyle," +
                    "Anthony Trollope," +
                    "Baroness Orczy," +
                    "Brendan Behan," +
                    "Brian Moore," +
                    "Boris Pasternik," +
                    "Charles Dickens," +
                    "Charlotte Bronte," +
                    "Dorothy Parker," +
                    "Emile Zola," +
                    "Frank O'Connor," +
                    "Geoffrey Chaucer," +
                    "George Eliot," +
                    "G. K. Chesterton," +
                    "Graham Green," +
                    "Henry James," +
                    "James Joyce," +
                    "J. M. Synge," +
                    "J. R. Tolkien," +
                    "Jane Austin," +
                    "Leo Tolstoy," +
                    "Liam O'Flaherty," +
                    "Marcel Proust," +
                    "Mark Twain," +
                    "Oscar Wilde," +
                    "O. Henry," +
                    "Samuel Beckett," +
                    "Sean O'Casey," +
                    "William Shakespeare," +
                    "William Makepeace Thackeray," +
                    "W. B. Yeats," +
                    "Wilkie Collins";

}
