# 1234Altwagen

![Klassendiagramm](readmeFiles/Klassendiagramm.png)

@startuml

title 1234Altwagen - Class Diagram


class Car {
    -carId: int
    -price float
    -constructionYear: int
    -drivenKM: int
    -brand: string
    -model: string
    -note: string
    -location: Location
    -status: string
    +setPrice (int newCarId, float newPrice): void
}

class Location {
    -locId: int
    -adress: Adress
}

class Request {
    -requestId: int
    -type: bool
    -car: Car
    -employee: Employee
    -customer: Customer
    -status: string
}
class Adress {
    -adrId: int
    -country: string
    -city: string
    -zip: string
    -street: string
    -houseNumber: string
}
class Controller {
    +listCars(): Car[]
    +registerUser (User): bool
    +deleteUser (int userId): bool
}

class User {
    -userId: int
    -firstname: string
    -surname: string
    -eMail: string
    -password: string
    -userAdress: Adress
}
class Customer {
    -requestCount: int
    +requestSellCar(Car): Request
    +requestBuyCar(int carId): Request
    +cancelRequest(Request): bool
}
class Employee {
    +createCar(Car): bool
    +acceptRequest(Request): bool
    +denyRequest(Request): bool
}

Customer --> User
Employee --> User

Car -- Location
Car -- Request
Location -- Adress
Request -- Customer
Request -- Employee
Adress -- User

@enduml
