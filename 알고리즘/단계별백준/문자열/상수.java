package 알고리즘.단계별백준.문자열;

import java.util.Scanner;

public class 상수 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int nn = sc.nextInt();
        int mm = sc.nextInt();

        String n = String.valueOf(nn);
        String m = String.valueOf(mm);



        StringBuilder sb = new StringBuilder();

        int a = 0;

        int b = 0;


        for (int i = 2; i >= 0; i--) {
//            n = n + String.valueOf(sb.append(n.charAt(i)));
            sb = sb.append(n.charAt(i));

        }
        a = Integer.parseInt(String.valueOf(sb));

        StringBuilder s6 = new StringBuilder();

        for (int i = 2; i >= 0; i--) {


//            m = m + String.valueOf(sb.append(m.charAt(i)));
            s6 = s6.append(m.charAt(i)); // n = n + 1 이렇게 만들려다 실패 append는 그냥 붙이면 됨


        }
        b = Integer.parseInt(String.valueOf(s6));


        System.out.println(Math.max(a, b));


    }
}
