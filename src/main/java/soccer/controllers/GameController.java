package soccer.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import soccer.Application;
import soccer.enteties.Game;
import soccer.repositories.GameRepository;
import soccer.repositories.LeagueRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/league/{title}/games")
@EntityScan(basePackageClasses = {Application.class, Jsr310JpaConverters.class})
public class GameController {
@Autowired
    private GameRepository gameRepository;
@Autowired
    private LeagueRepository leagueRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody Collection<String> readGames(@PathVariable String title) {
        this.validateLeague(title);
        return this.gameRepository.findByTheLeagueTitle(title)
                .stream().map(Game::toString).collect(Collectors.toList());
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{gameId}")
    @ResponseBody Optional<Game> readGame(@PathVariable String title,
                                          @PathVariable int gameId) {
        this.validateLeague(title);
        return this.gameRepository.findOne(gameId);
    }

    private void validateLeague(String title) {
        this.leagueRepository.findByTitle(title).orElseThrow(
                () -> new LeagueException (title));
    }
}