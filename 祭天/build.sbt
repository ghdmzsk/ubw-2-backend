scalaVersion := "2.13.0"

libraryDependencies ++= Seq(
  "com.chuusai" %% "shapeless" % "2.3.3"
)

val circeVersion = "0.12.1"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)