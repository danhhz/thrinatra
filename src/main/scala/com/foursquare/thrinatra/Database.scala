package com.foursquare.thrinatra

import com.foursquare.rogue.spindle.{SpindleDBCollectionFactory, SpindleDatabaseService}
import com.foursquare.spindle.UntypedMetaRecord
import com.mongodb.{DB, Mongo, MongoClient, MongoURI}

object ConcreteDBCollectionFactory extends SpindleDBCollectionFactory {
  lazy val db: DB = {
    val mongoUrl = System.getenv("MONGOHQ_URL")
    if (mongoUrl == null) {
      // TODO(dan): Support a flag override
      new MongoClient("localhost", 27017).getDB("thrinatra")
    } else {
      val mongoURI = new MongoURI(mongoUrl)
      val mongo = mongoURI.connectDB
      if (mongoURI.getUsername != null && mongoURI.getUsername.nonEmpty) {
        mongo.authenticate(mongoURI.getUsername, mongoURI.getPassword)
      }
      mongo
    }
  }
  override def getPrimaryDB(meta: UntypedMetaRecord) = db
  override def indexCache = None
}

object Database extends SpindleDatabaseService(ConcreteDBCollectionFactory)
