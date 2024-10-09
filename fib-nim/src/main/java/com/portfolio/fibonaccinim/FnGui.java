package com.portfolio.fibonaccinim;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class FnGui extends JFrame {
    static final int PLAYERS = 2;
    static final int NUM_OF_COINS = 13;
    static final int MAX_HEAP = 3;
    static final int MIN_HEAP = -3;

    private int[] heaps = {NUM_OF_COINS, NUM_OF_COINS, NUM_OF_COINS};
    private int currentPlayer = 1;
    private List<Integer> usedReset = new ArrayList<>();

    private JLabel heapLabel1 = new JLabel("Heap 1: " + heaps[0]);
    private JLabel heapLabel2 = new JLabel("Heap 2: " + heaps[1]);
    private JLabel heapLabel3 = new JLabel("Heap 3: " + heaps[2]);
    private JLabel playerTurnLabel = new JLabel("Player " + currentPlayer + "'s Turn");
    private JLabel messageLabel = new JLabel("");
    private JComboBox<Integer> heapChoice = new JComboBox<>(new Integer[]{1, 2, 3});
    private JTextField coinsField = new JTextField(5);
    private JButton takeCoinsButton = new JButton("Take Coins");
    private JButton resetHeapButton = new JButton("Use Reset Token");

    public FnGui() {
        setTitle("Fibonacci Nim Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set up layout
        setLayout(new BorderLayout());

        // Panel for heaps and player turn
        JPanel topPanel = new JPanel(new GridLayout(4, 1));
        topPanel.add(heapLabel1);
        topPanel.add(heapLabel2);
        topPanel.add(heapLabel3);
        topPanel.add(playerTurnLabel);
        add(topPanel, BorderLayout.NORTH);

        // Panel for player actions
        JPanel centerPanel = new JPanel();
        centerPanel.add(new JLabel("Choose a Heap:"));
        centerPanel.add(heapChoice);
        centerPanel.add(new JLabel("Coins to take:"));
        centerPanel.add(coinsField);
        centerPanel.add(takeCoinsButton);
        centerPanel.add(resetHeapButton);
        add(centerPanel, BorderLayout.CENTER);

        // Panel for game messages
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(messageLabel);
        add(bottomPanel, BorderLayout.SOUTH);

        // Action listeners
        takeCoinsButton.addActionListener(new TakeCoinsListener());
        resetHeapButton.addActionListener(new ResetHeapListener());
    }

    // Listener for "Take Coins" button
    private class TakeCoinsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int heap = (int) heapChoice.getSelectedItem();
                int coins = Integer.parseInt(coinsField.getText());
                int maxCoin = heaps[heap - 1];

                if (maxCoin == NUM_OF_COINS) {
                    maxCoin = heaps[heap -1] -1;
                    messageLabel.setText("Now choose a number of coins between 1 and " + maxCoin);
                } else {
                    messageLabel.setText("Now choose a number of coins between 1 and " + maxCoin);
                }

                if (coins <= 0 || coins > heaps[heap - 1] || coins == NUM_OF_COINS) {
                    messageLabel.setText("Invalid number of coins. Try again.");
                } else {
                    heaps[heap - 1] -= coins;
                    updateHeapLabels();
                    if (checkWin()) {
                        messageLabel.setText("Player " + currentPlayer + " Wins!");
                        disableButtons();
                    } else {
                        switchPlayer();
                        playerTurnLabel.setText("Player " + currentPlayer + "'s Turn");
                        messageLabel.setText("");
                    }
                }
            } catch (NumberFormatException ex) {
                messageLabel.setText("Please enter a valid number of coins.");
            }
        }
    }

    // Listener for "Use Reset Token" button
    private class ResetHeapListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int heap = -(int) heapChoice.getSelectedItem();
            if (usedReset.contains(currentPlayer)) {
                messageLabel.setText("Player " + currentPlayer + " has already used the reset token.");
            } else if (heaps[Math.abs(heap) - 1] == NUM_OF_COINS) {
                messageLabel.setText("Heap is already full.");
            } else {
                resetToken(heap);
                usedReset.add(currentPlayer);
                updateHeapLabels();
                messageLabel.setText("Player " + currentPlayer + " used the reset token.");
                switchPlayer();
                playerTurnLabel.setText("Player " + currentPlayer + "'s Turn");
                messageLabel.setText("");
            }
        }
    }

    // Method to update heap labels
    private void updateHeapLabels() {
        heapLabel1.setText("Heap 1: " + heaps[0]);
        heapLabel2.setText("Heap 2: " + heaps[1]);
        heapLabel3.setText("Heap 3: " + heaps[2]);
    }

    // Method to check if a player has won
    private boolean checkWin() {
        return heaps[0] == 0 && heaps[1] == 0 && heaps[2] == 0;
    }

    // Method to switch players
    private void switchPlayer() {
        currentPlayer = (currentPlayer == 1) ? 2 : 1;
    }

    // Method to disable buttons after game ends
    private void disableButtons() {
        takeCoinsButton.setEnabled(false);
        resetHeapButton.setEnabled(false);
    }

    // Method to reset the heap to full (13 coins)
    private void resetToken(int heap) {
        int convertNum = Math.abs(heap);
        heaps[convertNum - 1] = NUM_OF_COINS;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FnGui game = new FnGui();
            game.setVisible(true);
        });
    }
}
