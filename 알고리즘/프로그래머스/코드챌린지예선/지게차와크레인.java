package 알고리즘.프로그래머스.코드챌린지예선;

public class 지게차와크레인 {
    // n x m의 물건
    // 한 번 요청이 오면 벽이랑 인접한 것만 뺼 수 있다.(바로 옆에 또 있다고 연속으로 빼진 않음 당시 벽일때만)
    // 두 번 요청이 오면 모든 그 수를 다 뺄 수 있음
    // 남아 있는 수를  return

    public static void main(String[] args) {

        String[] storage = {"AZWQY", "CAABX", "BBDDA", "ACACA"};
        String[] request = new String[]{"A", "BB", "A"};
        지게차와크레인 main = new 지게차와크레인();
        main.solution(storage, request);

    }
    // 삭제 후 내가 다음 벽면이라는 걸 어떻게 갱신할 것인가?
    // 한 번씩 겉만 삭제된다면 문제가 없다 4방향 중 벽인 곳에 표시를 준 후 그 표시가 있다면
    // 벽이라고 생각하면 됨
    // but 2번 지우기가 나왔을 때 중앙도 삭제됨 그럴 떈 벽이 아니지만 빈 공간이 있게 됨
    // 그럼 2번 지우기가 나오면 지울 때 벽인 경우엔 그대로 표시, 안쪽에 지워진 공간엔 또 다른 표시를 하면 될듯

    // 지울 떄 현재 위치를 기준으로 동서남북에 알파벳이 있을 경우엔

    // 지울 때 현재를 0으로 만들고 동서남북에 0이 있으면 벽임을 알리자
    private int[][] movement = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int solution(String[] storage, String[] requests) {

        int n = storage.length;
        int m = storage[0].length();
        char box[][] = new char[n][m];
        int isWall[][] = new int[n+2][m+2];

        for (int i = 0; i < n; i++) {
            String now = storage[i];
            for (int j = 0; j < m; j++) {
                box[i][j] = now.charAt(j);

            }
        }

        for (int i = 0; i < n+2; i++) {
            for (int j = 0; j < m+2; j++) {
                if (i == 0 || i == n + 1 || j == 0 || j == m + 1) {
                    isWall[i][j] = 1;
                }
            }
        }




        for (int i = 0; i < requests.length; i++) {

            char now = requests[i].charAt(0);

            if (requests[i].length() == 1) {


                wallCheck(box, isWall, now,n,m);
                removeAccessible(box, isAccessible, target, n, m);

            } else{
                removeAll(box, isAccessible, target, n, m);

            }

            updateAccessible(box, isAccessible, n, m);


        }

        int answer = 0;
        return answer;
    }
    // 0은 안, 1은 벽,2는 벽안

    private void wallCheck(char[][] box, int[][] isWall, char c) {
        int n = box.length;
        int m = box[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (box[i][j] == c) {
                    updateWall(box, isWall, i, j);


                    }
                }
            }
        }
        // for (int k = 0; k < 4; k++) {
    //                        int nowX = i + movement[k][0];
    //                        int nowY = j + movement[k][1];
    //
    //                        if (isWall[nowX][nowY] == 1) {
    //
    //                            box[i][j] = 'a';
    //                            isWall[i][j] = 2;
    //                            break;
    //
    //                        }

    private void updateWall(char[][] box, int[][] isWall, int x, int y) {
        int n = box.length;
        int m = box[0].length;

        for (int[] move : movement) {
            int nx = x + move[0];
            int ny = y + move[1];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && box[nx][ny] != '0') {
                isWall[nx][ny] = 1; // 주변을 벽으로 설정
            }
        }






        //  if (isWall[i][j] == 1 || (i == 0 || j == 0) || (i == n - 1 || j == n - 1)) {
        //                        isWall[i][j] = 1;
        //                        box[i][j] = 'a';
        //
        //                    }



    }
}
