# mattermost
Complete OTH Mattermost Deployment and Configuration Guide
## Overview

### Project Structure in gitlab
```markdown
├── Mattermost-LDAP-Middleware
├── Mattermost-LDAP
├── Mattermost-mobile-ci
├── Mattermost-retention
├── Mattermost-sync
├── nginx
├── scripts
├── README.md
├── docker-compose.yml
└── .gitignore
```

All services are deployed using the `docker-compose.yml` file, providing a comprehensive setup for Mattermost. The key components and functionalities include:
- Nginx Reverse Proxy: Acts as a reverse proxy for the following endpoints:
    - https://mm.rchst.de > Mattermost
    - https://oauth.rchst.de > Mattermost-LDAP
- Mattermost-LDAP-middleware and Mattermost-LDAP:  Enables integrated authentication with GitLab SSO using the OTH ActiveDirectory service.
- Mattermost-Retention: Automates the removal of data older than 6 months.
- Mattermost-Sync: Performs synchronization between Mattermost teams/groups and ActiveDirectory groups.

## How-To: Deployment and Update Instructions
To update the Mattermost service, follow these steps:
1. Edit the `docker-compose.yml` and specify the preferred [Mattermost Version](https://docs.mattermost.com/install/self-managed-changelog.html)
2. Pull the updated Mattermost image: `docker-compose pull mattermost`
3. Start the Mattermost Service and detach the process from the terminal: `docker-compose up -d mattermost`

Or use the single combined command: `docker-compose pull mattermost docker-compose up -d mattermost` to combine steps 2 and 3.

Alternatively, for updating a single self-build service, use the following commands:
- `docker-compose build myservice`
- `docker-compose up -d myservice`

## Mattermost Push Proxy

To set up the Mattermost Push Proxy, perform the following actions:

1. Start the Mattermost Push Proxy service: `docker-compose up -d mattermost-push`
2. Configuration:
    - Android: Set the Android Firebase API Key (provided by Regina Griesbeck, safely stored in 1Password).
    - Apple:
        - Generate an Apple Push Notification certificate according to this guide: https://developers.mattermost.com/contribute/more-info/mobile/push-notifications/ios/
        - Use that certificate to generate a pem file according to this guide: https://developers.mattermost.com/contribute/more-info/mobile/push-notifications/service/
        - Modify the `"ApplePushTopic"` value in `/docker/volumes/docker_mattermost-push/_data/mattermost-push-proxy.json` to `"de.othregensburg.mattermost"`
        - Set the correct path to the pem-file in the same json-file
3. Configure the Mattermost Server to enable and send push notifications:
    - Go to System Console -> Push Notification Server
    - Set the value of `"Enable Push Notifications"` to  `"Manually enter Push Notification Service Location"` and provide the address at which the configured Push Proxy is accessible in the field `"Push Notification Server`
    - The push-proxy's default port is 8066 unless manually changed
    - Optional: Customize the content of push notifications in System Console -> Notifications

## Licenses
- Since the original Mattermost project is using the Apache License Version 2.0, this project will do so as well. This means that significant changes to the original are being documented. The original NOTICE.txt file is also being included which documents a list of open source components used in Mattermost Mobile, including those that have been modified. As there are no major changes apart from minor settings and adding environment variables, the NOTICE file will remain unchanged and all changes to the original Mattermost Mobile will be documented in this readme.
- The LICENSE.txt file is being adapted to include a copyright notice according to this question: https://opensource.stackexchange.com/questions/7300/copyright-notice-in-the-file-header-apache-v2-license. As such, a "Copyright Ostbayerische Techniche Hochschule Regensburg 2023. All rights reserved. Based on Mattermost mobile project (Copyright 2015-present Mattermost, Inc.)" is being added at the start of the file:
sed -i 's/Copyright 2015-present Mattermost, Inc./Copyright Ostbayerische Techniche Hochschule Regensburg 2023. All rights reserved.\n\nBased on Mattermost mobile project (Copyright 2015-present Mattermost, Inc.)/' ./LICENSE.txt


## TODO
- Mattermost Push Proxy
-  - [ ] restart -> MM Serverkonfig konfigurieren

