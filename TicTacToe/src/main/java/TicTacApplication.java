import business.TicTacGameController;
import business.impl.TicTacGameControllerImpl;

public class TicTacApplication {

    public static void main(String[] args) {
        TicTacGameController game = new TicTacGameControllerImpl();
        game.takeInitialInputAndStartGame();
    }
}
