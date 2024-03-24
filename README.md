# Appium test task for NDA project
___
### Software stack
- [Java 17 LTS](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Gradle](https://gradle.org/)
- [Cucumber BDD](https://cucumber.io/)
- [Android SDK](https://developer.android.com/studio)
- [Appium 2.x](https://github.com/appium/appium)
- [Selenide-Appium](https://github.com/selenide-examples/selenide-appium)
- [TestNG](https://testng.org/)
___
NOTE: Date of `.apk` file release is 2019. At that time, `Android 10` was the latest version.

![apkFileDate.png](https://github.com/vitaliidzubenko/appium-task/blob/main/src/main/resources/readme/apkFileDate.png)

Let's use `Android 10` (or lower) for emulator. For example: `Pixel_5_API_28` with `Android 9.0`.

![apkFileDate.png](https://github.com/vitaliidzubenko/appium-task/blob/main/src/main/resources/readme/androidDeviceType.png)

#### Before test execution, run commands below using CMD to start Android emulator (Windows 10, 11):

```shell
cd C:\Users\~UserName~\AppData\Local\Android\Sdk\emulator
.\emulator -list-avds
.\emulator -avd Pixel_5_API_28
```
Make sure Android emulator is up and running:

![adb.png](https://github.com/vitaliidzubenko/appium-task/blob/main/src/main/resources/readme/adb.png)

#### Start Appium server:
```shell
 appium --address 127.0.0.1 --port 4727
```
![appium.png](https://github.com/vitaliidzubenko/appium-task/blob/main/src/main/resources/readme/appium.png)

#### Configure Intellij IDEA build:

![ideaConfig.png](https://github.com/vitaliidzubenko/appium-task/blob/main/src/main/resources/readme/ideaConfig.png)

## Execution of tests:

1. By running appropriate Gradle task with params (from CMD):

`./gradlew clean cucumber -P tags=@smoke`

2. By running via TestNG `.xml` file: 

`./src/test/resources/suites/smoke_suite.xml`

3. By running via Cucumber Runner class: 

`./src/test/java/runners/SmokeTest.java`

3. By running via Cucumber Feature file:

`./src/test/resources/features/SmokeTest.feature`

![featureFile.png](https://github.com/vitaliidzubenko/appium-task/blob/main/src/main/resources/readme/featureFile.png)

___
### List of application properties to be set before test run:
 ```
appium.ip=
appium.port=
platform.name=
platform.version=
device.name=
android.app.file.name=
ios.app.file.name=
 ```

Can be found by path: `./src/main/resources/application.properties`

___
### Cucumber Report generation
- Cucumber Report will be generated automatically, after tests execution (based on the properties)
- Report URL can be found in console output
- Screenshot will be attached in case of failure

![reportUrl.png](https://github.com/vitaliidzubenko/appium-task/blob/main/src/main/resources/readme/reportUrl.png)

![reportExample.png](https://github.com/vitaliidzubenko/appium-task/blob/main/src/main/resources/readme/reportExample.png)
