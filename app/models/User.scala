package models

import models.dao.UserDAO
import play.api.libs.functional.syntax._
import play.api.libs.json._

object User {
   def get_all(): Int = {
     //val users = UserDAO.get_all()

     5
   }
}

case class User(userId: Int, groupId: Int)