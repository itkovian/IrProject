#!/bin/bash

LOCKFILE=/tmp/gettingPhoneData

file=$1;




## get the data file off the telephone
## protected by a lock


#get a lock
lockfile $LOCKFILE

# store data in /tmp
cd /tmp/

# pull the data
adb pull /sdcard/accelDataLog

if [ $? -ne 0 ]; then
  rm -rf $LOCKFILE
  echo "Oops, could not pull, bailing."
  exit -1
fi

cd -
mv /tmp/accelDataLog $file

# remove lockfile
rm -rf $LOCKFILE
