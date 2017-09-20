#!/usr/bin/env bash

mkdir "$ANDROID_HOME/licenses" || true
echo "8933bad161af4178b1185d1a37fbf41ea5269c55" > "$ANDROID_HOME/licenses/android-sdk-license"
sdkmanager tools
sdkmanager "system-images;android-25;default;armeabi-v7a"
echo no | avdmanager create avd --force -n test -k "system-images;android-25;default;armeabi-v7a"
$ANDROID_HOME/emulator/emulator -avd test -no-audio -no-window &
android-wait-for-emulator
adb shell input keyevent 82