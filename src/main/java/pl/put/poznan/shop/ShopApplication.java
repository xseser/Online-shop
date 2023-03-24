package pl.put.poznan.shop;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ShopApplication.class, args);
		Application.launch(GuiApplication.class, args);
	}

}
