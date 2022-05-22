package business.impl;

import business.TicTacGame;
import com.vinayak.practice.model.Board;
import com.vinayak.practice.model.Player;

import java.util.ArrayList;
import java.util.List;

public class TicTacGameImpl implements TicTacGame {
    private Board board;
    private int boardSize;
    private int numOfPlayer;
    private int playerCt;
    private List<Player> players;

    public TicTacGameImpl(int boardSize, int numOfPlayers) {
        board = new Board(boardSize);
        playerCt = 0;
        this.boardSize = boardSize;
        this.numOfPlayer = numOfPlayers;
        players = new ArrayList<>();
    }

    public void printBoard() {
        System.out.println(this.board);
    }

    public boolean registerPlayer(String name, String username) {
        if (players.size() < numOfPlayer) {
            players.add(new Player(name, username));
            return true;
        }
        return false;
    }

    public boolean executeTurn(int x, int y, Player player) {
        if (x >= this.boardSize || y >= this.boardSize || x < 0 || y < 0) return false;
        else if (!board.isEmpty(x, y)) return false;
        else {
            board.markValue(x, y, player.getUserName());
            playerCt = (playerCt + 1)%numOfPlayer;
            return true;
        }
    }

    public boolean noMoreMovesPossible() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board.isEmpty(i, j)) return false;
            }
        }
        return true;
    }

    public Player findPlayerWhoseTurnItIs(){
        Player currentPlayer =  players.get(playerCt);
        return  currentPlayer;
    }

    public Player findWinner() {
        for (Player player : players) {
            if (hasPlayerWon(player)) {
                return player;
            }
        }
        return null;
    }

    private boolean hasPlayerWon(Player player) {
        // either row has players id
        for (int i = 0; i < boardSize; i++) {
            int playersTiles = 0;
            for (int j = 0; j < boardSize; j++) {
                if (board.findValue(i, j) != null && board.findValue(i, j).equals(player.getUserName())) {
                    playersTiles = playersTiles + 1;
                } else {
                    break;
                }
            }
            if (playersTiles == boardSize) return true;
        }
        // either col has players id
        for (int i = 0; i < boardSize; i++) {
            int playersTiles = 0;
            for (int j = 0; j < boardSize; j++) {
                if (board.findValue(j, i) != null && board.findValue(j, i).equals(player.getUserName())) {
                    playersTiles = playersTiles + 1;
                } else {
                    break;
                }
            }
            if (playersTiles == boardSize) return true;
        }

        // left diagonal has players id
        int playersTiles = 0;
        for (int i = 0; i < boardSize; i++) {
            if (board.findValue(i, i) != null && board.findValue(i, i).equals(player.getUserName())) {
                playersTiles = playersTiles + 1;
            } else {
                break;
            }
        }
        if (playersTiles == boardSize) return true;

        // right diagonal has players id
        playersTiles = 0;
        for (int i = 0; i < boardSize; i++) {
            if (board.findValue(i, boardSize - i - 1) != null &&
                    board.findValue(i, boardSize - i - 1).equals(player.getUserName())) {
                playersTiles = playersTiles + 1;
            } else {
                break;
            }
        }
        if (playersTiles == boardSize) return true;

        return false;
    }
}
