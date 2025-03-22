package 알고리즘.프로그래머스.스택큐;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {

    //다리를 지나는 트럭을 최소 시간을 반환
    //트럭은 1초에 올라온다면 3초에 끝남
    //이런 식으로 다리에는 최대 버틸 무게와 최대 몇 대가 지나갈 지 정해져있다.
    // 최대 몇 대임과 동시에 다리의 길이니까 2초가 걸린다는 뜻

    public static void main(String[] args) {
        int bridge_length = 2;
        int bridge_length1 = 100;
        int truck_weights[] = new int[]{7, 4, 5, 6};
        int truck_weights1[] = new int[]{10};
        int truck_weights2[] = new int[]{10,10,10,10,10,10,10,10,10,10};
        int weight = 10;
        int weight1 = 100;
        다리를지나는트럭 main = new 다리를지나는트럭();
//        System.out.println( main.solution(bridge_length, weight, truck_weights));;
//        System.out.println( main.solution(bridge_length1, weight1, truck_weights1));
        System.out.println( main.solution(bridge_length1, weight1, truck_weights2));
    }

    // 1. 순서대로 지나가야 한다.
    // 2. 지나갈 때 조건을 거는데 1초 때 무게 + 가능한 대수가 되면 다 추가해줌

    // 시간이 안 지나도 한번에 담길 수가 있다.
    // 초 당 하나씩 빠져 나가는데, 지금 현재 몇 명을 이용하고 있는 지도 알아야 한다.
    // 1차선 다리

    // 틀린 이유 반복을 돌 때 들어오는 수로만 보고 안에서 내부의 다리가 지나가게끔 설계해야지

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue1 = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            queue.add(truck_weights[i]);
        }
        int nowWeight = 0;
        int answer = 0;
        int count = 0;



        while (!queue.isEmpty()) {
            // queue에는 다 넣고, 마지막은 빠져 나가는 조건이다.

            count++;
            answer++;



            int in = queue.peek();


            if (queue1.size() <= bridge_length && nowWeight + in <= weight) {

                queue1.offer(queue.poll());
                nowWeight += in;


            }
            if (count == bridge_length ) {
                int out = queue1.poll();
                count = 0;
                nowWeight -= out;
            }



        }


        return answer;
    }
}
