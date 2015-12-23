/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.interpsync.principal.gui;

import br.com.interpsync.controller.BaixaEstoque;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Leonardo
 */
public class Main {
    public static void main(String[] args) {
        int tempo = 30000;
        int periodo = 30000;
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask()
        {
           public void run()
           {
            BaixaEstoque be = new BaixaEstoque();
            be.executar();
           }
        }, tempo, periodo);
    }
}
