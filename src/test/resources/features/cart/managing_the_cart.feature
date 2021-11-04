Feature: Managing the shopping cart

  Rule: The number of items currently in the cart should be presented at all times
    Example: Adding items to an empty basket
      Given Colin has authenticated successfully
      And his cart is empty
      When he adds the following items to his cart:
        | Backpack     |
        | Bolt T-shirt |
      Then the basket item count should be <2>
      And the basket should only contain those items

    Example: Adding items to a basket that already contains other items
      Given Colin has authenticated successfully
      When he adds a Backpack and a Bolt T-shirt to a basket containing only a Onesie
      Then his basket includes a Backpack, a Bolt T-shirt and a Onesie only