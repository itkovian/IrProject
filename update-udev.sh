#!/bin/bash


## Add HTC Wildfire

echo "SUBSYSTEM==\"usb\",ATTR{idVendor}==\"0bb4\",ATTR{idProduct}==\"0c8b\",MODE==\"0666\"" >> /etc/udev/rules.d/51-android.rules


