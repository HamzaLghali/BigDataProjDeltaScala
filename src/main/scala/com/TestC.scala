package com

import tools.SparkCore.spark
import tools.pgconn.{connection, statement}

object TestC extends App {

  val sss: String = "SELECT * FROM test"
    try {
      val resultSet = statement.executeQuery(sss)
      while (resultSet.next) {
        val columnValue = resultSet.getString("id")
      }
    } catch {
      case error: Exception =>
        error.printStackTrace()
        println("An error occurred: " + error.getMessage)
    } finally {

      println("sdwde")
    }


}
