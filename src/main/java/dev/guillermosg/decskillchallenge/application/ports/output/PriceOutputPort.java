package dev.guillermosg.decskillchallenge.application.ports.output;

import dev.guillermosg.decskillchallenge.domain.model.PriceResponse;

import java.util.List;

/**
 * The interface Price output port.
 */

public interface PriceOutputPort {

    /**
     * @param productId
     * @param brandId
     * @return List<PriceResponse>
     */
    List<PriceResponse> _prices(Integer productId, Integer brandId);
}
