package technical.test.api.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import technical.test.api.mapper.AirportMapper;
import technical.test.api.mapper.FlightMapper;
import technical.test.api.record.AirportRecord;
import technical.test.api.record.FlightRecord;
import technical.test.api.representation.FlightRepresentation;
import technical.test.api.services.AirportService;
import technical.test.api.services.FlightService;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class FlightFacade {
    private final FlightService flightService;
    private final AirportService airportService;
    private final FlightMapper flightMapper;
    private final AirportMapper airportMapper;

    /**
     * Facade for the method getAllFlights to do the transition from the service to the endpoint controller.
     *
     * @return a flux of FlightRepresentation
     */
    public Flux<FlightRepresentation> getAllFlights() {
        return flightService.getAllFlights().flatMap(getFlightRecordMonoFunction());
    }

    /**
     * Facade for the method createFlight to do the transition from the service to the endpoint controller.
     *
     * @param flightRepresentation attributes of the new flight record
     * @return a mono flux of FlightRepresentation
     */
    public Mono<FlightRepresentation> createFlight(FlightRepresentation flightRepresentation) {
        return flightService.createFlight(flightMapper.convert(flightRepresentation)).flatMap(getFlightRecordMonoFunction());
    }

    /**
     * Facade for the method getAllFlightsOrderByPriceOrLocalisation to do the transition from the service to the endpoint controller.
     *
     * @param filter parameter we want to order the results
     * @return a flux of FlightRepresentation
     */
    public Flux<FlightRepresentation> getAllFlightsOrderByPriceOrLocalisation(String filter) {
        return flightService.getAllFlightsOrderByPriceOrLocalisation(filter).flatMap(getFlightRecordMonoFunction());
    }

    /**
     * Method to reduce the size of the code for map records from database to rest controller.
     *
     * @return data ready to be exposed
     */
    private Function<FlightRecord, Mono<? extends FlightRepresentation>> getFlightRecordMonoFunction() {
        return flightRecord -> airportService.findByIataCode(flightRecord.getOrigin()).zipWith(airportService.findByIataCode(flightRecord.getDestination())).flatMap(tuple -> {
            AirportRecord origin = tuple.getT1();
            AirportRecord destination = tuple.getT2();
            FlightRepresentation flight = this.flightMapper.convert(flightRecord);
            flight.setOrigin(this.airportMapper.convert(origin));
            flight.setDestination(this.airportMapper.convert(destination));
            return Mono.just(flight);
        });
    }
}
