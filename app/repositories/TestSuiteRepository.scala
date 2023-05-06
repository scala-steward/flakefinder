package repositories

import cats.effect.IO
import doobie.ConnectionIO
import doobie.util.transactor.Transactor
import dtos.xml.JUnitXMLDto
import models.config.DBConfig
import play.api.Configuration
import doobie.implicits._
import cats.implicits._
import doobie.util.meta.Meta
import doobie.util.update.Update
import doobie.postgres.implicits._
import dtos.persistence.TestCaseDto

import java.time.Instant
import javax.inject.Inject

case class TestSuiteRepository @Inject() (config: Configuration) {

  val dbConfig = config.get[DBConfig]("db")

  val xa = Transactor.fromDriverManager[IO](
    driver = "org.postgresql.Driver",       // driver classname
    url    = "jdbc:postgresql:flakefinder", // connect URL (driver-specific)
    user   = dbConfig.username,             // user
    pass   = dbConfig.password,             // password
  )

  def load(organisationId: String, correlationId: String, xml: JUnitXMLDto): ConnectionIO[Unit] = {
    val sql = """INSERT INTO test_cases (organisation_id, suite_name, timestamp, run_time, correlation_id, test_name, test_time, test_pass, failure_message) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"""

    val dtos = TestCaseDto.fromModel(xml, organisationId, correlationId)

    Update[TestCaseDto](sql).updateMany(dtos).void
  }
}
