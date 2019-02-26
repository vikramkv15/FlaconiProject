FROM openjdk:8-jre-slim

# Add the jar with all the dependencies
ADD  target/UserJourney-0.0.1-SNAPSHOT.jar /usr/share/tag/UserJourney-0.0.1-SNAPSHOT.jar

# Command line to execute the test
ENTRYPOINT ["/usr/bin/java", "-cp", "/usr/share/tag/UserJourney-0.0.1-SNAPSHOT.jar", "org.testng.TestNG", "-testclass", "com.flaconi.TestCase.AddPerfumeToCartTestCase"]
