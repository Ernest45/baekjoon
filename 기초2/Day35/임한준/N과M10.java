package 기초2.Day35.임한준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M10 {

    /**
     문제 15664
     N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

     N개의 자연수 중에서 M개를 고른 수열
     고른 수열은 비내림차순이어야 한다.
     길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
     입력
     첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

     둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.

     출력
     한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

     수열은 사전 순으로 증가하는 순서로 출력해야 한다.
     */

    // 파라미터로 하나으 ㅣ값을 더 넘겨서 확인 ?

    static int n , m;
    static int[] arr;
    static int[] ans;

    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        ans = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());}

        Arrays.sort(arr);

        dfs(0,0);
        System.out.println(sb.toString());

        }

    protected static void dfs(int depth, int idx) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(ans[i] + " ");
            }
            sb.append("\n");

            return;
        }
        int before = 0;
        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                    visited[i] = true;
                    ans[depth] = arr[i];
                    before = arr[i];
                    dfs(depth + 1, i);
                    visited[i] = false;


            }
        }
    }
}


