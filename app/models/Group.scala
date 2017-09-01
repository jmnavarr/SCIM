package models

import models.dao._
import play.api.libs.functional.syntax._
import play.api.libs.json._

object Group {
  implicit val groupWrites: Writes[Group] = (
      (JsPath \ "id").write[Int] and
      (JsPath \ "display_name").write[String] and
      (JsPath \ "members").write[Seq[User]] and
      (JsPath \ "date_updated").write[Int] and
      (JsPath \ "date_created").write[Int]
    )(unlift(Group.unapply))

   def get_all(count: Int = 10, startIndex: Int = 0): List[Group] = {
     val groups = GroupDAO.get_all(count, startIndex)

     for (group <- groups) {
       group.members = UserGroupMembershipDAO.get_users_for_group(group.id)
     }

     groups
   }

   def get_by_id(id: Int): Group = {
     val group = GroupDAO.get_by_id(id)

     group.members = UserGroupMembershipDAO.get_users_for_group(group.id)

     group
   }
}

case class Group(id: Int, display_name: String, var members: Seq[User], date_updated: Int, date_created: Int)