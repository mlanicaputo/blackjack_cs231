public class Blackjack{

    // initializing fields for the Blackjack class
    private int lowestNumDeck;
    private Hand playerHand;
    private Hand dealerHand;
    private Deck deck;

    public Blackjack(int reshuffleCutoff){
        // constructor method, creates a shuffled deck and two player hands
        lowestNumDeck = reshuffleCutoff;

        deck = new Deck();
        deck.shuffle();

        playerHand = new Hand();
        dealerHand = new Hand();
    }

    public void reset(){
        // emptys both player hands and shuffles a new deck if the current deck is too small
        playerHand.reset();
        dealerHand.reset();

        if (deck.size() < lowestNumDeck){
            deck = new Deck();
            deck.shuffle();
        }
    }

    public void deal(){
        // deals two cards to each player from the top of the deck (index 0)
        for (int i = 0; i < 2; i++){
            playerHand.add(deck.deal());
            dealerHand.add(deck.deal());
        }
    }

    public boolean playerTurn(){
        // adds cards from deck to player hand until player hand is greater than 16. returns a boolean based on whether the player busts or not
        while (playerHand.getTotalValue() < 16){
            playerHand.add(deck.deal());
        }

        if (playerHand.getTotalValue() > 21){
            return false;
        }

        return true;
    }

    public boolean dealerTurn(){
        // adds cards from deck to dealer hand until player hand is greater than 16. returns a boolean based on whether the dealer busts or not
        while (dealerHand.getTotalValue() < 17){
            dealerHand.add(deck.deal());
        }

        if (dealerHand.getTotalValue() > 21){
            return false;
        }

        return true;
    }

    // public boolean playerTurnInteractive(){
    //     System.out.println("Your hand: " + playerHand.toString() + 
    //     "\nWould you like to HIT or STAND?");

    // }

    public void setReshuffleCutoff(int cutoff){
        //mutator method for field lowestNumDeck
        lowestNumDeck = cutoff;
    }

    public int getReshuffleCutoff(){
        //accessor method for field lowestNumDeck
        return lowestNumDeck;
    }

    public String toString(){
        // returns a string describing both hands and the deck
        return "Dealer hand: " + this.dealerHand.toString() +
        "\n" + "Player hand: " + this.playerHand.toString() +
        "\n" + "Deck: " + this.deck.toString();
    }

    public int game(boolean verbose){
        // plays one complete hand of blackjack. Returns an 1 for player win, 0 for push, -1 for dealer win
        // argument is option to have a print statement for before/after hands.
        int gameResult;

        this.reset();

        this.deal();

        if (verbose == true){
            System.out.println("Initial hands: \nDealer hand: " + this.dealerHand.toString() +
        "\n" + "Player hand: " + this.playerHand.toString());
        }

        boolean playerBool = this.playerTurn();
        boolean dealerBool = this.dealerTurn();

        if (verbose == true){
            System.out.println("Final hands: \nDealer hand: " + this.dealerHand.toString() +
        "\n" + "Player hand: " + this.playerHand.toString());
        }


        if ((playerBool == false) && (dealerBool == false)){
            // gameResult = 0;
            gameResult = -1;
        } else if (playerBool == false || dealerBool == false){
            if (playerBool == false){
                gameResult = -1;
            } else {
                gameResult = 1;
            }
        } else {
            if (this.playerHand.getTotalValue() > this.dealerHand.getTotalValue()){
                gameResult = 1;
            } else if (this.playerHand.getTotalValue() < this.dealerHand.getTotalValue()){
                gameResult = -1;
            } else {
                gameResult = 0;
            }
        }

        if (verbose == true){
            if (gameResult == 1){
                System.out.println("Player wins.\n");
            } else if (gameResult == -1){
                System.out.println("Dealer wins.\n");
            } else if (gameResult == 0){
                System.out.println("Push.\n");
            }
        }

        return gameResult;
    }

    public static void main(String[] args){
        //main function creates a new blackjack object and plays 3 games
        Blackjack newGame = new Blackjack(30);

        for (int i = 0; i < 3; i++){
            int gameBool = newGame.game(true);
        }
    }
}