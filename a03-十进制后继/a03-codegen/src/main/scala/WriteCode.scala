package shijinzhi

import java.io.PrintWriter
import java.nio.file.{Files, Paths}

import scala.io.Source
import scala.util.Using

object WriteCode {

  def trimLines(i: String): String = Source.fromString(i).getLines.map(p => (p.trim, p)).filter(!_._1.isEmpty).map(_._2).mkString(System.lineSeparator)
  val filePath                     = Paths.get(".").resolve("a03-十进制后继").resolve("a03-core").resolve("src").resolve("main").resolve("scala")

  def main(arr: Array[String]): Unit = {
    {
      Files.createDirectories(filePath)
      Using(new PrintWriter(filePath.resolve("Setter.scala").toFile, "utf-8")) { writer =>
        val content = trimLines(views.txt.Setter(jinzhi = 10).body)
        writer.println(content)
      }
    }

    {
      Files.createDirectories(filePath)
      Using(new PrintWriter(filePath.resolve("Counter.scala").toFile, "utf-8")) { writer =>
        val content = trimLines(views.txt.Counter(jinzhi = 10).body)
        writer.println(content)
      }
    }

    {
      Files.createDirectories(filePath)
      Using(new PrintWriter(filePath.resolve("JinzhiItem.scala").toFile, "utf-8")) { writer =>
        val content = trimLines(views.txt.Item(jinzhi = 10).body)
        writer.println(content)
      }
    }

    {
      Files.createDirectories(filePath)
      Using(new PrintWriter(filePath.resolve("Data.scala").toFile, "utf-8")) { writer =>
        val content = trimLines(views.txt.Data(maxItem = 222).body)
        writer.println(content)
      }
    }

    {
      Files.createDirectories(filePath)
      Using(new PrintWriter(filePath.resolve("Runner.scala").toFile, "utf-8")) { writer =>
        val content = trimLines(views.txt.Runner(maxItem = 222).body)
        writer.println(content)
      }
    }

    {
      Files.createDirectories(filePath)
      Using(new PrintWriter(filePath.resolve("TypeRunner.scala").toFile, "utf-8")) { writer =>
        val content = trimLines(views.txt.TypeRunner(maxItem = 222).body)
        writer.println(content)
      }
    }

  }

}
