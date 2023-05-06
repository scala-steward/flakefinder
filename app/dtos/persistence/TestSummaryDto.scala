package dtos.persistence

import dtos.xml.JUnitXMLDto

import java.time.Instant

case class TestSummaryDto(
                        test_name: String,
                        passes: Int,
                        failures: Int,
                        unique_builds: Int,
                        most_common_failure_message: Option[String]
                      )

