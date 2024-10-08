package DeltaPostgres


import java.sql.{Connection, DriverManager, ResultSet, Statement}


object pgconn extends App {
  val url = "jdbc:postgresql://localhost:5432/Scala"
  val username = "postgres"
  val password = "password"
  val connection: Connection = DriverManager.getConnection(url, username, password)
  val statement: Statement = connection.createStatement()


  private val tb_name="Employees"


  //val del= s"truncate table $tb_name"

  //statement.executeQuery(del)
//  val selectS = s"select * from $tb_name"
//  val het = statement.executeQuery(selectS)
  val insert = s"INSERT INTO public.employees(emp_id, age, address) VALUES (3, 34, 'Marrakech');"


  try {
    val stin = statement.executeUpdate(insert)
    println("Record inserted successfully.")
  } catch {
    case e: Exception => println(s"Error occurred: ${e.getMessage}")
  }




  val resultSet: ResultSet = statement.executeQuery(s"SELECT * FROM $tb_name")
  while (resultSet.next()) {
    // Assuming the columns are named "id", "name", and "position"
    val id = resultSet.getInt("emp_id")
    val age = resultSet.getString("age")
    val address = resultSet.getString("address")

    println(s"ID: $id, age: $age, address: $address")
  }

  // Close the connection
  resultSet.close()
  statement.close()
  connection.close()
}







