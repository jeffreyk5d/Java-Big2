/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author a2001
 */
public class Run {

    public static void main(String[] args) {
        int posc = 0;                                                                                 //第posc張牌        
        Card[] allCard = new Card[52];                                                                //宣告有52張牌
        for (int i = 0; i < 52; i++) {                                                              //給空間
            allCard[i] = new Card();
        }
        for (int i = 0; i < 13; i++) {                                                              //設定牌的值
            for (int j = 0; j < 4; j++) {
                if (j == 0) {
                    allCard[posc].setRank(i);
                    allCard[posc].setSuit(j);
                } else if (j == 1) {
                    allCard[posc].setRank(i);
                    allCard[posc].setSuit(j);
                } else if (j == 2) {
                    allCard[posc].setRank(i);
                    allCard[posc].setSuit(j);
                } else if (j == 3) {
                    allCard[posc].setRank(i);
                    allCard[posc].setSuit(j);
                }
                posc++;
            }
        }

        System.out.printf("Display Cards(before shuffle)");                                             //印出牌(洗牌前)
        for (int i = 0; i < allCard.length; i++) {
            if (i % 10 == 0) {
                System.out.println("");
            }
            System.out.printf("%-25s", allCard[i]);

        }
        Deck.shuffle(allCard);                                                                          //用Deck的洗牌函式洗牌
        System.out.printf("\n\nDisplay Cards(after shuffle)");                                          //印出牌(洗牌後)
        for (int i = 0; i < allCard.length; i++) {
            if (i % 10 == 0) {
                System.out.println("");
            }
            System.out.printf("%-25s", allCard[i]);
        }
        System.out.println("\n\nDeal card to players");
        Player[] player = new Player[4];                                        //宣告4個玩家
        for (int i = 0; i < 4; i++) {                                           //給空間存放玩家
            player[i] = new Player();
        }
        for (int i = 0; i < player.length; i++) {                               //設定玩家編號
            player[i].setPlayerNum(i + 1);                                      
        }

        Deck.deal(allCard, player);                                               //用Deck的洗牌函式洗牌        
        Player.printCard(player);                                                  //印出玩家個別的牌
        for (int i = 0; i < player.length; i++) {
            player[i].rankSort=Player.rankBinSort(player[i].pCard);   
            player[i].suitSort=Player.suitBinSort(player[i].pCard);               
        }
        for (int i = 0; i < player.length; i++) {
            Player.printSort(player[i].rankSort,player[i].playerNum);
            Player.printSort(player[i].suitSort,player[i].playerNum);
            System.out.println("Playernum "+player[i].playerNum);
            Player.findPairs(player[i].rankSort);
            Player.findTriples(player[i].rankSort);
            Player.findQuads(player[i].rankSort);
            Player.findFlush(player[i].suitSort);
            Player.findStraights(player[i].rankSort);
            Player.findFullHouse(player[i].rankSort);
            Player.findStraightFlush(player[i].suitSort);
        }       
    }

}
