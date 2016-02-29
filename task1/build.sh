#!/bin/bash

cd src
javac *.java
mv *.class ../classes
cd ../classes
java Test
cd ..
