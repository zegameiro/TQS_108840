package deti.tqs.backend.bdd_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class HomePage {
  
  private final WebDriver driver;

  HomePage(WebDriver driver) {
    this.driver = driver;
  }

  void openWebsite() {
    driver.get("http:localhost:3000/");
  }

  void selectFromCity(String fromCity) {
    driver.findElement(By.cssSelector(".form-control:nth-child(1) > .select")).click();
    driver.findElement(By.xpath("//option[. = '" + fromCity + "']")).click();
  }

  void selectToCity(String toCity) {
    driver.findElement(By.cssSelector(".form-control:nth-child(3) > .select")).click();
    driver.findElement(By.xpath("//option[. = '" + toCity + "']")).click();
  }

  void clickSearchButton() {
    driver.findElement(By.cssSelector(".btn-accent")).click();
  }

  void clickSeeAllTripsButton() {
    driver.findElement(By.cssSelector(".btn-primary")).click();
  }
}
