package uk.co.ribot.androidboilerplate.util;

import android.animation.Animator;
import android.transition.ChangeBounds;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by anduser on 07.06.17.
 */

@Singleton
public class AnimationUtil {

    @Inject AnimationUtil() {};

    public static void performAlphaAnimation(View view, boolean show) {
        performAlphaAnimation(view, show, false);
    }

    public static void clearAnimation(View v) {
        if (v.getAnimation() != null) {
            v.getAnimation().cancel();
            v.getAnimation().setAnimationListener(null);
            v.clearAnimation();
            v.setAnimation(null);
        }
    }

    private static void performAlphaAnimation(View view, boolean show, boolean gone) {

        if ((show && view.getVisibility() == View.VISIBLE) || (!show && view.getVisibility() == View.INVISIBLE) || (!show && view.getVisibility() == View.GONE)) {
            return;
        }

        final boolean finalShow = show;
        final boolean finalGone = gone;
        final View finalView = view;

        AlphaAnimation alphaAnimation = new AlphaAnimation((show ? 0.0f : 1.0f), (show ? 1.0f : 0.0f));
        alphaAnimation.setDuration(250);
        alphaAnimation.setFillAfter(false);
        view.startAnimation(alphaAnimation);

        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                if (finalShow) {
                    finalView.setVisibility(View.VISIBLE);
                } else if (!finalGone) {
                    finalView.setVisibility(View.INVISIBLE);
                } else {
                    finalView.setVisibility(View.GONE);
                }
            }
        });
    }

    /*
     *  To animate view slide out from top to bottom
     */
    public static void slideToBottom(View view) {
        int height = view.getHeight();
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
        params.height = 0;
        view.setLayoutParams(params);
        view.setVisibility(View.VISIBLE);
        TranslateAnimation animate = new TranslateAnimation(0, 0, 0, height);
        animate.setDuration(300);
        animate.setFillAfter(true);
        view.startAnimation(animate);
    }

    /*
     *  To animate view slide out from bottom to top
     */
    public static void slideToTop(View view) {
        TranslateAnimation animate = new TranslateAnimation(0, 0, 0, -view.getHeight());
        animate.setDuration(300);
        animate.setFillAfter(true);
        view.startAnimation(animate);
        view.setVisibility(View.GONE);
    }

    public static void clipViewBounds(View view) {
        ChangeBounds changeBounds = new ChangeBounds();
    }
}
