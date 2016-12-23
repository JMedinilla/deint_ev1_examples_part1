package com.jmedinilla.logintextinputlayout;

/**
 * Created by JMedinilla on 2016-10-06
 */
interface ILoginMvp {

    interface View {
        void setLoginMessageError(String message, int idView);
    }

    interface Presenter {
        void validateCredentials(String user, String pass);
    }
}
