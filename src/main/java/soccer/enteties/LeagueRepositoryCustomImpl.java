package soccer.enteties;

import java.util.*;

class LeagueRepositoryCustomImpl implements LeagueRepositoryCustom{
    @Override
    public Optional<Team> findBestTeamById(int Id) {

    }

    @Override
    public Optional<Player> findBestPlayerByID(int Id) {
        Team[]teams =
        List<Player> thePlayers = new ArrayList();
        for (Team item:teams) {
            thePlayers.addAll(Arrays.asList(item.getPlayerArray()));

        }
        return thePlayers.stream().max(Comparator.comparingInt(Player::getNumOfPoints));

    }
        return null;
    }
}
