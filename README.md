## Setup Instructions - Backend Solution

# Running the MongoDB Container

First, we will pull the latest MongoDB image from Docker repository using the below command.

```bash
docker pull mongo
```

Next, we need to run the downloaded image. In order to run Mongo image, we use the following command:

```bash
docker run -d --name mongo-on-docker -p 27017:27017 mongo
```

# Running the Spring Application Container

Now we run the spring application container

```bash
docker run -p 8080:8080 starwars_henrique_castro
```

# Testing

## Provide information about your approach

