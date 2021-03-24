
import java.util.Collections;
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
        Card temp;
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card.length - 1; j++) {
                if (card[j].rank > card[j + 1].rank) {
                    temp = card[j];
                    card[j] = card[j + 1];
                    card[j + 1] = temp;

                }

            }

        }

        Vector<Card>[] bins = new Vector[4];

        for (int i = 0; i < bins.length; i++) {
            bins[i] = new Vector<Card>();                 //造bins的空間            
        }
        for (int i = 0; i < card.length; i++) {           //把cards按照suit放入bins[0]~bins[3]                        
            bins[card[i].suit].add(card[i]);
        }
//        for (int i = 0; i < bins.length; i++) {
//            bins[i].;
//        }

//        for (int i = 0; i < bins.length; i++) {            //BubbleSort之後同花順比較好找     
//            for (int j = 0; j < bins[i].size(); j++) {
//                for (int k = 0; k < bins[i].size(); k++) {
//                    if(bins[i].get(j).rank>bins[i].get(k).rank){
//                        temp=bins[i].elementAt(j);
//                        bins[i].=bins[i].get(k);
//                        bins[i].elementAt(j)=temp;
//                    }    
//                    
//                }
//                
//            }
//            
//        }
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

            if (cards[i].size() >= 2) {
                k++;
                System.out.println(cards[i].subList(0, 2) + "  ");
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
                for (int j = 0; j < cards[i].size() - 4; j++) {
                    System.out.println(cards[i].subList(j, j + 5) + "  ");

                }

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
            if (cards[i].size() >= 3) {
                k++;
                System.out.println(cards[i].subList(0, 3) + "  ");
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
        int count = 0;
        int flag = 0;

        System.out.println("FullHouse:");
        for (int i = 0; i < fullhouse.length; i++) {
            fullhouse[i] = new Vector<Card>();
        }

        for (int i = 0; i < cards.length; i++) {
            int notri = 1;
            if (cards[i].size() >= 3) {
                notri = 0;
                for (int j = 0; j < 3; j++) {
                    fullhouse[count].add(cards[i].get(j));
                }
            }
            if (notri == 0) {
                for (int j = 0; j < cards.length; j++) {
                    if (j != i) {
                        if (cards[j].size() >= 2) {
                            for (int k = 0; k < 2; k++) {
                                fullhouse[count].add(cards[j].get(k));
                            }
                            flag = 1;
                            break;
                        }
                    }

                }
                if (flag == 0) {
                    fullhouse[count].clear();
                }
                if (flag == 1) {
                    count++;
                }
            }
        }
        for (int i = 0; i < fullhouse.length; i++) {
            if (!fullhouse[i].isEmpty()) {
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
            System.out.println("");
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
                System.out.println("");
            }
            count = 0;
        }
        System.out.println("");
        System.out.println("");
    }

    public static void findStraightFlush(Vector<Card>[] cards) {
        Card[] check = new Card[13];
        Card[] check1 = new Card[13];
        Card[] check2 = new Card[13];
        Card[] check3 = new Card[13];
        int[] pin = new int[13];
        int[] pin1 = new int[13];
        int[] pin2 = new int[13];
        int[] pin3 = new int[13];
        for (int i = 0; i < pin3.length; i++) {
            pin3[i] = 0;
        }
        for (int i = 0; i < pin2.length; i++) {
            pin2[i] = 0;
        }
        for (int i = 0; i < pin1.length; i++) {
            pin1[i] = 0;
        }
        for (int i = 0; i < pin.length; i++) {
            pin[i] = 0;
        }
        System.out.println("StraightFlush:");

        for (int i = 0; i < cards[0].size(); i++) {
            check[cards[0].elementAt(i).rank] = cards[0].elementAt(i);
            pin[cards[0].elementAt(i).rank] = 1;
        }

        for (int i = 0; i < cards[1].size(); i++) {
            check1[cards[1].elementAt(i).rank] = cards[1].elementAt(i);
            pin[cards[1].elementAt(i).rank] = 1;
        }
        for (int i = 0; i < cards[2].size(); i++) {
            check2[cards[2].elementAt(i).rank] = cards[2].elementAt(i);
            pin2[cards[2].elementAt(i).rank] = 1;
        }
        for (int i = 0; i < cards[3].size(); i++) {
            check3[cards[3].elementAt(i).rank] = cards[3].elementAt(i);
            pin3[cards[3].elementAt(i).rank] = 1;
        }

        if (pin[12] == 1 && pin[0] == 1 && pin[9] == 1 && pin[10] == 1 && pin[11] == 1) {
            for (int i = 9; i < 13; i++) {
                System.out.print(check[i]);

            }
            System.out.print(check[0]);
            System.out.println("");
        }
        if (pin1[12] == 1 && pin1[0] == 1 && pin1[9] == 1 && pin1[10] == 1 && pin1[11] == 1) {
            for (int i = 9; i < 13; i++) {
                System.out.print(check1[i]);

            }
            System.out.print(check1[0]);
            System.out.println("");
        }
        if (pin2[12] == 1 && pin2[0] == 1 && pin2[9] == 1 && pin2[10] == 1 && pin2[11] == 1) {
            for (int i = 9; i < 13; i++) {
                System.out.print(check2[i]);

            }
            System.out.print(check2[0]);
            System.out.println("");
        }
        if (pin3[12] == 1 && pin3[0] == 1 && pin3[9] == 1 && pin3[10] == 1 && pin3[11] == 1) {
            for (int i = 9; i < 13; i++) {
                System.out.print(check3[i]);

            }
            System.out.print(check3[0]);
            System.out.println("");
        }
        int count = 0;
        for (int i = 0; i <= pin.length - 5; i++) {
            for (int j = i; j < i + 5; j++) {
                if (pin[j] == 1) {
                    count++;
                }
            }
            if (count == 5) {
                System.out.print('[');
                for (int j = i; j < i + 5; j++) {
                    System.out.print(check[j]);
                }
                System.out.print(']');
                System.out.println("");
            }
            count = 0;
        }

        for (int i = 0; i <= pin1.length - 5; i++) {
            for (int j = i; j < i + 5; j++) {
                if (pin1[j] == 1) {
                    count++;
                }
            }
            if (count == 5) {
                System.out.print('[');
                for (int j = i; j < i + 5; j++) {
                    System.out.print(check1[j]);
                }
                System.out.print(']');
                System.out.println("");
            }
            count = 0;
        }
        for (int i = 0; i <= pin2.length - 5; i++) {
            for (int j = i; j < i + 5; j++) {
                if (pin2[j] == 1) {
                    count++;
                }
            }
            if (count == 5) {
                System.out.print('[');
                for (int j = i; j < i + 5; j++) {
                    System.out.print(check2[j]);
                }
                System.out.print(']');
                System.out.println("");
            }
            count = 0;
        }
        for (int i = 0; i <= pin3.length - 5; i++) {
            for (int j = i; j < i + 5; j++) {
                if (pin3[j] == 1) {
                    count++;
                }
            }
            if (count == 5) {
                System.out.print('[');
                for (int j = i; j < i + 5; j++) {
                    System.out.print(check3[j]);
                }
                System.out.print(']');
                System.out.println("");
            }
            count = 0;
        }


        System.out.println("");
        System.out.println("");

    }
}
