package session_cookie.demo_javaweb_session09.test;

import java.util.Locale;

public class ShowLanguageCode {
    public static void main(String[] args) {
        Locale[] availableLocales = Locale.getAvailableLocales();
        for(Locale locale:availableLocales){
            System.out.println(locale.getDisplayCountry()+": "+locale.getLanguage()+"_"+locale.getCountry());
        }
    }
}
