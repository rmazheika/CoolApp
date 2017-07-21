package uk.co.ribot.androidboilerplate.ui.login;

import android.app.ActivityOptions;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.ribot.androidboilerplate.R;
import uk.co.ribot.androidboilerplate.ui.base.BaseActivity;
import uk.co.ribot.androidboilerplate.ui.main.MainActivity;
import uk.co.ribot.androidboilerplate.util.AnimationUtil;

/**
 * Created by anduser on 20.07.17.
 */

public class LoginActivity extends BaseActivity implements LoginMvpView {

    @Inject LoginPresenter loginPresenter;
    @Inject AnimationUtil animationUtil;

    @BindView(R.id.login_field_layout)
    TextInputLayout loginFieldLayout;
    @BindView(R.id.password_field_layout)
    TextInputLayout passwordFieldLayout;

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

    @OnClick(R.id.btn_login)
    public void onLoginBtnClick() {
        String login = loginFieldLayout.getEditText().getText().toString();
        String password = passwordFieldLayout.getEditText().getText().toString();

        if (loginPresenter.verifyCredentials(login, password)) {
            loginPresenter.executeLoginRequest(login, password);
        }
    }

    @Override
    public void showLoginSuccess() {
        ActivityOptions options = ActivityOptions
                .makeSceneTransitionAnimation(this);

        startActivity(MainActivity.getStartIntent(this, true), options.toBundle());

        finish();
    }

    @Override
    public void showLoginError() {
        loginFieldLayout.setError(getString(R.string.login_error));
    }
    @Override
    public void showLoginEmptyError() {
        loginFieldLayout.setError("");
    }
    @Override
    public void showPasswordError() {
        passwordFieldLayout.setError(getString(R.string.password_error));
    }
    @Override
    public void showPasswordEmptyError() {
        passwordFieldLayout.setError("");
    }

    @Override
    public void showError() {

    }
}
