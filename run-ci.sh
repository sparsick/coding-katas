#!/bin/bash
cd groovy-template
mvn verify
cd ../java-template
mvn verify
cd ../kotlin-template
mvn verify
