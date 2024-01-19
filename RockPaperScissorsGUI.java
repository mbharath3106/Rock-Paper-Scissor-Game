import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissorsGUI extends JFrame {
    private JLabel resultLabel;

    public RockPaperScissorsGUI() {
        super("Rock Paper Scissors Game");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JButton rockButton = new JButton("Rock");
        JButton paperButton = new JButton("Paper");
        JButton scissorsButton = new JButton("Scissors");

        resultLabel = new JLabel("Result: ");

        panel.add(rockButton, BorderLayout.WEST);
        panel.add(paperButton, BorderLayout.CENTER);
        panel.add(scissorsButton, BorderLayout.EAST);

        add(resultLabel, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);

        rockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                play("Rock");
            }
        });

        paperButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                play("Paper");
            }
        });

        scissorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                play("Scissors");
            }
        });
    }

    private void play(String userChoice) {
        String[] choices = {"Rock", "Paper", "Scissors"};
        String computerChoice = choices[(int) (Math.random() * 3)];

        String result = determineWinner(userChoice, computerChoice);

        resultLabel.setText("Result: " + result + " (You: " + userChoice + ", Computer: " + computerChoice + ")");
    }

    private String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "It's a tie!";
        } else if ((userChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                (userChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                (userChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RockPaperScissorsGUI().setVisible(true);
            }
        });
    }
}
