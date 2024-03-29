package 알고리즘.단계별백준.일차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바구니뒤집기일반 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] answer = new int[n];

        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
            answer[i - 1] = i;
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            reverseArrays(arr, start -1, end -1);
            }

        for (int values : arr) {
            System.out.print(values + " ");

        }
        }

    public static void reverseArrays(int[] arr, int start, int end) { // 1 4 0 3 투포인터궂나
        while (start < end) { // 0 3
            int temp = arr[start]; // 0
            arr[start] = arr[end]; //
            arr[end] = temp;
            start++; // 아 어차피 홀수면 안뒤집어도 되구나!
            end--;

        }
    }

    }


