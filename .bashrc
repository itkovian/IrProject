#!/bin/bash

export PATH=$HOME/bin:/usr/local/android-sdk-linux_x86/tools:/usr/local/android-sdk-linux_x86/platform-tools:/usr/local/eclipse:$PATH



git pull origin master


if [ -f settings.sh ]; then
  source settings.sh
fi
