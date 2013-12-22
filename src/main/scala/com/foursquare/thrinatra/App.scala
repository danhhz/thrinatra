package com.foursquare.thrinatra

import com.foursquare.rogue.Rogue._
import com.foursquare.rogue.spindle.{SpindleQuery => Q}
import com.twitter.finatra._
import com.twitter.finatra.ContentType._
import org.bson.types.ObjectId

object App extends FinatraServer {

  class ThrinatraController extends Controller {

    class ThrinatraMustache(val items: Seq[Item]) extends View {
      val template = "thrinatra.mustache"
    }
    get("/") { request =>
      val items = Database.fetch(Q(Item).orderDesc(_.id))
      val template = new ThrinatraMustache(items)
      render.view(template).toFuture
    }

    post("/item/put") { request =>
      val text = request.params.getOrElse("text", ???)
      Database.save(Item.newBuilder
        .id(ObjectId.get)
        .text(text)
        .result())
      redirect("/").toFuture
    }

    post("/item/:id/delete") { request =>
      val id = new ObjectId(request.routeParams.getOrElse("id", ???))
      Database.findAndDeleteOne(Q(Item).where(_.id eqs id))
      redirect("/", permanent = true).toFuture
    }

    notFound { request =>
      render.status(404).plain("not found yo").toFuture
    }
  }

  val app = new ThrinatraController
  register(app)
}
