public class AppSettings{

    private static AppSettings settingsInstance;

    private String appBackground;
    private String appCheckboxStyle;
    private String appBoxStyle;

    private AppSettings(String appBackground, String appCheckboxStyle, String appBoxStyle) {
        this.appBackground = appBackground;
        this.appCheckboxStyle = appCheckboxStyle;
        this.appBoxStyle = appBoxStyle;
    }

    public static AppSettings getInstance(){
        if (settingsInstance == null){
            settingsInstance = new AppSettings("white", "default-checkbox", "default-boxstyle");
            return settingsInstance;
        }
        return settingsInstance;
    }

    public String getAppBackground() {
        return appBackground;
    }

    public void setAppBackground(String appBackground) {
        this.appBackground = appBackground;
    }

    public String getAppCheckboxStyle() {
        return appCheckboxStyle;
    }

    public void setAppCheckboxStyle(String appCheckboxStyle) {
        this.appCheckboxStyle = appCheckboxStyle;
    }

    public String getAppBoxStyle() {
        return appBoxStyle;
    }

    public void setAppBoxStyle(String appBoxStyle) {
        this.appBoxStyle = appBoxStyle;
    }
}