package leetcode.random;

/**
 * LeetCode 1700: Number of students unable to eat lunch

 * The school cafeteria offers circular and square sandwiches at lunch break,
 * referred to by numbers 0 and 1 respectively. All students stand in a queue.
 * Each student either prefers square or circular sandwiches.
 * The number of sandwiches in the cafeteria is equal to the number of students.
 * The sandwiches are placed in a stack. At each step:

 * If the student at the front of the queue prefers the sandwich on the top of the
 * stack, they will take it and leave the queue.
 * Otherwise, they will leave it and go to the queue's end.
 * This continues until none of the queue students want to take the top sandwich
 * and are thus unable to eat.

 * You are given two integer arrays students and sandwiches where sandwiches[i] is
 * the type of the ith sandwich in the stack (i = 0 is the
 * top of the stack) and students[j] is the preference of the
 * jth student in the initial queue (j = 0 is the front of the queue). Return the
 * number of students that are unable to eat.

 * @author rathi.prakhar@outlook.com
 */
public class CountStudents {
    /**
     *    Keep a Stack and a Queue
     *          While (!q.isEmpty()) {
     *          int countCantFeed = 0;
     *          for each element
     *               if (cant feed) countCantFeed++;
     *          if (countCantFeed = q.size()) break return the size of queue
     *          }

     * OR use the following approach
     */
    public int countStudents(int[] students, int[] sandwiches) {

        // Another approach
        int countOneStudent = 0;
        int countZeroStudent = 0;

        for (int num: students) {
            if (num == 1) countOneStudent++;
            else countZeroStudent++;
        }

        for (int num: sandwiches) {
            if (num == 1) {
                if (countOneStudent == 0) return countZeroStudent;
                else countOneStudent--;
            }

            if (num == 0) {
                if (countZeroStudent == 0) return countOneStudent;
                else countZeroStudent--;
            }
        }

        return 0;
    }
}
