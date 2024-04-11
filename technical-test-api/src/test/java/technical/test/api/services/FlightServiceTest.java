package technical.test.api.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import technical.test.api.record.FlightRecord;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
class FlightServiceTest {

    @Autowired
    FlightService flightService;

    /**
     * Test the Service method to get all the flight records in database.
     */
    @Test
    void getAllFlights() {
        // When
        Flux<FlightRecord> flightRecordFlux = flightService.getAllFlights();

        // Then
        Assertions.assertNotNull(flightRecordFlux);
        Assertions.assertNotNull(flightRecordFlux.blockFirst());
    }

    /**
     * Test the Service method to create new flight record.
     */
    @Test
    void createFlight() {
        UUID randomUUID = UUID.randomUUID();
        FlightRecord flightRecord = FlightRecord.builder().id(randomUUID).build();

        // When
        Mono<FlightRecord> newFlightRecord = flightService.createFlight(flightRecord);

        // Then
        Assertions.assertNotNull(newFlightRecord);
        Assertions.assertEquals(flightRecord.getId(), newFlightRecord.block().getId());
    }

    /**
     * Test the Service method to get all the flight records but with a filter inside the request.
     */
    @Test
    void getAllFlightsOrderByPriceOrLocalisation() {
        // When
        Flux<FlightRecord> flightRecordFlux = flightService.getAllFlightsOrderByPriceOrLocalisation("price");

        Double firstFlightRecordPrice = flightRecordFlux.blockFirst().getPrice();
        Double lastFlightRecordPrice = flightRecordFlux.blockLast().getPrice();

        // Then
        Assertions.assertNotNull(flightRecordFlux);
        Assertions.assertTrue(firstFlightRecordPrice < lastFlightRecordPrice);
    }
}