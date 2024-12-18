[![Kotlin](https://img.shields.io/badge/kotlin-2.0.21-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Compose](https://img.shields.io/badge/compose-1.7.1-blue.svg?logo=jetpackcompose)](https://www.jetbrains.com/lp/compose-multiplatform)
![gradle-version](https://img.shields.io/badge/gradle-8.5.2-blue?logo=gradle)
[![License](https://img.shields.io/badge/License-Apache%202.0-green.svg)](https://opensource.org/licenses/Apache-2.0)

[![Website](https://img.shields.io/badge/Author-vivienmahe.com-purple)](https://vivienmahe.com/)
[![X/Twitter](https://img.shields.io/twitter/follow/VivienMahe)](https://twitter.com/VivienMahe)

---

# Kmplate

**Kmplate** is a template to easily create a new Kotlin Multiplatform project based on Clean Architecture with modularization by layer.

<br>

Be sure to show your support by starring ⭐️ this repository!

## 📦 Current stack
- UI framework: [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/) - Powered by [C·ZAN](https://github.com/Tweener/czan/) design system
- ViewModel: [Jetpack ViewModel](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-viewmodel.html)
- Navigation: [Voyager](https://github.com/adrielcafe/voyager)
- Dependency Injection: [Koin](https://insert-koin.io/)
- Build Config portage for KMP: [BuildKonfig](https://github.com/yshrsmz/BuildKonfig)
- Threading: [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)
- Network: [Ktor](https://ktor.io/)
- Local database: [Realm Kotlin](https://realm.io/realm-kotlin/) - Powered by [kmp-realm](https://github.com/Tweener/kmp-bom/tree/main/kmp-realm)
- Logging: [Napier](https://github.com/AAkira/Napier)
- Images loading: [Coil](https://coil-kt.github.io/coil/)
- Firebase portage for KMP: [GitLiveApp Firebase SDK](https://firebaseopensource.com/projects/gitliveapp/firebase-kotlin-sdk/) - Powered by [kmp-firebase](https://github.com/Tweener/kmp-bom/tree/main/kmp-firebase)

## 🛠️ Installation
### 1. Clone this template

Create your repository by cloning this template, using the green button at the top-right corner of the homepage.
![Screenshot 2024-02-21 at 18 42 43](https://github.com/Tweener/kmplate/assets/596985/8e41cc46-c295-431f-904d-df7bf4dbef13)

### 2. Create a webhook post messages on Slack

1. For Github Actions to post messages on Slack, you must create a new webhook URL by using the [Incoming Webhook](https://slack.com/apps/A0F7XDUAZ-incoming-webhooks) app.
2. Create a new [Github Actions secret](https://docs.github.com/en/actions/security-guides/encrypted-secrets) with name `SLACK_WEBHOOK_URL`, and copy paste the webhook created in the previous step as
   value of this secret.

### 3. Configure the Slack bot to post on Slack

We will configure 2 Slack bots to post message on Slack: one bot to check for outdated dependencies, and one bot for the build status.
To configure these 2 Slack bots, we need to create 3 [Github Actions variables](https://docs.github.com/en/actions/learn-github-actions/variables):

1. `SLACK_GITHUB_ACTIONS_CHANNEL_NAME`: the name of the Slack channel where Github Actions will post messages (ie. `myproject_build_status`).
2. `SLACK_GITHUB_ACTIONS_DEPENDENCY_UPDATES_ICON_URL`: the icon URL to be used as a profile picture for the "Dependency Updates" Slack bot.
3. `SLACK_GITHUB_ACTIONS_ICON_URL`: the icon URL to be used as a profile picture for the "Github Actions CI" Slack bot.

### 4. Rename package name to your own

1. Open `buildSrc/src/main/kotlin/Dependencies.kt` and rename the following things:
    1. _Line 13_: Replace `MyProject` object name with your own project name,
    2. _Line 14_: Replace `com.tweener.changehere` package name with your own package name.
2. Open `settings.gradle.kts` and replace `MyProjectName` on line 18 with your own project name.
3. Rename packages name (`import` and `package`) in all existing files:
    1. Click on `Edit` > `Find` > `Replace in files`,
    2. In the first input field, type `com.tweener.changehere`,
    3. In the second input field, type your own package name,
    4. Click on `Replace all` button.
4. Replace `com/tweener/changehere` with your own directory path in the following directories:
    1. `androidApp/src/main/kotlin/com/tweener/changehere`
    2. `shared/src/commonMain/kotlin/com/tweener/changehere`
    3. `shared/data/src/androidMain/kotlin/com/tweener/changehere`
    4. `shared/data/src/androidUnitTest/kotlin/com/tweener/changehere`
    5. `shared/data/src/commonMain/kotlin/com/tweener/changehere`
    6. `shared/data/src/iosMain/kotlin/com/tweener/changehere`
    7. `shared/data/src/iosTest/kotlin/com/tweener/changehere`
    8. `shared/domain/src/commonMain/kotlin/com/tweener/changehere`
    9. `shared/domain/src/commonTest/kotlin/com/tweener/changehere`
5. Open file `Theme.kt` and rename `MyProjectTheme` to your own project name. ie: `AmazingAppTheme`.
6. Rename file `MyProjectUIDefaults.kt` to your own project name. ie: `AmazingAppUIDefaults.kt`.
7. Open file `NavigationBar.kt` and rename `MyProjectNavigationBar` to your own project name. ie: `AmazingAppNavigationBar`.
8. Build and run the `androidApp` target from Android Studio.

### 5. Update iOS configuration

1. Open `iosApp/myProjectName.xcworkspace` in Xcode and build the project.
2. In Xcode, in the left panel, click on `iosApp`, then in tab `Signing & Capabilities` and replace the `Bundle identifier` value with your own bundleID (ie. "com.mycompany.myproject"),
3. Close Xcode and go back to Android Studio.
4. Run the `iosApp` target.

### 6. Rename Github Actions names

1. Open `.github/workflows/buildRelease.xml` and replace `Kmplate` on lines 1, 42 and 54 with your own name.
2. Open `.github/workflows/notify.xml` and replace `Kmplate` on lines 21 and 33 with your own name.

### 7. Use your own Google Services configurations

1. For Android, replace `androidApp/google-services.json` with your own `google-services.json` generated by Firebase.
2. For iOS, replace `iosApp/iosApp/GoogleService-Info.plist` with your own `GoogleService-Info.plist` generated by Firebase.
