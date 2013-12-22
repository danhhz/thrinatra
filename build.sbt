import com.typesafe.sbt.SbtStartScript

name := "scribbles"

version := "0.1-SNAPSHOT"

scalaVersion := "2.10.3"

resolvers += "Twitter's Repository" at "http://maven.twttr.com/"

libraryDependencies += "com.twitter" % "finatra" % "1.4.0"

libraryDependencies += "com.foursquare" %% "rogue-lift" % "2.2.0" intransitive()

libraryDependencies += "org.mongodb" % "mongo-java-driver" % "2.9.3"

libraryDependencies += "com.foursquare" % "common-thrift-bson" % "1.7.0"

libraryDependencies += "net.liftweb" % "lift-mongodb-record_2.10" % "2.5.1"

seq(thriftSettings: _*)

seq(SbtStartScript.startScriptForJarSettings: _*)
