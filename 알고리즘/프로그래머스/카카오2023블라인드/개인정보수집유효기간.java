package 알고리즘.프로그래머스.카카오2023블라인드;

import java.time.Duration;
import java.util.*;

public class 개인정보수집유효기간 {

    // 각 약관번호마다 유효기간이 있다
    // 개별 약관의 시작일과 약관번호를 조합에 만료된 개별 약관을 return

    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        개인정보수집유효기간 main = new 개인정보수집유효기간();
        main.solution(today, terms, privacies);


    }
    /*
    개인정보 수집일 + 약관 만료일을 더해서
    나온 날짜가 오늘이 지났으면,파기 아니면 보관
     */

    public int[] solution(String today, String[] terms, String[] privacies) {


        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        int now =Integer.parseInt(today.replace(".", ""));
        // String을 int로 변환


        for (int i = 0; i < terms.length; i++) {

            String splitTerms[] = terms[i].split(" ");
            int month = StringMonthToInt(splitTerms[1]);
            // 6개월이라면 0000 06 00 으로 변환

            map.put(splitTerms[0], month);

        }

        for (int i = 0; i < privacies.length; i++) {
            String splitPrivacy[] = privacies[i].split(" ");

            int day = Integer.parseInt(splitPrivacy[0].replace(".", ""));
            int months = map.get(splitPrivacy[1]); // 유효기간(개월)

            // 만료일 계산
            int expiryDay = dayAddPlus(day, months);

            // 만료일이 오늘보다 작거나 같으면 파기
            if (expiryDay <= now) {
                answer.add(i + 1); // 인덱스는 1부터 시작 (문제 조건 반영)
            }
        }
        int[] arr = answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();




        return arr;
    }}

        // ArrayList를 int[]로 변환


    // 개월 수를 날짜 계산에 반영하는 메서드
    private int dayAddPlus(int date, int months) {
        // date는 yyyymmdd 형식 (예: 20210502)
        int year = date / 10000; // 연도 (2021)
        int month = (date / 100) % 100; // 월 (05)
        int day = date % 100; // 일 (02)

        // 개월 수를 더함
        month += months;

        // 12개월이 넘으면 연도로 변환
        while (month > 12) {
            year += 1;
            month -= 12;
        }

        // 간단히 하기 위해 날짜는 그대로 유지 (정확히 하려면 일자 조정 필요)
        // 예: 2021.05.02 + 6개월 -> 2021.11.02
        int result = year * 10000 + month * 100 + day;

        return result;
    }



    private int StringMonthToInt(String month) {
        // 들어온 개월 수를 숫자로 변환하는 과정
        // 1~100개월사이로 들어옴
        // 변환 시 12개월 이상이면 년수로 올려서 변환
        int yyyymm = 00000000;
        String y = "000000";
        int m = 6;
        int q = Integer.parseInt(y) + m;
        System.out.println(q);



        int monthToInt = Integer.parseInt(month);
//        Duration.

//        if (monthToInt > ) {
//
//        }
        return 1;

    }

    private int dayAddPlus(int right, int left) {
        int result = 0;

        return result;

    }
}
