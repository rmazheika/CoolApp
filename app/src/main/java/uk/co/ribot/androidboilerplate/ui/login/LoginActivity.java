package uk.co.ribot.androidboilerplate.ui.login;

import android.os.Bundle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import uk.co.ribot.androidboilerplate.R;
import uk.co.ribot.androidboilerplate.ui.base.BaseActivity;

/**
 * Created by anduser on 20.07.17.
 */

public class LoginActivity extends BaseActivity implements LoginMvpView {

    @Inject LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        loginPresenter.detachView();
    }

    @Override
    public void showLoginSuccess() {

    }

    @Override
    public void showLoginError() {

    }
}
