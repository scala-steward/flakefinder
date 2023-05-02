# Flakefinder

Submit multiple JUnit reports for a test run to get aggregate statistics (such as which tests fail the most often)

This is _Rough and ready_ i.e. barely any error handling to speak of, not forgiving of poor inputs

# Requirements to Run

## Database

This project currently only supports a postgres database

## Environment variables

| Variable Name | Description                                          |
| ---------- |------------------------------------------------------|
| DB_HOST | The host of your database                            |
| DB_USERNAME | The username to connect to your database as          |
| DB_PASSWORD | The password to use when connecting to your database |