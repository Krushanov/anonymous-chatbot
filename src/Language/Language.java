package Language;

import java.util.Locale;
import java.util.ResourceBundle;

public class Language {

    private Locale ruLocale = new Locale("ru", "RU");
    private int currentLanguage;

    private Locale[] supportedLocales = {
        Locale.ENGLISH,
        ruLocale
    };

    public Language() {
        currentLanguage = 0;
    }

    public void setLanguage(int langIndex) {
        currentLanguage = langIndex;
    }

    public String getString(String key) {
        ResourceBundle strings = ResourceBundle.getBundle("Language/StringsBundle", supportedLocales[currentLanguage], new UTF8Control());
        return strings.getString(key);
    }
}
