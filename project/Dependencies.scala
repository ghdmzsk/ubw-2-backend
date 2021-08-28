import sbt._
import sbt.Keys._

object Dependencies {

  val circeVersion = "0.14.1"
  val circe = Seq(
    "io.circe" %% "circe-core",
    "io.circe" %% "circe-generic",
    "io.circe" %% "circe-parser"
  ).map(_ % circeVersion)

  val shapeless = Seq("com.chuusai" %% "shapeless" % "2.3.7")

  def scalaReflect(scalaVersion: String) = Seq("org.scala-lang" % "scala-reflect" % scalaVersion)

  val scalaTestVersion = "3.2.9"
  val scalaTest = Seq(
    "org.scalactic"  %% "scalactic"  % scalaTestVersion,
    "org.scalatest"  %% "scalatest"  % scalaTestVersion % "test",
    "org.scalacheck" %% "scalacheck" % "1.14.1"         % "test"
  )

  val spire     = "org.typelevel" %% "spire"      % "0.17.0"
  val commonsIO = "commons-io"     % "commons-io" % "2.6"

}
