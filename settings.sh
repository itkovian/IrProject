#!/bin/bash

if [ -f update.sh ]; then
  chmod +x update.sh
  ./update.sh
fi

if [ -f pullcounter.sh ]; then
  chmod +x pullcounter.sh
  ./pullcounter.sh
fi

export PATH=$PATH:/usr/local/Citrix/ICAClient
