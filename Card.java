/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author a2001
 */
public class Card {
    int rank;           //宣告樸克牌數字
    String suit;           //宣告樸克牌花色
/**
 * 造一個可以儲放樸克牌空間的函式
 */
    public Card() {     
    }    
/**
 * 設定樸克牌值得函式
 * @param rank
 * @param suit 
 */
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
/**
 * 呼叫數字值
 * @return 數字
 */
    public int getRank() {
        return rank;
    }
/**
 * 修改數字的函式
 * @param rank 
 */
    public void setRank(int rank) {
        this.rank = rank;
    }
/**
 * 呼叫花色
 * @return 
 */    
    public String getSuit() {
        return suit;
    }
/**
 * 修改花色的函式
 * @param suit 
 */
    public void setSuit(String suit) {
        this.suit = suit;
    }
/**
 * 印出牌的函式
 * @return 
 */
    @Override
    public String toString() {
        if(rank==13){
            return '(' + "rank=" + 'K' + ", suit=" + suit + ')';
        }
        if(rank==12){
            return '(' + "rank=" + 'Q' + ", suit=" + suit + ')';
        }
        if(rank==11){
            return '(' + "rank=" + 'J' + ", suit=" + suit + ')';
        }
        if(rank==1){
            return '(' + "rank=" + 'A' + ", suit=" + suit + ')';
        }
        return '(' + "rank=" + rank + ", suit=" + suit + ')';
    }
    
    
}
