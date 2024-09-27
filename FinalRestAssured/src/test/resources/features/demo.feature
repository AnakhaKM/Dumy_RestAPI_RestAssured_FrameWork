Feature: Validate API Test for Free Fake API

  Scenario: Verify user can create record
    Given user wants to call "create" end point
    And   set header "Content-Type" to "application/json"
    And   set request body from the file "create_record.json" using pogo class
    When  user performs post call
    And   verify id is not empty
    And   stores created id into "record.id"
    Then  verify status code is 200

  Scenario: verify user can get records
    Given user wants to call "employee/@id" end point
    And   set header "Content-Type" to "application/json"
    When  user performs get call
    Then  verify status code is 200

  Scenario: verify user can delete records
    Given user wants to call "delete/@id" end point
    And   set header "Content-Type" to "application/json"
    When  user performs delete call
    Then  verify status code is 200

  Scenario: verify user can update
    Given user wants to call "update/@id" end point
    And   set header "Content-Type" to "application/json"
    And   set request body from the file "update_record.json" using pogo class
    When  user performs put call
    Then  verify status code is 200

