
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

    Card[] pCard = new Card[13];//宣告玩家共有13張手牌
    int playerNum;            //宣告玩家編號
    Vector<Card>[] rankSort = new Vector[13];
    Vector<Card>[] suitSort = new Vector[4];

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
     *
     * @param playerNum
     */
    public Player(int playerNum) {
        this.playerNum = playerNum;
    }

    /**
     * 獲取玩家卡牌
     *
     * @return
     */
    public Card[] getpCard() {
        return pCard;
    }

    /**
     * 編輯玩家卡牌
     *
     * @param pCard
     */
    public void setpCard(Card[] pCard) {
        this.pCard = pCard;
    }

    public Vector<Card>[] getRankSort() {
        return rankSort;
    }

    public void setRankSort(Vector<Card>[] rankSort) {
        this.rankSort = rankSort;
    }

    public Vector<Card>[] getSuitSort() {
        return suitSort;
    }

    public void setSuitSort(Vector<Card>[] suitSort) {
        this.suitSort = suitSort;
    }

    /**
     * 獲取玩家編號
     *
     * @return
     */
    public int getPlayerNum() {
        return playerNum;
    }

    /**
     * 修改設定玩家編號
     *
     * @param playerNum
     */
    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }

    /**
     * 印出玩家手牌函式
     *
     * @param p
     */

    public static void printCard(Player[] p) {
        for (int j = 0; j < p.length; j++) {
            System.out.println("\n");
            System.out.printf("Player" + p[j].playerNum + ":");
            for (int i = 0; i < p[j].pCard.length; i++) {
                if (i % 7 == 0) {
                    System.out.println("");
                }
                System.out.printf("%-25s", p[j].pCard[i]);
            }
        }
        System.out.println("\n\n");
    }

    public static Vector<Card>[] rankBinSort(Card[] card) {
        Vector<Card>[] bins = new Vector[13];
        for (int i = 0; i < bins.length; i++) {
            bins[i] = new Vector<Card>();                 //造bins的空間            
        }
        for (int i = 0; i < card.length; i++) {           //把cards按照rank大小放入bins[0]~bins[12]                        
            bins[card[i].rank].add(card[i]);
        }
        return bins;
    }

    public static Vector<Card>[] suitBinSort(Card[] card) {
        Vector<Card>[] bins = new Vector[4];
        for (int i = 0; i < bins.length; i++) {
            bins[i] = new Vector<Card>();                 //造bins的空間            
        }
        for (int i = 0; i < card.length; i++) {           //把cards按照rank大小放入bins[0]~bins[3]                        
            bins[card[i].suit].add(card[i]);
        }
        return bins;
    }

    public static void printSort(Vector<Card>[] cards, int playernum) {
        System.out.println("Playernum " + playernum + ": ");
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[i].size(); j++) {
                System.out.print(cards[i].get(j));
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");
    }

    public static int findPairs(Vector<Card>[] cards) {
        int k = 0;
        System.out.println("Pairs: ");
        for (int i = 0; i < cards.length; i++) {

            if (cards[i].size() == 2) {
                k++;
                System.out.println(cards[i] + "  ");
            }
        }
        System.out.println("");
        System.out.println("");
        return k;
    }

    public static int findFlush(Vector<Card>[] cards) {
        int k = 0;
        System.out.println("Flush: ");
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].size() >= 5) {
                System.out.println(cards[i].subList(0, 5) + "  ");
                k++;
            }
        }
        System.out.println("");
        System.out.println("");
        return k;
    }

    public static int findTriples(Vector<Card>[] cards) {
        int k = 0;
        System.out.println("Triples: ");
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].size() == 3) {
                k++;
                System.out.println(cards[i] + "  ");
            }
        }
        System.out.println("");
        System.out.println("");
        return k;
    }

    public static int findQuads(Vector<Card>[] cards) {
        int k = 0;
        System.out.println("Quads: ");
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].size() == 4) {
                k++;
                System.out.println(cards[i] + "  ");
            }
        }
        System.out.println("");
        System.out.println("");
        return k;
    }

    public static void findFullHouse(Vector<Card>[] cards) {
        Vector<Card>[] fullhouse = new Vector[20];
        int count=0;
        int flag=0;
        
        System.out.println("FullHouse:");
        for (int i = 0; i < fullhouse.length; i++) {
            fullhouse[i] = new Vector<Card>();
        }        
        
        for (int i = 0; i < cards.length; i++) {
            int notri=1;
            if(cards[i].size()>=3){
                notri=0;
                for (int j = 0; j < 3;j++) {                    
                    fullhouse[count].add(cards[i].get(j));                                                        
                }                
            }
            if(notri==0){                
                for (int j = 0; j < cards.length; j++) {                
                    if(j!=i){
                      if(cards[j].size()>=2){
                       for (int k = 0; k < 2;k++) {
                         fullhouse[count].add(cards[j].get(k));                                                               
                        } 
                        flag=1;                        
                        break;
                        }   
                    }

                }
                if(flag==0){
                    fullhouse[count].clear();           
                }
                if(flag==1){
                    count++;
                }
            }            
        }
        for (int i = 0; i < fullhouse.length; i++) {        
            if(!fullhouse[i].isEmpty()){                
                System.out.println(fullhouse[i]);
            }
            
        }
        System.out.println("");
        System.out.println("");
        


    }

    public static void findStraights(Vector<Card>[] cards) {
        System.out.println("Straights:");
        int[] pin = new int[13];
        int count = 0;
        for (int i = 0; i < cards.length; i++) {
            pin[i] = 1;
        }
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].isEmpty()) {
                pin[i] = 0;
            }
        }

        if (pin[0] == 1 && pin[9] == 1 && pin[12] == 1 && pin[11] == 1 && pin[10] == 1) {
            System.out.print('[');
            for (int i = 9; i <= 12; i++) {
                System.out.print(cards[i].firstElement());
            }
            System.out.print(cards[0].firstElement());
            System.out.print(']');
        }
        for (int i = 0; i <= pin.length - 5; i++) {
            for (int j = i; j < i + 5; j++) {
                if (pin[j] == 1) {
                    count++;
                }
            }
            if (count == 5) {
                System.out.print('[');
                for (int j = i; j < i + 5; j++) {
                    System.out.print(cards[j].firstElement());
                }
                System.out.print(']');
            }
            count = 0;
        }
        System.out.println("");
        System.out.println("");
    }

    public static void findStraightFlush(Vector<Card>[] cards) {
        
//        int[] pin = new int[13];
//        int count=0;
//        Card temp=new Card();
//        for (int i = 0; i < cards.length; i++) {
//            pin[i] = 0;
//        }
//        for (int i = 0; i < cards.length; i++) {
//            if (cards[i].size() >= 5) {
//                for (int j = 0; j < pin.length; j++) {
//                    for (int k = 0; k < pin.length; k++) {                        
//                        temp=cards[i].sort(cards[i].get(j).rank);                                                    
//                    }
//                    
//                }
//                for (int j = 0; j < cards[i].size(); j++) {
//                    pin[cards[i].get(j).rank] = 1;
//                }
//                if (pin[0] == 1 && pin[9] == 1 && pin[12] == 1 && pin[11] == 1 && pin[10] == 1) {
//                    System.out.print('[');
////                    for (int o = 9; o <= 12; o++) {
////                        System.out.print(cards[o].firstElement());
////                    }
////                    System.out.print(cards[0].firstElement());
//                    System.out.print(']');
//                }
//                for (int o = 0; o <= pin.length - 5; o++) {
//                    for (int j = o; j < o + 5; j++) {
//                        if (pin[j] == 1) {
//                            count++;
//                        }
//                    }
//                    if (count == 5) {
//                        System.out.print('[');
//                        for (int j = i; j < i + 5; j++) {
////                            System.out.print(cards[j].firstElement());
//                        }
//                        System.out.print(']');
//                    }
//                    count = 0;
//                }
//            }
//        }

    }
}
