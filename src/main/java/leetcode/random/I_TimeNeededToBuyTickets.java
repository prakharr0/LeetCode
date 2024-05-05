package leetcode.random;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 2073 Time needed to Buy Tickets

 * There are n people in a line queuing to buy tickets, where the 0th person
 * is at the front of the line and the (n - 1)th person is at the back of the line.
 * You are given a 0-indexed integer array tickets of length n where the number
 * of tickets that the ith person would like to buy is tickets[i].
 * Each person takes exactly 1 second to buy a ticket. A person can only buy 1
 * ticket at a time and has to go back to the end of the line (which happens
 * instantaneously) in order to buy more tickets. If a person does not have any
 * tickets left to buy, the person will leave the line.
 * Return the time taken for the person at position k (0-indexed) to finish buying
 * tickets.

 * Example 1:
 * Input: tickets = [2,3,2], k = 2
 * Output: 6
 * Explanation:
 * - In the first pass, everyone in the line buys a ticket and the line becomes
 * [1, 2, 1].
 * - In the second pass, everyone in the line buys a ticket and the line becomes
 * [0, 1, 0].
 * The person at position 2 has successfully bought 2 tickets and it took 3 + 3 = 6 seconds.

 * Example 2:
 * Input: tickets = [5,1,1,1], k = 0
 * Output: 8
 * Explanation:
 * - In the first pass, everyone in the line buys a ticket and the line becomes
 * [4, 0, 0, 0].
 * - In the next 4 passes, only the person in position 0 is buying tickets.
 * The person at position 0 has successfully bought 5 tickets and it took
 * 4 + 1 + 1 + 1 + 1 = 8 seconds.

 * @author rathi.prakhar@outlook.com
 */
public class I_TimeNeededToBuyTickets {

    /**
     * Use a queue
     */
    public int timeRequiredToBuy(int[] tickets, int k) {
        int index = k;
        Queue<Integer> q = new LinkedList<>();

        for (int ticket: tickets) {
            q.offer(ticket);
        }

        int need = tickets[k];
        int time = 0;

        while (need > 0) {
            int current = q.poll();
            current--;
            time++;

            if (current != 0) {
                q.offer(current);
            }

            if (index == 0) {
                need--;
                index = q.size() - 1;
            } else {
                index = index - 1;
            }
        }

        return time;
    }

    /**
     * The elements in subarray[0, k-1] get a maximum allowed time of
     * tickets[k] to buy tickets.

     * The elements after k get tickets[k] - 1.

     * After every cycle, one unit time is decreased.
     * Ex: [1, 3, 2, 4] and k = 2
     * Cycle 1: [0 , 2, 1, 3]
     * Cycle 2: [0 , 1, 0]

     * so at the end, index 0 took 1 unit of time to go to 0
     * index 1 took 2 units of time to go to 1
     * and index 3 only got once chance, i.e 1 unit of time
     */
    public int timeRequired(int[] tickets, int k) {
        int timeTaken = tickets[k];
        int maxTime = timeTaken;

        for (int i = 0; i < tickets.length; i++) {
            if (i < k) {
                timeTaken += Math.min(tickets[i], maxTime);
            }

            if (i > k) {
                timeTaken += Math.min(tickets[i], maxTime-1);
            }
        }

        return timeTaken;
    }
}
