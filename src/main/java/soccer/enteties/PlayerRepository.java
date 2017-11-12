package soccer.enteties;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import soccer.enteties.Player;
@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {
}
