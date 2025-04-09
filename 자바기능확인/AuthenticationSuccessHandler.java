package 자바기능확인;

public interface AuthenticationSuccessHandler {

    default void onAuthenticationSuccess(String message, int ad) {

        System.out.println("인터페이스 메서드MyInterface.defaultMethod 실행됨!");
        onAuthenticationSuccess(message);
        System.out.println("MyInterface.defaultMethod 끝!");
    }

    void onAuthenticationSuccess(String message);
}


