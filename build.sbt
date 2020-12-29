import sbt._
import sbt.Keys.{publishArtifact, _}
import NativePackagerKeys._

lazy val commonSettings = Seq(
    organization  := "com.synthesissolutions",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.11.6"

)

lazy val web = (project in file("web")).
  settings(commonSettings: _*).
  settings(
    /* Project specific settings here */
    name := "web-demo",
    libraryDependencies ++= Seq( javaJdbc,
      cache, filters, javaWs),
    unmanagedResourceDirectories in Test <+= baseDirectory ( _ / "target/web/public/test" ),
    routesGenerator := InjectedRoutesGenerator,
    publishArtifact in (Compile, packageBin) := false ).enablePlugins(PlayJava)