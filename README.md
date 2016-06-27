Bahmni FAT - Functional Automation Testing - Thin light weight Automation Test Framework using [PageFactory](https://github.com/SeleniumHQ/selenium/wiki/PageFactory) in java.
 
Overview:
 1. Page Object Pattern for app pages
 2. Gradle based project.  The core is for the framework and implementations will have separate projects.
 3. JUnit construct to write tests

Setup:
 1. Clone this repo on local
 2. Copy chromedriver.zip, unzip and save under /usr/local/bin
 3. Open terminal and Navigate to the project folder, run "gradle build -x"

The framework is experimental.  Once the codebase becomes stable, the implementation projects like jss,amman,endtb can be made as separate projects and can depend on the core.
