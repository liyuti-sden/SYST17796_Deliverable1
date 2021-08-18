/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author YutingLi
 */
public class Main {
    public static void main(String[] args) {
        BlackJackGame blackJackGame = new BlackJackGame("BlackJack");
        boolean playAgain = true;
        while(playAgain){
            blackJackGame.play();
            System.out.print("Dealer Score ["+blackJackGame.getDealerScore()+"], "
                    + "Player Score ["+blackJackGame.getPlayerScore()+"], Do you want to play again ? [Y/N]");
            Scanner scanner = new Scanner(System.in);
            String userSelect = scanner.next();
            if (!"Y".equalsIgnoreCase(userSelect)) {
                playAgain = false;
            }
        }
    }
}
    

