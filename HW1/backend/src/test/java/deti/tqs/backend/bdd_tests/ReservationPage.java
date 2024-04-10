package deti.tqs.backend.bdd_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class ReservationPage {
  
  private final WebDriver driver;

  ReservationPage(WebDriver driver) {
    this.driver = driver;
  }

  void chooseSeat(String seatNumber) {
    driver.findElement(By.id(seatNumber)).click();
  }

  String getPrice() {
    return driver.findElement(By.cssSelector(".flex:nth-child(4) > span:nth-child(2)")).getText();
  }

  boolean isSeatAvailable(String seatNumber) {
    return driver.findElement(By.id(seatNumber)).isEnabled();
  }

  void fillInFirstName(String firstName) {
    driver.findElement(By.id("first_name")).sendKeys(firstName);
  }

  void fillInLastName(String lastName) {
    driver.findElement(By.id("last_name")).sendKeys(lastName);
  }

  void fillInEmail(String email) {
    driver.findElement(By.id("email")).sendKeys(email);
  }

  void fillInPhone(String phone) {
    driver.findElement(By.id("phone_number")).sendKeys(phone);
  }

  void clickBuyReservationButton() {
    driver.findElement(By.cssSelector(".btn-success")).click();
  }

}