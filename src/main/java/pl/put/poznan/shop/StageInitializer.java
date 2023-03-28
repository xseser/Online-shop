package pl.put.poznan.shop;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import pl.put.poznan.shop.GuiApplication.StageReadyEvent;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    @Value("classpath:/FXML/Init.fxml")
    private Resource guiResource;
    private String applicationTitle;
    private ApplicationContext applicationContext;
    private Stage stage;

    public StageInitializer(@Value("${spring.application.ui.title}") String applicationTitle, ApplicationContext applicationContext) {
        this.applicationTitle = applicationTitle;
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(guiResource.getURL());
            fxmlLoader.setControllerFactory(aClass -> applicationContext.getBean(aClass));
            Parent parent = fxmlLoader.load();

            stage = event.getStage();
            stage.setTitle(applicationTitle);

            stage.getIcons().add(new Image("https://w7.pngwing.com/pngs/288/368/png-transparent-red-and-white-shop-illustration-text-brand-illustration-shop-text-retail-rectangle-thumbnail.png"));
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void switchScene(Resource fxmlResource) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlResource.getURL());
            fxmlLoader.setControllerFactory(aClass -> applicationContext.getBean(aClass));
            Parent parent = fxmlLoader.load();
            stage.setScene(new Scene(parent));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
