package com.jmedinilla.logintable.controllers;

/**
 * Class that implements the Login interface to be used
 * in the Login Activity
 */
public class Login_Activity_Controller implements ILoginMvc {

    //Final variables to send errors
    public static final int OK = 0;
    public static final int PASSWORD_DIGIT = 1;
    public static final int PASSWORD_CASE = 2;
    public static final int PASSWORD_LENGTH = 3;

    public int validateCredentials(String user, String pass) {
        int result = 0;

        //Rules to validate the user and his password
        if (!pass.matches("^.*[0-9]+.*$")) {
            result = PASSWORD_DIGIT;
        }
        else if (!pass.matches("^.*(?=.*[a-z])(?=.*[A-Z]).*$")) {
            result = PASSWORD_CASE;
        }
        else if (pass.length() <=7) {
            result = PASSWORD_LENGTH;
        }

        return result;
    }
}
