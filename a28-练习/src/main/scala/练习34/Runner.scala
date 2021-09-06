package 练习34

import java.io.{File, PrintWriter}
import java.nio.file.Paths
import scala.io.Source
import scala.util.Using

object Runner extends App {

  Using(Source.fromFile(Paths.get("e:", "1.txt").toFile, "utf-8")) { aa =>
    val bb = aa.getLines().mkString
    val cc = bb.split("。")

    def trimLines(i: Array[String]): String =
      i.map(p => (p.trim, p)).filter(!_._1.isEmpty).map(_._2).mkString("。" + System.lineSeparator)

    Using(new PrintWriter(Paths.get("e:", "2.txt").toFile, "utf-8")) { writer =>
      val content = trimLines(cc)
      writer.println(content)
    }
  }

}
