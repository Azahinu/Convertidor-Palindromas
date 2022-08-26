package main;

import controller.palindromaGUI;

import javax.swing.*;

public class Main {


    public static void main(String args[]){

        palindromaGUI h = new palindromaGUI();


        h.setContentPane(h.panel1);
        h.setTitle("La asombrosa GUI de Anderson y Kim");
        h.setSize(850, 850);
        h.botones();
        h.setVisible(true);
        h.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }



}
