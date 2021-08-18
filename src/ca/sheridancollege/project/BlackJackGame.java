/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author YutingLi
 */
public class BlackJackGame extends Game {
    public BlackJackGame(String givenName) {
        super(givenName);
    }
    private int dealerScore;
    private int playerScore;

    @Override
    public void play() {
        BlackJackGroupOfCards cardsOnTable = new BlackJackGroupOfCards(52);
        BlackJackPlayer dealer = new BlackJackPlayer("Dealer");
        dealer.setCardsOnTable(cardsOnTable.showCards());
        BlackJackPlayer player = new BlackJackPlayer("Player");
        player.setCardsOnTable(cardsOnTable.showCards());
        getPlayers().add(dealer);
        getPlayers().add(player);


        System.out.println("Dealer draw card ...");
        dealer.play();
        System.out.println("Dealer draw card completed");
        System.out.println("");
        System.out.println("Player draw card ...");
        player.play();
        System.out.println("Player draw card completed");

        System.out.println("==========================");
        declareWinner();

    }

    @Override
    public void declareWinner() {
        ArrayList<Player> players = getPlayers();
        BlackJackPlayer dealer = (BlackJackPlayer)players.get(0);
        BlackJackPlayer player = (BlackJackPlayer) players.get(1);
        if (player.getTotalPoint() < dealer.getTotalPoint()){
            System.out.println("Player Lose");
            int score = getDealerScore();
            setDealerScore(++score);
        } else if (player.getTotalPoint() > 21){
            System.out.println("Player Lose");
            int score = getDealerScore();
            setDealerScore(++score);
        }
        else if (player.getTotalPoint() > dealer.getTotalPoint()){
            System.out.println("Player Win");
            int score = getPlayerScore();
            setPlayerScore(++score);
        }
        else if (player.getTotalPoint() == dealer.getTotalPoint()){
            System.out.println("Tie");
        }

        dealer.showCardsOnHand();
        player.showCardsOnHand();
    }



    private void resetScore() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getDealerScore() {
        return dealerScore;
    }

    public void setDealerScore(int dealerScore) {
        this.dealerScore = dealerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }
}
