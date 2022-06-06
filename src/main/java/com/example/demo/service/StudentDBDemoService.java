package com.example.demo.service;

import com.example.demo.domain.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.*;

@Service
public class StudentDBDemoService {

    Connection mysqlConnection;
    PreparedStatement studentInsertStatement;
    PreparedStatement getStudentStatement;

    Logger log= LoggerFactory.getLogger(StudentDBDemoService.class);

    /** Constructor gets called on the bean creation because of the @Component annotation
     * it will setup the mysql connection for our app with the mysql db running on our machine
     * */

    public StudentDBDemoService() throws SQLException {
        System.out.println("I am getting called 1");
        /**
         * Driver manager is able to establish connection because of the mysql driver dependency we added in pom
         * */
        mysqlConnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","root");

    }
    @PostConstruct
    private void createRequiredTable() throws SQLException {

        /**
         * 1. From connection, we get a statement so that it can compile the query while execution
         * 2. In normal statement, we get the statement instance first and then provide the query everytime
         *      to compile and run
         * 3. In prepared statement we give the query with ? at time of statement instance creation so it is precompiled,
         *      and we just update the ? with the values to set the new values
         * */
        Statement statement = mysqlConnection.createStatement();
        // query to create table
        String query = "create table if not exists student (id int primary key auto_increment,name varchar(20),semester int)";
        studentInsertStatement=mysqlConnection.prepareStatement("insert into student (name,semester) values (?,?)");
        getStudentStatement=mysqlConnection.prepareStatement("select * from student where id = ?");

        // statement to execute
        statement.execute(query);
    }


    /***
     * q1. select * from student where id=1  ---> executeQuery()
     * 2. check if student with id 1 exists  -->   execute()
     * 3. insert or update query -- > executeUpdate()
     *
     * */

    public Student addStudent(Student student) {
        try {

            // ask for statement space to run the query
           // Statement statement = mysqlConnection.createStatement();
            // query to create table

            studentInsertStatement.setString(1,student.getName());
            studentInsertStatement.setInt(2,student.getAge());

            //String query="insert into student (name,semester) values('"+student.getName()+"',"+student.getAge()+")";
            // statement to execute
        //   int result=statement.executeUpdate(query);

            studentInsertStatement.execute();

           /*2 steps:
           * 1. compile the query
           * 2. execute the query
           * */
          // log.info("result here:"+result);


        }
        catch (Exception ex) {
            log.error("exception while adding student");
        }
        return student;
    }

    public Student getStudentById(int id) throws SQLException {

        getStudentStatement.setInt(1,id);
        ResultSet set=getStudentStatement.executeQuery();
        Student s= new Student();

        while(set.next()){
            s.setAge(set.getInt("semester"));
            s.setName(set.getString("name"));
        }

        return s;

    }




    /***
     * 1. Interface  -> JPA -> java persistence api
     * 2. Implementation: 1. Hibernate
     *                    2. OpenJPA
     *
     * */






}
