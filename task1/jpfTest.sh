#!/bin/bash

cd classes
jpf +classpath=. Test
cd ..
