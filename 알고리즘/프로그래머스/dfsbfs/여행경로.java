package 알고리즘.프로그래머스.dfsbfs;

import java.util.*;

public class 여행경로 {

    // 주어진 티켓을 모두 활용해서 여행경로를 짜려고 한다.
    // 같은 항공권이 있다면 알파벳으로 앞서는 순으로 먼저 넣어라.
    // 우선순위가 있는 stack의 형식으로 구현?
    // dfs

    // 출발은 무조건 인천


    public static void main(String[] args) {

        String tickets[][] = new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String tickets1[][] = new String[][]{{"ICN", "DD"}, {"DD", "ICN"}, {"ICN", "BB"}};

        여행경로 main = new 여행경로();
        main.solution(tickets1);


    }

    private int totalTicket;
    private HashMap<String, PriorityQueue<String>> hashMap;
    private List<String> path;


    public String[] solution(String[][] tickets) {
        // 1. haspmap , 2. 우선순위를 넣은 stack의 형태로 관리
        //hash map 을 통해 출발을 from, to로 관리
        //hash map에 저장될 때 dfs로 돌아야 하는데, 우선순위가 있다. value를 우선 순위 queue로 넣는건?

        hashMap = new HashMap<>();
        totalTicket = tickets.length;

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

        }
        path = new ArrayList<>();
        path.add("ICN");

        dfs("ICN");

        for (String s : path) {
            System.out.println(s);
        }


        return path.toArray(new String[0]);
    }

    private void dfs(String current) {

        if (path.size() == totalTicket + 1) {
            // 기저 조건

            return;
        }

        if (!hashMap.containsKey(current) || hashMap.get(current).isEmpty()){
            return;
           // note backTracking을 위한, 돌면서 위에 티켓을 다 사용하지 않았는데도 비어버리게 된다면 다시 백트레킹으로 되돌아가버리기
        }


        PriorityQueue<String> queue = hashMap.get(current);
        List<String> tempList = new ArrayList<>(queue); // 복사본 저장 (백트래킹 대비)

        while (!queue.isEmpty()) {
            String next = queue.poll();
            path.add(next);
            dfs(next);


            if (path.size() == totalTicket + 1) {
                // note dfs에서 1.기저에서 return이 됐을 경우 백트레킹을 더 실행하지 않게 하는 코드

                return;
            }
            path.remove(path.size() - 1);
            queue.clear();
            queue.addAll(tempList);
            // 지우고 다시

        }


    }







}

