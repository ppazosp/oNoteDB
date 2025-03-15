# oNoteDB - Spring Boot REST API

**oNoteDB** is the backend service for the **oNote** mobile application. It provides a **RESTful API** for managing data related to university lecture transcription, assignments, and file storage. This server is built with **Spring Boot** and connects to a **MongoDB NoSQL database**.

---
## Features

- **Subject & Class Management**: Stores information about subjects and their respective classes.
- **Real-time Transcription Storage**: Saves transcriptions retrieved from the **oNoteAPIs WebSocket server**.
- **Task Scheduling & Calendar Integration**: Manages deadlines and reminders for users.
- **File Management**: Handles file uploads and associations with subjects and classes.

---

## Technology Stack

- **Spring Boot**: Framework for building RESTful web services.
- **MongoDB**: NoSQL database for flexible and scalable data storage.
- **Spring Data MongoDB**: Facilitates seamless interaction with MongoDB.
- **REST API Design**: Follows RESTful best practices for API development.

---

## API Endpoints (Overview)

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/classes` | Retrieve all lectures for a subject |
| `GET` | `/class` | Retrieve a class by name and subject |
| `POST` | `/resume` | Add resume to a lecture |
| `PUT` | `/upload` | Add a file |
| `GET` | `/files` | Retrieve all files |
| `GET` | `/classfiles` | Retrieve all files for a class of a subject |
| `GET` | `/reminders` | Retrieve all reminders for a subject |
| `GET` | `/subjects` | Retrieve all subjects |

---
