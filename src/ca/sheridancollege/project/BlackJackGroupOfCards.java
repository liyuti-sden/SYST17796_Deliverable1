/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 *
 * @author YutingLi
 */
import java.util.ArrayList;
import java.util.Scanner;
public class BlackJackGroupOfCards extends GroupOfCards{
    public BlackJackGroupOfCards(int givenSize) {
        super(givenSize);
        initial();
        shuffle();
    }

    private void initial(){
        ArrayList<Card> cards = new ArrayList<>();
        for(int i=0;i<=3;i++){
            for(int j=1;j<=13;j++){
                BlackJackCard card = new BlackJackCard();
                card.setSuit(BlackJackCard.SUITS[i]);
                card.setValue(j);
                cards.add(card);
            }
        }
        this.setCards(cards);
    }
}
