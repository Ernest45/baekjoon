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


        퍼즐조각채우기 main = new 퍼즐조각채우기();
        main.solution(game_board, table);
    }

    // 배열의 전체 부분 중 빈 곳끼리의 연관을 지어야 한다.
    // 각 자 빈 부분이 시작되면 현재 부분에서 어느 크기의 빈 공간이 있는 지 확인 후 채워넣기
    // 이 과정에서 순서는 중요하지 않음 딱 맞아야 하기에  더 좋은 자리에서 써야하는 게 아니라 맞으면 바로 쓰면 됨!
    // 빈 공간과 맞는 테이블을 matching 시킬 때 돌려도 되기에 그 부분을 잘 탐색 해야할 듯?

    // 돌려도 똑같은 지 알 수 있는 방법은 xy의 구분을 하지 않고 도형의 크기로만 판단
    int boardX;
    int boardY;
    int squareSize;
    private static final int[][] movement = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    // note 빈공간 찾고, 도형도 찾고 정규화로 0,0 만들고, 90도 돌려가면서 맞는 지 확인



    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;

        int n = game_board.length;
        int m = game_board[0].length;
        squareSize = n;
        // 사실 n,m이 같긴 하네
        // 뒤에는 squareSize = n; 정사각형이라 이거 다 써 야겠다


        boolean isVisited[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (game_board[i][j] == 0) {
                    searchBoard(i, j, isVisited, game_board);
                    //note 퍼즐의 형태를 일정하게 저장하기 위해서 dfs보다 bfs가 더 낫다고 하는데 이해를 못함.. 느낌은 알겠다
                }
            }
        }

        for (int i = 0; i < squareSize; i++) {
            for (int j = 0; j < squareSize; j++) {
                System.out.print((isVisited[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }

        return answer;
    }

    private void searchBoard(int x, int y, boolean[][] isVisited, int[][] board) {
        //확산하며 찾는데, 더 이상 움직일 수 없을 때 그 도형을 찾았다고 판단


        if (isVisited[x][y]) {
            // 이미 확산하면서 찾은 것이라 바로 return
            return;
        }

        isVisited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nowX = x + movement[i][0];
            int nowY = y + movement[i][1];
            if ((nowX >= 0 && nowX < squareSize) && (nowY >= 0 && nowY < squareSize)) {

                if (!isVisited[nowX][nowY] && board[nowX][nowY] == 0) {

                    searchBoard(nowX, nowY, isVisited, board);
                }
            }
        }


    }

}
