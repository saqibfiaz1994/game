name := "hmrc-apprentice-scalajs"

version := "0.1"

scalaVersion := "2.12.8"


enablePlugins(ScalaJSPlugin)

// This is an application with a main method
scalaJSUseMainModuleInitializer := true

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.6"
