package 알고리즘.프로그래머스.재귀;

import java.util.ArrayList;

public class 하노이의탑 {

    // 유명한 재귀 문제
    // n은 첫번 째에 걸려있는 원판의 갯수고
    // 무조건 3개의 기둥, 최소로 움직여야함
    // 조건 나보다 작은 원판 위엔 올릴 수 없고 한번 씩만가능

    public static void main(String[] args) {
        int n = 2;
//        int result[][] = new int[][]{{1, 2}, {1, 3}, {2, 3}};
        하노이의탑 main = new 하노이의탑();

        int[][] result =main.solution(n);
        System.out.println("\n📦 최종 이동 결과:");
        for (int[] move : result) {
            System.out.println(move[0] + " → " + move[1]);
        }
    }

    //현재 수를 옮길 때 어디에 옮길지?처음엔 아무대나 옮겨도 되지만 조건으로 가까운 원판으로 옮기자
    //현재 수 다시 옮길 때 숫자로 스택으로 표현해서 stack.peek이 나보다 낮거나 없을 떄 가능


    public int[][] solution(int n) {

        ArrayList<int[]> arr = new ArrayList<>();

        recur(n,1,2,3,arr,0);
        //총 2ⁿ - 1 = 7번 이동이 일어남
        //→ 이건 하노이의 탑의 최소 이동 횟수 공식이기도 하지.
        // 트리 이진구조 재귀
        /*

                   recur(3)
                 /        \
         recur(2)          recur(2)
         /     \           /     \
     recur(1) recur(1)  recur(1) recur(1)

         */

        //숫자를 올리고
        return arr.toArray(new int[0][]);
    }

    private void recur(int n, int start, int mid, int end,ArrayList<int[]> arr,int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(indent + "▶ recur(n=" + n + ", from=" + start + ", temp=" + mid + ", to=" + end + ")");


        if (n == 1) {
            System.out.println(indent + "  ✅ move: " + start + " → " + end + " (n=1, 직접 이동)");
            arr.add(new int[]{start, end});
            return;

        }

        recur(n - 1, start, end, mid,arr,depth+1);
        //중간으로 옮기기

        System.out.println(indent + "  ✅ move: " + start + " → " + end + " (n=" + n + ")");
        arr.add(new int[]{start, end});



        recur(n-1,mid,start,end,arr,depth+1);
        //중간에서 끝으로 옮기기
    }
}

