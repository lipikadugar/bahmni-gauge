Automation Test Suite using Gauge Framework
============================================

Installation instructions
--------------------------
* Download Gauge from this [link](http://getgauge.io/get-started/).

* Install core plugins using the following commands
    gauge --install java
    gauge --install html-report

* For running the tests, run the command
    export implementation_name=<implementation_name>
    export url=<environment_url>
    mvn -DspecsDir=<location_of_specs> clean install
    mvn -DspecsDir=~/bahmni-code/endtb-config/openmrs/automatedTests clean install

