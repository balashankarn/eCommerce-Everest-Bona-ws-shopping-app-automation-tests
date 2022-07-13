# eCommerce-Everest-Bona-ws-shopping-app-automation-tests
This Repo is Everest and Bona Team App Automation

Once the project code received import to eclipse/ intellij . Make sure installed all pre request installation in your local machine to Run Automation Script . 
Prerequisites installation: 

Java   

Maven   

Appium   

Cucumber   

Junit  

Android Studio  

Execution : 

In case if you want to run the testcases in Cloud (Browserstack ) you need to set username, assess key, app-id environment variable during runtime in the terminal by using export command. 

Examples: 
For MAC use below commands in case Windows use SET instead of export 

export BROWSERSTACK_USERNAME=test 

export BROWSERSTACK_ACCESS_KEY=test1 

export BROWSERSTACK_APP_ID=bs://e0b31cfd5590d5714555456c 

Note : App id you will get once you upload the apk/ipa file in to browserstack. 
The environments file has JSON Array for devices, so we need to pass the deviceindex at runtime. 
Maven command to run: mvn test -Dplatform=iOS -DdeviceIndex=0 
You can right click on the project and select show in terminal to start executing the commands and setting environment variables, refer the pom.xml file to view the list of environment variables. 
