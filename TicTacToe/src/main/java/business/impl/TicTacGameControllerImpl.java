package business.impl;

import business.TicTacGame;
import business.TicTacGameController;
import com.vinayak.practice.model.Player;

import java.util.Scanner;

public class TicTacGameControllerImpl implements TicTacGameController {
    String s;
    int boardSize;
    int numOfPlayers;
    int x;
    int y;

    public void takeInitialInputAndStartGame() {
        Scanner in = new Scanner(System.in);

        System.out.println("Input Board size");
        s = in.nextLine();
        boardSize = Integer.parseInt(s);

        System.out.println("Input num of players");
        s = in.nextLine();
        numOfPlayers = Integer.parseInt(s);

        TicTacGame ticTacGame = new TicTacGameImpl(boardSize, numOfPlayers);

        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("Input player details in format name;username");
            s = in.nextLine();
            // name;username
            ticTacGame.registerPlayer(s.split(";")[0], s.split(";")[1]);
        }

        System.out.println("Starting Game");
        while (!ticTacGame.noMoreMovesPossible()) {
            ticTacGame.printBoard();
            System.out.println(ticTacGame.findPlayerWhoseTurnItIs().getUserName() + " turn, Enter cordinates x y");

            while (true) {
                s = in.nextLine();
                x = Integer.parseInt(s.split(" ")[0]);
                y = Integer.parseInt(s.split(" ")[1]);
                if (ticTacGame.executeTurn(x, y, ticTacGame.findPlayerWhoseTurnItIs())) {
                    break;
                } else {
                    System.out.println("Wrong cordinates, please re enter them");
                }
            }

            Player player = ticTacGame.findWinner();

            if (player != null) {
                System.out.println(player.getUserName() + " has won the game.");
                break;
            }
        }
        System.out.println("Game has ended");
    }

}
