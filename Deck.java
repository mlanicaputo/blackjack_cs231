import java.util.ArrayList;
import java.util.Random;

public class Deck{
    // initializes field for a deck ArrayList
    ArrayList<Card> deckArrayList;

    public Deck(){
        // constructor method for a deck
        this.build();
    }

    public void build(){
        // allocates memory for deck ArrayList, adds cards of proper values to it
        this.deckArrayList = new ArrayList<Card>();

        for (int i = 0; i < 4; i++){

            for (int j = 1; j < 9; j++){
                int cardValue = j + 1;

                Card myCard = new Card(cardValue);

                this.deckArrayList.add(myCard);
            }

            Card myCard = new Card(11);
            this.deckArrayList.add(myCard);
        }

        for (int i = 0; i < 16; i++){
            Card myCard = new Card(10);
            this.deckArrayList.add(myCard);
        }
    }

    public int size(){
        // returns the size of the deck
        return this.deckArrayList.size();
    }

    public Card deal(){
        // takes a card from the top of the deck and returns it
        Card tempCard = this.deckArrayList.remove(0);

        return tempCard;
    }

    public Card pick(int i){
        // optional method; returns a card at index i of the deck
        Card tempCard = this.deckArrayList.get(i);
        
        this.deckArrayList.remove(i);

        return tempCard;
    }

    public void shuffle(){
        //shuffles the deck using a random object
        Random randomObj = new Random(System.currentTimeMillis());

        ArrayList<Card> newDeckList = new ArrayList<Card>();

        int numberIterations = this.deckArrayList.size();

        while (numberIterations > 0){
            int randInt;

            if (numberIterations == 1){
                randInt = 0;
            } else {
                randInt = randomObj.nextInt(numberIterations - 1);
            }

            newDeckList.add(this.deckArrayList.get(randInt));
            this.deckArrayList.remove(randInt);

            numberIterations--;
        }

        this.deckArrayList.clear();

        for (int i = 0; i < newDeckList.size(); i++){
            Card tempCard = newDeckList.get(i);

            this.deckArrayList.add(tempCard);
        }
    }

    public String toString(){
        // returns a string representing the deck
        String deckString = "Deck contents: [";

        for (int i = 0; i < this.deckArrayList.size(); i++){
            Card tempCard = this.deckArrayList.get(i);
            
            String tempStr = String.valueOf(tempCard.getValue());

            deckString += tempStr;
            deckString += ", ";
        }

        deckString += "]";

        return deckString;
    }

    public static void main(String[] args){
        // main function creates a deck and tests several methods
        Deck myDeck = new Deck();
        System.out.println(myDeck.toString());

        myDeck.shuffle();
        System.out.println(myDeck.toString());
        System.out.println(myDeck.size());

        System.out.println(myDeck.deal());
        System.out.println(myDeck.pick(22));
        System.out.println(myDeck.size());

        System.out.println(myDeck.toString());
    }
}