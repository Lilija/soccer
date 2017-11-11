package soccer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import soccer.enteties.Team;
@Repository
public interface TeamRepository extends CrudRepository<Team, Integer> {
}
