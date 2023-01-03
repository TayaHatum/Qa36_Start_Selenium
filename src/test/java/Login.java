import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class Login {

    WebDriver wd;

    @BeforeMethod
    public void preCondition() {
        // open browser
        wd = new ChromeDriver();
        // open site
        wd.get("https://telranedu.web.app");
    }

    @Test
    public void findElementsOnPage() {
        // by tagName
        WebElement element = wd.findElement(By.tagName("div"));
        List<WebElement> divs = wd.findElements(By.tagName("div"));

        // By id
        WebElement el1 = wd.findElement(By.id("root"));
        // By class
        WebElement el2 = wd.findElement(By.className("container"));
        // By name
        //wd.findElement(By.name("name"));

        // By link text a href
        wd.findElement(By.linkText("HOME"));
        wd.findElement(By.linkText("ABOUT"));
        wd.findElement(By.partialLinkText("HO"));

    }

    @Test
    public void loginSuccess() {
        // open form
        // wd find item + click

        WebElement itemLogin = wd.findElement(By.linkText("LOGIN"));
        itemLogin.click();

        // fill form
        // find email + click + clear + type
        WebElement email = wd.findElement(By.name("email"));
        email.click();
        email.clear();
        email.sendKeys("noa@gmail.com");

        // find password + click +clear + type
        WebElement password = wd.findElement(By.name("password"));
        password.click();
        password.clear();
        password.sendKeys("Nnoa12345$");

        // submit  form
        // find button login + click
        List<WebElement> buttons = wd.findElements(By.tagName("button"));
        WebElement buttonLogin = buttons.get(0);
        buttonLogin.click();

        Assert.assertEquals("", "");
        // ac ==exp
    }

    @Test
    public void registrationSuccess() {

    }

    @Test
    public void ccslocatrstest() {

        // нужно перейти на страницу логина, так как на главной странице мало элементов для поиска и тренировки
        // переход на страницу логина тут:
        wd.findElement(By.linkText("LOGIN")).click();

        // теперь мы на странице логина и тут будем тренироваться


        // На странице логин найти несколько элементов по их  tagname
        wd.findElement(By.tagName("div"));
        wd.findElement(By.cssSelector("div"));
        wd.findElement(By.cssSelector("a"));
        wd.findElement(By.cssSelector("input"));
        wd.findElement(By.cssSelector("button"));
        // ON Login PAGE find some elements by class
        wd.findElement(By.className("container"));
        wd.findElement(By.cssSelector(".container"));
        wd.findElement(By.cssSelector(".active"));  // class='active'
        wd.findElement(By.cssSelector("[class = 'active']"));  // class='active'
        // id
        wd.findElement(By.cssSelector("#root")); /// id='root'
        wd.findElement(By.cssSelector("[id=\"root\"]")); /// id='root'
       // wd.findElement(By.cssSelector("[id="root"]")); /// id='root'
        wd.findElement(By.cssSelector("[id='root']")); /// id='root'

        // На странице логин найти несколько элементов по их  attribute
        wd.findElement(By.cssSelector("[href='/login']"));
        wd.findElement(By.cssSelector("[href$='/login']"));

        //На странице логин найти  элемент с  атрибутом placeholder, значение которого начинается на "Pass"
        wd.findElement(By.cssSelector("[placeholder ='Password']"));
        wd.findElement(By.cssSelector("[placeholder ^='Pass']"));
        //На странице логин найти  элемент с  атрибутом placeholder, значение которого  содержит на  "ass"
        wd.findElement(By.cssSelector("[placeholder *='ass']"));
        //На странице логин найти  элемент с  атрибутом placeholder, значение которого заканчивается на "ord"
        wd.findElement(By.cssSelector("[placeholder $='ord']"));

        // Объединение !!
        //найти элемент div, у которого есть id со значением "root"  и класс со значением container
        wd.findElement(By.cssSelector("div#root.container"));
        wd.findElement(By.cssSelector("div[id='root'][class='container']"));
        // найти элемент а, у которого есть атрибут href со значением /login
        wd.findElement(By.cssSelector("a[href='/login']"));
        // найти элемент input, у которого есть атрибут name cо значением email
        wd.findElement(By.cssSelector("input[name='email']"));
        // найти элемент button, у которого есть атрибут name cо значением login
        wd.findElement(By.cssSelector("button[name='login']"));

        // Поиск по дочерним элементам (* задание со звездоской)
        // Найти кнопку регистрации, как последнего ребенка элемента form


    }

    @AfterMethod
    public void postCondition() {
        // close browser
        // wd.quit();
    }



}
