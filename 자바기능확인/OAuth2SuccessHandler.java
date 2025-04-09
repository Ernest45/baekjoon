package 자바기능확인;

public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {



    @Override
    public void onAuthenticationSuccess(String message, int ad) {
        System.out.println("12");;
    }
}
