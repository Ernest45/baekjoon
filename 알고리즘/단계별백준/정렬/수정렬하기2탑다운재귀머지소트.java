package 알고리즘.단계별백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기2탑다운재귀머지소트 {

    public static int[] sort;

    // 버블소트의 경우 최악의 경우 1조번 연산인데 2초니까 안됨
    // nlogN 짜리 머지 소트나, 퀵소트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];



        for (int i = 0; i < n; i++) {

            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        mergeSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


    }

    public static void mergeSort(int[] arr, int left, int right) {

        sort = new int[arr.length];

        if (left == right) {
            // left랑 rigth랑 같아진다면 즉 나눈 부분 리스트 1개의 원소만 갖고 있을 때 리턴(나눌 수 없을 시점)
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {

        int l = left; // 나눠진 부분 리스트 시작점
        int r = mid + 1; //오른쪽 부분 리스트의 시작점
        int idx = left; // 채워 넣을 배열의 인덱스

        while (l <= mid && r <= right) {


            if (arr[l] <= arr[r]) {

                //왼쪽 부분 리스트 l번 원소가 오른쪽 부분리스트 r번째 요소보다 작거나 같을 경우
                //왼 l번째 요소를 새 배열에 넣고 l과 inx를 증가시킨다.

                sort[idx] = arr[l];
                idx++;
                l++;

            } else {
                //  오른쪽 부분리스트 r번째 원소가 왼쪽 부분리스트 l번째 원소보다 작거나 같을 경우
                // 오른쪽의 r번째 원소를 새 배열에 넣고 r과 idx를 1 증가시킨다.

                sort[idx] = arr[r];
                idx++;
                r++;

            }
        }

        // 왼쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (l > mid)
        // = 오른쪽 부분리스트 원소가 아직 남아있을 경우
        // 오른쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.

        if (l > mid) {
            while (r <= right) {
                sort[idx] = arr[r];
                idx++;
                r++;
            }

        } else {
            while (l <= mid) {
                sort[idx] = arr[l];
                idx++;
                l++;
            }
        }
        for (int i = left; i <= right; i++) {
            arr[i] = sort[i];

        }
    }
    
}
