Feature: Find distance between two places using the Google Maps Distance Matrix API
  The Google Maps Distance Matrix API is a service that provides travel distance and time for a matrix of origins and destinations,
  based on the recommended route between start and end points.

  #Activity1: Add a new row in the 'Examples' table below to find the distance between
  #Washington,DC and New York City, NY in metric
  @test
  Scenario Outline: API Test 01: Find the distance between two places and verify if the status is OK
    Given that I want to find the distance between <origin> and <destination> in <units>
    When I send valid request to Distance Matrix API
    Then the status is 'OK'

    Examples:
    |origin|destination|units|
    |Edinburgh,UK|Glasgow,UK|imperial|
    #|Washington,DC|New York City, NY|metric|

  #Activity2: Create a new scenario to find the travel time between any two places when mode of travel is 'bicycling'
  @test
  Scenario: API Test 02: Find the time taken to travel between two places in England and verify if the status is OK
    Given that I want to find the 'bicycling' time between 'origin' and 'destination'
    When I send valid request to Distance Matrix API
    Then the status is 'OK'


