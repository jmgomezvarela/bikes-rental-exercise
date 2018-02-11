# Intive FDV Bikes Rental

Based on the SOLID principles and TDD the project allows to calculate the total amount of different rents and also the combinations of that rents.


## Technologies

* Java 1.8

```
It give me the chance to use Lambda expressions and the Stream API.
```

* LogBack 1.2.3

```
To add logging in the application, note: The logback.xml is configured just to write on the Java Console, 
but it is simple to change to write to a file.
```

* JUnit 4.12

```
To Perform the unit tests.
```

* Jacoco 0.7.9

```
Jacoco provides tools to messure the code coverage and also create repots about the status of each Java
method, the idea is a coverage ratio over the 85%.
```


## Design

The Challenge is to design a solution adaptable to future changes and reusable but in a simple design. Using the SOLID principles and TDD, thinking in a posible future change that the model have to be stored in a database and also a chance of new user cases or changes in the bussiness scale, with the idea to minimize the impact of future changes, the rents class like HourRental, DayRental and WeekRental extends from Rental class and implements the IRentalSubtotal. The model was thinking in the code reuse and a adaptive software Development. 

## Developed practices

The combination of 3 patterns had been used to development the app.

* Factory 
```
To provide differents intances of Hour, Day and Week Rental depending of the request from the client.
```

* Composite

```
Because the Familiar rental is the composition of several other rentals, for example 1 FamiliarRental = 3 
differents bikes for 3 hs each, 1 bike for a Week and 1 bike for 2 days. The common interface IRentalSubTotal, the
implemenatation of the method calculateSubtotal will different for each class (DayRental, WeekRental, HourRental) 
and in the case of the RentalCoposite class this method will be calculate the sum of all the others classes that performs 
the clients rentals.
```

* Strategy

```
To apply the discount in case the context indicates the conditions goes to a discount. If tomorrow a 
new promotion is added or the existing promotion is removed or change for other marketing conditions 
the impact of the change will be minimal for the project and easy to change the app behavior. The Single 
responsibility principle and the open/closed principle are guaranteed.
```


## Running the tests

I used Maven, for this reason to run the test is a mandatory tool.

### Steps to run the tests:

1. Clone or Download the repo
2. Navigate to the root folder of the repo
3. Using a terminal run the command **mvn clean test**
4. The reports will be generated in bikes-rental-intive/target/site/jacoco-unittest/index.html 
