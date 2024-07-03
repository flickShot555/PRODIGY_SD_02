package com.example.prodigy_sd_02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessingGame {
    private static int randnum;
    private static int attempts;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);

        resetGame();
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        JLabel promptLabel = new JLabel("Guess a number between 1 and 100:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(promptLabel, gbc);

        JTextField guessField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(guessField, gbc);

        JButton guessButton = new JButton("Guess");
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(guessButton, gbc);

        JLabel feedbackLabel = new JLabel("");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(feedbackLabel, gbc);

        JLabel attemptsLabel = new JLabel("Attempts: 0");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(attemptsLabel, gbc);

        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int guess = Integer.parseInt(guessField.getText());
                    attempts++;
                    if (guess < randnum) {
                        feedbackLabel.setText("Too low!");
                    } else if (guess > randnum) {
                        feedbackLabel.setText("Too high!");
                    } else {
                        feedbackLabel.setText("Correct! You win!");
                        JOptionPane.showMessageDialog(panel, "You guessed the number in " + attempts + " attempts!");
                        resetGame();
                    }
                    attemptsLabel.setText("Attempts: " + attempts);
                } catch (NumberFormatException ex) {
                    feedbackLabel.setText("Please enter a valid number.");
                }
            }
        });
    }

    private static void resetGame() {
        Random rand = new Random();
        randnum = rand.nextInt(100) + 1;
        attempts = 0;
    }
}