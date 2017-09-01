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
object UserGroupMembershipDAO {
  //private val db = dBApi.getDatabase("default")

  def get_users_for_group(group_id: Int): List[User] = {
    DB.withConnection { implicit c =>
      val results = SQL(
        s"""
          |SELECT users.* FROM users
          |JOIN user_group_membership ON user_group_membership.user_id = users.id
          |WHERE group_id = {group_id}
          |ORDER BY users.id asc
          |
        """.stripMargin
      ).on(
        "group_id" -> group_id
      ).apply()

      results.map { row =>
        User(row[Int]("id"), row[String]("first_name"), row[String]("last_name"),
          row[String]("user_name"), row[String]("email"), row[Int]("active"),
          row[Int]("date_updated"), row[Int]("date_created"))
      }.force.toList
    }
  }
}
