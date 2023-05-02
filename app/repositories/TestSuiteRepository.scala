package repositories

import cats.effect.IO
import doobie.util.transactor.Transactor
import models.config.DBConfig
import play.api.Configuration

import javax.inject.Inject

case class TestSuiteRepository @Inject()(config: Configuration) {

  val dbConfig = config.get[DBConfig]("db")

  val xa = Transactor.fromDriverManager[IO](
    driver = "org.postgresql.Driver", // driver classname
    url = "jdbc:postgresql:flakefinder", // connect URL (driver-specific)
    user = dbConfig.username, // user
     pass = dbConfig.password // password
  )
}
