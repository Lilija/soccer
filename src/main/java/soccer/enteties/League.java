package soccer.enteties;

import soccer.util.CrTeamsException;
import soccer.util.PlayerDatabase;
import soccer.util.ProjectSettings;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;


@Entity
public class League {
@Id@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private LocalDate fromDate;
private LocalDate toDate;
    @OneToMany(mappedBy = "theLeague")
    @Transient
    private Game[] gamesArrey;

    @OneToMany(mappedBy = "playerLeague")
    @Transient
    private Player[] leaguePlayers;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;


    public Optional<Team> getBestTeam (Team[] teams) {
        return Arrays.stream(teams).max(Comparator.comparing(Team::getNumOfPoints));
    }



 League() {}

    public League(String title, LocalDate fromDate, LocalDate toDate){
     this.title = title;
    this.fromDate = fromDate;
    this.toDate = toDate;
}

public String  getAnounsment() {
    return ("League "+ this.getTitle()+" will be played from "+
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
                    games.add(new Game(homeTeam, awayTeam, this));
                }
            }
        }

        return games.toArray(new Game[games.size()]);
    }



/*
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
    */
}
