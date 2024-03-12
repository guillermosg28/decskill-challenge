package dev.guillermosg.decskillchallenge.infrastructure.adapters.input.rest;

import dev.guillermosg.decskillchallenge.application.ports.dto.ErrorDTO;
import dev.guillermosg.decskillchallenge.infrastructure.adapters.input.rest.data.PriceResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Prices rest adapter integration test.
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PricesRestAdapterIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * Test 1.
     */
    @Test
    public void test1() {
        ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity("/api/v1/prices?fecha=2020-06-14 10:00:00&productId=35455&brandId=1", PriceResponseDto.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(new BigDecimal("35.50"), response.getBody().getPrice());
    }

    /**
     * Test 2.
     */
    @Test
    public void test2() {
        ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity("/api/v1/prices?fecha=2020-06-14 16:00:00&productId=35455&brandId=1", PriceResponseDto.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(new BigDecimal("25.45"), response.getBody().getPrice());
    }

    /**
     * Test 3.
     */
    @Test
    public void test3() {
        ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity("/api/v1/prices?fecha=2020-06-14 21:00:00&productId=35455&brandId=1", PriceResponseDto.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(new BigDecimal("35.50"), response.getBody().getPrice());
    }

    /**
     * Test 4.
     */
    @Test
    public void test4() {
        ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity("/api/v1/prices?fecha=2020-06-15 10:00:00&productId=35455&brandId=1", PriceResponseDto.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(new BigDecimal("30.50"), response.getBody().getPrice());
    }

    /**
     * Test 5.
     */
    @Test
    public void test5() {
        ResponseEntity<PriceResponseDto> response = restTemplate.getForEntity("/api/v1/prices?fecha=2020-06-16 21:00:00&productId=35455&brandId=1", PriceResponseDto.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(new BigDecimal("38.95"), response.getBody().getPrice());
    }

    /**
     * Price not found.
     */
    @Test
    public void priceNotFound() {
        ResponseEntity<ErrorDTO> response = restTemplate.getForEntity("/api/v1/prices?fecha=2020-06-16 21:00:00&productId=35455&brandId=2", ErrorDTO.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("001", response.getBody().getCodResponse());
        assertEquals("Precio no encontrado.", response.getBody().getDesResponse());
    }

    /**
     * required Parameters
     */
    @Test
    public void requiredParameters() {
        ResponseEntity<ErrorDTO> response = restTemplate.getForEntity("/api/v1/prices", ErrorDTO.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("400", response.getBody().getCodResponse());
        assertEquals("Parametros requeridos.", response.getBody().getDesResponse());
    }

}

