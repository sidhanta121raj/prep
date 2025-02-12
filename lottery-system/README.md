# Poppulo Lottery System

## Table of Contents
- [Problem Details](#problem-details)
- [Solution Details](#solution-details)
- [API Details](#api-details)
  - [Create a Ticket](#create-a-ticket)
  - [Get All Tickets](#get-all-tickets)
  - [Get a Ticket by ID](#get-a-ticket-by-id)
  - [Amend Ticket Lines](#amend-ticket-lines)
  - [Retrieve Ticket Status](#retrieve-ticket-status)
- [Sample Request and Response](#sample-request-and-response)
  - [Create a Ticket (Random)](#create-a-ticket-random)
  - [Create a Ticket (Provided Lines)](#create-a-ticket-provided-lines)
  - [Get All Tickets](#get-all-tickets-sample)
  - [Get a Ticket by ID](#get-a-ticket-by-id-sample)
  - [Amend Ticket Lines](#amend-ticket-lines-sample)
  - [Retrieve Ticket Status](#retrieve-ticket-status-sample)
- [Installation and Running](#installation-and-running)
- [Testing](#testing)

## Problem Details
The Poppulo Lottery System is designed to manage lottery tickets. 
A ticket has a series of lines on a ticket with 3 numbers, each of which has a value of 0, 1, or 2. 
For each ticket 
- If the sum of the values on a line is 2, the result for that line is 10.
- Otherwise if they are all the same, the result is 5. 
- Otherwise so long as both 2nd and 3rd numbers are different from the 1st, the result is 1. 
- Otherwise the result is 0.


## Solution Details
The solution is built using Spring Boot, providing RESTful APIs for managing lottery tickets. The application includes:
- API endpoints for creating, retrieving, and amending tickets.
- Validation to ensure correct input.
- Exception handling for various error scenarios.
- Logging for monitoring and debugging.

## API Details

### Create a Ticket
- **Endpoint:** `POST /lottery/v1/ticket`
- **Description:** Creates a new lottery ticket.
- **Parameters:**
  - `isRandom` (boolean, optional, default: `true`): Indicates whether to generate random lines.
- **Request Body (optional):**
  - `CreateTicketRequestDTO` (required if `isRandom` is `false`)

### Get All Tickets
- **Endpoint:** `GET /lottery/v1/ticket`
- **Description:** Retrieves all lottery tickets.

### Get a Ticket by ID
- **Endpoint:** `GET /lottery/v1/ticket/{id}`
- **Description:** Retrieves a lottery ticket by its ID.

### Amend Ticket Lines
- **Endpoint:** `PUT /lottery/v1/ticket/{id}`
- **Description:** Amends the lines of a lottery ticket.
- **Request Body:** `CreateTicketRequestDTO`

### Retrieve Ticket Status
- **Endpoint:** `PUT /lottery/v1/ticket/status/{id}`
- **Description:** Retrieves the status of a lottery ticket.

## Sample Request and Response

### Create a Ticket (Random)
**Request:**
`POST /lottery/v1/ticket?isRandom=true`
`Content-Type: application/json`
**Response:**
```json
{
  "id": 1,
  "lines": [
    {"number1": 0, "number2": 1, "number3": 2, "outcome": null},
    {"number1": 2, "number2": 2, "number3": 0, "outcome": null}
  ],
  "status": "UNCHECKED"
}
```
### Create a Ticket (Provided Lines)
**Request:**
`POST /lottery/v1/ticket?isRandom=false`
`Content-Type: application/json`
```json
{
  "lines": [
    {"number1": 0, "number2": 1, "number3": 2},
    {"number1": 2, "number2": 2, "number3": 0}
  ]
}
```

**Response:**
```json
{
  "id": 1,
  "lines": [
    {"number1": 0, "number2": 1, "number3": 2, "outcome": null},
    {"number1": 2, "number2": 2, "number3": 0, "outcome": null}
  ],
  "status": "UNCHECKED"
}
```

### Get All Tickets (Sample)
**Request:**
`GET /lottery/v1/ticket`

**Response:**
```json
[
  {
    "id": 1,
    "lines": [
      {"number1": 0, "number2": 1, "number3": 2, "outcome": null},
      {"number1": 2, "number2": 2, "number3": 0, "outcome": null}
    ],
    "status": "UNCHECKED"
  }
]
```

### Get a Ticket by ID (Sample)
**Request:**
`GET /lottery/v1/ticket/1`


**Response:**
```json
{
  "id": 1,
  "lines": [
    {"number1": 0, "number2": 1, "number3": 2, "outcome": null},
    {"number1": 2, "number2": 2, "number3": 0, "outcome": null}
  ],
  "status": "UNCHECKED"
}
```
### Amend Ticket Lines (Sample)
**Request:**
`PUT /lottery/v1/ticket/1`
`Content-Type: application/json `

```json
{
  "lines": [
    {"number1": 1, "number2": 1, "number3": 1}
  ]
}
```
**Response:**
```json
{
  "id": 1,
  "lines": [
    {"number1": 0, "number2": 1, "number3": 2, "outcome": null},
    {"number1": 2, "number2": 2, "number3": 0, "outcome": null},
    {"number1": 1, "number2": 1, "number3": 1, "outcome": null}
  ],
  "status": "UNCHECKED"
}
```
### Retrieve Ticket Status (Sample)
**Request:**
`PUT /lottery/v1/ticket/status/1`

**Response:**
```json
{
  "id": 1,
  "lines": [
    {"number1": 0, "number2": 1, "number3": 2, "outcome": 1},
    {"number1": 2, "number2": 2, "number3": 0, "outcome": 0},
    {"number1": 1, "number2": 1, "number3": 1, "outcome": 5}
  ],
  "status": "CHECKED"
}
```
### Installation and Running

**Building the Project:** mvn clean install

**Running the Application:** mvn spring-boot:run

**Access the Application:** The application will be running at `http://localhost:8080`

**Access the Swagger UI** The Swagger UI can be accessed to test the APIs at `http://localhost:8080/swagger-ui/index.html#/`
### Testing
**Run Tests** mvn test


