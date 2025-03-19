package 알고리즘.프로그래머스.코드챌린지예선;

public class 지게차와크레인정답 {

    public static void main(String[] args) {
        지게차와크레인1 sol = new 지게차와크레인1();
        String[] storage = {"AZWQY", "CAABX", "BBDDA", "ACACA"};
        String[] requests = {"A", "BB", "A"};
        System.out.println(sol.solution(storage, requests)); // 11

        String[] storage2 = {"HAH", "HBH", "HHH", "HAH", "HBH"};
        String[] requests2 = {"C", "B", "B", "B", "B", "H"};
        System.out.println(sol.solution(storage2, requests2)); // 4

        String[] storage3 = {"AAAA", "ABAA", "ABAA", "ACAA", "AAAA"};
        String[] requests3 = {"BB", "C"}; //: 18
        System.out.println(sol.solution(storage3, requests3));

        String[] storage4 = {"AAA", "BAB", "AAA"};
        String[] requests4 = {"A"};// : 3

        System.out.println(sol.solution(storage4, requests4));
        String[] storage5 = {"BBBB", "AAAB", "BBBB"};
        String[] requests5 = {"B", "A"}; //: 0
        System.out.println(sol.solution(storage5, requests5));

        String[] storage6 = {"BBBB", "AAAB", "BBBB"};
        String[] requests6 = {"A", "B"};// : 2
        System.out.println(sol.solution(storage6, requests6));

        String[] storage7 = {"BBBB", "ACDE", "BBBB"};
        String[] requests7 = {"CC", "A", "D"}; //: 9
        System.out.println(sol.solution(storage7, requests7));

        String[] storage8 = {"BBBB", "ACDE", "BBBB"};
        String[] requests8 = {"CC", "D", "A"};// : 10
        System.out.println(sol.solution(storage8, requests8));

        String[] storage9 = {"BBBBBB", "ACACAC", "BBBBBB"};
        String[] requests9 = {"B", "C"};// : 3
        System.out.println(sol.solution(storage9, requests9));

        String[] storage10 = {"AAAAAA",
                "ABBBBA",
                "ABCCBA",
                "ABCCBA",
                "ABBBBB",
                "AAAAAA",};
        String[] requests10 = {"B", "B", "B", "C", "C"};// : 29
        System.out.println(sol.solution(storage10, requests10));

        String[] storage11 = {"AAAA", "ABAA", "ABAA", "ACAA", "AAAA"};
        String[] re11 = {"BB", "C"}; //18
        System.out.println(sol.solution(storage11, re11));

        String[] storage12 = {"AAA", "BAB", "AAA"};
        String[] re12 = {"A"};
        System.out.println(sol.solution(storage12, re12));// 3

        String[] storage13 = {
                "AAAA",
                "ABAA",
                "ABAA",
                "ACAA",
                "AAAA"
        };
        String[] requests13 = {"BB", "C"};
        System.out.println(sol.solution(storage13, requests13));// 20

        String[] storage14 = {
                "AAAA",
                "AAAB",
                "AAAA"
        };
        String[] requests14 = {"A"};
        System.out.println(sol.solution(storage14, requests14));// 1

        String[] storage15 = {
                "BBBB",
                "AAAB",
                "BBBB"
        };
        String[] requests15 = {"B", "A"};
        System.out.println(sol.solution(storage15, requests15));//0



    }

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    public int solution(String[] storage, String[] requests) {
        char[][] containers = new char[storage.length][];

        for (int i = 0; i < storage.length; i++) {
            containers[i] = storage[i].toCharArray();
        }

        for (String request : requests) {
            char c = request.charAt(0);

            if (request.length() == 1) {
                removeWithForklift(containers, c);
            } else {
                removeWithCrane(containers, c);
            }

        }

        int count = 0;

        for (char[] container : containers) {
            for (char c : container) {
                if (c != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private void removeWithCrane(char[][] containers, char c) {
        for (int i = 0; i < containers.length; i++) {
            for (int j = 0; j < containers[i].length; j++) {
                if (containers[i][j] == c) {
                    containers[i][j] = 0;
                }
            }
        }
    }

    private void removeWithForklift(char[][] containers, char c) {
        boolean[][] isVisited = new boolean[containers.length][containers[0].length];

        for (int i = 0; i < containers.length; i++) {
            for (int j = 0; j < containers[i].length; j++) {
                if ((i == 0 || j == 0 || i == containers.length - 1 || j == containers[i].length - 1)
                        && !isVisited[i][j]) {
                    dfs(containers, i, j, c, isVisited);
                }
            }
        }




    }

    private void dfs(char[][] containers, int x, int y, char c, boolean[][] isVisited) {
        if (x < 0 || y < 0 || x >= containers.length || y >= containers[x].length
                || isVisited[x][y]) {
            return;
        }

        isVisited[x][y] = true;

        if (containers[x][y] == c) {
            containers[x][y] = 1;
            return;
        }

        if(containers[x][y] != 0) return;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            dfs(containers, nx, ny, c, isVisited);
        }

        containers[x][y] = 0;
    }
}
