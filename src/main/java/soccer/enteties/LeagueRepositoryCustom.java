package soccer.enteties;

import java.util.Optional;

protected interface LeagueRepositoryCustom {
    Optional<Team> findBestTeamById (int Id);
    Optional<Player> findBestPlayerByID (int Id);

}
