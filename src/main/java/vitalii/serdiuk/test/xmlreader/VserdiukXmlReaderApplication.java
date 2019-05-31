package vitalii.serdiuk.test.xmlreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import vitalii.serdiuk.test.xmlreader.service.XmlService;

import java.io.File;
import java.net.URL;

@SpringBootApplication
public class VserdiukXmlReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(VserdiukXmlReaderApplication.class, args);
		VserdiukXmlReaderApplication vserdiukXmlReaderApplication = new VserdiukXmlReaderApplication();
		File xmlFile = new File(String.valueOf(vserdiukXmlReaderApplication.getFileFromResources("test.xml")));

		ConfigurableApplicationContext context = SpringApplication.run(VserdiukXmlReaderApplication.class, args);
		XmlService xmlService =  context.getBean(XmlService.class);
		xmlService.saveXmlDataInDb(xmlFile);
	}

	private File getFileFromResources(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		URL resource = classLoader.getResource(fileName);
		if (resource == null) {
			throw new IllegalArgumentException("file is not found!");
		} else {
			return new File(resource.getFile());
		}
	}

}
