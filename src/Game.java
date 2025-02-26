// Blackjack by Trevor van der Pyl

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Deck deck;
    private Player pOne;
    private Player pTwo;
    private GameViewer window;
    boolean isDone = false;
    private int screen;
    private String finish;

    public Game() {
        deck = new Deck(window);
        pOne = new Player("CPU");
        pTwo = new Player("JP", 100);
        window = new GameViewer(this);
        screen = 0;
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
                window.repaint();
            }
            else{
                isDone = true;
                break;
            }
        }
        if(this.val(pTwo.getHand()) <= 21){
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

    public int getScreen(){
        // returns the int screen so the front end knows what phase of game it is in
        return screen;
    }

    public String playGame() {
        deck.shuffle();
        this.deal();
        Scanner s = new Scanner(System.in);
        while (!s.nextLine().equals("ok") && !s.nextLine().equals("OK"))
        {
            window.repaint();
        }
        // switch screen to 1 so front end knows that it is time to display the game
        screen = 1;
        //Prints the one visible dealer card
        System.out.println("Dealers card: " + pOne.getCard().toString());
        window.repaint();
        int pval = this.pturn();
        int cval = this.dturn();
        if (pval == 0) {
            isDone = true;
            window.repaint();
            System.out.println("You busted");
            System.out.println("dealer: " + pOne.getHand());
            return "dealer wins";
        }
        if (cval > pval){
            isDone = true;
            window.repaint();
            System.out.println("dealer: "+ pOne.getHand());
            return "dealer wins";
        }
        if (cval == 0 || pval > cval){
            isDone = true;
            window.repaint();
            System.out.println("dealer: "+ pOne.getHand());
            return "player wins";
        }
        window.repaint();
        return "push";
    }

    public ArrayList<Card> getCPUCHand(){
        return pOne.getHand();
    }

    public ArrayList<Card> getPlayerHand(){
        return pTwo.getHand();
    }

    public Boolean getDone(){
        return isDone;
    }

    public void storeGame(String store){
        finish = store;
    }

    public String getFinish(){
        return finish;
    }

    public static void main(String[] args) {
        Game game = new Game();
        Game.instructions();
        String g = game.playGame();
        // have to store string g in the game class in order to send it into the front end
        game.storeGame(g);
        System.out.println(g);
    }
}