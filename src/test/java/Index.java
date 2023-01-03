import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Index {
    WebDriver wd;


    @BeforeMethod
    public void start(){
        wd = new ChromeDriver();
        wd.get("file:///Users/tayahatum/Downloads/apk/index.html");
        wd.manage().window().maximize();

    }

    @Test
    public void itemsTests(){
        // find Item1 & click() ===> assert that "div-alert" contains message  "Clicked by Item 1"
        wd.findElement(By.cssSelector("a")).click();

        WebElement container = wd.findElement(By.cssSelector("#alert"));
        String message = container.getText();
        System.out.println("Text of container is -->" +message);
        Assert.assertTrue(message.contains("Clicked by Item 1"));
        Assert.assertTrue(message.equals("Clicked by Item 1"));
        Assert.assertEquals(message,"Clicked by Item 1");

        // find Item3 & click() ===> assert that "div-alert" contains message  "Clicked by Item 3"
        WebElement item3 = wd.findElement(By.xpath("//li[3]"));
        item3.click();
        String item3Text = item3.getText(); /// Item 3
        message = container.getText(); // Clicked by Item 3
        Assert.assertTrue(message.contains(item3Text));


    }

    @Test
    public void formTests(){
     // fill name & fill surename & click send
        WebElement name = wd.findElement(By.xpath("//input[1]"));
        name.click();
        name.clear();
        name.sendKeys("עגרדלו");

        String inputText = name.getAttribute("value");
        System.out.println("!!!! " +inputText);
        WebElement sureName = wd.findElement(By.xpath("//input[2]"));
        sureName.click();
        sureName.clear();
        sureName.sendKeys("First");

        wd.findElement(By.xpath("//button")).click();
        // Assert that "div-alert" contains text with name + surename
        WebElement container = wd.findElement(By.cssSelector("#alert"));
        String message = container.getText();
        //  Assert.assertEquals(message,"עגרדלו First");
        Assert.assertTrue(message.contains(inputText));
        System.out.println("חיכאטגע");
    }

    @Test
    public void tableTest(){
        // проверить правда ли в таблице 4 строки

        List<WebElement> rows = wd.findElements(By.cssSelector("tr"));
        Assert.assertEquals(rows.size(),4);

        // правда ли что последння строка сожержит строку Mexico
        WebElement lastRow = wd.findElement(By.cssSelector("tr:last-child"));
        String text = lastRow.getText();
        System.out.println(text);
        //   "Poland Chine Mexico" contains "Mexico"
        Assert.assertTrue(text.contains("Mexico"));
// правда ли что последняя ячейка сожержит строку Mexico
        WebElement lastCell = wd.findElement(By.cssSelector("tr:last-child td:last-child"));
        String str = lastCell.getText();
        boolean res =str.contains("Mexico");
        Assert.assertTrue(str.contains("Mexico"));
        Assert.assertTrue(res);


    }

}
