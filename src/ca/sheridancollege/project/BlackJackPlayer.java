/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author YutingLi
 */
public class BlackJackPlayer extends Player {
    private ArrayList<Card> cardsOnTable ;
    private ArrayList<BlackJackCard> cardsOnHand = new ArrayList<>();
    private int totalPoint ;

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public BlackJackPlayer(String name) {
        super(name);
    }

    public void play(){
        Scanner scanner = new Scanner(System.in);
        if(cardsOnHand.size() ==0 ){
            drawTwoCard();
            setTotalPoint(checkPoint());
        }
        if("Player".equals(getPlayerID())){
            if (cardsOnTable.size()>0 ){
                String userSelect = "2";
                while (checkPoint() < 21 && "2".equals(userSelect)){
                    showCardsOnHand();
                    System.out.print("Do you want Stand[1] or Hit[2], please choose 1 or 2 : ");
                    userSelect = scanner.next();
                    if ("2".equals(userSelect)){
                        hit();
                    }
                }
                setTotalPoint(checkPoint());
            }
        }
    }


    private int checkPoint(){
        List<BlackJackCard> aceCardOnHand = new ArrayList<>();
        int totalPoint = 0;
        for (BlackJackCard card : cardsOnHand){
            totalPoint += card.getValue();
            if (card.getValue() == 11){
                aceCardOnHand.add(card);
            }
        }

        for(BlackJackCard card : aceCardOnHand) {
            if(totalPoint > 21) {
                totalPoint = totalPoint - 10;
            }
        }
        return totalPoint;
    }

    private void hit(){
        if(cardsOnTable.size()>0){
            BlackJackCard blackJackCard = (BlackJackCard) cardsOnTable.remove(0);
            cardsOnHand.add(blackJackCard);
        }
    }

    private void drawTwoCard(){
        hit();
        hit();
    }

    public ArrayList<Card> getCardsOnTable() {
        return cardsOnTable;
    }

    public void setCardsOnTable(ArrayList<Card> cardsOnTable) {
        this.cardsOnTable = cardsOnTable;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }

    public ArrayList<BlackJackCard> getCardsOnHand() {
        return cardsOnHand;
    }

    public void setCardsOnHand(ArrayList<BlackJackCard> cardsOnHand) {
        this.cardsOnHand = cardsOnHand;
    }

    public void showCardsOnHand () {
        System.out.println(getPlayerID()+" cards on hand, total point is ["+checkPoint()+"]");
        for(BlackJackCard card : getCardsOnHand()){
            System.out.println("["+card.getSuit()+"] "+card.getValue());
        }
        System.out.println("====================== ");
    }
}
