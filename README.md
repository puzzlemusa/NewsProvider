# README #

This README would normally document whatever steps are necessary to get your application up and running.

### What is this repository for? ###

This is a simple news service provider application. This application is divided into frontend and backend parts. Here we can add news and view news. We can use the api in both json and xml data format. BDD style tests are written for server code.

### Framework used ###

* For the backend Spring Boot is used.
* For frontend Angular 2 is used.
* Cucumber for unit testing

### How do I get set up? ###
####Backend####
To run backend just go to **Backend** directory. Open command prompt there and type
```
gradlew build
```
and hit enter. It should take couple of minutes to download all the dependencies.
Once completed type 
```
gradlew bootRun
```
Then server should be up and running on http://localhost:8080/news.json

####Frontend####
First you need install Node. If your system don't have Node installed, go to https://nodejs.org/en/download/, download and install. Installation is pretty straight forward so it wont be a problem.
Now go to **Frontend** directory. Open another command prompt instance there and type:
```
npm install
```
hit enter. Again it should take couple of minutes to download all dependencies. When completed type
```
npm start
```
and hit enter, then a news form should be opened in your default browser.

### Testing ###
To run test just go to **Backend** directory, open command prompt there and type:
```
gradlew test
```
hit enter, all test should be run.
When finished if you want to see the features that the tests covered just go to **Backend\CucumberReports** directory.
Here you will find different directory for different features. Enter into any of them and open **index.html**.
You'll able to see the feature.

### Who do I talk to? ###
Abu Saled Md Musa

Email: puzzlemusa@gmail.com

Skype: puzzlemusa

Mobile: +49 1782130363
