# Backend Solution

## Setup Instructions

1. Pull the latest MongoDB image from Docker repository using the below command.

```bash
docker pull mongo
```

2. Clone this repository
3. Run cd backend
4. Run the docker compose up command

```bash
docker compose up
```

## Provide information about your approach

The solution was implemented using java spring boot, and mongodb.

A extend model using mongodb was created adding a count property on each entity to keep track of the number of units for vehicles and starships.

If the mongodb database is empty when it starts, a request is made to the SWAPI API, loading it with the API responses.

There are entity tests, integration tests and useCase tests.

All endpoints use name as parameter to find the starship or vehicle, you can use an underline to separate the names, example: Star_Destroyer.

There are in total eight endpoints which are listed bellow. There is a file called imsomnia_requests.json on the project.

## Starship Requests

### Get Starship Request By Name

`GET /starship/:name`

    curl -X GET http://localhost:8080/starship/Star_Destroyer

Response:

    {"id":1,"name":"Star Destroyer","unitCount":4}

### Set Starship Unit By Name Request

`PUT /starship/:name/set-unit/:unit`

    curl -X PUT http://localhost:8080/starship/Star_Destroyer/set-unit/4

Response:

    {"id":1,"name":"Star Destroyer","unitCount":4}

### Decrement Starship Unit by Name Request

`PUT /starship/:name/decrement-unit/:unit`

    curl -X PUT http://localhost:8080/starship/Star_Destroyer/decrement-unit/1

Response:

    {"id":1,"name":"Star Destroyer","unitCount":3}

### Increment Starship Unit By Name Request

`PUT /starship/:name/increment-unit/:unit`

    curl -X PUT http://localhost:8080/starship/Star_Destroyer/increment-unit/3

Response:

    {"id":1,"name":"Star Destroyer","unitCount":3}

## Vehicle Requests

### Get Vehicle Request By Name

`GET /vehicle/:name`

    curl -X GET http://localhost:8080/vehicle/Sand_Crawler

Response:

    {"id":36,"name":"Sand Crawler","unitCount":8}

### Set Vehicle Unit By Name Request

`PUT /vehicle/:name/set-unit/:unit`

    curl -X PUT http://localhost:8080/vehicle/Sand_Crawler/set-unit/4

Response:

    {"id":36,"name":"Sand Crawler","unitCount":4}

### Decrement Vehicle Unit by Name Request

`PUT /vehicle/:name/decrement-unit/:unit`

    curl -X PUT http://localhost:8080/vehicle/Sand_Crawler/decrement-unit/1

Response:

    {"id":36,"name":"Sand Crawler","unitCount":3}

### Increment Vehicle Unit By Name Request

`PUT /vehicle/:name/increment-unit/:unit`

    curl -X PUT http://localhost:8080/vehicle/Sand_Crawler/increment-unit/3

Response:

    {"id":36,"name":"Sand Crawler","unitCount":6}
