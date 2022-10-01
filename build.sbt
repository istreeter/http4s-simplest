organization := "com.example"
name := "http4s-simplest"
scalaVersion := "2.13.4"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-blaze-server" % "0.23.12",
  "org.http4s" %% "http4s-dsl"          % "0.23.12",
  "org.slf4j"  %  "slf4j-simple"        % "1.6.4"
)
