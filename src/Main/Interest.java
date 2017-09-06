package Main;

public class Interest {
	public final static int DEFAULT = 0;
	public final static int MUSIC = 1;
    public final static int FILMS = 2;
    public final static int GAMES = 3;
    public final static int IT = 4;
    public final static int SEX = 5;
    public final static int PSYHOLOGY = 6;

    private static String [] STRINGS = {
            "Отлично! Теперь вы будете общаться на любые темы.",
            "Отлично! Теперь вы будете говорить о музыке.",
            "Отлично! Теперь вы будете говорить о фильмах.",
            "Отлично! Теперь вы будете говорить об играх.",
            "Отлично! Теперь вы будете говорить об IT.",
            "Отлично! Теперь вы будете говорить о сексе.",
            "Отлично! Теперь вы будете говорить о психологии."
    };

    public static String getString(int i) {
        return STRINGS[i];
    }
}
