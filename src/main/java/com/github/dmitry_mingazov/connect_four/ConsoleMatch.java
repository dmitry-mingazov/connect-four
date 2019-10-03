package com.github.dmitry_mingazov.connect_four;
import com.github.dmitry_mingazov.connect_four.boards.StandardBoard;
import com.github.dmitry_mingazov.connect_four.botStrategies.GreedyStrategy;
import com.github.dmitry_mingazov.connect_four.controllers.StandardController;
import com.github.dmitry_mingazov.connect_four.models.StandardModel;
import com.github.dmitry_mingazov.connect_four.players.InteractivePlayer;
import com.github.dmitry_mingazov.connect_four.players.PlayerFactory;
import com.github.dmitry_mingazov.connect_four.views.ConsoleView;

public class ConsoleMatch {
    public static void main(String args[]){

        Board board = new StandardBoard();
        Player player1 = PlayerFactory.getPlayer("MARIO ROSSO", Disc.RED);
        Player player2 = PlayerFactory.getPlayer("Bot", Disc.YELLOW);
        player2.setStrategy(new GreedyStrategy());

        Model model = new StandardModel(board, player1, player2);
        Controller controller = new StandardController(model);
        View view = new ConsoleView(model, controller);
        view.enableInputFor(player1);
        view.enableInputFor(player2);
        model.addObserver(view);

        controller.play();
    }
}
