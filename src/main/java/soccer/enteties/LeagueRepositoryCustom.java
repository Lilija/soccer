package soccer.enteties;

import java.util.Optional;

 interface LeagueRepositoryCustom<League, Integer> {
    Optional<Team> findBestTeamById (int Id);
    Optional<Player> findBestPlayerByID (int Id);

}
