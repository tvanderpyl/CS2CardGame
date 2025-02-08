import javax.swing.*;
import java.awt.*;

public class GameViewer extends JFrame{
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 700;
    private final int TITLE_BAR_HEIGHT = 23;
    private Game game;
    private Image board;
    public GameViewer(Game game) {

        // Initialize instance variables.
        // TODO: initialize the View's instance variables.
        this.game = game;
        board = new ImageIcon("Images/table.jpg").getImage();

        // Setup the window and the buffer strategy.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Black Jack");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g){
        g.drawImage(board, 0, 0, 1000, 700, this);
    }
}
