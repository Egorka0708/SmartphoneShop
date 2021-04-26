package naumen.project.shop;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import naumen.project.shop.models.Smartphone;
import naumen.project.shop.repository.SmartphoneRepository;
import naumen.project.shop.services.SmartphoneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ShopApplication.class);
//		try {
//			Serialization(context);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

//	public static void Serialization (ConfigurableApplicationContext context) throws IOException {
//		SmartphoneRepository repository = context.getBean(SmartphoneRepository.class);
//		ObjectMapper objectMapper = new ObjectMapper();
//		List<Smartphone> smartphones = repository.findAll();
//		FileWriter writer = new FileWriter("C:\\Users\\Dravo\\Documents\\ProjectCars\\CarShop\\shop\\src\\main\\resources\\JSON\\ser.json",true);
//		FileReader reader = new FileReader("C:\\Users\\Dravo\\Documents\\ProjectCars\\CarShop\\shop\\src\\main\\resources\\JSON\\ser.json");
//		writer.append("[\n");
//		for (Smartphone smartphone : smartphones
//		) {
//			String smartphoneAsString = objectMapper.writeValueAsString(smartphone);
//			writer.append(smartphoneAsString + ",\n");
//			//(new File("C:\\Users\\Dravo\\Documents\\ProjectCars\\CarShop\\shop\\src\\main\\resources\\JSON\\ser.json"), smartphoneAsString);
//		}
//		writer.append("]\n");
//		writer.flush();
//	}

	@Bean
	CommandLineRunner runner(SmartphoneService smartphoneService){
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			var allExistingSmartphones = smartphoneService.allSmartphones();
			TypeReference<List<Smartphone>> typeReference = new TypeReference<List<Smartphone>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/smartphonesDB.json");
			HashMap<String, Smartphone> mappedSmartphonesDB = new HashMap<String, Smartphone>();

			for (Smartphone smartphoneDB: allExistingSmartphones
				 ) {
				mappedSmartphonesDB.put(smartphoneDB.getName(), smartphoneDB);
			}

			try {
				List<Smartphone> smartphones = mapper.readValue(inputStream,typeReference);
				for (Smartphone smartphone:smartphones) {
					if (!mappedSmartphonesDB.containsKey(smartphone.getName()))
						smartphoneService.save(smartphone);
				}
				System.out.println("Smartphones Saved!");
			} catch (IOException e){
				System.out.println("Unable to save smartphones: " + e.getMessage());
			}
		};
	}
}