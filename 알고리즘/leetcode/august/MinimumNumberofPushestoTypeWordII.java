package 알고리즘.leetcode.august;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MinimumNumberofPushestoTypeWordII {

    //3016. Minimum Number of Pushes to Type Word II

    //키보드의 구성이 헷갈린다 사진을 보니.. 댓글 보니까
    // 예제 무시하고 그냥 ?

    // 기본적인 일반 키패드로 생각하자는 건 아닐테고
    // 보니까 주어진 word에 확정된 키패드가 아닌
    // word가 주어지면 내가 배열을 해서 최소로 누르게 하는 것
    // 나오는 빈도가 많은 단어일수록 한번만 누르게 설계하면 될듯?
    //우선순위를 둬서 처리하면 좋을 거 같드

    public static void main(String[] args) {

        String word = "aabbccddeeffgghhiiiiii";

        MinimumNumberofPushestoTypeWordII sol = new MinimumNumberofPushestoTypeWordII();
        sol.minimumPushes(word);




    }

    public int minimumPushes(String word) {

        // 1숫자 세고, 숫자에 따라 8개씩 끊어서 우선순위 부여 작을수록
        // 그럼 map에 저장할 때 key에 저장 다하고 8개 초과면 value 확인 후 우선순위 다르게

        // 최고 효율의 기준은 8 8 8 2로 구성하는 것

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);

        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {


        }

        return 1;

    }
}