package models

import models.dao.UserDAO
import play.api.libs.functional.syntax._
import play.api.libs.json._

object User {
  implicit val userWrites: Writes[User] = (
      (JsPath \ "id").write[Int] and
      (JsPath \ "first_name").write[String] and
      (JsPath \ "last_name").write[String] and
      (JsPath \ "user_name").write[String] and
      (JsPath \ "email").write[String] and
      (JsPath \ "active").write[Int] and
      (JsPath \ "date_updated").write[Int] and
      (JsPath \ "date_created").write[Int]
    )(unlift(User.unapply))

   def get_all(filter:Option[String], count: Int = 10, startIndex: Int = 0): List[User] = {
     val users = UserDAO.get_all(filter, count, startIndex)

     users
   }

   def get_by_id(id: Int): User = {
     val user = UserDAO.get_by_id(id)

     user
   }

   def delete(id: Int) = {
     UserDAO.delete(id)
   }
}

case class User(id: Int, first_name: String, last_name: String, user_name: String, email: String, active: Int, date_updated: Int, date_created: Int)