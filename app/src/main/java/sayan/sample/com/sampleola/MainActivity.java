package sayan.sample.com.sampleola;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import sayan.sample.com.sayan_ola_ride_sdk.AccessTokenManager;
import sayan.sample.com.sayan_ola_ride_sdk.Authenticate;
import sayan.sample.com.sayan_ola_ride_sdk.SessionConfig;
import sayan.sample.com.sayan_ola_ride_sdk.interfaces.AuthenticateCallback;

public class MainActivity extends AppCompatActivity {

    private SessionConfig mSessionConfig;
    private AccessTokenManager mAccessTokenManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSessionConfig = new SessionConfig.Builder()
                .setEnvironment(SessionConfig.Environment.SANDBOX)
                .setoAuthUrl(getResources().getString(R.string.o_auth_url))
                .setxAppToken(getResources().getString(R.string.x_app_token))
//                .setUserName("msayan64@gmail.com")
//                .setPassword("Titirece@50")
                .build();
        mAccessTokenManager = new AccessTokenManager();
        Authenticate.authenticateUser(this, mSessionConfig, mAccessTokenManager, new AuthenticateCallback() {
            @Override
            public void onAccessTokenSaved(String s) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
