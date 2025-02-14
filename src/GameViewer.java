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
        // TODO: initialize the View's instance variables.
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
        for (int i = 0; i < game.getCPUCHand().size(); i++){
            g.drawImage(game.getCPUCHand().get(i).getImage(), 100 + 150 * i, 100, 100, 140, this);
        }
        if (!game.getDone()){
            g.drawImage(back, 250, 100, 100, 140, this);
        }
        for (int i = 0; i < game.getPlayerHand().size(); i++){
            g.drawImage(game.getPlayerHand().get(i).getImage(), 100 + 150 * i, 300, 100, 140, this);
        }
    }
}
