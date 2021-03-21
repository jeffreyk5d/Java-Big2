
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author a2001
 */
public class Player {
    Card[] pCard=new Card[13];//宣告玩家共有13張手牌
    int playerNum;            //宣告玩家編號
/**
 * 給玩家空間存值
 */
    public Player() {
    }
/**
 * 
 * @param pCard 
 */
    public Player(Card[] pCard) {
        this.pCard = pCard;
    }
/**
 * 設定玩家編號
 * @param playerNum 
 */
    public Player(int playerNum) {
        this.playerNum = playerNum;
    }
/**
 * 獲取玩家卡牌
 * @return 
 */
    public Card[] getpCard() {
        return pCard;
    }
/**
 * 編輯玩家卡牌
 * @param pCard 
 */
    public void setpCard(Card[] pCard) {
        this.pCard = pCard;
    }
/**
 * 獲取玩家編號
 * @return 
 */
    public int getPlayerNum() {
        return playerNum;
    }
/**
 * 修改設定玩家編號
 * @param playerNum 
 */
    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }
/**
 * 印出玩家手牌函式
 * @param p 
 */
    
    public static void printCard(Player[] p) {
        for (int j = 0; j < p.length; j++) {
            System.out.println("\n");            
            System.out.printf("Player"+p[j].playerNum+":");
            for (int i = 0; i < p[j].pCard.length; i++) {
               if(i%7==0){
                    System.out.println("");
                }
                System.out.printf("%-25s",p[j].pCard[i]);                
            }
        }
        System.out.println("\n\n");               
    }
    public static void suitBinSort(Card[] cards) {
        Vector<Card>[] bins=new Vector[13];
    }
    public static void rankBinSort(Card[] cards) {
        
    }
    public static void findPairs(Card[] cards) {
        
    }
    public static void findFlush(Card[] cards) {
        
    }
    public static void findTriples(Card[] cards) {
        
    }
    public static void findQuads(Card[] cards) {
        
    }
    public static void findFullHouse(Card[] cards) {
        
    }
    public static void findStraights(Card[] cards) {
        
    }
    public static void findStraightFlush(Card[] cards) {
        
    }

}
