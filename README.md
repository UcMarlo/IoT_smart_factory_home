# Smart home/factory an CO IoT project

# How to run locally

- inside projects main directory:

    ```docker-compose up```

- after containers are up and ready login into to rabbitmq management interface (localhost:15672) and create queue: 

    ```devices.measurement_added.event.smart_dashboard```

- launch main application

# Docker image generation
    
- (Optional) On windows Settings >> check ```Expose daemon on tcp://localhost:2375 without TLS```

- run ```mvn clean install -Pdocker```

# Documentation

## Used technologies  

## Schematic diagram
