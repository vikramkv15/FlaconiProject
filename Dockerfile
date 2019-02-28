FROM openjdk:8-jre-slim

WORKDIR /usr/share/tag

# Add the project jar & copy dependencies
ADD  target/selenium-docker.jar selenium-docker.jar
ADD  target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD  target/libs libs

# Add the suite xmls
ADD FlaconiUserJourney.xml FlaconiUserJourney.xml

# Command line to execute the test
# Expects below ennvironment variables
# BROWSER = chrome
# MODULE  = FlaconiUserJourney
# GRIDHOST = selenium hub hostname / ipaddress

ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DseleniumHubHost=$SELENIUM_HUB -Dbrowser=$BROWSER org.testng.TestNG $MODULE
