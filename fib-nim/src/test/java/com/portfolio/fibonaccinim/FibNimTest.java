package com.portfolio.fibonaccinim;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class FibNimTest 
{
    /**
     * Rigorous Test :-)
     */


    @Test
    public void testLevel1Player1Wins1() {
        String expected = "Remaining coins: 13, 13, 13\n "+
                    "Player 1: choose a heap: Now choose a number of coins between 1 and 12: Remaining coins: 13, 9, 13\n"+
                    "Player 2: choose a heap: Now choose a number of coins between 1 and 8: Remaining coins: 13, 1, 13\n" +
                    "Player 1: choose a heap: Now choose a number of coins between 1 and 12: Remaining coins: 9, 1, 13\n" +
                    "Player 2: choose a heap: Now choose a number of coins between 1 and 12: Remaining coins: 9, 1, 9\n" +
                    "Player 1: choose a heap: Now choose a number of coins between 1 and 8: Remaining coins: 1, 1, 9\n" +
                    "Player 2: choose a heap: Now choose a number of coins between 1 and 1: Remaining coins: 0, 1, 9\n" +
                    "Player 1: choose a heap: Now choose a number of coins between 1 and 1: Remaining coins: 0, 0, 9\n" +
                    "Player 2: choose a heap: Now choose a number of coins between 1 and 8: Remaining coins: 0, 0, 1\n" +
                    "Player 1: choose a heap: Now choose a number of coins between 1 and 1: Player 1 wins!";

    }

    @Test
    public void testLevel1Player1Wins2() {
        String expected = "Remaining coins: 13, 13, 13\n" +
                "Player 1: choose a heap: Now choose a number of coins between 1 and 12: Remaining coins: 13, 13, 1\n" +
                "Player 2: choose a heap: Now choose a number of coins between 1 and 12: Remaining coins: 13, 1, 1\n" +
                "Player 1: choose a heap: Now choose a number of coins between 1 and 12: Remaining coins: 2, 1, 1\n" +
                "Player 2: choose a heap: Now choose a number of coins between 1 and 2: Remaining coins: 1, 1, 1\n" +
                "Player 1: choose a heap: Now choose a number of coins between 1 and 1: Remaining coins: 0, 1, 1\n" +
                "Player 2: choose a heap: Now choose a number of coins between 1 and 1: Remaining coins: 0, 0, 1\n" +
                "Player 1: choose a heap: Now choose a number of coins between 1 and 1: Player 1 wins!";

    }

    @Test
    public void testLevel1Player2Wins1() {
        String expected = "Remaining coins: 13, 13, 13\n "+
                    "Player 1: choose a heap: Now choose a number of coins between 1 and 12: Remaining coins: 1, 13, 13\n"+
                    "Player 2: choose a heap: Now choose a number of coins between 1 and 12: Remaining coins: 1, 1, 13\n" +
                    "Player 1: choose a heap: Now choose a number of coins between 1 and 12: Remaining coins: 1, 1, 1\n" +
                    "Player 2: choose a heap: Now choose a number of coins between 1 and 1: Remaining coins: 0, 1, 1 \n" +
                    "Player 1: choose a heap: Now choose a number of coins between 1 and 1: Remaining coins: 0, 0, 1\n" +
                    "Player 2: choose a heap: Now choose a number of coins between 1 and 1: Player 2 wins!";
    }

    @Test
    public void testLevel1Player2Wins2() {
        String expected = "Remaining coins: 13, 13, 13\n" +
                "Player 1: choose a heap: Now choose a number of coins between 1 and 12: Remaining coins: 12, 13, 13\n" +
                "Player 2: choose a heap: Now choose a number of coins between 1 and 2: Remaining coins: 10, 13, 13\n" +
                "Player 1: choose a heap: Now choose a number of coins between 1 and 4: Remaining coins: 6, 13, 13\n" +
                "Player 2: choose a heap: Now choose a number of coins between 1 and 6: Remaining coins: 0, 13, 13\n" +
                "Player 1: choose a heap: Now choose a number of coins between 1 and 12: Remaining coins: 0, 12, 13\n" +
                "Player 2: choose a heap: Now choose a number of coins between 1 and 2: Remaining coins: 0, 10, 13\n" +
                "Player 1: choose a heap: Now choose a number of coins between 1 and 4: Remaining coins: 0, 6, 13\n" +
                "Player 2: choose a heap: Now choose a number of coins between 1 and 6: Remaining coins: 0, 0, 13\n" +
                "Player 1: choose a heap: Now choose a number of coins between 1 and 12: Remaining coins: 0, 0, 12\n" +
                "Player 2: choose a heap: Now choose a number of coins between 1 and 2: Remaining coins: 0, 0, 10\n" +
                "Player 1: choose a heap: Now choose a number of coins between 1 and 4: Remaining coins: 0, 0, 6\n" +
                "Player 2: choose a heap: Now choose a number of coins between 1 and 6: Player 2 wins!";

    }

    @Test
    void testLevel2InvalidHeapInput() {
        String expected = "Remaining coins: 13, 13, 13\n" + 
                    "Player 1: choose a heap: Now choose a number of coins between 1 and 12: Remaining coins: 1, 13, 13\n" + 
                    "Player 2: choose a heap: Sorry you must enter an integer in the range -3 to 3, excluding zero.\n" + 
                    "Player 2: choose a heap: Sorry you must enter an integer in the range -3 to 3, excluding zero.\n" +
                    "Player 2: choose a heap: Now choose a number of coins between 1 and 12: Remaining coins: 1, 1, 13\n" + 
                    "Player 1: choose a heap: Now choose a number of coins between 1 and 12: Sorry you must enter an integer.\n" + 
                    "Now choose between 1 and 12: Remaining coins: 1, 1, 1\n" + 
                    "Player 2: choose a heap: Now choose a number of coins between 1 and 1: Sorry you must enter an integer.\n" + 
                    "Now choose between 1 and 1: Sorry you must enter an integer.\n" + 
                    "Now choose between 1 and 1: Remaining coins: 0, 1, 1\n" + 
                    "Player 1: choose a heap: Now choose a number of coins between 1 and 1: Remaining coins: 0, 0, 1\n" + 
                    "Player 2: choose a heap: Now choose a number of coins between 1 and 1: Player 2 wins!";

    }
    




}
