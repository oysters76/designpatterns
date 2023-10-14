import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppSettings{

    private static final AppSettings settingsInstance = initAppSettings();

    private String appBackground;
    private String appCheckboxStyle;
    private String appBoxStyle;

    private AppSettings(String appBackground, String appCheckboxStyle, String appBoxStyle) {
        this.appBackground = appBackground;
        this.appCheckboxStyle = appCheckboxStyle;
        this.appBoxStyle = appBoxStyle;
    }

    public static AppSettings initAppSettings(){
        Properties properties = new Properties();
        AppSettings appSettings;
        try {
            properties.load(AppSettings.class.getResourceAsStream("app.properties"));
            appSettings = new AppSettings(
                    properties.getProperty("appBackground"),
                    properties.getProperty("appCheckboxStyle"),
                    properties.getProperty("appBoxStyle")
            );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return appSettings;
    }

    public static AppSettings getInstance(){
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