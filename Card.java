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
    int  suit;           //宣告樸克牌花色
    static final String[] SUITS={"Club","Diamonds","Heart","Spades"};
    static final String[] RANKS={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};    
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
    public Card(int rank, int suit) {
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
    public int getSuit() {
        return suit;
    }
/**
 * 修改花色的函式
 * @param suit 
 */
    public void setSuit(int suit) {
        this.suit = suit;
    }
/**
 * 印出牌的函式
 * @return 
 */
    @Override
    public String toString() {
        return '(' + "rank=" + RANKS[rank] + ", suit=" + SUITS[suit] + ')';
    }
    
    
}
