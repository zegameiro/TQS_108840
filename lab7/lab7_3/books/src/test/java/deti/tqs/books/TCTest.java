package deti.tqs.books;

import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import static org.assertj.core.api.Assertions.assertThat;

import deti.tqs.books.models.Student;
import deti.tqs.books.repository.StudentRepository;

@Testcontainers
@SpringBootTest
public class TCTest {
  
    @Autowired
    private StudentRepository studentRepository;

    @SuppressWarnings("rawtypes")
    @Container
    @Order(1)
    public static PostgreSQLContainer container = new PostgreSQLContainer<>("postgres:14")
      .withUsername("zegameiro")
      .withPassword("tqsUA")
      .withDatabaseName("tqsBooks");

    @DynamicPropertySource
    @Order(2)
    static void properties(DynamicPropertyRegistry registry) {
      registry.add("spring.datasource.url", container::getJdbcUrl);
      registry.add("spring.datasource.password", container::getPassword);
      registry.add("spring.datasource.username", container::getUsername);
    }

    @Test
    @DisplayName("Test add Student")
    @Order(3)
    void testadd() {
      Student s = new Student();
      s.setAge(29);
      s.setEmail("cristiano@gmail.com");
      s.setNome("Cristiano");
      s.setNmec(6351);

      studentRepository.save(s);

      Student result = studentRepository.findById(6351).get();

      assertThat(result.getAge()).isEqualTo(29);
      assertThat(result.getNome()).isEqualTo("Cristiano");
    }

    @Test 
    @DisplayName("Test update student")
    @Order(4)
    void testupdate() {
      Student s = new Student();
      s.setAge(20);
      s.setEmail("mariana@ua.pt");
      s.setNome("Mariana");
      s.setNmec(90421);

      studentRepository.save(s);

      Student result = studentRepository.findById(90421).get();

      result.setNome("Mariana");
      studentRepository.save(result);

      Student result2 = studentRepository.findById(90421).get();
      
      assertThat(result2.getNome()).isEqualTo("Mariana");
    }

    @Test
    @DisplayName("Test delete student")
    @Order(5)
    void testdelete() {
      Student s = new Student();
      s.setAge(20);
      s.setEmail("diogo@ua.pt");
      s.setNome("Diogo");
      s.setNmec(847124);

      studentRepository.save(s);

      studentRepository.deleteById(847124);

      assertThat(studentRepository.findById(847124)).isEmpty();
    }

    @Test
    @DisplayName("Test get student inserted in .sql")
    @Order(6)
    void testget() {
      Student result = studentRepository.findById(999).get();
      assertThat(result.getNome()).isEqualTo("João");
    }
}
