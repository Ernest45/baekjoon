package 알고리즘.나머지;

import java.io.*;
import java.util.StringTokenizer;

//문제
//(A+B)%C는 ((A%C) + (B%C))%C 와 같을까?

//(A×B)%C는 ((A%C) × (B%C))%C 와 같을까?

//세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오.

//입력
//첫째 줄에 A, B, C가 순서대로 주어진다. (2 ≤ A, B, C ≤ 10000)

//출력
//첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.
public class 백준10430 {

    static int a;
    static int b;
    static int c;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int answer1 = ((a + b) % c);
        int answer2 = ((a % b) + (b % c)) % c;
        int answer3 = ((a * b) % c);
        int answer4 = ((a % b) * (b % c)) % c;


        bw.write(String.valueOf(answer1));
        bw.newLine();
        bw.write(String.valueOf(answer2));
        bw.newLine();
        bw.write(String.valueOf(answer3));
        bw.newLine();
        bw.write(String.valueOf(answer4));

        br.close();
        bw.close();


    }
}
