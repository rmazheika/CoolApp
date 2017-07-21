package uk.co.ribot.androidboilerplate.ui.login;

import uk.co.ribot.androidboilerplate.ui.base.MvpView;

/**
 * Created by anduser on 20.07.17.
 */

public interface LoginMvpView extends MvpView {

    void showLoginSuccess();

    void showLoginError();
    void showLoginEmptyError();

    void showPasswordError();
    void showPasswordEmptyError();

    void showError();
}
