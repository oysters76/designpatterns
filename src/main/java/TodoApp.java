public class TodoApp {

    public static void main(String[] args) {
        TodoApp app = new TodoApp();
        MainWindow window = app.new MainWindow();
        TodoItem item = app.new TodoItem();
        window.render();
        item.render();

        System.out.println("------------user changes---------------");
        AppSettings settings = AppSettings.getInstance();
        settings.setAppBoxStyle("custom-boxstyle");
        settings.setAppBackground("black");
        settings.setAppCheckboxStyle("custom-checkbox");
        window.render();
        item.render();

    }

    interface Component{
        void render();
    }

    class MainWindow implements Component{
        private AppSettings settings;

        public MainWindow(){
            this.settings = AppSettings.getInstance();
        }

        @Override
        public void render() {
            //logic to render main-window to display
            System.out.println("main-window-background: " + this.settings.getAppBackground());
        }
    }

    class TodoItem implements Component{

        private AppSettings settings;

        public TodoItem(){
            this.settings = AppSettings.getInstance();
        }

        @Override
        public void render() {
            System.out.println("check: " + settings.getAppCheckboxStyle() + " taskBox: " + settings.getAppBoxStyle());
        }

    }


}
