package com.github.dmitry_mingazov.connect_four.views;

import com.github.dmitry_mingazov.connect_four.*;
import com.github.dmitry_mingazov.connect_four.exceptions.IllegalMoveException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ConsoleView implements View {
    private Model model;
    private Controller controller;
    private ArrayList<Player> players;
    private BufferedReader reader;

    public ConsoleView(Model model, Controller controller){
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.model = model;
        this.controller = controller;
        this.players = new ArrayList<>();
    }

    @Override
    public void enableInputFor(Player player){
        if(player != null)
            this.players.add(player);
    }


    @Override
    public void update(Observable observable, Object obj){

        if(obj instanceof Player){
            if(this.model.hasWinner()){
                System.out.println(obj + " has won!");
                return;
            }
            for(Player player : this.players) {
                if (player.equals(obj)) {
                    if (this.model.isTakingInput()) {
                        do {
                            System.out.println("Where do you want to put your disc, " + player + "?");
                            try {
                                this.model.selectColumn(Integer.parseInt(reader.readLine())-1);
                            } catch (IOException | IllegalMoveException | NumberFormatException e) {
                                System.out.println(e);
                                continue;
                            }
                        } while (false);
                    }

                }
            }
            return;
        }

        if(obj instanceof Board){
            this.printBoard();
            return;
        }


    }

    private void printBoard(){
        int height = this.model.getBoardHeight();
        int width = this.model.getBoardWidth();
        System.out.println();
        for(int z = 0; z <= width+1; z++){
            System.out.print("# ");
        }
        System.out.println();
        for(int i = height - 1; i >= 0; i--){
            System.out.print("#");
            for(int k = 0; k < width; k++){
               System.out.print(" " + this.discSymbol(this.model.getDiscAt(k, i)));
            }
            System.out.println(" #");
        }
        for(int z = 0; z <= width+1; z++){
            System.out.print("# ");
        }
        System.out.println();
        System.out.print("  ");
        for(int z = 0; z < width; z++){
            System.out.print((z+1) +" ");
        }
        System.out.println();
    }

    private String discSymbol(Disc disc){
        switch(disc){
            case RED:
                return "R";
            case YELLOW:
                return "Y";
            case EMPTY:
                return "-";
        }
        return "?";
    }
}
