package com.jmedinilla.logintextinputlayout;

import android.app.Application;
import com.jmedinilla.logintextinputlayout.modelo.User;

/**
 * Creater by JMedinilla on 2016-10-06
 */
public class LoginApplication extends Application {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
