# Flakefinder

Submit multiple JUnit reports for a test run to get aggregate statistics (such as which tests fail the most often). 

This is _Rough and ready_ i.e. barely any error handling to speak of, not forgiving of poor inputs. It is heavily influenced by the JUnit format that Cypress outputs.

# Requirements to Run

## Database

This project currently only supports a postgres database

## Environment variables

| Variable Name | Description                                          |
| ---------- |------------------------------------------------------|
| DB_HOST | The host of your database                            |
| DB_USERNAME | The username to connect to your database as          |
| DB_PASSWORD | The password to use when connecting to your database |

# Running: Docker Example

```
docker build -f build/Dockerfile -t flake .
docker run flake -e DB_PASSWORD=foo -e DB_USERNAME=bar -e DB_HOST=localhost
```

# Running: CLI/SBT Example

```
DB_PASSWORD=foo DB_USERNAME=bar DB_HOST=localhost sbt run
```

# Screenshot

![Flakefinder JUnit Test Summary](https://github.com/henricook/flakefinder/raw/main/docs/screenshots/summary.png)