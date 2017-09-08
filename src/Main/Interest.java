package Main;

import Language.Language;

public class Interest {
    private Language language;
	public final static int DEFAULT = 0;
	public final static int MUSIC = 1;
    public final static int FILMS = 2;
    public final static int GAMES = 3;
    public final static int IT = 4;
    public final static int SEX = 5;
    public final static int PSYHOLOGY = 6;

    private String [] STRINGS;

    public Interest(Language language) {
        this.language = language;
        setStrings();
    }

    private void setStrings() {

        STRINGS = new String[] {
            language.getString("defaultInterest"),
            language.getString("musicInterest"),
            language.getString("filmsInterest"),
            language.getString("gamesInterest"),
            language.getString("itInterest"),
            language.getString("sexInterest"),
            language.getString("psyhologyInterest"),
        };

    }

    public String getString(int i) {
        return STRINGS[i];
    }

}
