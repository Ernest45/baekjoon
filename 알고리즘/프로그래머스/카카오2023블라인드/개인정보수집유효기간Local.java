package 알고리즘.프로그래머스.카카오2023블라인드;

import java.time.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.HashMap;

public class 개인정보수집유효기간Local {

    // 각 약관번호마다 유효기간이 있다
    // 개별 약관의 시작일과 약관번호를 조합에 만료된 개별 약관을 return

    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        개인정보수집유효기간Local main = new 개인정보수집유효기간Local();
        main.solution(today, terms, privacies);


    }
    /*
    개인정보 수집일 + 약관 만료일을 더해서
    나온 날짜가 오늘이 지났으면,파기 아니면 보관
     */

    public int[] solution(String today, String[] terms, String[] privacies) {


        // 오늘 날짜를 LocalDate로 변환
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayDate = LocalDate.parse(today, formatter);
        System.out.println(todayDate);

        // 약관별 유효기간을 HashMap에 저장
        HashMap<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] splitTerm = term.split(" ");
            termMap.put(splitTerm[0], Integer.parseInt(splitTerm[1]));
        }

        // 만료된 개인정보 인덱스를 저장할 리스트
        ArrayList<Integer> expired = new ArrayList<>();

        // 각 개인정보의 유효기간 체크
        for (int i = 0; i < privacies.length; i++) {
            String[] splitPrivacy = privacies[i].split(" ");
            LocalDate startDate = LocalDate.parse(splitPrivacy[0], formatter); // 수집일
            int months = termMap.get(splitPrivacy[1]); // 유효기간(개월)

            // 만료일 계산: 수집일 + 유효기간(개월)
            LocalDate expiryDate = startDate.plusMonths(months);


            // 만료일이 오늘보다 이전이면 파기 대상
            if (expiryDate.isBefore(todayDate) || expiryDate.isEqual(todayDate)) {
                expired.add(i + 1); // 인덱스는 1부터 시작 (문제 조건에 따라)
            }
        }

        // ArrayList를 int[]로 변환
        return expired.stream().mapToInt(Integer::intValue).toArray();
    }
}
