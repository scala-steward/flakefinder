name         := """flakefinder"""
organization := "com.henricook"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.10"

libraryDependencies += guice

libraryDependencies ++= List(
  // Cats
  "org.typelevel" %% "cats-core"   % "2.9.0" withJavadoc (),
  "org.typelevel" %% "cats-effect" % "3.4.10",

  // XML Parsing
  "ru.tinkoff" %% "phobos-core" % "0.20.0",

  // Test
  "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
  "com.lihaoyi"            %% "pprint"             % "0.8.1" % Test,
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.henricook.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.henricook.binders._"
