package soccer.repositories;

import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import soccer.enteties.Game;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer>{
    Collection<Game> findByTheLeagueTitle(String title);
    Optional<Game> findOne(int id);
}
