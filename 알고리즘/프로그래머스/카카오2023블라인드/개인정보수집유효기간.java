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


        for (int i = 0; i < terms.length; i++) {

            String splitTerms[] = terms[i].split(" ");
            int month = StringMonthToInt(splitTerms[1]);

            map.put(splitTerms[0], month);

        }

        for (int i = 0; i < privacies.length; i++) {
            String splitPrivacy[] = privacies[i].split(" ");

            int day = Integer.parseInt(splitPrivacy[0].replace(".", ""));
            int plus = map.get(splitPrivacy[1]);

            if (day + plus > now) {
                answer.add(i);
            }
        }

        int[] arr = answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();




        return arr;
    }
    private int StringMonthToInt(String month) {
        // 들어온 개월 수를 숫자로 변환하는 과정
        // 1~100개월사이로 들어옴
        // 변환 시 12개월 이상이면 년수로 올려서 변환
        int yyyymmdd = 00000000;


        int monthToInt = Integer.parseInt(month);
        Duration.

        if (monthToInt < 12) {

        }


    }
}
