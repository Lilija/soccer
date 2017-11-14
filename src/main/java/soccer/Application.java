package soccer;


        import org.springframework.boot.CommandLineRunner;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.context.annotation.Bean;
        import soccer.enteties.*;
        import soccer.repositories.GameRepository;
        import soccer.repositories.LeagueRepository;
        import soccer.repositories.PlayerRepository;
        import soccer.repositories.TeamRepository;
        import soccer.util.PlayerDatabase;

        import java.time.LocalDate;
        import java.util.Arrays;
        import java.util.stream.Collectors;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
    CommandLineRunner init(LeagueRepository league, GameRepository game,
                           TeamRepository team, PlayerRepository player ) {

        League theLeague = new League("Test Liga iz App", LocalDate.now(),  LocalDate.now().plusMonths(2).plusDays(5));
        league.save(theLeague);
        PlayerDatabase players = new PlayerDatabase();
        player.save(players.getPlayers()
                .parallelStream()
                .peek(p->p.setPlayerLeague(theLeague))
                .collect(Collectors.toList()));
        String names = "Prvi tim, Drugi tim, Treci tim";
        Team[] gameTeams  = theLeague.createTeams(names, 3);
        team.save(Arrays.asList(gameTeams));
        player.save(players.getPlayers()
                .parallelStream()
                .peek(p->p.setPlayerLeague(theLeague))
                .collect(Collectors.toList()));
        Game[] leagueGames = theLeague.createGames(gameTeams);
        for (Game item : leagueGames) {
            item.playGame();
        }

        return (evt) -> Arrays.stream(leagueGames)
                .forEach(game::save);
    }

}