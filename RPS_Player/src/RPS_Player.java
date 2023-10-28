import java.util.Random;

public class RPS_Player {
    private int numberOfGamesWon;
    private int numberOfGamesPlayed;
    private int choice;
    private String name;

    public RPS_Player(String name){
        this.name = name;
        this.numberOfGamesWon = 0;
        this.numberOfGamesPlayed = 0;
    }

    public String getName(){
        return name;
    }

    /**
     * Returns the number of games played since a clear() was issued.
     * @return returns the number of games played.
     */
    public int getNumberOfGamesPlayed(){
        return numberOfGamesPlayed;    }

    /**
     * Returns the number of games won since a clear() was issued.
     * @return returns the number of games won.
     */
    public int getNumberOfGamesWon(){
        return numberOfGamesWon;
    }

    /**
     * Returns the win percentage as number between 0 and 1.
     * @return win percentage as a double.
     */
    public double getWinPercentage(){

        return (double) numberOfGamesWon / numberOfGamesPlayed;
    }

    /**
     * Starts a new game.
     */
    public void clear(){
        numberOfGamesPlayed = 0;
        numberOfGamesWon = 0;
    }

    /**
     * This player challenges anotherPlayer whereby both players make a
     * random choice of rock, paper, scissors.  A reference to the winning
     * player is returned or null if there is a draw.
     * @param anotherPlayer an RPS_Player that this player is challenging.
     * @return Reference to the RPS_Player that won or a null if there is a draw
     */
    public RPS_Player challenge(RPS_Player anotherPlayer){
        Random random = new Random();
        int thisChoice = random.nextInt(3);
        int anotherChoice = random.nextInt(3);

        this.choice = thisChoice;
        anotherPlayer.choice = anotherChoice;

        if (thisChoice == anotherChoice) {
            this.numberOfGamesPlayed++;
            anotherPlayer.numberOfGamesPlayed++;
            return null;
        } else if ((thisChoice == 0 && anotherChoice == 2) ||
                (thisChoice == 1 && anotherChoice == 0) ||
                (thisChoice == 2 && anotherChoice == 1)) {
            this.numberOfGamesWon++;
            this.numberOfGamesPlayed++;
            anotherPlayer.numberOfGamesPlayed++;
            return this;
        } else {
            anotherPlayer.numberOfGamesWon++;
            this.numberOfGamesPlayed++;
            anotherPlayer.numberOfGamesPlayed++;
            return anotherPlayer;
        }
    }

    /**
     * This player challenges anotherPlayer whereby this player uses the previous
     * choice made and anotherPlayer makes a random choice of rock, paper, scissors.
     * A reference to the winning player is returned or null if there is a draw.
     * @param anotherPlayer an RPS_Player that this player is challenging.
     * @return Reference to the RPS_Player that won or a null if there is a draw
     */
    public RPS_Player keepAndChallenge(RPS_Player anotherPlayer){
        Random random = new Random();
        int anotherChoice = random.nextInt(3);

        anotherPlayer.choice = anotherChoice;

        if (this.choice == anotherChoice) {
            return null; // It's a draw
        } else if ((this.choice == 0 && anotherChoice == 2) ||
                (this.choice == 1 && anotherChoice == 0) ||
                (this.choice == 2 && anotherChoice == 1)) {
            this.numberOfGamesWon++;
            return this;
        } else {
            anotherPlayer.numberOfGamesWon++;
            return anotherPlayer;
        }
    }
}


