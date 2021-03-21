/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author a2001
 */
public class Deck {
/**
 * 洗牌函式
 * @param allCards 
 */   
    public static void shuffle(Card[] allCards) {
        Card temp=new Card();                       //宣告一個暫存的Card空間以方便換牌
        for (int i = 0; i < allCards.length; i++) {
            int k;
            k=(int)(Math.random()*52);
            temp=allCards[i];
            allCards[i]=allCards[k];
            allCards[k]=temp;            
        }
    }
    
/**
 * 發牌函式
 * @param allCards
 * @param p 
 */       
    public static void deal(Card[] allCards,Player[] p) {         
   
        for (int i = 0; i < allCards.length; i++) {           
            p[i%4].pCard[i%13]=allCards[i];     //i%4意思為一張張照順序發 由player1發到player4...i%13是指每個的每個人的13張牌
        }        
    }
}
