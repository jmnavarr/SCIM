# SCIM

## Requirements
Write a SCIM 2.0 server including 7 necessary requests used by identity providers using Scala on the Play framework. You'll have design a database to define users, groups, and user-group membership. The API needs no presentation layer, just RESTful endpoints that can manipulate the database and return JSON. The repository contains a template for the project, including routes and a controller to get you started.

## Resources
Here are some useful links for the project.
* [Play](https://www.playframework.com/)
* [Scala](http://www.scala-lang.org/documentation/)
* [SCIM](http://www.simplecloud.info/)

## Notes
* curl -X GET http://localhost:9000/
* curl -X GET http://localhost:9000/scim/v2/Users
* curl -X GET http://localhost:9000/scim/v2/Users/1
* curl -X GET "http://localhost:9000/scim/v2/Users?count=2&startIndex=0&filter=starts_with:a" -v
* curl -X GET "http://localhost:9000/scim/v2/Groups?count=2&startIndex=0" -v

## Database
* create table users (
     id int(10) unsigned auto_increment primary key,
     first_name varchar(30) not null,
     last_name varchar(30) not null,
     user_name varchar(30) not null,
     email varchar(50),
     active bit(1) default 1,
     date_updated int(10),
     date_created int(10)
  )
* create table groups (
     id int(10) unsigned auto_increment primary key,
     display_name varchar(30) not null,
     date_updated int(10),
     date_created int(10)
  )
* create table user_group_membership (
     id int(10) unsigned auto_increment primary key,
     user_id int(10) unsigned,
     group_id int(10) unsigned,
     date_created int(10)
  )