# Music Library / Playlist Manager

## A. Project Overview

**Project Name:** Music Library / Playlist Manager  
**Purpose:** Manage songs, podcasts, and playlists via a simple REST-like CLI API.  
**Entities and Relationships:**
- **Media** (abstract) -> **Song**, **Podcast**
- **Playlist** -> contains multiple `Media` via `playlist_media` (many-to-many)

**OOP Concepts Used:**
- **Inheritance:** `Media` -> `Song` / `Podcast`
- **Polymorphism:** calling `getType()` on `Media` reference
- **Composition / Aggregation:** `Playlist` contains a list of `Media`

---

## B. OOP Design Documentation

**Abstract Class and Subclasses:**
- `Media` (id, name, duration)
- `Song` -> extends `Media`
- `Podcast` -> extends `Media`

**Polymorphism Example:**
```java
Media m = new Song("Save Your Tears", 216);
System.out.println(m.getType()); // SONG