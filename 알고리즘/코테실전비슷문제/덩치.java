package 알고리즘.코테실전비슷문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 덩치 {
    // 무조건 키, 몸무게 둘다 커야 더 큰 덩치고 만약 하나만 더 크고 하나는 작은 상태라면 같은 등수가 부여됨
    // 올림픽 문제랑 유사

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] arr = new int[t][3];
        StringTokenizer st;


        for (int i = 0; i < t ; i++) {
            st = new StringTokenizer(br.readLine());
//            arr[i][2] = rank;

            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());


            }

        }
        int rank = 1;

        for (int i = 0; i < t; i++) {



            for (int j = i + 1; j < t; j++) {
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    swap(arr, i, j);

                }


            }
            if (arr[i][0] < arr[i + 1][0] && arr[i][1] > arr[i + 1][1] || arr[i][0] > arr[i + 1][0] && arr[i][1] < arr[i + 1][1]) {
                arr[i+1][2] =  arr[i][2];
                rank++;
            }
            arr[i][2] = rank;
            rank++;

        }

        for (int[] a : arr) {
            for (int n : a) {
                System.out.println(n);

            }

        }
    }

    public static void swap(int arr[][], int a, int b) {

        int temp = arr[a][0];
        arr[a][0] = arr[b][0];
        arr[b][0] = temp;
        int temp1 = arr[a][1];
        arr[a][1] = arr[b][1];
        arr[b][1] = temp1;

    }
    }

