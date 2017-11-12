package soccer.enteties;

import javafx.print.Collation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import soccer.enteties.Player;

import java.util.Collection;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {
   Collection<Player> findByTeamId(int teamId);
}
