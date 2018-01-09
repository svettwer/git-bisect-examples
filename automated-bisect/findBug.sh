#!/bin/bash

mvn clean verify -f ./cake-factory/pom.xml -Dskip.unit.tests=true
