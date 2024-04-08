package deti.tqs.backend.configuration;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import deti.tqs.backend.models.Bus;
import deti.tqs.backend.models.BusTrip;
import deti.tqs.backend.models.Seat;
import deti.tqs.backend.repositories.BusRepository;
import deti.tqs.backend.repositories.BusTripRepository;

@Component
@ConditionalOnProperty(name = "spring.profiles.active", havingValue = "dev")
public class Configuration implements ApplicationRunner {
  
  private static final Logger logger = LoggerFactory.getLogger(Configuration.class);

  @Autowired
  private BusRepository busRepository;

  @Autowired
  private BusTripRepository busTripRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {

    logger.info("Creating default values");

    String firstClass = "First Class";

    Bus bus1 = new Bus();
    bus1.setName("Flix Bux 1");
    bus1.setCapacity(60);

    int bus1Id = busRepository.save(bus1).getId();

    Bus bus2 = new Bus();
    bus2.setName("Bus Bud 1");
    bus2.setCapacity(50);
    
    int bus2Id = busRepository.save(bus2).getId();

    Bus bus3 = new Bus();
    bus3.setName("Expresso Bus 1");
    bus3.setCapacity(40);

    int bus3Id = busRepository.save(bus3).getId();

    Bus bus4 = new Bus();
    bus4.setName("Flix Bus 2");
    bus4.setCapacity(45);

    int bus4Id = busRepository.save(bus4).getId();

    Bus bus5 = new Bus();
    bus5.setName("Bus Bud 2");
    bus5.setCapacity(55);

    int bus5Id = busRepository.save(bus5).getId();

    Bus bus6 = new Bus();
    bus6.setName("Expresso Bus 2");
    bus6.setCapacity(35);

    int bus6Id = busRepository.save(bus6).getId();


    logger.info("Buses created");


    BusTrip busTrip1 = new BusTrip();
    busTrip1.setFromCity("Leiria");
    busTrip1.setToCity("Lisboa");
    busTrip1.setBusId(bus1Id);
    busTrip1.setPrice(9.0);
    busTrip1.setDate("2005-04-09");
    busTrip1.setTime("09h00");

    ArrayList<Seat> seats1 = new ArrayList<Seat>(bus1.getCapacity());

    for (int i = 0; i < bus1.getCapacity(); i++) {
      seats1.add(new Seat());
      if (i % 5 == 0) {
        seats1.get(i).setSeatType(firstClass);
      }
    }

    busTrip1.setSeats(seats1);

    BusTrip busTrip2 = new BusTrip();
    busTrip2.setFromCity("Aveiro");
    busTrip2.setToCity("Mirandela");
    busTrip2.setBusId(bus2Id);
    busTrip2.setPrice(25.0);
    busTrip2.setDate("2014-06-21");
    busTrip2.setTime("21h30");

    ArrayList<Seat> seats2 = new ArrayList<Seat>(bus2.getCapacity());

    for (int i = 0; i < bus2.getCapacity(); i++) {
      seats2.add(new Seat());
      if (i % 4 == 0) {
        seats2.get(i).setSeatType(firstClass);
      }
    }

    busTrip2.setSeats(seats2);

    BusTrip busTrip3 = new BusTrip();
    busTrip3.setFromCity("Porto");
    busTrip3.setToCity("Faro");
    busTrip3.setBusId(bus3Id);
    busTrip3.setPrice(46.5);
    busTrip3.setDate("2021-04-16");
    busTrip3.setTime("08h00");

    ArrayList<Seat> seats3 = new ArrayList<Seat>(bus3.getCapacity());

    for (int i = 0; i < bus3.getCapacity(); i++) {
      seats3.add(new Seat());
      if (i % 7 == 0) {
        seats3.get(i).setSeatType(firstClass);
      }
    }

    busTrip3.setSeats(seats3);


    BusTrip busTrip4 = new BusTrip();
    busTrip4.setFromCity("Santarém");
    busTrip4.setToCity("Coimbra");
    busTrip4.setBusId(bus4Id);
    busTrip4.setPrice(13.6);
    busTrip4.setDate("2020-12-12");
    busTrip4.setTime("12h30");

    ArrayList<Seat> seats4 = new ArrayList<Seat>(bus4.getCapacity());

    for (int i = 0; i < bus4.getCapacity(); i++) {
      seats4.add(new Seat());
      if (i % 3 == 0) {
        seats4.get(i).setSeatType(firstClass);
      }
    }

    busTrip4.setSeats(seats4);


    BusTrip busTrip5 = new BusTrip();
    busTrip5.setFromCity("Castelo Branco");
    busTrip5.setToCity("Figueira da Foz");
    busTrip5.setBusId(bus5Id);
    busTrip5.setPrice(18.0);
    busTrip5.setDate("2022-01-01");
    busTrip5.setTime("15h43");

    ArrayList<Seat> seats5 = new ArrayList<Seat>(bus5.getCapacity());

    for (int i = 0; i < bus5.getCapacity(); i++) {
      seats5.add(new Seat());
      if (i % 6 == 0) {
        seats5.get(i).setSeatType(firstClass);
      }
    }

    busTrip5.setSeats(seats5);


    BusTrip busTrip6 = new BusTrip();
    busTrip6.setFromCity("Viseu");
    busTrip6.setToCity("Viana do Castelo");
    busTrip6.setBusId(bus6Id);
    busTrip6.setPrice(30.0);
    busTrip6.setDate("2003-01-06");
    busTrip6.setTime("17h23");

    ArrayList<Seat> seats6 = new ArrayList<Seat>(bus6.getCapacity());

    for (int i = 0; i < bus6.getCapacity(); i++) {
      seats6.add(new Seat());
      if (i % 9 == 0) {
        seats6.get(i).setSeatType(firstClass);
      }
    }

    busTrip6.setSeats(seats6);

    busTripRepository.save(busTrip1);
    busTripRepository.save(busTrip2);
    busTripRepository.save(busTrip3);
    busTripRepository.save(busTrip4);
    busTripRepository.save(busTrip5);
    busTripRepository.save(busTrip6);

    logger.info("Bus trips created");
  }
}
