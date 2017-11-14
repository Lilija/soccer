package soccer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import soccer.Application;
import soccer.repositories.LeagueRepository;
import soccer.enteties.League;
import java.time.LocalDate;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Controller
    @EntityScan(basePackageClasses = {Application.class, Jsr310JpaConverters.class})
    @RequestMapping(path="/league")
 public class LeagueController {
        @Autowired
        private LeagueRepository leagueRepository;

        @GetMapping(path="/{title}")
        public Optional<League>
        getLeague (@PathVariable String title) {

            return this.leagueRepository.findByTitle(title);
        }

        @PostMapping(path="/add")
        String add(@RequestBody League input, Model model) {
            AtomicInteger counter = new AtomicInteger(0);
            input = new League("Test League " + counter.incrementAndGet(), LocalDate.now().plusDays(counter.get()), LocalDate.now().plusDays(counter.get()+50));
            leagueRepository.save(input);
            model.addAttribute("leagueAnounsment", input.getAnounsment());
            return "league";
        }

        @GetMapping(path="/all")
        public @ResponseBody Iterable<League> getAllLeagues() {
            // This returns a JSON or XML with the users
            return leagueRepository.findAll();
        }

}
