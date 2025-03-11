package 알고리즘.프로그래머스.dfsbfs;

public class 퍼즐조각채우기 {
    // 보드에 맞게 테이블을 활용해 채우기
    // 채울 때 table들을 활용해야 하는데, 회전할 수 있다
    // 하나씩 쓸 수 있다.
    // 채울 때  여러개의 테이블을 쓰거나 딱 맞지 않게 쓸 수 없다 (두개를 조합 시ㅣㅋ기도 불가능)
    public static void main(String[] args) {

        int game_board[][] = new int[][]{
                {1, 1, 0, 0, 1, 0},
                {0, 0, 1, 0, 1, 0},
                {0, 1, 1, 0, 0, 1},
                {1, 1, 0, 1, 1, 1},
                {1, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0, 0}};

        int table[][] = new int[][]{
                {1, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 1, 0, 1, 1},
                {0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0, 0}};
    }


    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;
        return answer;
    }

}
