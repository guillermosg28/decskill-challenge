package dev.guillermosg.decskillchallenge.infrastructure.adapters.output.persistence.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class PriceEntityTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link PriceEntity}
     *   <li>{@link PriceEntity#setBrandId(Integer)}
     *   <li>{@link PriceEntity#setCurrency(String)}
     *   <li>{@link PriceEntity#setEndDate(LocalDateTime)}
     *   <li>{@link PriceEntity#setId(Long)}
     *   <li>{@link PriceEntity#setPrice(BigDecimal)}
     *   <li>{@link PriceEntity#setPriceList(Integer)}
     *   <li>{@link PriceEntity#setPriority(Integer)}
     *   <li>{@link PriceEntity#setProductId(Integer)}
     *   <li>{@link PriceEntity#setStartDate(LocalDateTime)}
     *   <li>{@link PriceEntity#getBrandId()}
     *   <li>{@link PriceEntity#getCurrency()}
     *   <li>{@link PriceEntity#getEndDate()}
     *   <li>{@link PriceEntity#getId()}
     *   <li>{@link PriceEntity#getPrice()}
     *   <li>{@link PriceEntity#getPriceList()}
     *   <li>{@link PriceEntity#getPriority()}
     *   <li>{@link PriceEntity#getProductId()}
     *   <li>{@link PriceEntity#getStartDate()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        PriceEntity actualPriceEntity = new PriceEntity();
        actualPriceEntity.setBrandId(1);
        actualPriceEntity.setCurrency("GBP");
        LocalDateTime endDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualPriceEntity.setEndDate(endDate);
        actualPriceEntity.setId(1L);
        BigDecimal price = new BigDecimal("2.3");
        actualPriceEntity.setPrice(price);
        actualPriceEntity.setPriceList(1);
        actualPriceEntity.setPriority(1);
        actualPriceEntity.setProductId(1);
        LocalDateTime startDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualPriceEntity.setStartDate(startDate);
        Integer actualBrandId = actualPriceEntity.getBrandId();
        String actualCurrency = actualPriceEntity.getCurrency();
        LocalDateTime actualEndDate = actualPriceEntity.getEndDate();
        Long actualId = actualPriceEntity.getId();
        BigDecimal actualPrice = actualPriceEntity.getPrice();
        Integer actualPriceList = actualPriceEntity.getPriceList();
        Integer actualPriority = actualPriceEntity.getPriority();
        Integer actualProductId = actualPriceEntity.getProductId();
        LocalDateTime actualStartDate = actualPriceEntity.getStartDate();

        // Assert that nothing has changed
        assertEquals("GBP", actualCurrency);
        assertEquals(1, actualBrandId.intValue());
        assertEquals(1, actualPriceList.intValue());
        assertEquals(1, actualPriority.intValue());
        assertEquals(1, actualProductId.intValue());
        assertEquals(1L, actualId.longValue());
        assertEquals(new BigDecimal("2.3"), actualPrice);
        assertSame(price, actualPrice);
        assertSame(endDate, actualEndDate);
        assertSame(startDate, actualStartDate);
    }
}
