package dev.guillermosg.decskillchallenge.domain.service;

import dev.guillermosg.decskillchallenge.application.ports.input.PriceUseCase;
import dev.guillermosg.decskillchallenge.application.ports.output.PriceOutputPort;
import dev.guillermosg.decskillchallenge.domain.exception.PriceNotFoundException;
import dev.guillermosg.decskillchallenge.domain.model.PriceResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

/**
 * The Price service.
 */

@Service
@AllArgsConstructor
@Slf4j
public class PriceService implements PriceUseCase {

    private final PriceOutputPort priceOutputPort;

    /**
     * @param fecha
     * @param productId
     * @param brandId
     * @return PriceResponse
     */
    @Override
    public PriceResponse _prices(String fecha, Integer productId, Integer brandId) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateFormatter = LocalDateTime.parse(fecha, formatter);

        List<PriceResponse> priceResponses = priceOutputPort._prices(productId, brandId);

        PriceResponse priceResponse = priceResponses.stream()
                .filter(p -> dateFormatter.isAfter(p.getStartDate()) || dateFormatter.isEqual(p.getStartDate()))
                .filter(p -> dateFormatter.isBefore(p.getEndDate()) || dateFormatter.isEqual(p.getEndDate()))
                .max(Comparator.comparingInt(PriceResponse::getPriority))
                .orElseThrow(() -> new PriceNotFoundException());

        return priceResponse;
    }
}
