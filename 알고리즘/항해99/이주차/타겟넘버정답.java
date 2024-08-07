package 알고리즘.항해99.이주차;

public class 타겟넘버정답 {

    // 2의 20승 100만번인데, 최악의 경우 500만번까지 통과 가능 재귀로 완전탐색 해도 문제 없다.


        int[] numbers;
        int target;
        int answer;

        public void dfs(int idx, int sum) {
            // 1. 탈출조건
            if (idx == numbers.length) {
                if (sum == target)
                    answer++;

                return;

            }

            // 수행동작
            dfs(idx + 1, sum + numbers[idx]);
            dfs(idx + 1, sum - numbers[idx]);
        }

        public int solution(int[] numbers, int target) {
            this.target = target;
            this.numbers = numbers;

            dfs(0, 0);
            return answer;

        }

        public static void main(String[] args) {
            타겟넘버정답 sol = new 타겟넘버정답();
            int[] numbers = {1, 1, 1};
            int target = 1;
            System.out.println(sol.solution(numbers, target));
        }
    }


