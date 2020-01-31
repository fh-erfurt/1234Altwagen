# 1234Altwagen

Das Ziel von 1234Altwagen ist eine Platform zu schaffen, auf der Nutzer ihre Gebrauchtwagen an uns (den Händler) verkaufen können oder auch Gebrauchtwagen, die wir im Sortiment haben von uns kaufen können. 

## Funktionen
* Der Nutzer kann 
  * Anfragen zum Verkaufen und kaufen erstellen (maximal 2 aktive Anfragen)
  * seine eigenen Anfragen einsehen
  * noch nicht bearbeitete Anfrage abbrechen
* Der Mitarbeiter kann
  * Anfragen annehmen oder ablehnen
  * Autos, die 1234Altwagen gehören, den verschiedenen Standorten zuweisen
  * von Kunden gekaufte Autos zu einem bestimmten Preis zum Verkauf anbieten
  
## Paketstrukturierung
Der Quellcode ist in 5 Unterpakete des Paketes *de.altwagen* gegliedert. Sie sind nach den zu verwaltenden Objekten gegliedert. Das "car"-package beinhaltet alle Klassen, die zum Verwalten von Autos gehören. Das "domain"-package dient dem Verwalten der Adressklasse und von den Standorten von 1234Altwagen. Das "exceptions"-package enthält alle Exception-Klassen. Das "request"-Package kümmert sich um die Verwaltung der Anfragen der Nutzer. In dem "user"-package findet die gesamte Nutzerverwaltung (Kunde und Mitarbeiter) statt.

Zu jeder Klasse, welche ausreichend Code enthält existiert eine dazugehörige Testklasse im selben package.

Nachfolgend ist die Projektstruktur abgebildet. Das (C) steht für Klasse und das (E) für Enumeration.
### Sourcecode
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
    
### Test Klassen
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
    
## Klassendiagram

![1234Altwagen](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/fh-erfurt/1234Altwagen/master/klassendiagramm.iuml)
