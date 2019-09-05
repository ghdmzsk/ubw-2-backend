val scalaV = "2.13.0"

name := "dotty-simple"
version := "0.1.0"

scalaVersion := scalaV

libraryDependencies ++= Seq(
  "com.chuusai" %% "shapeless" % "2.3.3"
)
