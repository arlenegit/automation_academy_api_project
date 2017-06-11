Feature: Find distance between two places using the Google Maps Distance Matrix API
  The Google Maps Distance Matrix API is a service that provides travel distance and time for a matrix of origins and destinations,
  based on the recommended route between start and end points.

  @test
  Scenario Outline: API Test 01: Find the distance between two places and verify if the status is OK
    Given that I want to find the distance between <origin> and <destination> in <units>
    When I send the request to Distance Matrix API
    Then the status is 'OK'

    Examples:
    |origin|destination|units|
    |Edinburgh,UK|Glasgow,UK|metric|
    |York,UK|London,UK|imperial|
    |Washington,DC|New York City, NY|metric|

  @test
  Scenario: API Test 02: Verify the status is INVALID_REQUEST if the origin is missing in the request
    Given I send the request to Distance Matrix API
    When the value of origin is blank
    Then the status is 'INVALID_REQUEST'
