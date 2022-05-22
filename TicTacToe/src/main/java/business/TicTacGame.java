package business;

import com.vinayak.practice.model.Player;

import java.util.List;

public interface TicTacGame {

    public void printBoard();

    public boolean registerPlayer(String name, String id);

    public boolean executeTurn(int x, int y, Player player);

    public Player findWinner();

    public boolean noMoreMovesPossible();

    public Player findPlayerWhoseTurnItIs();
}
