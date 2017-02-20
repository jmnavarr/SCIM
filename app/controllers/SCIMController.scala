package controllers

import javax.inject._
import play.api.db.Database
import play.api.mvc._


class SCIMController @Inject() (db:Database) extends Controller {

  def users(filter:Option[String], count:Option[String], startIndex:Option[String]): Result = {
    // TODO: Retrieve paginated User Objects
    // TODO: Allow for an equals and startsWith filters on username
    Ok
  }

  def user(uid:String): Result = {
    // TODO: Retrieve a single User Object by ID
    Ok
  }

  def createUser(): Result = {
    // TODO: Create a User Object with firstname and lastname metadata
    Ok
  }

  def updateUser(uid:String): Result = {
    // TODO: Update a User Object's firstname, lastname, and active status
    Ok
  }

  def deleteUser(uid:String): Result = {
    // TODO: Delete a User Object by ID
    Ok
  }

  def groups(count:Option[String], startIndex:Option[String]): Result = {
    // TODO: Retrieve paginated Group Objects
    Ok
  }

  def group(groupId:String): Result = {
    // TODO: Retrieve a single Group Object by ID
    Ok
  }

  def patchGroup(groupId:String): Result = {
    // TODO: Patch a Group Object, modifying its members
    Ok
  }

}
