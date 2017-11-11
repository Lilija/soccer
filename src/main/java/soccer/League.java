package soccer;

import util.CrTeamsException;
import util.PlayerDatabase;
import util.ProjectSettings;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

public class League {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
@Temporal(TemporalType.DATE)
private LocalDate fromDate;
@OneToMany(mappedBy = "theLeague")
private Game[] gamesArrey;


@Temporal(TemporalType.DATE)
private LocalDate toDate;

public void getBestTeams (Team[] teams) {
    Arrays.sort(teams);
    for (Team item:teams) {
        System.out.println(item);
    }

}
    public Optional<Team> getBestTeam (Team[] teams) {
        return Arrays.stream(teams).max(Comparator.comparing(Team::getNumOfPoints));
    }

/*
    public void getBestPlayers (Team[] teams) {
        List<Player> thePlayers = new ArrayList();
        for (Team item:teams) {
            thePlayers.addAll(Arrays.asList(item.getPlayerArray()));

        }
        Collections.sort(thePlayers,
                (p1,p2)->Double.valueOf(p2.getNumOfPoints()).compareTo(Double.valueOf(p1.getNumOfPoints())));

        for (Player item: thePlayers) {
            System.out.println(item.toString());
        }

    }
*/
    public Optional<Player> getBestPlayer (Team[] teams) {
        List<Player> thePlayers = new ArrayList();
        for (Team item:teams) {
            thePlayers.addAll(Arrays.asList(item.getPlayerArray()));

        }
       return thePlayers.stream().max(Comparator.comparingInt(Player::getNumOfPoints));

    }

    public League(LocalDate fromDate, LocalDate toDate){
    this.fromDate = fromDate;
    this.toDate = toDate;
}

public void getAnounsment() {
    System.out.println("Leage will be played from "+
                        this.fromDate.format(ProjectSettings.SoccerFormater)+
                        " to "+ this.toDate.format(ProjectSettings.SoccerFormater));
}

    public  Team[]createTeams (String names, int numOfPlayers) {
        PlayerDatabase leaguePlayers = new PlayerDatabase();
        //getTeam(String name, int numOfPlayers)
        ArrayList<Team> theTeams = new ArrayList();
        for (String item : names.split(",")){
           try{ theTeams.add(leaguePlayers.getTeam(item, numOfPlayers));}
           catch (CrTeamsException e){
               e.printStackTrace();
           }
        }
            return theTeams.toArray(new Team[theTeams.size()]);

    }

    public Game[]createGames (Team[] teams){
        ArrayList<Game> games = new ArrayList();
        for (Team homeTeam: teams){
            for (Team awayTeam:teams){
                if (homeTeam!=awayTeam){
                    games.add(new Game(homeTeam, awayTeam));
                }
            }
        }

        return games.toArray(new Game[games.size()]);
    }




    public static void main (String[] args) {

        League theLeague = new League(LocalDate.now(),  LocalDate.now().plusMonths(2).plusDays(5));
        theLeague.getAnounsment();
        String names = "Prvi tim, Drugi tim, Treci tim";
        Team[] gameTeams  = theLeague.createTeams(names, 3);
        Game[] leagueGames = theLeague.createGames(gameTeams);
        for (Game item : leagueGames) {
            item.playGame();
            System.out.println(item.toString());
            //item.getDescription();
        }
        System.out.println(theLeague.getBestTeam(gameTeams).toString());
        System.out.println(theLeague.getBestPlayer(gameTeams).toString());


    }
}
