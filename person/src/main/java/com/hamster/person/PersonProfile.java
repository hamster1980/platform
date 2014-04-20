package com.hamster.person;

import java.io.Serializable;
import java.util.Locale;

import com.google.common.base.Preconditions;
import com.hamster.model.Auth;

public class PersonProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    public static PersonProfile create(String lang) {
        return new PersonProfile(null, new Locale(lang, null));
    }
    
    public static PersonProfile auth(PersonProfile prev, Auth auth) {
        return new PersonProfile(auth, prev.getLocale());
    }
    
    public static PersonProfile changeLang(PersonProfile prev, String lang) {
        return new PersonProfile(prev.getAuth(), new Locale(lang, prev.getLocale().getCountry()));
    }
    
    private final Auth auth;
    private final Locale locale;

    public PersonProfile(Auth auth, Locale locale) {
        this.auth = auth;
        this.locale = Preconditions.checkNotNull(locale);
    }

    public Auth getAuth() {
        return auth;
    }

    public Locale getLocale() {
        return locale;
    }
    
    
}
