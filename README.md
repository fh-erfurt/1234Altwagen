# 1234Altwagen

Das Ziel von 1234Altwagen ist eine Platform zu schaffen, auf der Nutzer ihre Gebrauchtwagen an uns (den Händler) verkaufen können oder auch Gebrauchtwagen, die wir im Sortiment haben von uns kaufen können. 

# Funktionen
* Der Nutzer kann 
  * Anfragen zum Verkaufen und kaufen erstellen (maximal 2 aktive Anfragen)
  * seine eigenen Anfragen einsehen
  * noch nicht bearbeitete Anfrage abbrechen
* Der Mitarbeiter kann
  * Anfragen annehmen oder ablehnen
  * Autos, die 1234Altwagen gehören, den verschiedenen Standorten zuweisen
  * von Kunden gekaufte Autos zu einem bestimmten Preis zum Verkauf anbieten
  
# Paketstrukturierung
Der Quellcode ist in 5 Unterpakete des Paketes *de.altwagen* gegliedert. Sie sind nach den zu verwaltenden Objekten gegliedert. Das "car"-package beinhaltet alle Klassen, die zum Verwalten von Autos gehören. Das "domain"-package dient dem Verwalten der Adressklasse und von den Standorten von 1234Altwagen. Das "exceptions"-package enthält alle Exception-Klassen. Das "request"-Package kümmert sich um die Verwaltung der Anfragen der Nutzer. In dem "user"-package findet die gesamte Nutzerverwaltung (Kunde und Mitarbeiter) statt.

Zu jeder Klasse, welche ausreichend Code enthält existiert eine dazugehörige Testklasse im selben package.

Nachfolgend ist die Projektstruktur abgebildet. Das (C) steht für Klasse und das (E) für Enumeration.
## Sourcecode
* de.altwagen
  * car
    * (C) Car
    * (C) CarManager
    * (E) CarStatus
  * domain
    * (C) Address
    * (C) Location
    * (C) LocationManager
  * exceptions
    * (C) CarCountBelowZeroException
  * request
    * (C) Request
    * (C) RequestManager
    * (E) RequestStatus
    * (E) RequestType
  * user
    * (C) Customer
    * (C) Employee
    * (C) User
    * (C) UserManager
    
## Test Klassen
* de.altwagen
  * car
    * (C) CarTest
    * (C) CarManagerTest
  * domain
    * (C) LocationTest
    * (C) LocationManagerTest
  * Request
    * (C) RequestTest
    * (C) RequestManagerTest
  * user
    * (C) CustomerTest
    * (C) EmployeeTest
    * (C) UserTest
    * (C) UserManagerTest
    
# Klassendiagramm
Zur Übersicht werden im im folgenden Diagramm die Beziehungen der Klassen dargestellt. Dabei wurde der Inhalt soweit wie möglich reduziert, um sich auf die Klassenbeziehungen zu konzentrieren:
![1234Altwagen Klassenbeziehungen](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/fh-erfurt/1234Altwagen/master/readmeFiles/klassendiagramm.iuml)

# Klassen
Nachfolgend sind die Felder und Methoden der einzelnen Klassen dargestellt. Für die Übersichtlichkeit werden die Getter und Setter nicht mit angezeigt.

## Manager Klassen

Die Manager Klassen verwalten die jeweiligen Klassen in Form von ArrayListen. Sie sind als Singleton-Klassen definiert. Über die Funktion getInstance() wird eine neue Instance oder die vorhandene der Managerklasse zurückgegeben. Das hat den Zweck, dass man von überall auf die selben ArrayListen zugreifen kann.

### CarManager
![1234Altwagen CarManager](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/fh-erfurt/1234Altwagen/master/readmeFiles/CarManager.iuml)

Bemerkungen:
* Die Funktion addNewCar initialisiert ein neues Auto immer mit der Location *null*. Sobald das Auto zum Händler gehört sollte das Auto einer Location zugeordnet werden.

### LocationManager
![1234Altwagen LocationManager](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/fh-erfurt/1234Altwagen/master/readmeFiles/LocationManager.iuml)
### RequestManager
![1234Altwagen RequestManager](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/fh-erfurt/1234Altwagen/master/readmeFiles/RequestManager.iuml)
### UserManager
![1234Altwagen UserManager](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/fh-erfurt/1234Altwagen/master/readmeFiles/UserManager.iuml)

## User Klassen

### User
![1234Altwagen User](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/fh-erfurt/1234Altwagen/master/readmeFiles/User.iuml)

Bemerkungen:
* Die equals-Methode vergleicht auf die Gleichheit der E-Mails, da jeder Nutzer eine eindeutige E-Mail besitzen sollte
* listMyRequests() zeigt alle Requests ungeachtet des RequestType und des RequestStatus zu der dieser User gehört, ob als Customer oder Employee

### Customer
![1234Altwagen Customer](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/fh-erfurt/1234Altwagen/master/readmeFiles/Customer.iuml)

Bemerkungen:
* decreaseRequestCount sollte nicht extern aufgerufen werden. Die Funktion wird automatisch aufgerufen, wenn eine Request akzeptiert, abgelehnt oder abgebrochen wird.

### Employee
![1234Altwagen Employee](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/fh-erfurt/1234Altwagen/master/readmeFiles/Employee.iuml)

## Car Klassen

### Car
![1234Altwagen Car](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/fh-erfurt/1234Altwagen/master/readmeFiles/Car.iuml)

Bemerkungen:
* Die equals-Methode prüft auf Gleichheit der chassisNumber, da jedes Auto eine eindeutige Fahrgestellnummer haben soll

### CarStatus
![1234Altwagen CarStatus](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/fh-erfurt/1234Altwagen/master/readmeFiles/CarStatus.iuml)

## Request Klassen

### Request
![1234Altwagen Request](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/fh-erfurt/1234Altwagen/master/readmeFiles/Request.iuml)

### RequestStatus
![1234Altwagen RequestStatus](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/fh-erfurt/1234Altwagen/master/readmeFiles/RequestStatus.iuml)

### RequestType
![1234Altwagen RequestType](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/fh-erfurt/1234Altwagen/master/readmeFiles/RequestType.iuml)

## Location / Address

### Location
![1234Altwagen Location](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/fh-erfurt/1234Altwagen/master/readmeFiles/Location.iuml)

Bemerkungen:
* Die equals-Methode prüft auf Gleichheit der Adresse, da keine zwei Standorte an einer Adresse sein können.

### Address
![1234Altwagen Address](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/fh-erfurt/1234Altwagen/master/readmeFiles/Address.iuml)

Bemerkungen:
* Die equals-Methode prüft auf Gleichheit aller felder

## Exceptions

### CarCountBelowZeroException
![1234Altwagen CarCountBelowZeroException](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/fh-erfurt/1234Altwagen/master/readmeFiles/CarCountBelowZeroException.iuml)

### DeleteLocationWithCarsException
![1234Altwagen DeleteLocationWithCarsException](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/fh-erfurt/1234Altwagen/master/readmeFiles/DeleteLocationWithCarsException.iuml)

