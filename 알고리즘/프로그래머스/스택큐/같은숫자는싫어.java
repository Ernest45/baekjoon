package 알고리즘.프로그래머스.스택큐;

import java.util.Stack;

public class 같은숫자는싫어 {
    // 배열 중 연속되는 수가 나오면 무조건 하나만 나오게
    // 중복 x 순서가 중요함. 따로 set을 순서대로 넣게 해서 구현할 수 있지만xx

    // stack을 쓰는게 좋아보임

    public static void main(String[] args) {

        int[] arr = new int[]{1, 1, 3, 3, 0, 1, 1};
        같은숫자는싫어 main = new 같은숫자는싫어();
        main.solution(arr);
    }

    public int[] solution(int []arr) {


        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int now = stack.peek();
            if (now != arr[i]) {
                stack.push(arr[i]);
            }
        }

        Integer[] stackArray = stack.toArray(new Integer[0]);

        // Integer[]를 int[]로 변환
        int[] answer = new int[stackArray.length];
        for (int i = 0; i < stackArray.length; i++) {
            answer[i] = stackArray[i]; // Boxing -> Unboxing
        }



        return answer;
    }
}
