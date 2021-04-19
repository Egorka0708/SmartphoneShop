package naumen.project.shop;

import naumen.project.shop.models.Smartphone;
import naumen.project.shop.repository.SmartphoneRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ShopApplication.class);
		SmartphoneRepository repository = context.getBean(SmartphoneRepository.class);

		repository.save(new Smartphone(1, "Android", "Samsung Galaxy S20 Ultra", "images/Samsung_Galaxy_S20_Ultra.jpg"));
		repository.save(new Smartphone(2, "Android", "Huawei P40 Pro", "images/Huawei_P40_Pro.jpg"));
		repository.save(new Smartphone(3, "Apple", "IPhone 12 mini", "images/IPhone_12_mini.jpg"));
		repository.save(new Smartphone(4, "Android", "Xiaomi Poco M3", "images/Xiaomi_Poco_M3.jpg"));
		repository.save(new Smartphone(5, "Apple", "IPhone 12 Pro", "images/IPhone_12_Pro.jpg"));
		repository.save(new Smartphone(6, "Android", "OnePlus 8", "images/OnePlus_8.jpg"));
		repository.save(new Smartphone(7, "Apple", "IPhone 11", "images/IPhone_11.jpg"));
		repository.save(new Smartphone(8, "Android", "Samsung Galaxy Nota 20 Ultra", "images/Samsung_Galaxy_Nota_20_Ultra.jpg"));
		repository.save(new Smartphone(9, "Apple", "IPhone X", "images/IPhone_X.jpg"));
		repository.save(new Smartphone(10, "Android", "Honor 30", "images/Honor_30.png"));
		repository.save(new Smartphone(11, "Apple", "IPhone 12 Pro Max", "images/IPhone_12_Pro_Max.jpg"));
		repository.save(new Smartphone(12, "Android", "realme X3 Superzoom", "images/realme_X3_Superzoom.jpg"));
	}
}
