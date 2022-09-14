class Simulation{
    public static void main(String[] args){

        //initializing fields for Simulation class
        int playerWins = 0;
        int dealerWins = 0;
        int pushes = 0;
        int result = 0;

        Blackjack newGame = new Blackjack(30); // creating a new Blackjack object

        for (int i = 0; i < 1000; i++){
            result = newGame.game(false); // play one game

            if (result == -1){ //check to see who won the game and add the result to the master counts
                dealerWins++;
            } else if (result == 1){
                playerWins++;
            } else {
                pushes++;
            }
        }
        
        // print statement to print in the terminal the result of playing 1000 games
        System.out.println(
            "Player wins: " + playerWins + "\n" +
            (playerWins / 10) + "% of games" + "\n\n" +

            "Dealer wins: " + dealerWins + "\n" +
            (dealerWins / 10) + "% of games" + "\n\n" +

            "Pushes: " + pushes + "\n" +
            (pushes / 10) + "% of games"
        );
    }
}