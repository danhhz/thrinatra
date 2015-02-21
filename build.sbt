import com.typesafe.sbt.SbtStartScript

name := "thrinatra"

version := "0.1-SNAPSHOT"

scalaVersion := "2.10.3"

resolvers += "Twitter's Repository" at "http://maven.twttr.com/"

libraryDependencies += "com.twitter" %% "finatra" % "1.6.0"

libraryDependencies += "com.foursquare" %% "rogue-field" % "2.2.1" intransitive()

libraryDependencies += "com.foursquare" %% "rogue-index" % "3.0.0-beta13.1" intransitive()

libraryDependencies += "com.foursquare" %% "rogue-core" % "3.0.0-beta13.1" intransitive()

libraryDependencies += "com.foursquare" %% "rogue-spindle" % "3.0.0-beta13.1" intransitive()

libraryDependencies += "org.mongodb" % "mongo-java-driver" % "2.10.1"

libraryDependencies += "com.foursquare" % "common-thrift-bson" % "1.7.0"

seq(thriftSettings: _*)

seq(SbtStartScript.startScriptForJarSettings: _*)
