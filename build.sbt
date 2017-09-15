name := "projetoping"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "com.google.code.gson" % "gson" % "2.8.0",
  "org.quartz-scheduler" % "quartz" % "2.2.3"
)     

play.Project.playJavaSettings
