package deti.tqs.backend.models;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class BusTrip {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "idFromCity")
  private long idFromCity;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "idToCity")
  private long idToCity;

  @Column(name = "price", nullable = false)
  private double price;

  @Column(name = "date", nullable = false)
  private Date date;

  @Column(name = "availableSeats", nullable = false)
  private int availableSeats;

  public BusTrip() {}

  public BusTrip(long idFromCity, long idToCity, double price, Date date, int availableSeats) {
    this.idFromCity = idFromCity;
    this.idToCity = idToCity;
    this.price = price;
    this.date = date;
    this.availableSeats = availableSeats;
  }

  public long getId() {
    return id;
  }

  public long getId_fromCity() {
    return idFromCity;
  }

  public long getId_toCity() {
    return idToCity;
  }

  public double getPrice() {
    return price;
  }

  public Date getDate() {
    return date;
  }

  public int getAvailableSeats() {
    return availableSeats;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setId_fromCity(long id_fromCity) {
    this.idFromCity = id_fromCity;
  }

  public void setId_toCity(long id_toCity) {
    this.idToCity = id_toCity;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public void setAvailableSeats(int availableSeats) {
    this.availableSeats = availableSeats;
  }
}
