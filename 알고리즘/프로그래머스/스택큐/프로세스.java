package 알고리즘.프로그래머스.스택큐;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 프로세스 {

    public static void main(String[] args) {
        int priorities[] = new int[]{2, 1, 3, 2};

        int location = 2;
        프로세스 main = new 프로세스();
        main.solution(priorities, location);
    }

    public int solution(int[] priorities, int location) {

        int size = priorities.length;

        Queue<int[]> queue = new LinkedList<>();


        for (int i = 0; i <size ; i++) {
            queue.offer(new int[]{priorities[i], i});
            // 2 0
            // 1 1
            // 3 2
            // 2 3

        }
        int sequence = 0;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();
            boolean hasHigherPriority = false;


            for (int[] ints : queue) {

                if (current[0] < ints[0]) {
                    hasHigherPriority = true;
                    break;
                }
            }

            if (hasHigherPriority) {

                queue.offer(current);
            } else {
                sequence++;
                if (current[1] == location) {

                // 2 0
                // 1 1
                // 3 2
                // 2 3
                    return sequence;}
        }}
        return -1;
    }
}


