package technical.test.api.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import technical.test.api.record.FlightRecord;
import technical.test.api.repository.FlightRepository;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;

    /**
     * Service for the method getAllFlights to do the transition from the repository to the facade.
     *
     * @return a flux of FlightRecord
     */
    public Flux<FlightRecord> getAllFlights() {
        return flightRepository.findAll();
    }

    /**
     * Service for the method createFlight to do the transition from the repository to the facade.
     *
     * @param flightRecord data we want to store as new flight record
     * @return a mono flux of FlightRecord
     */
    public Mono<FlightRecord> createFlight(FlightRecord flightRecord) {
        return flightRepository.save(flightRecord);
    }

    /**
     * Service for the method getAllFlightsOrderByPriceOrLocalisation to do the transition from the repository to the facade.
     *
     * @param filter for sorting in the repository
     * @return a flux of FlightRecord
     */
    public Flux<FlightRecord> getAllFlightsOrderByPriceOrLocalisation(String filter) {
        return flightRepository.findAll(Sort.by(filter));
    }

}
