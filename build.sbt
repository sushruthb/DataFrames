name := "hello"
  
version := "1.0"
fork := true
  
scalaVersion := "2.11.11"
  
  
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.2.0"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.2.0"

scalacOptions += "-target:jvm-1.8"