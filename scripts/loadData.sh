#!/bin/bash
# Script requires:
#  - jq
#  - curl


# Double escape double quotes, once for bash and another for JSON payload
FILE1_CONTENT=$(cat ../test/resources/fixtures/valid-junit-1.xml | jq -Rsa)
FILE2_CONTENT=$(cat ../test/resources/fixtures/valid-junit-2.xml | jq -Rsa)
FILE3_CONTENT=$(cat ../test/resources/fixtures/valid-junit-3.xml | jq -Rsa)

ORG_ID="testorg"

BUILD_ID="A"

curl http://localhost:2005/load -X POST -H "Content-type: application/json" -d "{\"organisationId\": \"$ORG_ID\", \"buildId\": \"$BUILD_ID\", \"xml\": $FILE1_CONTENT}"
curl http://localhost:2005/load -X POST -H "Content-type: application/json" -d "{\"organisationId\": \"$ORG_ID\", \"buildId\": \"$BUILD_ID\", \"xml\": $FILE2_CONTENT}"
curl http://localhost:2005/load -X POST -H "Content-type: application/json" -d "{\"organisationId\": \"$ORG_ID\", \"buildId\": \"$BUILD_ID\", \"xml\": $FILE3_CONTENT}"

BUILD_ID="B"

curl http://localhost:2005/load -X POST -H "Content-type: application/json" -d "{\"organisationId\": \"$ORG_ID\", \"buildId\": \"$BUILD_ID\", \"xml\": $FILE1_CONTENT}"

BUILD_ID="F"

curl http://localhost:2005/load -X POST -H "Content-type: application/json" -d "{\"organisationId\": \"$ORG_ID\", \"buildId\": \"$BUILD_ID\", \"xml\": $FILE1_CONTENT}"
curl http://localhost:2005/load -X POST -H "Content-type: application/json" -d "{\"organisationId\": \"$ORG_ID\", \"buildId\": \"$BUILD_ID\", \"xml\": $FILE2_CONTENT}"
curl http://localhost:2005/load -X POST -H "Content-type: application/json" -d "{\"organisationId\": \"$ORG_ID\", \"buildId\": \"$BUILD_ID\", \"xml\": $FILE3_CONTENT}"
curl http://localhost:2005/load -X POST -H "Content-type: application/json" -d "{\"organisationId\": \"$ORG_ID\", \"buildId\": \"$BUILD_ID\", \"xml\": $FILE3_CONTENT}"
curl http://localhost:2005/load -X POST -H "Content-type: application/json" -d "{\"organisationId\": \"$ORG_ID\", \"buildId\": \"$BUILD_ID\", \"xml\": $FILE3_CONTENT}"
curl http://localhost:2005/load -X POST -H "Content-type: application/json" -d "{\"organisationId\": \"$ORG_ID\", \"buildId\": \"$BUILD_ID\", \"xml\": $FILE3_CONTENT}"
curl http://localhost:2005/load -X POST -H "Content-type: application/json" -d "{\"organisationId\": \"$ORG_ID\", \"buildId\": \"$BUILD_ID\", \"xml\": $FILE3_CONTENT}"
curl http://localhost:2005/load -X POST -H "Content-type: application/json" -d "{\"organisationId\": \"$ORG_ID\", \"buildId\": \"$BUILD_ID\", \"xml\": $FILE3_CONTENT}"
curl http://localhost:2005/load -X POST -H "Content-type: application/json" -d "{\"organisationId\": \"$ORG_ID\", \"buildId\": \"$BUILD_ID\", \"xml\": $FILE3_CONTENT}"
curl http://localhost:2005/load -X POST -H "Content-type: application/json" -d "{\"organisationId\": \"$ORG_ID\", \"buildId\": \"$BUILD_ID\", \"xml\": $FILE3_CONTENT}"
curl http://localhost:2005/load -X POST -H "Content-type: application/json" -d "{\"organisationId\": \"$ORG_ID\", \"buildId\": \"$BUILD_ID\", \"xml\": $FILE3_CONTENT}"
curl http://localhost:2005/load -X POST -H "Content-type: application/json" -d "{\"organisationId\": \"$ORG_ID\", \"buildId\": \"$BUILD_ID\", \"xml\": $FILE3_CONTENT}"
curl http://localhost:2005/load -X POST -H "Content-type: application/json" -d "{\"organisationId\": \"$ORG_ID\", \"buildId\": \"$BUILD_ID\", \"xml\": $FILE3_CONTENT}"
curl http://localhost:2005/load -X POST -H "Content-type: application/json" -d "{\"organisationId\": \"$ORG_ID\", \"buildId\": \"$BUILD_ID\", \"xml\": $FILE3_CONTENT}"
curl http://localhost:2005/load -X POST -H "Content-type: application/json" -d "{\"organisationId\": \"$ORG_ID\", \"buildId\": \"$BUILD_ID\", \"xml\": $FILE3_CONTENT}"
