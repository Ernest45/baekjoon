package 알고리즘.프로그래머스.일반문제;

public class 택배상자꺼내기 {

    /*
    택배상자를 쌓아 넣고, 꺼낼 땐 위에서 박스 다 제거 후 꺼내야함
    그래야 할 때 num이 주어지면 총 몇 갤 치워야 하나? (내꺼 까지 포함)
     */

    public static void main(String[] args) {
        int n = 22;
        int w = 6;
        int num = 8;
        택배상자꺼내기 main = new 택배상자꺼내기();
        main.solution(n, w, num);

    }
    /*
    1. 일단 쌓을 때 지그재그로 쌓아야하고,
    2. 꺼낼 때 w 신경써서 꺼내기

    그럼 1을 저장하기 위해 짝수면 그대로 홀수면 반대로 저장되게
     */
    public int solution(int n, int w, int num) {

        int x = n / w + 1;
        int[][] box = new int[x][w];
        int answer = 0;
        int idx = 1;

        for (int i = 0; i < x; i++) {

            if (i % 2 == 0) {
                for (int j = 0; j < w; j++) {
                    if (idx > n) {
                        break;
                    }
                    box[i][j] = idx++;
                }
            } else
                for (int j = w-1; j >= 0 ; j--) {
                    if (n < idx) {
                        break;
                    }
                    box[i][j] = idx++;
                }
        }
        int nowY = 0;
        int nowX = 0;

        for (int i = 0; i < x; i++) {

            if (i % 2 == 0) {
                for (int j = 0; j < w; j++) {

                    if (box[i][j] == num) {
                        nowY = j;
                        nowX = i;

                    }
                }
            } else
                for (int j = w-1; j >= 0 ; j--) {

                    if (box[i][j] == num) {
                        nowY = j;
                        nowX = i;

                    }
                }
        }

        System.out.println(box[x-1][nowY]);
        if (box[x - 1][nowY] != 0) {
            answer = x-1 - nowX +1;
        } else
            answer = x-1 - nowX;


        if (nowX == 0) {
            answer -= 1;

        }




        return answer;
    }
}
