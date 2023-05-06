FROM sbtscala/scala-sbt:graalvm-ce-21.3.0-java11_1.8.1_2.13.10 AS builder

COPY files/run-java.sh /usr/local/bin/

RUN chmod 755 /usr/local/bin/run-java.sh && mkdir /build

WORKDIR /build

COPY build.sbt ./

COPY project ./project/
COPY conf ./conf/
COPY test ./test/
COPY app ./app/

RUN JAVA_OPTS="$(run-java.sh options) -Xmx1G -Xss8m -Dfile.encoding=UTF8 -XX:+UseStringDeduplication" sbt -v universal:stage \
    && mv target/universal/stage /app \
    && chmod 755 /app/bin/*

FROM azul/zulu-openjdk-alpine:11-latest

RUN apk --no-cache add curl bash

WORKDIR /app

RUN chown nobody /app

EXPOSE 2005
USER nobody

COPY --from=builder /app/ /app/
COPY --from=builder /usr/local/bin/run-java.sh /usr/local/bin/run-java.sh

ENV DB_PASSWORD=
ENV DB_USERNAME=
ENV DB_HOST=

ENTRYPOINT [ "/bin/sh", "-c", "JAVA_OPTS=\"-XX:+UseStringDeduplication --add-exports=java.base/sun.security.x509=ALL-UNNAMED --add-opens=java.base/sun.security.ssl=ALL-UNNAMED $(run-java.sh options --jit --diagnostic --cpu --gc)\" exec /app/bin/flakefinder -Dhttp.port=2005" ]