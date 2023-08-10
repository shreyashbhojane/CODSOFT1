import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class codesoftinternp2 extends JFrame {

    private int randomNumber;
    private int attempts;

    private JLabel titleLabel;
    private JLabel promptLabel;
    private JTextField inputField;
    private JButton submitButton;
    private JLabel resultLabel;

    public codesoftinternp2() {
        randomNumber = generateRandomNumber();
        attempts = 0;

        titleLabel = new JLabel("Guess the Number Game");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        promptLabel = new JLabel("Enter your guess (1-100):");
        inputField = new JTextField(10);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());

        resultLabel = new JLabel(" ");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));

        setLayout(new GridLayout(4, 1));
        add(titleLabel);
        add(promptLabel);
        add(inputField);
        add(submitButton);
        add(resultLabel);

        setTitle("Guess the Number");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    private class SubmitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                int guess = Integer.parseInt(inputField.getText());
                attempts++;

                if (guess == randomNumber) {
                    resultLabel.setText("Congratulations! You guessed it in " + attempts + " attempts.");
                    submitButton.setEnabled(false);
                } else if (guess < randomNumber) {
                    resultLabel.setText("Try again. Your guess is too low.");
                } else {
                    resultLabel.setText("Try again. Your guess is too high.");
                }
            } catch (NumberFormatException e) {
                resultLabel.setText("Invalid input. Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new codesoftinternp2();
            }
        });
    }
}