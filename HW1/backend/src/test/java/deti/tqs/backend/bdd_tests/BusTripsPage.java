package deti.tqs.backend.bdd_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class BusTripsPage {
  
  private final WebDriver driver;
  
  BusTripsPage(WebDriver driver) {
    this.driver = driver;
  }

  // Choose Castelo Branco - Figueira da Foz trip
  void chooseTripButton() {
    driver.findElement(By.cssSelector(".btn-sm")).click();
  }

  String getFromCity() {
    return driver.findElement(By.id("from_city")).getText();
  }

  String getToCity() {
    return driver.findElement(By.id("to_city")).getText();
  }

  String getBusName() {
    return driver.findElement(By.id("bus_name")).getText();
  }

}
