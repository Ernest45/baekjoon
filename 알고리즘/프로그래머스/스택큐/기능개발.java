package 알고리즘.프로그래머스.스택큐;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
    // 현재 작업량과 스피드를 받으면 배포가 가능한 날짜가 나온다
    // 한번에 나오는 작업량이 몇갠지 리턴
    // 중요한 건 뒤에 것이 완료되어도 앞에 것이 안도미ㅕㄴ 배포 불가능

    public static void main(String[] args) {

        int[] progresses = new int[]{95, 90, 99, 99, 80, 99};
        int[] speeds = new int[]{1, 1, 1, 1, 1, 1};
        기능개발 main = new 기능개발();
        main.solution(progresses, speeds);

    }

    // 뺼때가 관건인데, 현재가 100이 되면 뺸다 그러나 뒤에 있는 게 100인지 확인해서 같이 뺴기

    // 큐에 넣으면서 매일 speed마다 올리는 건 좀 직관적이지 않은데?
    // 먼저 올리고 100이 되면 넣는 것도 순서 문제가 있어 보임
    // 올리고 100이 되는 지 매일 판별해야 한다면 너무 많은 검사가 필요한데 데이터부터 확인해보자
    // 총 100개의 작업들을 다 확인 해야한다
    public int[] solution(int[] progresses, int[] speeds) {

        int size = progresses.length;


        ArrayList<Integer> arrayList = new ArrayList<>();
        int index = 0;
        // 첫날에 바로 나갈 순 없다
        while (index < size) {
            int count = 0;

            for (int i = 0; i < size; i++) {
                progresses[i] = progresses[i] + speeds[i];
                if (progresses[index] >= 100) {
                    index++;
                    count++;
                }
            }
            if (count != 0) {
                arrayList.add(count);
            }}


            int[] answer = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                answer[i] = arrayList.get(i);
                System.out.println(i);
            }

            return answer;
        }

    }


