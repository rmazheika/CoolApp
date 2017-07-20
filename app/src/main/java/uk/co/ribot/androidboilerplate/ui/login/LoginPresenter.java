package uk.co.ribot.androidboilerplate.ui.login;

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

    public void executeLoginRequest(String login, String password) {

    }
}
