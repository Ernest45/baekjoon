package 알고리즘.프로그래머스.카카오윈터인턴쉽;

public class 가장많이받은선물 {

    // 선물하기 기능
    // 선물을 주고 받은 기록이 있고, 다르다면 더 적게 선물한 사람이 다음달에 더 많이 선물한 사람에게 선물해야함
    // 없거나 같다면 선물지수가 작은 사람이 큰 사람에게 다음달에선물해야함
    // 선물 지수란? 이번 달에 내가 준 선물 - 받은 선물
    // 선물 지수도 같다면 그냥 냅두기
    // 이해 안가는 부분에 둘이 선물 받은 부분이 없는 애들을 다 카운트해야할 거 같진 않음

    // 이 규칙을 다 지키고 다음 달에 선물을 가장 많이 받을 친구의 선물 수를 return;

    public static void main(String[] args) {
        String[] friend = new String[]{"muzi", "ryan", "frodo", "neo"};
        String[] gifts = new String[]{
                "muzi frodo",
                "muzi frodo",
                "ryan muzi",
                "ryan muzi",
                "ryan muzi",
                "frodo muzi",
                "frodo ryan",
                "neo muzi"};
    }
}
