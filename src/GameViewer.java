import javax.swing.*;
import java.awt.*;

public class GameViewer extends JFrame{
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 700;
    private final int TITLE_BAR_HEIGHT = 23;
    private Game game;
    private Image board;
    private Image back;
    public GameViewer(Game game) {

        // Initialize instance variables.
        this.game = game;
        board = new ImageIcon("Images/table.jpg").getImage();
        back = new ImageIcon("Images/back.png").getImage();

        // Setup the window and the buffer strategy.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Black Jack");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g){
        g.drawImage(board, 0, 0, 1000, 700, this);
        // Print the CPU hand
        for (int i = 0; i < game.getCPUCHand().size(); i++){
            g.drawImage(game.getCPUCHand().get(i).getImage(), 100 + 150 * i, 100, 100, 140, this);
        }
        // Make sure only one CPU's cards is showing
        if (!game.getDone()){
            g.drawImage(back, 250, 100, 100, 140, this);
        }
        // Draw players hand
        for (int i = 0; i < game.getPlayerHand().size(); i++){
            g.drawImage(game.getPlayerHand().get(i).getImage(), 100 + 150 * i, 400, 100, 140, this);
        }
        // print the instructions
        if (game.getScreen() == 0){
            g.drawImage(board, 0, 0, 1000, 700, this);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Ariel", Font.PLAIN, 50));
            g.drawString("It is blackjack", 250, 300);
            g.drawString("Type 'OK' if you understand", 250, 400);
        }
        // print winner
        if(game.getDone()){
            g.setFont(new Font("Ariel", Font.PLAIN, 60));
            // get and print the outcome of the game
            g.drawString(game.getFinish(), 250, 330);
        }
    }
}
