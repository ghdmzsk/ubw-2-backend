scalaVersion := "2.12.8"

val circeVersion = "0.9.3"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core"
  , "io.circe" %% "circe-generic"
  , "io.circe" %% "circe-parser"
  , "io.circe" %% "circe-literal"
).map(_ % circeVersion)