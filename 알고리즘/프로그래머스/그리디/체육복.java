package 알고리즘.프로그래머스.그리디;

import java.util.HashSet;

public class 체육복 {

    /*
    오름차순 정렬이라 순서대로 서있는 아이들이 있고, (앞뒤만 서로 빌려줄 수 있음..)
    최대의 체육복을 입을 수를 리턴


     */

    public static void main(String[] args) {

        int n = 5;
        int[] lost = new int[]{2, 4};
        int[] reserve = new int[]{1, 3, 5};

        체육복 main = new 체육복();
        System.out.println(main.solution(n, lost, reserve));


    }

    //현재를 기준으로 앞뒤 탐색
    //해시로 넣고 +1,-1 확인 ?
    // or queue 에 넣고 현재 lost를 탐색 시 빌려줄 수 있다면 +1

    // queue 보다 해시로 관리해서 삭제해 가는 게 나을 듯

    // 너무 쉽게 생각했음.. 내가 여분이 있는 채로 도난 당할경우 어차피 그리디에 의해서 빌려주면 된다 했는데,
    // n = 3 / lost = [2, 3] / reserve = [1, 2]의 경우 2는 빌려주질 못해서 내 코드대로라면
    // 3명 다 쓸수 있지만 2명이 나와야 정답임 그래서 lost의 경우 먼저 처리해줘야함


    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;

        int student[] = new int[n + 2];
        int size = student.length;
        // +1, -1 할꺼라서 경계 값을 위해 +2로 표현

        for (int i : lost) {// 도난의 경우 -1해주기
            student[i]--;
        }

        for (int i : reserve) {
            student[i]++; // 여벌의 경우 +1 해주기
        }

        // sutdent는 -1 , 0, 1 을 가짐 -1은 도난당하고 여벌도

        // note 중요한 건 도난 당한 사람은 여벌을 빌려줄 수 없다! 먼저 꼭 처리해줘야함 반례가 있기에..


        for (int i = 1; i < size; i++) { // +2로 찾기위해 1부터 size까지 포함

            if (student[i] == -1) {
                if (student[i - 1] == 1) {
                    student[i - 1] = 0;
                    student[i] = 0;
                } else if (student[i + 1] == 1) {
                    student[i + 1] = 0;
                    student[i] = 0;
                } else
                    answer--;


            }

        }

        return answer;
    }


}
