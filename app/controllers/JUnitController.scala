package controllers

import dtos.JUnitContentDto
import dtos.xml.JUnitXMLDto

import javax.inject._
import play.api._
import play.api.mvc._
import services.JUnitService
import cats.implicits._

import ru.tinkoff.phobos.decoding._
import ru.tinkoff.phobos.syntax._
import ru.tinkoff.phobos.derivation.semiauto._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class JUnitController @Inject()(val controllerComponents: ControllerComponents, junitService: JUnitService) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def load(): Action[JUnitContentDto] = Action(parse.json[JUnitContentDto]) { implicit request: Request[JUnitContentDto] =>
    XmlDecoder[JUnitXMLDto].decode(request.body.xml) match {
      case Left(err) => throw new Exception(s"Unexpected error: expected Right(...) but got Left($err)")
      case Right(xml) =>

        val result = junitService.load(request.body.organisationId, request.body.correlationId, xml)

        Ok(views.html.index())
    }
  }
}
