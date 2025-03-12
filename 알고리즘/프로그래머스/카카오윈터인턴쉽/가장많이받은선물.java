package 알고리즘.프로그래머스.카카오윈터인턴쉽;

import java.util.HashMap;

public class 가장많이받은선물 {

    // 선물하기 기능
    // 선물을 주고 받은 기록이 있고, 다르다면 더 적게 선물한 사람이 다음달에 더 많이 선물한 사람에게 선물해야함
    // 없거나 같다면 선물지수가 작은 사람이 큰 사람에게 다음달에선물해야함
    // 선물 지수란? 이번 달에 내가 준 선물 - 받은 선물
    // 선물 지수도 같다면 그냥 냅두기
    // 이해 안가는 부분에 둘이 선물 받은 부분이 없는 애들을 다 카운트해야할 거 같진 않음

    // 이 규칙을 다 지키고 다음 달에 선물을 가장 많이 받을 친구의 선물 수를 return;

    public static void main(String[] args) {
        String[] friend = new String[]{"muzi", "ryan", "frodo", "neo"};
        String[] gifts = new String[]{
                "muzi frodo",
                "muzi frodo",
                "ryan muzi",
                "ryan muzi",
                "ryan muzi",
                "frodo muzi",
                "frodo ryan",
                "neo muzi"};

        가장많이받은선물 main = new 가장많이받은선물();
        main.solution(friend, gifts);
    }

    // 1. 각 사람을 담을 공간을 생성 후 받은 선물을 기록 + 받고 줄 때의 지수까지 기록
    // 2. 받은 선물들을 비교해 돌면서 다음 달 선물 받을 기록을 따로 담기
    // 3. 가장 큰 선물을 반환


    public int solution(String[] friends, String[] gifts) {
        int size = friends.length;
        int answer = Integer.MIN_VALUE;
        int[][] giftList = new int[size][size];
        int answerList[] = new int[size];
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < size; i++) {
            map.put(friends[i], i);
        }
        for (int i = 0; i < gifts.length; i++) {

            String[] now = gifts[i].split(" ");

            int to = map.get(now[0]);
            int from = map.get(now[1]);

            giftList[to][from]++;
            answerList[to]++;
            answerList[from]--;
//            giftList[to][to]++;
//            giftList[from][from]--;

        }
        int[] nextGift = new int[size];

        for (int i = 0; i <size ; i++) {
            for (int j = i + 1; j < size; j++) {

                if (giftList[i][j] < giftList[j][i]) {
                    nextGift[j]++;

                } else if (giftList[i][j] > giftList[j][i]) {
                    nextGift[i]++;
                } else
                    if(answerList[j] < answerList[i]){
                        nextGift[i]++;

                    } else if (answerList[j] > answerList[i]) {
                        nextGift[j]++;
                    }
            }
        }

        for (int i : nextGift) {
            answer = Math.max(i, answer);
        }

        return answer;
    }
}
