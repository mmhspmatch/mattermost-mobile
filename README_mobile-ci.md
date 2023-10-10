## Installation

### Current repository structure:
```markdown  
├── Override
├── .env  
├── Dockerfile  
├── README.md  
├── about_links.ts
├── circleci-config  
├── README.md  
├── default.txt
├── google-services.json
├── mmm.keystore
├── mobilecron.sh
├── privkey
└── privkey.pub  
```

To initiate the installation process, execute the following commands:
- `docker build . --no-cache -t mmm-repo-sync`
- `docker run -d mmm-repo-sync`

## Purpose

This project involves cloning and customizing the original repository from [Mattermost-Mobile](https://github.com/mattermost/mattermost-mobile) to accommodate the OTH-RCHST build procedures. Regular updates are performed using the `mobilecron.sh` script. SSH keys are added for seamless integration with the associated [GitHub repository](https://github.com/othrchst/oth-mattermost-mobile) connected to [CircleCI](https://app.circleci.com/). Pushing changes to the GitHub repository triggers the CircleCI pipeline.


The [Privacy Policy](https://rchst.de/mattermost-mobile-privacy-policy/) for the application is specified in the `about_links.ts` file.

The pipeline workflow is defined in the `circleci_config` file. For push notifications, integration with the Firebase application is managed through the `google-services.json` configuration file.

The keystore file (access available in 1Password) is provided for completeness. The keys are integrated into the CI pipeline and the Play Store.

To make the application available in the App Stores, Google and Apple both require a test user named `"mmgtest1"`. Access credentials can be found in 1Password.

## Initial configuration
To start the initial configuration, follow these steps to create the keystore files:
1. Download Keystore Explorer (unless you prefer another application).
2. Create a new keystore using Keystore Explorer:
    - JKS Keystore
    - -> Generate Keypair
    - -> RSA, Key Size 2048
    - -> SHA-256 with RSA Version 3
    - -> 25 Jahre Gültigkeit! Validity of 25 years! (Important, a shorter duration will not be accepted by the Google Play Store)
    - -> Fill in Company Details
    - -> Specify and record (important!) the Keystore Alias
    - -> Specify and record (important!) the Keystore Password
    - -> Save the keystore with a .keystore file extension (the file extension must be specified manually)
    - -> Convert the keystore file to a base64 string. If the PowerShell command doesn't produce a valid base64-string on Windows, you can use a website like [https://base64.guru/converter/encode/file](https://base64.guru/converter/encode/file). On Linux however, the command `base64 /path/to/file` should work.
    - -> Securely store the keystore file and base64 string
3. Configure CircleCI:
    - The account for CircleCI is the same account you use for GitHub (Use the "Login via GitHub" option offered in CircleCI)
    - Enable 3rd Party Orbs in CircleCI: Go to Organization Settings -> Security -> Orb Security Settings.
    - Ensure that the tests are passing successfully at this stage.
    - Add a user key to the CircleCI project to allow it to access the certificate repository: [https://circleci.com/docs/ios-codesigning/#adding-a-user-key-to-the-circleci-project](https://circleci.com/docs/ios-codesigning/#adding-a-user-key-to-the-circleci-project)
    -  Set project environment variables in CircleCI:
        - BASE_64_KEYSTORE = Base64 string of the keystore created earlier.
        - GOOGLE_PLAY_KEY = contents of the file received from Regina Griesbeck, the current owner of the Google Developer Account.
        - STORE_ALIAS = Alias specified for the keystore.
        - STORE_FILE = keystore
        - STORE_PASSWORD = Previously set keystore password
        - APP_STORE_CONNECT_API_KEY_ISSUER_ID: 522fd721-7636-42ce-a603-b2c7ce9beee2
        - IOS_API_ISSUER_ID: 522fd721-7636-42ce-a603-b2c7ce9beee2
        - APP_STORE_CONNECT_API_KEY_IS_KEY_CONTENT_BASE64: true
        - APP_STORE_CONNECT_API_KEY_KEY_ID: GVZYG65M6Y
        - IOS_API_KEY_ID: GVZYG65M6Y
        - IOS_API_KEY: same as APP_STORE_CONNECT_API_KEY_KEY below
        - APP_STORE_CONNECT_API_KEY_KEY: 
            LS0tLS1CRUdJTiBQUklWQVRFIEtFWS0tLS0tCk1JR1RBZ0VBTUJNR0J5cUdTTTQ5
            QWdFR0NDcUdTTTQ5QXdFSEJIa3dkd0lCQVFRZ1VoSk9jaVRNL2FIM1RrcGwKcGE4
            andLdTRXVTQ2d0RISTFvZHNyRG1obHNhZ0NnWUlLb1pJemowREFRZWhSQU5DQUFT
            WWdvRHUzSktjdGFBaApucC9UUGdlZXYvZVNWY21oQXE3K2RiVTZuMjhUS2N0WTFp
            OEJ4ZllLNVpQc2taMkw0NWtReU5NbFQ5N3cwd0FrClkwcTQ4MXJ0Ci0tLS0tRU5E
            IFBSSVZBVEUgS0VZLS0tLS0=
        - FASTLANE_PASSWORD: nh8obPZb4meZ3VgsyTsp (Your App Store Connect / Apple Developer Portal password)
        - MATCH_PASSWORD: nh8obPZb4meZ3VgsyTsp  (Encryption password for the certificates)
        - MATCH_USERNAME: mm-service@rchst.de   (Account that generated the certificates)
        - MATCH_GIT_BASIC_AUTHORIZATION in base64: hidden, github won't show it to you more than once. To generate a new one if needed: Follow the instructions at [https://docs.fastlane.tools/actions/match/](https://docs.fastlane.tools/actions/match/) (section 'Git Storage on GitHub')

## App und Build Configuration
The remaining configuration of the app and the build process is handled through environment variables in the `fastlane/.env` file. The following variables are currently used for configuration, build, and automatic release of the Android app:
- export APP_NAME="OTH Mattermost"
- export COMMIT_CHANGES_TO_GIT=true
- export ANDROID_BUILD_TASK=bundle
- export SUPPLY_TRACK=production
- export SUBMIT_ANDROID_TO_GOOGLE_PLAY=true
- export SUPPLY_PACKAGE_NAME=de.othregensburg.mattermost
- export SUPPLY_JSON_KEY=google-play-key.json
- export BUILD_FOR_RELEASE=true
- export REPLACE_ASSETS=true

Similarly, the following variables are used for the Apple version of the app:
- export MATCH_APP_IDENTIFIER=de.othregensburg.mattermost.NotificationService,de.othregensburg.mattermost.MattermostShare,de.othregensburg.mattermost
- export NOTIFICATION_SERVICE_IDENTIFIER=de.othregensburg.mattermost.NotificationService
- export MAIN_APP_IDENTIFIER=de.othregensburg.mattermost
- export EXTENSION_APP_IDENTIFIER=de.othregensburg.mattermost.MattermostShare
- export IOS_APP_GROUP=group.de.othregensburg.mattermost
- export IOS_ICLOUD_CONTAINER=iCloud.de.othregensburg.mattermost
- export SYNC_PROVISIONING_PROFILES=true
- export MATCH_TYPE=appstore
- export IOS_BUILD_EXPORT_METHOD=app-store
- export FASTLANE_TEAM_ID=4TPR8SJM7Z

- An Appfile is added to the `./fastlane` folder with the following content:
team_name "Ostbayerische Technische Hochschule Regensburg"
team_id "4TPR8SJM7Z"
itc_team_id "121869968"
itc_team_name "Ostbayerische Technische Hochschule Regensburg"

For further reading about the different variables, consult the corresponding part about the Appfile on [this website](https://medium.com/revelo-tech/setting-up-automatic-ios-release-with-fastlane-and-match-on-ci-cd-server-16c3f1d79bc5) or the [Appfile documentation](https://docs.fastlane.tools/advanced/Appfile/)

The original Matchfile only contains comments, so it can be completely replaced. It ensures that the relevant calls to match will find the correct certificate repository and compare these with the certificates in the Apple Developer Portal. The content of it is the following:
app_identifier ["de.othregensburg.mattermost", "de.othregensburg.mattermost.NotificationService", "de.othregensburg.mattermost.de.MattermostShare"]
username "mm-service@rchst.de" # Your Apple Developer Portal username
git_url("git@github.com:othrchst/mmfastlane.git")
git_branch("main") # can change the branch name if needed
storage_mode("git")
type("appstore")

- Match is being used to automatically generate, renew and manage the provisioning profiles and the certificates. See [the documentation](https://docs.fastlane.tools/actions/match/) for more details. 

- Certificates and profiles are being hosted on github at a private repository in [https://github.com/othrchst/mmfastlane](https://github.com/othrchst/mmfastlane). In regards to whether or not this is secure:
"An App Store profile can't be used for anything as long as it's not re-signed by Apple. The only way to get an app resigned is to submit an app for review which could take anywhere from 24 hours to a few days (checkout appreviewtimes.com for up-to-date expectations). Attackers could only submit an app for review, if they also got access to your App Store Connect credentials (which are not stored in git, but in your local keychain). Additionally you get an email notification every time a build gets uploaded to cancel the submission even before your app gets into the review stage." Source: [https://docs.fastlane.tools/actions/match/#is-this-secure](https://docs.fastlane.tools/actions/match/#is-this-secure)
- the "Country" field in the certificates is set to US for some unknown reason (the account that created them is set to Germany), this should not matter according to Apple support: https://developer.apple.com/forums/thread/84111, https://developer.apple.com/forums/thread/12543

- Since the Mattermost Team has moved away from CircleCI starting with version 2.5 onwards, the corresponding `config.yml` is not being updated anymore and thus some things have to be taken into account. If there happens to be a complete overhaul to the project, the `config.yml` might not work anymore. Some version specifiers (like the XCode version to be uses for the Apple build) have to be specified manually, especially when a version is declared as deprecated, as it won't be allowed on the App Store otherwise. Sed commands are being used for this but it can also be done manually.
- The Xcode version (line 31 in the `config.yml`) has to be set manually since the original version is no longer supported (use version 14.1 and above as of the time of this writing). You can check for the latest XCode version at https://xcodereleases.com/. There does not seem to be a CircleCI parameter that would simply get the latest version.
- Other values like node-version for npm might also be affected by this in the future
- The `config.yml` for the iOS build has to be changed slightly to avoid missing access rights when building with CircleCI. For this it is necessary to mark the two .sh files (`uploadDebugSymbols.sh` and `bundleReactNative.sh`) in the `/ios/` folder with the use of chmod. This is added via a sed command:
sed -i '/^          name: Run fastlane to build iOS/,/^            export TERM=xterm && bundle exec fastlane ios build/ c\
          name: Run fastlane to build iOS\n          no_output_timeout: 30m\n          command: |\n            HOMEBREW_NO_AUTO_UPDATE=1 brew install watchman\n            cd ../ios/\n            chmod +x uploadDebugSymbols.sh\n            chmod +x bundleReactNative.sh\n            cd ../fastlane/\n            export TERM=xterm && bundle exec fastlane ios build' ./.circleci/config.yml
If you decide to change this manually, search for the `build-ios` lane in the config file that says "Run fastlane to build iOS" (line 185 following). Here's what the changed lane commands look like:
          command: |
            HOMEBREW_NO_AUTO_UPDATE=1 brew install watchman
            cd ../ios/
            chmod +x uploadDebugSymbols.sh
            chmod +x bundleReactNative.sh
            cd ../fastlane/
            export TERM=xterm && bundle exec fastlane ios build

- Furthermore, the container size for the iOS build has to be changed since the original default values are no longer supported:
sed -i '/ios:/,/resource_class:/ s/default: medium/default: macos.m1.medium.gen1/g' ./.circleci/config.yml
    - Note: This parameter has changed from `medium` to `macos.x86.medium.gen2` to `macos.m1.medium.gen1` within one year, so it might change again.


## App Store Settings:
- Key words that dictate search results in the App Store are set to: Mattermost, Messaging, Open-Source, OTH, Ostbayerische Technische Hochschule Regensburg
- Datenschutz-URL: [https://rchst.de/mattermost-mobile-privacy-policy/](https://rchst.de/mattermost-mobile-privacy-policy/)
- For the support-url we chose to use the official mattermost mobile reference: [https://github.com/mattermost/mattermost-mobile/issues](https://github.com/mattermost/mattermost-mobile/issues)
- For the App Privacy we specified how data is being used similarly to the [original Mattermost App Store page](https://apps.apple.com/us/app/mattermost/id1257222717), that being Identifiers, Usage Data and Diagnostics not being linked to the user's identity.


## Noteworthy external documentation:
- Appfile: [https://docs.fastlane.tools/advanced/Appfile/](https://docs.fastlane.tools/advanced/Appfile/)
- Match: [https://docs.fastlane.tools/actions/match/](https://docs.fastlane.tools/actions/match/)
- More practical setup of match: [https://medium.com/revelo-tech/setting-up-automatic-ios-release-with-fastlane-and-match-on-ci-cd-server-16c3f1d79bc5](https://medium.com/revelo-tech/setting-up-automatic-ios-release-with-fastlane-and-match-on-ci-cd-server-16c3f1d79bc5)


## ToDo:
- [ ] update folder structure with appfile and matchfile