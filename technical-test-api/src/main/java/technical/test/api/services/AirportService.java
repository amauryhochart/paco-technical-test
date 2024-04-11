package technical.test.api.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import technical.test.api.record.AirportRecord;
import technical.test.api.repository.AirportRepository;

@Service
@RequiredArgsConstructor
public class AirportService {
    private final AirportRepository airportRepository;

    public Mono<AirportRecord> findByIataCode(final String iataCode) {
        System.err.println("finding by iata code:" + iataCode);
        return airportRepository.findAirportRecordByIata(iataCode);
//        return airportRepository.findById(iataCode);
    }
}
