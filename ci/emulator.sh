#!/usr/bin/env bash

$ANDROID_HOME/tools/bin/sdkmanager tools
$ANDROID_HOME/tools/bin/sdkmanager "system-images;android-25;default;armeabi-v7a"
echo no | avdmanager create avd --force -n test -k "system-images;android-25;default;armeabi-v7a"
$ANDROID_HOME/emulator/emulator -avd test -no-audio -no-window &
android-wait-for-emulator
adb shell input keyevent 82