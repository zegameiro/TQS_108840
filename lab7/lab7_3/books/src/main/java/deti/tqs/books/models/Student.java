package deti.tqs.books.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Student {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int nmec;
  private int age;
  private String name;
  private String email;

  public Student() {}

  public int getNmec() {
    return nmec;
  }

  public void setNmec(int nmec) {
    this.nmec = nmec;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getNome() {
    return name;
  }

  public void setNome(String nome) {
    this.name = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
