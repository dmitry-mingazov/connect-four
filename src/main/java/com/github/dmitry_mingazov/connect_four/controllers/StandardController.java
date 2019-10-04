package com.github.dmitry_mingazov.connect_four.controllers;

import com.github.dmitry_mingazov.connect_four.Controller;
import com.github.dmitry_mingazov.connect_four.Model;
import com.github.dmitry_mingazov.connect_four.Player;
import com.github.dmitry_mingazov.connect_four.exceptions.IllegalMoveException;

/**
 * Standard controller, let the players play until one of them wins
 */
public class StandardController implements Controller {
    private Model model;

    public StandardController(Model model){
        this.model = model;
    }

    @Override
    public void play(){
        Player winner = null;
        do{
           this.model.takeInput();
           try {
               this.model.insertDisc();
           }catch(IllegalMoveException e){
               continue;
           }
           winner = this.model.checkWinner();
           this.model.changeTurn();
        }while(winner == null);
    }
}
