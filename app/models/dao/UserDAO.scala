package models.dao

import play.db._
import anorm._
import models.User
import play.api.db.DB
import play.api.Play.current
import javax.inject.{Inject, Singleton}

@Singleton
class UserDAO @Inject() (dBApi: DBApi) {
  private val db = dBApi.getDatabase("default")
/*
  def get_all(): List[User] = {
    db.withConnection {
      implicit c => {
        val results = SQL(
          """
            |SELECT * FROM users
            |
          """.stripMargin
        ).apply()

        results.map { row =>
          User(row[Int]("id"), 3)
        }.force.toList
      }
    }
  }
  */
}
