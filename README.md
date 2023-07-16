# KMM CA Template
Template to create a new KMM project based on Clean Architecture with modularization by features.

### 1. Create a webhook post messages on Slack
1. For Github Actions to post messages on Slack, you must create a new webhook URL by using the [Incoming Webhook](https://slack.com/apps/A0F7XDUAZ-incoming-webhooks) app.
2. Create a new [Github Actions secret](https://docs.github.com/en/actions/security-guides/encrypted-secrets) with name `SLACK_WEBHOOK_URL`, and copy paste the webhook created in the previous step as value of this secret.

### 2. Configure the Slack bot to post on Slack
We will configure 2 Slack bots to post message on Slack: one bot to check for outdated dependencies, and one bot for the build status.
To configure these 2 Slack bots, we need to create 3 [Github Actions variables](https://docs.github.com/en/actions/learn-github-actions/variables):
1. `SLACK_GITHUB_ACTIONS_CHANNEL_NAME`: the name of the Slack channel where Github Actions will post messages (ie. `myproject_build_status`).
2. `SLACK_GITHUB_ACTIONS_DEPENDENCY_UPDATES_ICON_URL`: the icon URL to be used as a profile picture for the "Dependency Updates" Slack bot.
3. `SLACK_GITHUB_ACTIONS_ICON_URL`: the icon URL to be used as a profile picture for the "Github Actions CI" Slack bot.

### 3. Rename package name to your own
1. Open `buildSrc/src/main/kotlin/Dependencies.kt` and rename the following things:
    1. _Line 13_: Change `MyProject` object name to your own project name,
    2. _Line 14_: Change `com.tweener.changehere` package name to your own package name.
2. Open `settings.gradle.kts` and change `MyProjectName` on line 18 by your own project name.
3. Rename packages name (`import` and `package`) in all existing files:
    1. Click on `Edit` > `Find` > `Replace in files`,
    2. In the first input field, type `com.tweener.changehere`,
    3. In the second input field, type your own package name,
    4. Click on `Replace all` button.
4. Replace `com/tweener/changehere` by your own directory path in the following directories:
    1. `androidApp/src/main/java/com/tweener/changehere`
    2. `shared/src/commonMain/kotlin/com/tweener/changehere`
    3. `shared/data/src/androidMain/kotlin/com/tweener/changehere`
    4. `shared/data/src/androidUnitTest/kotlin/com/tweener/changehere`
    5. `shared/data/src/commonMain/kotlin/com/tweener/changehere`
    6. `shared/data/src/iosMain/kotlin/com/tweener/changehere`
    7. `shared/data/src/iosTest/kotlin/com/tweener/changehere`
    8. `shared/domain/src/commonMain/kotlin/com/tweener/changehere`
    9. `shared/domain/src/commonTest/kotlin/com/tweener/changehere`
5. iOS TODO
