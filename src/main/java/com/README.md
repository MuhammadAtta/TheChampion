
## Architectural Thoughts

Before I define the Pre requisites , I want to brief the architecture which I kept in my mind before preparing it. 
As per my experience I followed 

```
MicroService Architecture

```
Where I kept focus on 

```
PARALLEL DEVELOPMENT , TEAM COLLABORATION , PAIR PROGRAMMING

```

The architecture described in a way where each layer does have their own responsibility. Please see through below.


```
CONTROLLER LAYER [RESPONSIBLE FOR UI/UX INTERACTION] <---> SERVICE LAYER [RESPONSIBLE FOR BUSINESS LOGIC , AND PASS THROUGH DATA TO DAO LAYER] <--> REPOSITORY LAYER [RESPONSIBLE FOR DATA BASE OPERATIONS]

```
### ASSUMPTIONS

	*Submit a participant request: Create Player Information
	
	*Get a list of all participant: List of all the player existing in DB
	
	*Group randomly participant into (n) groups: I have used the following formula to simulate the Groups
	
	```
	No of Matches Per round is been considered as No of Groups
	No of Rounds = if (n == ODD NO) then n else n-1 where n=No of Participants
	No of Total Matches= n*(n-1)/2 where n= No of Participants
	No of Matches Per Round= no Of Total Matches/ No of Rounds
	
	*Get the list of all automatically created first-round match: Exposed an API by which User may get Matches based on Round No

	*Update match-winner and results: The user may update the match-winner with results on the endpoint
	*Close round: Either Auto-close if all the match are done or the user may do it manually
	*Submit a request for the new match (players and time): User may create a league by selecting players as well as time [as per understanding Start Date, Please confirm ?]this will automatically create a group of match
	*Submit league champion: Participant ID corresponding to created League Id

### Prerequisites

For using application , seek below software to be available in system

```
JAVA [>=1.8]
MAVEN 3
H2
Eclipse [for code walkthrough]

```

## Test Coverage

the testcases would run whenever build is been created and could be visualized via JACOCO plugin at 

```
../target/site/jacoco/index.html

```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.4/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.4/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.4.4/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Java Mail Sender](https://docs.spring.io/spring-boot/docs/2.4.4/reference/htmlsingle/#boot-features-email)
* [Tournament Scheduling](https://nrich.maths.org/1443)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

