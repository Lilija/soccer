package soccer;

public abstract class GameEvent {
    private Team theTeam;
    private Player thePlayer;
    private double theTime;

    public Team getTheTeam() {
        return this.theTeam;
    }

    public void setTheTeam(Team theTeam) {
        this.theTeam = theTeam;
    }
    public void setTheTeam(Player player) {
        this.theTeam = player.getPlayerTeam();
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " for " + getTheTeam().getTeamName() +
                " by " + getThePlayer().toString() +
                ", at " + getTheTime() + "min";
    }

    public Player getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }

    public double getTheTime() {
        return theTime;
    }

    public void setTheTime(double theTime) {
        this.theTime = theTime;
    }
}
