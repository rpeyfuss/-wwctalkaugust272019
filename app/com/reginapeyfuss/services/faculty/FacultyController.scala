package com.reginapeyfuss.services.faculty

import com.reginapeyfuss.services.utilities.FacultyUtilities
import javax.inject._
import play.api.mvc._

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class FacultyController @Inject()(cc: ControllerComponents,
                                  facultyMgr: FacultyManager)
    extends AbstractController(cc) {

    /**
      * Create an Action to render an HTML page.
      *
      * The configuration in the `routes` file means that this method
      * will be called when the application receives a `GET` request with
      * a path of `/`.
      */
    def faculty = Action { implicit request: Request[AnyContent] =>
        Ok("test")
    }

    def facultyType(typeName: String) = Action { implicit request: Request[AnyContent] =>
        FacultyUtilities.parseFacultyType(typeName) match {
            case Invalid => BadRequest
            case faculty => Ok("test")
        }
    }



}
