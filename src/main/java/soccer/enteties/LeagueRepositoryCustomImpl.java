package soccer.enteties;

import java.util.*;

class LeagueRepositoryCustomImpl implements LeagueRepositoryCustom{

    @Override
    public Optional<Team> findBestTeamById(int Id) {
return null;
    }

    @Override
    public Optional<Player> findBestPlayerByID(int Id) {
        /*
        Team[]teams = TeamRepository.f
        List<Player> thePlayers = new ArrayList();
        for (Team item:teams) {
            thePlayers.addAll(Arrays.asList(item.getPlayerArray()));

        }
        return thePlayers.stream().max(Comparator.comparingInt(Player::getNumOfPoints));

    }
    */
        return null;
    }

}
