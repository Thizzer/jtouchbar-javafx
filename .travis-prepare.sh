#!/usr/bin/env bash

# prepare maven installation
mkdir -p $HOME/.bin
cd $HOME/.bin

if [ '!' -d apache-maven-3.5.2 ]
then
  if [ '!' -f apache-maven-3.5.2-bin.zip ]
  then 
    wget https://archive.apache.org/dist/maven/maven-3/3.5.2/binaries/apache-maven-3.5.2-bin.zip || exit 1
  fi
  echo "Installing maven 3.5.2"
  unzip -qq apache-maven-3.5.2-bin.zip || exit 1
  rm -f apache-maven-3.5.2-bin.zip
fi
