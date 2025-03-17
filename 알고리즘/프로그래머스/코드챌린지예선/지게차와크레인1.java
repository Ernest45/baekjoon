package 알고리즘.프로그래머스.코드챌린지예선;

public class 지게차와크레인1 {

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



        private int[][] movement = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 동서남북

        public int solution(String[] storage, String[] requests) {
            int n = storage.length;
            int m = storage[0].length();
            char[][] box = new char[n][m];
            int[][] isAccessible = new int[n][m];

            // 1. 초기화
            for (int i = 0; i < n; i++) {
                String row = storage[i];
                for (int j = 0; j < m; j++) {
                    box[i][j] = row.charAt(j);
                    // 외곽은 초기 접근 가능
                    if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                        isAccessible[i][j] = 1;
                    }
                }
            }

            // 2. 요청 처리
            for (String req : requests) {
                char target = req.charAt(0);
                if (req.length() == 1) {
                    // 지게차: 접근 가능한 것만 제거
                    removeAccessible(box, isAccessible, target, n, m);

                } else {
                    // 크레인: 모두 제거
                    removeAll(box, isAccessible, target, n, m);

                }
                updateAccessible(box, isAccessible, n, m);

            }

            // 3. 남은 컨테이너 수 계산
            int answer = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (box[i][j] != '0') answer++;
                }
            }
            return answer;
        }



    // 지게차: 접근 가능한 컨테이너 제거
        private void removeAccessible(char[][] box, int[][] isAccessible, char target, int n, int m) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (box[i][j] == target && isAccessible[i][j] == 1) {
                        box[i][j] = '0';
                    }
                }
            }
        }

        // 크레인: 모든 해당 컨테이너 제거
        private void removeAll(char[][] box, int[][] isAccessible, char target, int n, int m) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (box[i][j] == target) {
                        box[i][j] = '0';
                    }
                }
            }
        }




        // 접근 가능성 갱신
        private void updateAccessible(char[][] box, int[][] isAccessible, int n, int m) {
            // 신경쓸 것
            // 1. 현재가 0인것만으로는 다 확인 x
            // 2. 벽이여야만 하나씩 지울 수 있다.
            // 3. 중간에 값이 지우진 후라면, 벽으로 판정하지 않아야 한다.
            for (int i = 0; i <n; i++) {
                for (int j = 0; j < m; j++) {

                    if (box[i][j] == '0')    {
                        if (isAccessible[i][j] == 2) {
                            isAccessible[i][j] = 1;
                        }

                        for (int[] ints : movement) {
                            int x = i + ints[0];
                            int y = j + ints[1];

                            if (0 <= x && x < n && 0 <= y && y < m) {

                                if (isAccessible[i][j] == 1) {
                                    isAccessible[x][y] = 1;}
                                // 문제점 중간에 걸 빼면 벽이라고 인식을 안하긴 하는데

                                if (isAccessible[i][j] != 1 && box[i][j] == '0') {
                                    // 1이 아닌데 지워진 경우가 있음 내부라고 봄
                                    isAccessible[i][j] = 2;
                                }

                            }

                        }
                    }

                }

            }
        }




    }

