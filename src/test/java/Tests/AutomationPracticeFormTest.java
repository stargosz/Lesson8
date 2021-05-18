package Tests;

import TestBase.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AutomationPracticeFormTest extends TestBase {
    private Logger logger = LoggerFactory.getLogger("AutomationPracticeFormTest.class");
    Random rnd = new Random();

    String url;
    String firstName;
    String lastName;
    String email;
    String age;
    int radioSexIndex;
    int checkboxProfessionIndex;
    String continent;
    int seleniumCommandIndex;
    String filePath;
    String message;

    @Test
    public void shouldFillFormWithSuccess() {
        url = "https://seleniumui.moderntester.pl/form.php";
        getDriver().get(url);
        logger.info("Webpage url: " +url);
        firstName = "John";
        getDriver().findElement(By.cssSelector("#inputFirstName3")).sendKeys(firstName);
        lastName = "Mayer";
        getDriver().findElement(By.cssSelector("#inputLastName3")).sendKeys(lastName);
        logger.debug("First name set to: {} and last name set to: {}", firstName, lastName );
        email = "JohnMarye@gmail.com";
        getDriver().findElement(By.cssSelector("#inputEmail3")).sendKeys(email);
        logger.debug("Email set to: "+email);
        radioSexIndex = 0;
        getDriver().findElements(By.cssSelector("[name='gridRadiosSex']")).get(radioSexIndex).click();
        logger.debug("Radio button of index "+radioSexIndex+" selected");
        age = "23";
        getDriver().findElement(By.cssSelector("#inputAge3")).sendKeys(age);
        logger.debug("Age set to: "+age);
        List<WebElement> gridRadiosExperience = getDriver().findElements(By.cssSelector("[name='gridRadiosExperience']"));
        logger.debug("Number of 'years of experience' radios: "+ gridRadiosExperience.size());
        int index = rnd.nextInt(gridRadiosExperience.size());
        if (!gridRadiosExperience.get(index).isSelected()) {
            gridRadiosExperience.get(index).click();
        }
        logger.debug("Selected random radio button of index: "+index);
        checkboxProfessionIndex = 1;
        getDriver().findElements(By.cssSelector("[name='gridCheckboxProfession")).get(checkboxProfessionIndex).click();
        logger.debug("Checkbox of index: "+checkboxProfessionIndex+" properly selected");
        continent = "north-america";
        Select continents = new Select(getDriver().findElement(By.cssSelector("#selectContinents")));
        continents.selectByValue(continent);
        logger.debug("Selected continent: "+continent);
        seleniumCommandIndex = 3;
        Select seleniumCommands = new Select(getDriver().findElement(By.cssSelector("#selectSeleniumCommands")));
        seleniumCommands.selectByIndex(seleniumCommandIndex);
        logger.debug("Selected by index "+seleniumCommandIndex);
        filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\Files\\File.txt";
        getDriver().findElement(By.cssSelector("#chooseFile")).sendKeys(filePath);
        logger.debug("File path set to: "+ filePath);
        getDriver().findElement(By.cssSelector(".btn-primary")).click();
        logger.debug("'Sign in' button properly clicked");
        WebElement msg = getDriver().findElement(By.cssSelector("#validator-message"));
        logger.debug("Message displayed: " + msg.getText());
        message = "Form send with success";
        assertThat(msg.getText(), is(message));
    }
}


