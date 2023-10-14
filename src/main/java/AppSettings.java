public class AppSettings{

    //Lazy Loading Singleton Instance
    //private static AppSettings settingsInstance;

    //Eager loading Singleton Instance
    private static final AppSettings settingsInstance  = new AppSettings("white", "default-checkbox", "default-boxstyle");

    private String appBackground;
    private String appCheckboxStyle;
    private String appBoxStyle;

    private AppSettings(String appBackground, String appCheckboxStyle, String appBoxStyle) {
        this.appBackground = appBackground;
        this.appCheckboxStyle = appCheckboxStyle;
        this.appBoxStyle = appBoxStyle;
    }

    //Lazy Loading ,return the Singleton Instance
    /*public static AppSettings getInstance(){
        if (settingsInstance == null){
            settingsInstance = new AppSettings("white", "default-checkbox", "default-boxstyle");
            return settingsInstance;
        }
        return settingsInstance;
    }*/
    //Lazy Loading

    //Eager loading, return the Singleton Instance
    public static AppSettings getInstance(){
        return settingsInstance;
    }
    //end Eager loading

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