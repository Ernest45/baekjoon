package 알고리즘.중요도고려한프린터;
// 일반적인 프린터 인쇄요이 들어온대로지만 중요도에 따라 먼저 인쇄될 수 있는 프린터
// 인쇄 대기목록의 가장 앞 문(J)를 대기 목록에서 꺼낸다.
// 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 하나라도 존재하면 J를 마지막으로 보내고 아님 J꺼내기
// 대기목록은 1-100, 인쇄목록은 1-9있고 클수록 중요
// location은 0 이상(현 대기목록 있는 작업 수 -1)이하의 값을 가지 대기목록의 가장 앞에 있으면 0, 아님 1로 표현
// 로케이션은 제로베이스로 인덱싱 하겠다 ! 뜻

// queue로 구현하면 일단 맨 앞에꺼 꺼내서 뒤에 꺼랑 비교 후 높은 게 있으면 마지막에 넣어주고 또 비교 후 반복

// class를 활용한 queue와 그냥 queue

import java.util.ArrayList;
import java.util.List;

public class SolutionQueue { // 그냥 큐만 써보기
    // 클래스로 인덱스를 설정하지 않았기에 location을 활용해 현재 처리 시점에 location이 0인 지 확인
    public int solution(int[] priorities, int location) {
        // 1. Queue 만들기
        List<Integer> printer = new ArrayList<>();
        for (int priority : priorities) {
            printer.add(priority); // 클래스랑 다른 점은 인덱스는 안 넣어주고 있다.
        }
        // {2x, 1, 3, 2}
        int turn = 0;
        // 2. 0번을 꺼내서 max priority 아니 다시 끝에 넣는다.
        while (!printer.isEmpty()) {
            Integer priority = printer.remove(0); // 프린터에서 빼고 그 수를 저장

            // {2x, 1, 3, 2} , l = 0  (1)
            // {1, 3, 2, 2x} , l = 3  (4)
            // {3, 2, 2x, 1} , l = 2  (7)
            // {2, 2x, 1} , l = 1     (10)
            // {2x, 1} , l = 0        (13)

            if (printer.stream().anyMatch(otherPriority -> priority < otherPriority)) {
                printer.add(priority);// 내가 젤 높은 수가 아니라면 다시 넣어주기
                // {1, 3, 2, 2x} , l = 0  (2)
                // {3, 2, 2x, 1} , l = 3  (5)
            } else {
                // 3. 내가 젤 크다면 내가 찾는 job이 맞는 지 확인해본다.

                turn++; // 내가 높다면 바로 한턴 수행
                // {2, 2x, 1} , l = 2 t = 1 (8)
                // {2x, 1} , l = 1 t = 2    (11)
                // {1} , l = 0 t = 3         (14)

                if (location == 0)
                    break;
                // (15)
            }
            location--; // 마지막 수에 넣든 턴을 수행했든 로케이션을 빼준다.
            // -1 (3)
            // 2 (6)
            // 1 (9)
            // 0 (12)
            if (location < 0)
                location = printer.size() - 1; // 지금까지 남아있는 값들보다 하나 작은 값을 인덱스로 넣을꺼라서

        }
        return turn; // (16)
    }







    class PrintJob {
        int location;
        int priority;

        public PrintJob(int location, int priority) {
            this.location = location;
            this.priority = priority;

        }
    }

    public static void main(String[] args) {
        SolutionQueue sol = new SolutionQueue();
        int[] priorities = {2, 1, 3, 2};
        System.out.println(sol.solution(priorities, 2));

    }
}

