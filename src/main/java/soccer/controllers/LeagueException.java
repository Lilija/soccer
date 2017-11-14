package soccer.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class LeagueException extends RuntimeException {

    public LeagueException(String leagueTitle) {
        super("No such league '" + leagueTitle + "'.");
    }
}