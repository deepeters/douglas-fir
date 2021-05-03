# Project Name: Douglas Fir


### Project Description
This is a Java-Spark Application that allows Rangers to track wildlife sightings in an area.

<img src="/douglas-fir.png">

### Setup Instructions
# User Stories

### Setup
* To run the application, first install the java development kit from `https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html`
* Install gradle.
* Next clone the project using `$ git clone https://github.com/deepeters/douglas-fir` to your preferred folder.
* In the command prompt, navigate to cloned folder and use the following command to run the app `$ gradle run`
* Open the browser and enter the address `localhost:4567`

* * Install PostgreSQL. for help installing ==> https://www.youtube.com/watch?v=-LwI4HMR_Eg
  * Open up your terminal and type the following commands(only works if postgreSQL is installed)
  * 
          psql
          
          CREATE DATABASE wildlife_tracker;
          
          \c wildlife_tracker;
          
          CREATE TABLE animals 
          (id serial PRIMARY KEY, name varchar, age varchar,health varchar, type varchar);
          
          CREATE TABLE sightings
          (id serial PRIMARY KEY, animalId int, location varchar, rangerName varchar, sightingDate timestamp);
          
          CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;



# Contact Information:
### Author: [DENNIS NJENGA](https://github.com/deepeters)

         Email: dennis@dennis.com
         Phone: +254712345678

### Technology Used
1. Java
2. HTML
3. CSS

### Frameworks Used
1. Gradle
2. Spark
3. Maven
4. Junit

### Libraries Used
1. Bootstrap
2. Material Design Bootstrap.

### LICENSE: [MIT LICENSE](https://raw.githubusercontent.com/deepeters/douglas-fir/master/LICENSE)