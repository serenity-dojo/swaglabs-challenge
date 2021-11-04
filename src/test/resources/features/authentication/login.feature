Feature: Login
  Users need to provide credentials in order to keep the system safe.

  Rule: Customer needs to provide valid credentials to access site

    Example: Colin logs in with valid credentials
      Given Colin is a registered user
      When he logs in using valid credentials
      Then he should be presented with the catalog

    Scenario Outline: Login with invalid credentials
      Given Colin is a registered user
      When Colin registers as a new user
      When Colin attempts to login with "<username>" and "<password>"
      Then he should be refused access because: <outcome>

      Examples:
        | username      | password       | outcome                                                     |
        | standard_user | wrong_password | Username and password do not match any user in this service |
        | unknown_user  | secret_sauce   | Username and password do not match any user in this service |
        |               | secret_sauce   | Username is required                                        |
        | unknown_user  |                | Password is required                                        |
        |               |                | Username is required                                        |

  Rule: Locked-out users should be blocked
    Example: The one where Bob's account is blocked
      Given Bob is a registered user
      But his account is blocked
      When he logs in using valid credentials
      Then he should not be given access to the application
      And he should be provided with instructions on how to unblock his account




