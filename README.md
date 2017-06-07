# BBProject for QA Automation

## Project Setup on your local machine - dev env

Step1: git clone https://github.com/Manidipachat/BBProject.git <br />
Step2: Make sure you have maven installed on your machine. <br />



## Steps to run the project
Step3: If you are on windows, please update your local chromeDriver path in BB_Auto_Browser.java </br></br>
       System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
       </br></br>
       On mac install the chromedriver using brew install chromedriver and set the PATH Variable for the chromeDriver </br></br>
       
    
    
Step4: Goto terminal and browse to root of the project. <br />
Step5: You can either run mvn clean install test from terminal <br />
Step6: Or, you can directly goto ecllipse or intellJi and right click on testng.xml file and Run it directly <br />

## Reports
Open Target > Sunfire reports > index.html in browser

