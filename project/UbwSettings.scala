import org.scalafmt.sbt.ScalafmtPlugin.autoImport.scalafmtOnCompile
import sbt._
import sbt.Keys._

object UbwSettings {

  val currentScalaVersion = "2.13.6"
  val dottyVersion        = "3.0.1"

  val setting1 = scalaVersion      := currentScalaVersion
  val setting2 = version           := "0.0.4-SNAP2020060801"
  val setting3 = organization      := "org.xarcher"
  val setting4 = licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
  val setting5 = scalafmtOnCompile := true
  val setting6 = scalaVersion      := dottyVersion

  val scalaVersionSettings = Seq(setting1, setting2, setting3, setting4, setting5)
  val dottyVersionSettings = Seq(setting2, setting3, setting4, setting6, setting5)

}
