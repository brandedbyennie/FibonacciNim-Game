import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibNim {
    static int PLAYERS = 2;
    static int NUM_OF_COINS = 13;
    static int MAX_HEAP = 3;
    static int MIN_HEAP = -3;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] heaps = {NUM_OF_COINS, NUM_OF_COINS, NUM_OF_COINS};
        int heap;
        int coins;

        List<Integer> resetToken = new ArrayList<>();

        do {
            for (int playersTurn = 0; playersTurn < PLAYERS; playersTurn++) {
                if (heaps[0] == 0 && heaps[1] == 0 && heaps[2] == 0) {
                    break;
                }

                System.out.println("Remaining coins: " + heaps[0] + ", " + heaps[1] + ", " + heaps[2]);

                String chosenHeap;
                String coinsTaken;

                do {
                    System.out.print("Player " + (playersTurn + 1) + " choose a heap: ");
                    chosenHeap = input.nextLine();
                    if (!(isInteger(chosenHeap))) {
                        System.out.println("Sorry you must enter an integer in the range -3 to 3, excluding zero.");
                        continue;
                    }

                    heap = Integer.parseInt(chosenHeap);
                    if (heap >= 1 && heap <= MAX_HEAP) {
                        if (heaps[heap - 1] == 0) {
                            System.out.println("Sorry, that's not a legal heap choice.");
                            continue; 
                        } 
                        
                    } else if (heap < MIN_HEAP) {
                        heap = Math.abs(heap);
                        System.out.println("Sorry, that's not a legal heap choice.");
                        continue;

                    } else {
                        if (heap >= MIN_HEAP && heap <= -1) {
                            if (resetToken.contains(playersTurn)) {
                                System.out.println("Sorry you have used your reset.");
                                continue;
                            } else {
                                resetArr(heaps, heap);
                                resetToken.add(playersTurn);
                                System.out.println("Reset Token Used");
                                break;  
                            }
                            
                        }
                    }

                    break;
                } while(true);

                if (heap >= MIN_HEAP && heap <= -1) {
                    continue;
                }

                do {
                    int maxCoin = heaps[heap - 1];
                    if (maxCoin == NUM_OF_COINS) {
                        maxCoin = heaps[heap - 1] -1;
                        System.out.print("Now choose a number of coins between 1 and " + maxCoin + ": ");
                    } else {
                        System.out.print("Now choose a number of coins between 1 and " + maxCoin + ": ");
                    }

                    coinsTaken = input.nextLine();
                    if (!(isInteger(coinsTaken))) {
                        System.out.println("Sorry you must enter an integer.");
                        continue;
                    } 
                    
                    coins = Integer.parseInt(coinsTaken);
                    if (coins <= 0 || coins > maxCoin) {
                        System.out.println("Sorry that's not a legal number of coins for that heap.");
                    } else {
                        break;
                    }
                } while(true);

                calculateRemainingCoins(heaps, heap, coins);
                

                if (heaps[0] == 0 && heaps[1] == 0 && heaps[2] == 0) {
                    System.out.println("Player " + (playersTurn + 1) + " Wins!");
                }

            }

        } while (!(heaps[0] == 0 && heaps[1] == 0 && heaps[2] == 0));

    }

    /* if the user enters anything other than an integer*/
    public static boolean isInteger(String strInput) {
        return strInput.matches("-?\\d+");
    }


    public static boolean isCoinsValid(int [] heaps, int chosenHeap, String coinsTaken) {
        int coins = Integer.parseInt(coinsTaken);
        int maxCoin = heaps[chosenHeap-1];
        return coins > 0 && coins <= maxCoin;
    }

    public static void calculateRemainingCoins(int[] heaps, int chosenHeap, int coinsTaken) {
        heaps[chosenHeap - 1] -= coinsTaken;
        //lastCoin[coinsTaken - 1] = coinsTaken;
    }


    public static int resetArr(int [] arr, int num) {
        int convertNum = Math.abs(num);
        return arr[convertNum -1] = NUM_OF_COINS;

    }

    public static void output(int [] arr, String str) {

        int num = Integer.parseInt(str);
        if (num > 0 && num <= MAX_HEAP){
            System.out.println("good");
        } else if (num < 0 && num >= MIN_HEAP) {
            resetArr(arr, num);
            System.out.println("Remaining coins: " + arr[0] + ", " + arr[1] + ", " + arr[2]);
        }
    }

}