package 자바기능확인;

abstract class AbstractAuthenticationTargetUrlRequestHandler {

    public void handle(String message) {
        System.out.println("꼭대기AbstractClass.hadle 실행됨: " + message);
    }
}
