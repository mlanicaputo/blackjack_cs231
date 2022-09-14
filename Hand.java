import java.util.ArrayList;

public class Hand{
    // initializes an ArrayList to represent the hand
    ArrayList<Card> cardList;

    public Hand(){
        //constructor method for the hand, allocates memory
        cardList = new ArrayList<Card>();
    }

    public void reset(){
        // clears the hand of cards
        cardList.clear();
    }

    public void add(Card card){
        // adds a card (parameter) to the card object
        cardList.add(card);
    }

    public int size(){
        // returns the number of cards in the hand
        return cardList.size();
    }

    public Card getCard(int i){
        // returns the card object at index i
        return cardList.get(i);
    }

    public int getTotalValue(){
        // returns the total value of the cards in the player's hand
        int sum = 0;

        for (int i = 0; i < cardList.size(); i++){
            Card cardToAdd = cardList.get(i);
            sum += cardToAdd.getValue();
        }

        return sum;
    }

    public String toString(){
        // returns a string that represents the hand
        String handString = "";

        handString += "This hand has: ";

        for (int i = 0; i < cardList.size(); i++){
            Card cardToAdd = cardList.get(i);
            handString += cardToAdd.getValue();
            handString += ", ";
        }

        handString += ".";

        return handString;    
    }

    public static void main(String[] args){
        // main function creates some card and hand objects and tests methods
        Card ace = new Card(11);
        Card queen = new Card(10);

        Hand myHand = new Hand();
        System.out.println(myHand.size());

        myHand.add(ace);
        myHand.add(queen);
        System.out.println(myHand.size());
        System.out.println(myHand.getTotalValue());
        System.out.println(myHand.toString());

        System.out.println(myHand.getCard(0));

        myHand.reset();
        System.out.println(myHand.size());
        System.out.println(myHand.toString());
    }
}