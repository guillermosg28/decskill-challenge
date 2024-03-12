package dev.guillermosg.decskillchallenge.infrastructure.adapters.input.rest;

import dev.guillermosg.decskillchallenge.application.ports.input.PriceUseCase;
import dev.guillermosg.decskillchallenge.infrastructure.adapters.input.rest.data.PriceResponseDto;
import dev.guillermosg.decskillchallenge.infrastructure.adapters.input.rest.mapper.PriceRestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Prices rest adapter.
 */

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/")
public class PricesRestAdapter implements PricesApi {

    private final PriceUseCase priceUseCase;
    private final PriceRestMapper priceRestMapper;

    /**
     * @param fecha     Fecha de aplicación en formato \&quot;2023-14-31 23:59:59\&quot; (required)
     * @param productId Identificador del producto (required)
     * @param brandId   Identificador de la marca (required)
     * @return PriceResponseDto
     */
    @Override
    public ResponseEntity<PriceResponseDto> _prices(String fecha, Integer productId, Integer brandId) {
        return ResponseEntity.ok().body(priceRestMapper.toPriceResponseDto(priceUseCase._prices(fecha, productId, brandId)));
    }
}
