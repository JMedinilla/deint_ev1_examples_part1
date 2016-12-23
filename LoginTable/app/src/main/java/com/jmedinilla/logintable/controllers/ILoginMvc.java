package com.jmedinilla.logintable.controllers;

/**
 * Interface that gives the user the method to validate
 * the user's credentials
 * @author JMedinilla
 * @version 1.0
 */
public interface ILoginMvc {
    int validateCredentials(String user, String pass);
}
