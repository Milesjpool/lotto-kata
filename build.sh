#!/bin/bash

application="TicketPrizeCalculator"
main_path="${application}/build/classes/java/main/"

cd $application
./gradlew build
