/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.interpsync.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonardo
 */
public class Geralog {
    public void enviar(String app, String msg){
        try {
            String local = new File("./log.txt").getCanonicalFile().toString();
            File arq = new File(local);
            boolean existe = arq.exists();        
            if (!existe){
                arq.createNewFile();
            }
            FileWriter fw = new FileWriter( arq, true );
            BufferedWriter bw = new BufferedWriter( fw );
            String mensagem = app+" >> "+msg;
            bw.write(mensagem);
            bw.newLine();
            bw.close();
            fw.close();
        }catch (IOException ex) {
            Logger.getLogger(Geralog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
