package soccer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import soccer.enteties.League;
import java.time.LocalDate;

    @Controller
    @EntityScan(basePackageClasses = {Application.class, Jsr310JpaConverters.class})
    @RequestMapping(path="/league")
 public class LeagueController {
        @Autowired
        private LeagueRepository leagueRepository;

        @GetMapping(path="/add") // Map ONLY GET Requests
        public @ResponseBody String
        addNewLeague () {
            League league = new League(LocalDate.now(), LocalDate.now().plusDays(50));
            leagueRepository.save(league);
            return league.getAnounsment();
        }

        @GetMapping(path="/all")
        public @ResponseBody Iterable<League> getAllLeagues() {
            // This returns a JSON or XML with the users
            return leagueRepository.findAll();
        }

}
