package 알고리즘.프로그래머스.dfsbfs;

import java.util.*;

public class 여행경로 {

    // 주어진 티켓을 모두 활용해서 여행경로를 짜려고 한다.
    // 같은 항공권이 있다면 알파벳으로 앞서는 순으로 먼저 넣어라.
    // 우선순위가 있는 stack의 형식으로 구현?
    // dfs

    // 출발은 무조건 인천

    public static void main(String[] args) {

        String tickets[][] = new String[][] {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String tickets1[][] = new String[][] {{"ICN", "DD"}, {"DD", "ICN"}, {"ICN", "BB"}};

        여행경로 main = new 여행경로();
        main.solution(tickets1);



    }

    public String[] solution(String[][] tickets) {
        // 1. haspmap , 2. 우선순위를 넣은 stack의 형태로 관리
        //hash map 을 통해 출발을 from, to로 관리
        //hash map에 저장될 때 dfs로 돌아야 하는데, 우선순위가 있다. value를 우선 순위 queue로 넣는건?

        HashMap<String, PriorityQueue<String>> hashMap = new HashMap<>();

        // 틀린 이유가 반례를 찾지 못해서인데.. 무조건 알파벳순으로 가지 않는다!!
        // dfs보다 bfs의 접근이 더 좋을 거 같네..


        String[] answer = {};

        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];

            PriorityQueue<String> queue = hashMap.getOrDefault(from, new PriorityQueue<>());
            //note 핵심 hashmap으로 우선순위 queue를 활용해, 추가해주기

            //hash map을 돌면서 from이 없다면 새로운 큐를 넣어주고 있으면 그 queue에 추가
            queue.offer(to);
            hashMap.put(from, queue);

        }

        for (Map.Entry<String, PriorityQueue<String>> stringPriorityQueueEntry : hashMap.entrySet()) {
            System.out.println(stringPriorityQueueEntry);
        }
        List<String> path = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();

        queue.offer("ICN");


        while (!queue.isEmpty()) {


            String now = queue.poll();
            path.add(now);

            PriorityQueue<String> queue1 = hashMap.get(now);
            if (queue1 != null && queue1.isEmpty()) {
                for (String s : queue1) {
                    queue.offer(s);
                }
            }}


            for (String s : path) {
                System.out.println(s);
            }


            return path.toArray(new String[0]);
            // note 사이즈를 넘기는데 제네릭 활용해서 STring으로 넘긴 후 0(최소사이즈)로 넘기면 jvm에서 알아서 자동생성
        }


    }

