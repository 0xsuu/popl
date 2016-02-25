#!/bin/bash

pushd popl2015/Linda
javac *.java
jar cfv popl2015.jar *.class
mv popl2015.jar ../../
popd

