

public class Card{
    //initializing field for card value
    int value;

    public Card(int v){
        // constructor method for a card object
        this.value = v;
    }

    public int getValue(){
        // returns the value of the card object
        return value;
    }

    public String toString(){
        // returns a string representing the card object
        return Integer.toString(this.value);
    }

    public static void main(String[] args){
        // main function, creates a card object and tests methods
        Card ace = new Card(8);

        System.out.println(ace.getValue());

        System.out.println(ace.toString());
    }
}