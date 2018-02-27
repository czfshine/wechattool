package cn.czfshine.wechat;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * @author:czfshine
 * @date:18-2-21
 **/
public class GUI extends Application {

    private Scene scene;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Web View Sample");
        scene = new Scene(new Browser(stage));

        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

class Browser extends Region {
    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();
    public Browser(final Stage stage) {
        webEngine.load("http://baidu.com");



        getChildren().add(browser);
    }

}
