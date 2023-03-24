package pl.put.poznan.shop.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;

@Controller
public class Init {

    @FXML
    public Label initLabel;

    @Value("classpath:/FXML/Init.fxml")
    Resource initResource;
}
