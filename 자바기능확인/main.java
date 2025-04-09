package 자바기능확인;

public class main {

    public static void main(String[] args) {


        OAuth2SuccessHandler sol = new OAuth2SuccessHandler();
        sol.onAuthenticationSuccess("hello", 1);


    }
}


