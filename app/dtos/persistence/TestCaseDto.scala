package dtos.persistence

import dtos.xml.JUnitXMLDto

import java.time.Instant

case class TestCaseDto(
                        organisation_id: String,
                        suite_name: String,
                        timestamp: Instant,
                        run_time: Double,
                        correlation_id: String,
                        test_name: String,
                        test_time: Double,
                        test_pass: Boolean,
                        failure_message: Option[String],
                      )

object TestCaseDto {

  def fromModel(xml: JUnitXMLDto, organisationId: String, correlationId: String): List[TestCaseDto] = {
    xml.testsuite.flatMap { testSuite =>
      testSuite.testcase.map { testCase =>
        TestCaseDto(
          organisation_id = organisationId,
          suite_name = testSuite.name,
          timestamp = Instant.parse(testSuite.timestamp),
          run_time = testSuite.time,
          correlation_id = correlationId,
          test_name = testCase.name,
          test_time = testCase.time,
          test_pass = testCase.failure.isEmpty,
          failure_message = testCase.failure.map(_.message)
        )
      }
    }
  }
}