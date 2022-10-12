WorldMac Telegram Bot.


## Deployment
Deployment process as easy as possible:
Required software:
- terminal for running bash scripts
- docker
- docker-compose

to deploy application, switch to needed branch and run bash script:


create a folder /envForWmBot/env in the project folder
create two files with variables in it 

1) wm-bot.env

    
    structure wm-bot.env file:
        BOT_NAME=botName
        BOT_TOKEN=botToken
        BOT_DB_USERNAME=dbUser
        BOT_DB_PASSWORD=dbPass

2) wm-bot-db.env
    
    
    structure wm-bot-db.env file:
        BOT_DB_USERNAME=dbUser
        BOT_DB_PASSWORD=dbPass

$ bash start.sh

That's all.