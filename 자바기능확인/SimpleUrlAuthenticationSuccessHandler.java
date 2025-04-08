package 자바기능확인;

public class SimpleUrlAuthenticationSuccessHandler extends AbstractAuthenticationTargetUrlRequestHandler
        implements  AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(String message) {
        handle(message);
        System.out.println("구현 및 상속MyImplementation.customMethod 실행됨: " + message);
    }
}
