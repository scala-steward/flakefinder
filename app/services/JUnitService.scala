package services

import dtos.xml.{JUnitXMLDto, TestSuiteXMLDto}
import play.api.Logger

import javax.inject.Inject
import cats.implicits._
import javax.inject.Singleton


@Singleton
case class JUnitService @Inject()() {

  val logger: Logger = Logger(this.getClass())

  protected type InMemStorage = Map[String, Map[String, List[TestSuiteXMLDto]]]
  // Organisation Id -> Correlation Id -> TestStats
  var inMemStorage: InMemStorage = Map[String, Map[String, List[TestSuiteXMLDto]]]()

  def load(organisationId: String, correlationId: String, xml: JUnitXMLDto): InMemStorage = {
    logger.info(s"Parsing XML for organisationId $organisationId / correlationId: $correlationId")

    // Filter out suites with 0 tests
    val filteredTestSuites = xml.testsuite.filter(_.testcase.size =!= 0)

    inMemStorage = inMemStorage |+| Map(organisationId -> Map(correlationId -> filteredTestSuites))

    logger.info(s"Done parsing XML for organisationId $organisationId / correlationId: $correlationId")

    inMemStorage
  }
}
