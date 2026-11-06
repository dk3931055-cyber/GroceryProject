# Grocery Cucumber API + Mobile Project
## How to Run in Eclipse
File > Import > Maven > Existing Maven Projects > Select this folder > Finish
Right click > Run As > Maven test  OR  Run RunCucumberTest.java as JUnit

## How to Push to GitHub
git add . ; git commit -m "Add Cucumber API Mobile Project" ; git push origin main

## Jenkins Job
Source: GitHub https://github.com/dk3931055-cyber/GroceryProject.git branch main
Build Step: Invoke top-level Maven targets Goals: clean test
Post-build: Publish JUnit test result report: target/surefire-reports/*.xml
Expected: Tests run: 11+ , BUILD SUCCESS
