package projectC_prototype;
import javax.swing.*;
import java.awt.*;

class ScoreWindow {
    private JFrame Scoreframe;
    private JLabel scoreLabel;

    public ScoreWindow() {
        Scoreframe = new JFrame("Score Window");
        Scoreframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Scoreframe.setLayout(new FlowLayout());

        scoreLabel = new JLabel("Score: 0"); // Initial score

        // Customize the label's font and size
        Font labelFont = scoreLabel.getFont();
        scoreLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, 24));

        Scoreframe.add(scoreLabel);
        Scoreframe.setSize(300, 100);
        Scoreframe.setVisible(true);
    }

    // Method to update the score
    public void setScore(int score) {
        scoreLabel.setText("Score: " + score);
    }
}
public class window {
    public static void main(String[] args) {
       
    }
}
