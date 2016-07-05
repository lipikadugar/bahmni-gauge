Automation Test Suite using Gauge Framework
============================================

Installation instructions
--------------------------
* For installation of Gauge, follow the wiki instructions [here](http://getgauge.io/documentation/user/current/installations/operating_system/install_on_mac.html)
* On MAC, run the following commands
    brew update
    brew install gauge
* Install Language Runner  plugins using the following commands
    gauge --install java
    gauge --install html-report

* For running the tests, run the command
    mvn gauge:execute

