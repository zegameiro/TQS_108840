package deti.tqs.backend.models;

import java.util.Random;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Reservation {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @OneToOne(cascade = CascadeType.ALL)
  @Column(name = "id_busTrip", nullable = false)
  private long idBusTrip;

  @Column(name = "firstName", nullable = false)
  private String firstName;
  
  @Column(name = "lastName", nullable = false)
  private String lastName;

  @Column(name = "email", nullable = false)
  private String email;
  
  @Column(name = "phone", nullable = false, length = 9)
  private String phone;

  @Column(columnDefinition = "boolean default false",  name = "isPaid", nullable = false)
  private boolean isPaid;

  public Reservation() {}

  public Reservation(long idBusTrip, String firstName, String lastName, String email, String phone, boolean isPaid) {
    this.idBusTrip = idBusTrip;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
    this.isPaid = isPaid;
  }

  public long getId() {
    return id;
  }

  public long getIdBusTrip() {
    return idBusTrip;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public boolean getIsPaid() {
    return isPaid;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setId() {
    this.id = new Random().nextLong();
  }

  public void setIdBusTrip(long idBusTrip) {
    this.idBusTrip = idBusTrip;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setIsPaid(boolean isPaid) {
    this.isPaid = isPaid;
  }
}
