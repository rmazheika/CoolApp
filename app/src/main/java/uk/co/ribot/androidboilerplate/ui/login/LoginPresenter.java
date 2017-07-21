package uk.co.ribot.androidboilerplate.ui.login;

import android.text.TextUtils;

import javax.inject.Inject;

import rx.Subscription;
import uk.co.ribot.androidboilerplate.injection.ConfigPersistent;
import uk.co.ribot.androidboilerplate.ui.base.BasePresenter;

/**
 * Created by anduser on 20.07.17.
 */

@ConfigPersistent
public class LoginPresenter extends BasePresenter<LoginMvpView> {

    private Subscription mSubscription;

    @Inject LoginPresenter() {};

    @Override
    public void attachView(LoginMvpView loginMvpView) {
        super.attachView(loginMvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    public boolean verifyCredentials(String login, String password) {
        boolean verified = true;

        if (TextUtils.isEmpty(login)) {
            getMvpView().showLoginError();
            verified = false;
        } else {
            getMvpView().showLoginEmptyError();
        }
        if (TextUtils.isEmpty(password)) {
            getMvpView().showPasswordError();
            verified = false;
        } else {
            getMvpView().showPasswordEmptyError();
        }
        return verified;
    }

    public void executeLoginRequest(String login, String password) {
        getMvpView().showLoginSuccess();
    }
}
