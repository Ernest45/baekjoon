package 알고리즘.실전코테;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullHd화면직사각형 {

    /**
     * v1
     * 먼저 다 칠해준 후에 그래프 전체를 탐색하면 될거라 생각했는데
     * 1920 x 1080 x n를 다 탐색하기엔 너무.. 비효율적이다.
     * v2
     * 여기서 제일 중요한 건 중복된 사각형을 관리하는 것이다.
     * 전체 탐색을 없이 좌표를 저장함과 동시에 중복을 없앨 수 있다면?
     * set을 써보면 될듯
     *
     *
     */


    public static void main(String[] args) {



        Set<String> set = new HashSet<>();


        int[][] location = new int[][]
                        {{1, 0, 4, 2},
                        {8, 3, 9, 4},
                        {2, 3, 5, 7},
                        {4, 6, 7, 8},
                        {3, 1, 6, 5},
                        {1, 8, 4, 10},
                        {7, 2, 9, 5},
                        {8, 8, 10, 9},
                        {1, 4, 2, 6}};


        for (int[] ints : location) {
            int x1 = ints[0], y1 = ints[1];
            int x2 = ints[2], y2 = ints[3];


            for (int i = y1; i < y2; i++) {
                for (int j = x1; j <x2; j++) {

                    set.add(i + "." + j);
                }
            }
        }
        System.out.println(set.size());


    }
}

