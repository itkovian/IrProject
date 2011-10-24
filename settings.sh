#!/bin/bash

if [ -f update.sh ]; then
  chmod +x update.sh
  ./update.sh
fi

export PATH=$PATH:/usr/local/Citrix/ICAClient
