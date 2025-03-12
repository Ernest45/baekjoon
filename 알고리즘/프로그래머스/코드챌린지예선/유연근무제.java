package 알고리즘.프로그래머스.코드챌린지예선;

import java.util.HashMap;
import java.util.Map;

public class 유연근무제 {
    //출근 희망 시간이 주어지고, +10까지 평일에 출근하면 출근인정
    // 주말엔 상관 x 다출근했을 때 상을 준다. 상을 몇 명이서 받을지 return

    public static void main(String[] args) {
        int[] schedules = new int[]{700, 800, 1100};
        int[][] timeLogs = new int[][]{
                {710, 2359, 1050, 700, 650, 631, 659},
                {800, 801, 805, 800, 759, 810, 809},
                {1105, 1001, 1002, 600, 1059, 1001, 1100}};
        int startDay = 5;
        유연근무제 main = new 유연근무제();
        int a = main.solution(schedules, timeLogs, startDay);
        System.out.println(a);
    }



    public int solution(int[] schedules, int[][] timelogs, int startday) {

        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        // note schedule은 700 ~1100 이라, 100의 자리가 올림될 일은 9일 경우
        System.out.println(954 % 1000);


        for (int i = 0; i < schedules.length; i++) {
            int now = schedules[i];

            int hour = now / 100;  // 시간 추출
            int minute = now % 100; // 분 추출

            minute += 10; // 10분 추가

            if (minute >= 60) {  // 60분이 넘으면 시간 증가
                hour += 1;
                minute -= 60;
            }

            now = hour * 100 + minute; // 다시 조합
            map.put(i, now);
        }





        for (int i = 0; i < timelogs.length; i++) {
            int now = 0;

            for (int j = 0; j < 7; j++) {
//                System.out.println("startday = " + startday % 7);

                if ( startday % 7 != 6 && startday % 7 != 0) {



                    if (timelogs[i][j] <= map.get(i)) {

                        now++;

                    }

                }
                startday++;

            }
            if (now == 5) {

                answer++;
            }

        }



        return answer;
    }
}
