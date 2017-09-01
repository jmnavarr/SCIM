package controllers

import javax.inject._
import play.api.db.Database
import play.api.libs.json.Json
import play.api.mvc._
import models._

class SCIMController @Inject() (db:Database) extends Controller {

  def users(filter:Option[String], count:Option[String], startIndex:Option[String]) = Action {
    // TODO: Retrieve paginated User Objects
    // TODO: Allow for an equals and startsWith filters on username
    val limit = if (count.isEmpty) 10 else count.get.toInt
    val offset = if (startIndex.isEmpty) 0 else startIndex.get.toInt

    val users_result = User.get_all(filter, limit, offset)

    Ok(Json.obj("result" -> users_result))
  }

  def user(uid:String) = Action {
    // TODO: Retrieve a single User Object by ID
    val id = uid.toInt
    val user_result = User.get_by_id(id)

    Ok(Json.obj("result" -> user_result))
  }

  def createUser() = Action {
    // TODO: Create a User Object with firstname and lastname metadata
    Ok
  }

  def updateUser(uid:String) = Action {
    // TODO: Update a User Object's firstname, lastname, and active status
    Ok
  }

  def deleteUser(uid:String) = Action {
    // TODO: Delete a User Object by ID
    Ok
  }

  def groups(count:Option[String], startIndex:Option[String]) = Action {
    // TODO: Retrieve paginated Group Objects
    val limit = if (count.isEmpty) 10 else count.get.toInt
    val offset = if (startIndex.isEmpty) 0 else startIndex.get.toInt

    val groups_result = Group.get_all(limit, offset)

    Ok(Json.obj("result" -> groups_result))
  }

  def group(groupId:String) = Action {
    // TODO: Retrieve a single Group Object by ID
    val id = groupId.toInt
    val group_result = Group.get_by_id(id)

    Ok(Json.obj("result" -> group_result))
  }

  def patchGroup(groupId:String) = Action {
    // TODO: Patch a Group Object, modifying its members
    Ok
  }

}
