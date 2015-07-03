name := "akka"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.3.11"
libraryDependencies += "com.typesafe.akka" % "akka-remote_2.11" % "2.3.11"

enablePlugins(DockerPlugin)

dockerAutoPackageJavaApplication()