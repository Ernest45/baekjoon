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
        main.solution(n);
    }

    //현재 수를 옮길 때 어디에 옮길지?처음엔 아무대나 옮겨도 되지만 조건으로 가까운 원판으로 옮기자
    //현재 수 다시 옮길 때 숫자로 스택으로 표현해서 stack.peek이 나보다 낮거나 없을 떄 가능


    public int[][] solution(int n) {

        ArrayList<int[]> arr = new ArrayList<>();

        recur(n,1,2,3,arr);

        //숫자를 올리고
        return arr.toArray(new int[0][]);
    }

    private void recur(int n, int start, int mid, int end,ArrayList<int[]> arr) {


        if (n == 1) {
            arr.add(new int[]{start, end});
            return;

        }

        recur(n - 1, start, end, mid,arr);

        arr.add(new int[]{start, end});



        recur(n-1,mid,start,end,arr);
    }
}

