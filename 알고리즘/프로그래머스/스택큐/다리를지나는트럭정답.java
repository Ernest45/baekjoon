package 알고리즘.프로그래머스.스택큐;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭정답 {

    //다리를 지나는 트럭을 최소 시간을 반환
    //트럭은 1초에 올라온다면 3초에 끝남
    //이런 식으로 다리에는 최대 버틸 무게와 최대 몇 대가 지나갈 지 정해져있다.
    // 최대 몇 대임과 동시에 다리의 길이니까 2초가 걸린다는 뜻

    public static void main(String[] args) {
        int bridge_length = 2;
        int bridge_length1 = 100;
        int truck_weights[] = new int[]{7, 4, 5, 6};
        int truck_weights1[] = new int[]{10};
        int truck_weights2[] = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int weight = 10;
        int weight1 = 100;
        다리를지나는트럭정답 main = new 다리를지나는트럭정답();
//        System.out.println( main.solution(bridge_length, weight, truck_weights));;
//        System.out.println( main.solution(bridge_length1, weight1, truck_weights1));
        System.out.println(main.solution(100, 100, truck_weights2));
    }

    // 1. 순서대로 지나가야 한다.
    // 2. 지나갈 때 조건을 거는데 1초 때 무게 + 가능한 대수가 되면 다 추가해줌

    // 시간이 안 지나도 한번에 담길 수가 있다.
    // 초 당 하나씩 빠져 나가는데, 지금 현재 몇 명을 이용하고 있는 지도 알아야 한다.
    // 1차선 다리

    // 틀린 이유 반복을 돌 때 들어오는 수로만 보고 안에서 내부의 다리가 지나가게끔 설계해야함

    // note 핵심은 원형 큐 처럼 처음에 빈공간의 큐를 만들고 계속 돌아가게끔!
    // note 내가 틀린 부분은 큐 공간 자체를 bridge_length로 고정할 생각을 못했음 가변적인 다리를 만들 생각했는데, but 불변다리가 훨씬쉬움

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < bridge_length; i++) {
            queue.add(0);
        }
        //note 불변적인 다리를 만들기 위해 queue 초기화
        int nowWeight = 0;
        int answer = 0;
        int index = 0;

        while (!queue.isEmpty()) {

            answer++; // 무조건 늘고,

            nowWeight -= queue.poll(); // 맨앞에 있는 것이 나감


            if(index < truck_weights.length){

                int now = truck_weights[index];

                if (nowWeight + now <= weight) {

                    queue.offer(now);
                    nowWeight += now;
                    index++;
                } else {
                    queue.offer(0);}
            }
        }
        return answer;}




        // 베스트는 ㅈ처음처럼 주입하고 지금 들어올 때 나가는 수까지

        // 그러면 안에 있는 for문은 고정적으로 다리의 길이만큼 돌게 하고
        // 언제 들어왔는지 카운트 후?
        // x 틀을 바꿔야함
        // 추가는 안에서 이루어지고 내부 반복을 queue 기준으로


    }

