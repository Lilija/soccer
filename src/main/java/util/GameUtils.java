/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import soccer.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author ksomervi
 */
public class GameUtils {

    public static void addGameEvent(Game currGame, int maxNumGoals) {
        if (currGame.getGameEvents() == null) {
            currGame.setGameEvents(new GameEvent[(int) (Math.random() * (maxNumGoals+1))]);
        }
        int i = 0;
        for (GameEvent currGameEvent : currGame.getGameEvents()) {
            currGameEvent = (Math.random()>0.3)? new Goal() : new Possesion();
            currGameEvent.setTheTeam(Math.random() > 0.5 ? getHomeTeam(currGame, "home") : getHomeTeam(currGame, "away"));
            currGameEvent.setThePlayer(currGameEvent.getTheTeam().getPlayerArray()[(int) (Math.random() * currGameEvent.getTheTeam().getPlayerArray().length)]);
            currGameEvent.setTheTime((int) (Math.random() * 90));
            currGame.getGameEvents()[i] = currGameEvent;
            //ako je Gol, uvecavamo poene timu, igracu i pratimo rezlultat
            if (currGameEvent  instanceof Goal ) {
                currGameEvent.getThePlayer().incPlayerNumOfPoints(1);
                if (currGameEvent.getTheTeam() == getHomeTeam(currGame, "home")) {
                    currGame.setHomeTeamGoals(currGame.getHomeTeamGoals() + 1);
                } else currGame.setAwayTeamGoals(currGame.getAwayTeamGoals() + 1);
            }
            i++;
        }



    }

    public static void addGameEvent(Game currGame) {

        addGameEvent( currGame,9) ;

    }

    private static Team getHomeTeam(Game currGame, String homeOrAway) {
        Team theTeam = null;
        Method m;
        Field f;
        try {
            m = Game.class.getMethod("get" + Character.toUpperCase(homeOrAway.charAt(0)) + homeOrAway.substring(1) + "Team");
            theTeam = (Team)m.invoke(currGame);
        } catch (NoSuchMethodException|IllegalAccessException|InvocationTargetException em) {
            try {
                f = Game.class.getField(homeOrAway + "Team");
                theTeam = (Team)f.get(currGame);
            } catch (NoSuchFieldException|IllegalAccessException ef) { 
                System.out.println("The addGoals() utility requires the Goal class to contain either:\n" +
                        "public String fields called homeTeam and awayTeam, OR,\n" +
                        "public accessor methods called getHomeTeam() and getAwayTeam().");
            }
        }
        return theTeam;
    }
}
