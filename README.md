1. Clone this project in to your Machine
2. Open the project in Eclipse
3. In src/test/java folder, you will find 4 packages and inside each package these things are included.
    - PageObjects - in here the web elements related to that page are listed and also the methods
    - TestBase - Seleniumcommand repository
    - TestCases - the testcases should added in here
    - Utils - Configuration classes, or any other config classes should be added in here such as reporting strutures, Excel utilities and etc
4. In src/test/resources you may add all the resource files such as webdrivers, test data files and etc
5. All the dependancies are added in pom.xml file
6. To run the test case go to src/test/java -> TestCases package, right click on the test class and run as TestNg (if the chrome browser is not getting launches please check the version of your chrome browser and update it, or else replace the chromedriver in src/test/resources/drivers into the new chromedriver)
