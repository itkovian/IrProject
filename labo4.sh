#!/bin/bash


cd $HOME/code/StepCounter
modified_files=`git status . | grep "modified" | wc -l`

if [ $modified_files -eq 0 ]; then
  echo  << HERE 
Zorg ervoor dat je de bestaande code in $HOME/code/StepCounter hebt
vervangen door je eigen bestande voor de volgende bestanden:

StepCounterActivity.java
main.xml
HERE
  cd
  exit 1;
fi

git commit -a -m "Changes made by students"
git merge labo4

if [ $? -ne 0]; then
  echo "OEPS. ER IS IETS MISGELOPEN."
fi

cd
