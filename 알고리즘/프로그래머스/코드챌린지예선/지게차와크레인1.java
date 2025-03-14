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
                updateAccessible(box, isAccessible, n, m); // 접근 가능성 갱신
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
            // 모두 초기화 후 재계산
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    isAccessible[i][j] = 0; // 기본: 접근 불가
                    if (box[i][j] == '0') continue; // 빈 공간은 체크 제외
                    // 외곽이거나 빈 공간 옆이면 접근 가능
                    if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                        isAccessible[i][j] = 1;
                    } else {
                        for (int[] move : movement) {
                            int ni = i + move[0];
                            int nj = j + move[1];
                            if (ni >= 0 && ni < n && nj >= 0 && nj < m && box[ni][nj] == '0') {
                                isAccessible[i][j] = 1;
                                break;
                            }
                        }
                    }
                }
            }
        }


    }

