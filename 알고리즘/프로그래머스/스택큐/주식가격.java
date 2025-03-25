package 알고리즘.프로그래머스.스택큐;


/*
입출력 예
prices : [1, 2, 3, 2, 3]
return : [4, 3, 1, 1, 0]

1초의 주가는 1~5초까지 떨어지 않아서 4초 유지
2초의 주가는 2~5초까지 떨어지지 않아서 3초 유지
3초 주가는 다음에 바로 떨어져서 1초 유지
4초 주가는 4~5초까지 1초 유지
5초 주가는 다음의 수가 업기에 0초 유지

지문이 이상하지만, 다음 수에 변하든 말든 지났으면 1초의 숫자가 유지된 느낌임
 */


import java.util.Arrays;
import java.util.Stack;

public class 주식가격 {

    public static void main(String[] args) {
        int[] price = new int[]{1, 2, 3, 2, 3};
        주식가격 main = new 주식가격();
        int[] as = main.solution(price);
        System.out.println( Arrays.toString(as));



    }

    //n^2로 하면 100억 n2는 10^5까지만이기에 pass

    // 스택 문제라는데 어떻게 접근할 지 감이 안왔음
    // n^2이 현재 가격에 대해서 미럐 가격을 싹다 찾는 거라면
    // 스택을 활용하는 건 현재 가격에서 과거를 살펴보는 방식이다.


    public int[] solution(int[] prices) {
        int size = prices.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {

            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                // 저장된 게 더 크다면? 가격이 떨어졌다는 뜻(현재 가격이랑 스택에 넣은 가격을 비교
                // 계속 돌면서 큰 게 나올 때까지 반복
                int before = stack.peek();
                int now = prices[i];
                int idx = stack.pop();
                // 떨어졌으니 가장 최근의 인덱스를 제거
                result[idx] = i - idx;

            }
            stack.push(i);


        }
        while (!stack.isEmpty()) {
            // 한 번도 떨어진 적이 없는 것들을 따로 처리
            int idx = stack.pop();
            result[idx] = size - idx - 1;
        }

        return result;
    }


}
