Feature: Pruebas de la API

  Background:
    * url baseUrl

  Scenario: Test 1
    Given path '/api/v1/prices'
    And param fecha = '2020-06-14 10:00:00'
    And param productId = 35455
    And param brandId = 1
    When method get
    Then status 200
    And match response.price == 35.50

  Scenario: Test 2
    Given path '/api/v1/prices'
    And param fecha = '2020-06-14 16:00:00'
    And param productId = 35455
    And param brandId = 1
    When method get
    Then status 200
    And match response.price == 25.45

  Scenario: Test 3
    Given path '/api/v1/prices'
    And param fecha = '2020-06-14 21:00:00'
    And param productId = 35455
    And param brandId = 1
    When method get
    Then status 200
    And match response.price == 35.50

  Scenario: Test 4
    Given path '/api/v1/prices'
    And param fecha = '2020-06-15 10:00:00'
    And param productId = 35455
    And param brandId = 1
    When method get
    Then status 200
    And match response.price == 30.50

  Scenario: Test 5
    Given path '/api/v1/prices'
    And param fecha = '2020-06-16 21:00:00'
    And param productId = 35455
    And param brandId = 1
    When method get
    Then status 200
    And match response.price == 38.95

  Scenario: Price not found
    Given path '/api/v1/prices'
    And param fecha = '2020-06-16 21:00:00'
    And param productId = 35455
    And param brandId = 2
    When method get
    Then status 400
    And match response == { cod_response: '001', des_response: 'Precio no encontrado.' }

  Scenario: Required parameters
    Given path '/api/v1/prices'
    When method get
    Then status 400
    And match response == { cod_response: '400', des_response: 'Parametros requeridos.' }