package repos;

import org.springframework.data.repository.CrudRepository;
import soccer.Player;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
}
