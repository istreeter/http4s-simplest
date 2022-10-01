package com.example

import cats.effect._
import org.http4s._
import org.http4s.dsl._
import org.http4s.dsl.io._
import org.http4s.syntax._
import org.http4s.server.blaze.BlazeServerBuilder

object QuickstartApp extends IOApp {

  val routes = HttpRoutes.of[IO] {
    case req @ POST -> Root / "ping" => {
      req.body.compile.drain.flatMap { _ =>
        Ok("ok")
      }
    }
  }

  override def run(args: List[String]): IO[ExitCode] =
    BlazeServerBuilder[IO].bindHttp(8080, "0.0.0.0")
      .withHttpApp(routes.orNotFound)
      .serve
      .compile
      .drain
      .as(ExitCode.Success)
}
