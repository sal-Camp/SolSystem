#!/bin/bash

read -p "Enter version: " version

git archive master -o SolSystem-$version.zip --prefix SolSystem-$version/