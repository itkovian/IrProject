#!/bin/bash

if [ ! -d $HOME/code ]; then
  mkdir code
  cd code
  git clone git://github.com/itkovian/StepCounter.git
  cd StepCounter
  git checkout labo3
  git checkout labo4
  git checkout labo3
  cd -
fi;
