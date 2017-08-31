package models.dao

// Source: https://stackoverflow.com/questions/39185780/play-framework-anorm-withconnection-error
// Source: https://github.com/tobyjsullivan/applicative-demo/blob/master/chapter2.1/app/models/dao/FavouriteStudioDAO.scala
// Source: https://www.youtube.com/watch?v=jaZIilhjcDw&index=8&list=PL9PYCDsIJ_oTFD-Ga91B05o94kHBhoaFW&t=1609s

import play.db._
import anorm._
import models.User
import play.api.db.DB
import play.api.Play.current
import javax.inject.{Inject, Singleton}
import java.sql._
import anorm.SqlParser.{ int, str, to }

//@Singleton
//class UserDAO @Inject() (dBApi: DBApi) {
object UserDAO {
  //private val db = dBApi.getDatabase("default")

  def get_all(): List[User] = {
    DB.withConnection { implicit c =>
      val results = SQL(
        """
          |SELECT * FROM users
          |
        """.stripMargin
      ).apply()

      results.map { row =>
        User(row[Int]("id"), row[String]("first_name"), row[String]("last_name"),
          row[String]("user_name"), row[String]("email"), row[Int]("active"),
          row[Int]("date_updated"), row[Int]("date_created"))
      }.force.toList
    }
  }

  def get_by_id(id: Int): User = {
    DB.withConnection { implicit c =>
      //val parser = int("id") ~ str("first_name") ~ str("last_name") ~ str("user_name") ~ str("email") ~ int("active") ~ int("date_updated") ~ int("date_created") map { case id ~ first_name ~ last_name ~ user_name ~ email ~ active ~ date_updated ~ date_created => (id, first_name, last_name, user_name, email, active, date_updated, date_created) }

      //val results: List[(Int, String, String, String, String, Int, Int, Int)] = SQL(
      val results = SQL(
        """
          |SELECT * FROM users
          |WHERE id = {user_id}
          |
        """.stripMargin
      ).on(
        "user_id" -> id
      ).apply() //.as(parser.flatten.*)

      val user = results.map { row =>
        User(row[Int]("id"), row[String]("first_name"), row[String]("last_name"),
          row[String]("user_name"), row[String]("email"), row[Int]("active"),
          row[Int]("date_updated"), row[Int]("date_created"))
      }

      user.head
      //User(5, "test_user", "test_last", "test_user", "test@gmail.com", 1, 10, 11)
    }
  }
}
