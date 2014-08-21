package czt.interview;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by TeaEra on 2014-08-21.
 *
 * 本题为一美团面试题，题目大概描述为：
 *   电影院的票按优先级卖出，优先级的计算为，越靠后排、越靠中间优先级越高；
 *
 * 此题要求使用OO设计，其实是要靠Comparable接口；
 *
 * 有很多可以沟通的点：
 *   比如，行、列谁的优先级更高；
 */
public class Ticket implements Comparable<Ticket> {
    int row;
    int column;
    int maxRow;
    int maxColumn;

    public Ticket(int row, int column, int maxRow, int maxColumn) {
        this.row = row;
        this.column = column;
        this.maxRow = maxRow;
        this.maxColumn = maxColumn;
    }

    @Override
    public int compareTo(Ticket t) {
        if (
            Math.pow(row - maxRow, 2)
                    + Math.pow(column - maxColumn/2, 2)
            > Math.pow(t.row - maxRow, 2)
                    + Math.pow(t.column - maxColumn/2, 2)
        ) {
            return 1;
        }
        else if (
                Math.pow(row - maxRow, 2)
                     + Math.pow(column - maxColumn/2, 2)
                == Math.pow(t.row - maxRow, 2)
                    + Math.pow(t.column - maxColumn/2, 2)
        ) {
            return 0;
        }

        return -1;
    }

    public static void main(String[] args) {
        int maxRow = 9;
        int maxColumn = 9;
        Ticket[] tickets = new Ticket[maxRow*maxColumn];
        for (int i=0; i<maxRow; ++i) {
            for (int j=0; j<maxColumn; ++j) {
                tickets[i*maxRow+j] = new Ticket(i, j, maxRow-1, maxColumn-1);
            }
        }
        Arrays.sort(tickets);
        //
        for (Ticket eachTicket : tickets) {
            System.out.println(eachTicket.row + " - " + eachTicket.column);
        }
    }
}
