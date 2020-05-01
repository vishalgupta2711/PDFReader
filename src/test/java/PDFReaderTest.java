import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PDFReaderTest {

	@Test
	public void readPDFTest() throws IOException {
		
		System.setProperty("webdriver.ch	rome.driver","F:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.africau.edu/images/default/sample.pdf");
		
		//driver.get("file:///C:/Users/Ravindra/Downloads/Vishal%20Gupta%20report%20.pdf");
		
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		
		URL url = new URL(currentURL);
		InputStream is = url.openStream();
		
		BufferedInputStream fileParse = new BufferedInputStream(is);
		PDDocument document = null;
		
		document = PDDocument.load(fileParse);
		String pdfContent = new PDFTextStripper().getText(document);
		
		System.out.println(pdfContent);
		
		Assert.assertTrue(pdfContent.contains("paint dry"));
		Assert.assertTrue(pdfContent.contains("The end, and just as well"));
		
		
	}
	
}
