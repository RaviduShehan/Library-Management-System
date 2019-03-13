name := """Westminster LMS"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava).settings(
  watchSources ++= (baseDirectory.value / "public/ui" ** "*").get
)

scalaVersion := "2.12.2"

libraryDependencies += jdbc   // JDBC dependency
libraryDependencies += guice

// Test Database
libraryDependencies += "com.h2database" % "h2" % "1.4.194"

// Testing libraries for dealing with CompletionStage...
libraryDependencies += "org.assertj" % "assertj-core" % "3.6.2" % Test
libraryDependencies += "org.awaitility" % "awaitility" % "2.0.0" % Test

// Make verbose tests
testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))


//Added dependency for the mysql dataBase
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.41"
/*

name := "WestminsterLMS"

version := "1.0"

lazy val `WestminsterLMS` = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

scalaVersion := "2.11.11"
libraryDependencies += jdbc

libraryDependencies += guice


libraryDependencies ++= Seq( javaJdbc , cache , javaWs )
unmanagedResourceDirectories in Test <+= baseDirectory ( _ /"target/web/public/test" )
libraryDependencies += "mysql"%"mysql-connector-java"%"5.1.41"

*/