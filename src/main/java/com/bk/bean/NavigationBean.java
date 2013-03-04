package com.bk.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * User: ph
 * Date: 1/17/13
 */

@Component
@Scope("request")
public class NavigationBean {
    private static final String REDIRECT = "?faces-redirect=true";
    private static final String HOME = "/pages/home.jsf";
    private static final String LOGIN = "/pages/login.jsf";
    private static final String REGISTER = "/pages/register.jsf";
    private static final String ADD_BOOK = "/pages/admin/addBook.jsf";
    private static final String BOOK = "/pages/book.jsf";

    public static String LOGIN() {
        return LOGIN + REDIRECT;
    }

    public static String REGISTER() {
        return REGISTER + REDIRECT;
    }

    public static String HOME() {
        return HOME + REDIRECT;
    }

    public static String ADD_BOOK() {
        return ADD_BOOK + REDIRECT;
    }

    public static String BOOK() {
        return BOOK;
    }
}
