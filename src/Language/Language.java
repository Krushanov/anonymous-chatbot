package Language;

import java.util.Locale;
import java.util.ResourceBundle;

public class Language {

    private Locale ruLocale = new Locale("ru", "RU");
    private int currentLanguage;

    public final static int ENGLISH = 0;
    public final static int RUSSAIN = 1;

    private Locale[] supportedLocales = {
        Locale.ENGLISH,
        ruLocale
    };

    private String [] STRINGS = {
            getString("selectEnglish"),
            getString("selectRussian")
    };

    public void setLanguage(int langIndex) {
        currentLanguage = langIndex;
    }

    public String getString(String key) {
        ResourceBundle strings = ResourceBundle.getBundle("Language/StringsBundle", supportedLocales[currentLanguage], new UTF8Control());
        return strings.getString(key);
    }

    public String getLanguageName(int i) {
        return STRINGS[i];
    }
}
