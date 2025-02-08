// Blackjack by Trevor van der Pyl

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Deck deck;
    private Player pOne;
    private Player pTwo;
    private GameViewer window;

    public Game() {
        deck = new Deck();
        pOne = new Player("CPU");
        pTwo = new Player("JP", 100);
        window = new GameViewer(this);
    }

    public void deal() {
        pOne.deal(deck);
        pTwo.deal(deck);
    }

    public static void instructions() {
        System.out.println("It's Blackjack");
    }

    public int val(ArrayList<Card> hand){
        int aces = 0;
        int value = 0;
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getValue() == 1){
                aces++;
            }
            else{
                value += hand.get(i).getValue();
            }
        }
        for(int i = 0; i < aces; i++){
            if(value + 11 <= 21){
                value += 11;
            }
            else{
                value += 1;
            }
        }
        return value;
    }

    public void hit(Player player){
        player.addCard(deck.deal());
    }

    public void shuffle(){
        deck.shuffle();
    }

    public int pturn(){
        while (this.val(pTwo.getHand()) < 21) {
            System.out.println(pTwo.getHand().toString());
            System.out.println("Do you want to hit or stand");
            Scanner s = new Scanner(System.in);
            if (s.nextLine().equals("hit")) {
                this.hit(pTwo);
            }
            else{
                break;
            }
        }
        if(this.val(pTwo.getHand()) < 21){
            return this.val(pTwo.getHand());
        }
        return 0;
    }

    public int dturn(){
        while (this.val(pOne.getHand()) < 17){
            this.hit(pOne);
        }
        if (17 < this.val(pOne.getHand()) && this.val(pOne.getHand()) < 21){
            return this.val(pOne.getHand());
        }
        return 0;
    }

    public String playGame() {
        deck.shuffle();
        this.deal();
        //Prints the one visible dealer card
        System.out.println("Dealers card: " + pOne.getCard().toString());
        int pval = this.pturn();
        int cval = this.dturn();
        if (pval == 0) {
            System.out.println("You busted");
            System.out.println("dealer: " + pOne.getHand());
            return "dealer wins";
        }
        if (cval > pval){
            System.out.println("dealer: "+ pOne.getHand());
            return "dealer wins";
        }
        if (cval == 0 || pval > cval){
            System.out.println("dealer: "+ pOne.getHand());
            return "player wins";
        }
        return "push";
    }

    public static void main(String[] args) {
        Game game = new Game();
        Game.instructions();
        System.out.println(game.playGame());
    }
}