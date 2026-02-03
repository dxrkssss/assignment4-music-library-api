# Music Library API (Assignment 4 - SOLID & Advanced OOP)

## Project Overview
This project is a Music Library API that manages Songs and Podcasts.  
It demonstrates SOLID principles, advanced OOP features (polymorphism, abstract classes, interfaces, generics, lambdas, reflection), and a layered architecture (controller → service → repository → database).

Entities:
- **Media** (abstract)
- **Song** and **Podcast** (subclasses)
- **Playlist** (composition: contains Media objects)

---

## SOLID Documentation

**SRP (Single Responsibility Principle)**
- Each class has a single responsibility:
    - `MediaService` handles business logic and validation
    - `MediaRepository` handles only database access
    - `MediaController` handles only user input

**OCP (Open/Closed Principle)**
- Abstract `Media` allows adding new media types (e.g., Audiobook) without modifying existing code

**LSP (Liskov Substitution Principle)**
- `Song` and `Podcast` can be used anywhere `Media` is expected

**ISP (Interface Segregation Principle)**
- `Validatable<T>` and `CrudRepository<T>` interfaces provide narrow, focused contracts

**DIP (Dependency Inversion Principle)**
- `MediaServiceImpl` depends on `CrudRepository<Media>` interface, not a concrete class

---

## Advanced OOP Features

**Generics**
- `CrudRepository<T>` is generic and supports all entity types

**Lambdas**
- Sorting and filtering lists in `SortingUtils` using lambda expressions

**Reflection / RTTI**
- `ReflectionUtils` demonstrates runtime inspection of classes, fields, and methods

**Interface Default/Static Methods**
- `Validatable<T>` interface provides default validation method
- Static helper methods for reusable checks

---

## OOP Design

**Abstract class + subclasses**
- `Media` (abstract)
- `Song` (extends Media)
- `Podcast` (extends Media)

**Composition**
- `Playlist` contains multiple `Media` objects

**Polymorphism**
```java
List<Media> mediaList = List.of(new Song(...), new Podcast(...));
for (Media m : mediaList) {
    System.out.println(m.getDisplayName());
}
