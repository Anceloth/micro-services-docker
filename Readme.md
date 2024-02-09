1. Download the project
2. In root folder execute "docker-compose up -d" to create database and load data inside it
3. Start the eureka server
4. Start the microservices
	4.1.  Start movies-service 
	4.2.  Start authors-service 

5. To start new instances for each service

	In terminal
	# --- inside authors-service folder execute
	$ mvn package
	$ cd target 
	$ java -Dserver.port=8083 -jar authors-service-0.0.1-SNAPSHOT.jar
	-------------------------------------------------------------
	# --- inside movies-service folder execute
	$ mvn package
	$ cd target 
	$ java -Dserver.port=8084 -jar movies-service-0.0.1-SNAPSHOT.jar
