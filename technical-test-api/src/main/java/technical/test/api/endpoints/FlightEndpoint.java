package technical.test.api.endpoints;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import technical.test.api.facade.FlightFacade;
import technical.test.api.representation.FlightRepresentation;

@RestController
@RequestMapping("/flight")
@RequiredArgsConstructor
public class FlightEndpoint {
    private final FlightFacade flightFacade;

    @GetMapping
    public Flux<FlightRepresentation> getAllFlights(@RequestParam @Nullable Long resultNumber) {
        if (resultNumber != null) {
            return flightFacade.getAllFlights().take(resultNumber);
        }
        return flightFacade.getAllFlights();
    }

    /**
     * Endpoint to create a flight in database.
     *
     * @param flightRepresentation attributes of the flight (body of the request)
     * @return the flight representation of the new created flight
     */
    @PostMapping
    public Mono<FlightRepresentation> createFlight(@RequestBody FlightRepresentation flightRepresentation) {
        return flightFacade.createFlight(flightRepresentation);
    }


    /**
     * Endpoint to get all the flights but filtered/ordered by price, origin, destination...
     *
     * @param filterParam  filer parameter (price, origin, destination...)
     * @param resultNumber nullable number of results for pagination
     * @return a flux of all representation flights returned
     */
    @GetMapping("/filter")
    public Flux<FlightRepresentation> getAllFlightsFiltered(@RequestParam String filterParam, @RequestParam @Nullable Long resultNumber) {
        if (filterParam.isBlank()) {
            return Flux.error(new IllegalArgumentException("filterParam is null"));
        }
        if (resultNumber != null) {
            return flightFacade.getAllFlightsOrderByPriceOrLocalisation(filterParam).take(resultNumber);
        }
        return flightFacade.getAllFlightsOrderByPriceOrLocalisation(filterParam);
    }
}
