<h1>WebHook telegram bot + Spring Boot</h1>

<p>a simple Telegram bot that repeats every message you write</p>
<p> This bot was created to teach you how to use a webhook, don't expect too much from it👨‍💻</p>

<h2>Quick Start</h2>

<p> To start this bot you will need:
  <ul>
    <li>bot token - you can ask it from your @BotFather</li>
    <li>Bot name - you can ask it from your @BotFather</li>
    <li>Webhook link - I will be using ngrok but you can use whatever you want😉</li>
  </ul>
<p>

<div>
  <p> Use this command in your terminal to start ngrok: </p>

  ```CMD
  ~ ngrok http 8080
  ```

  <img width="890" alt="Screenshot 2023-12-23 at 19 34 06" src="https://github.com/nhavronskyi/webhook-telegram-bot-demo/assets/96009885/c2c18d0c-cd79-4d4c-8497-9ab9a6875497">

  <p>You need to set this link to the telegram bot as a webhook</p>

  ```HTTP
  GET https://api.telegram.org/bot<your_token>/setWebhook?url=<copied_link>
  ```

Then you should receive an answer like:

  ```JSON
  {
    "ok": true,
    "result": true,
    "description": "Webhook was set"
  }
  ```

You can check if the link chains with your bot:

  ```HTTP
  GET https://api.telegram.org/bot<your_token>/getWebhookInfo
  ```

Now you can put your webhook link to your application properties, and run your application.
</div>


