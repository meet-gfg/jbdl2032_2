package com.example.demo.service;

import com.example.demo.appinterface.StudentInternalService;
import com.example.demo.controller.StudentController;
import com.example.demo.domain.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @Service annotation is used for marking the service class and Spring will generate the bean of it
 * because it indirectly annotates with @Component
 *
 * */

@Service
public class StudentService {


    /***
     * Types of Dependency injection
     * 1. Constructor dependency injection -- recommended
     * 2. Field dependency injection
     * 3. Setter dependency injection
     **/


    /**Field dependency injection */
   //Autowired
    public StudentInternalService studentInternalService;
    /**
    private StudentInternalService studentInternalService=new StudentInternalService();
     */


    /**Constructor dependency injection*/
//    public StudentService(StudentInternalService studentInternalService) {
//        this.studentInternalService = studentInternalService;
//    }
//

    /**Setter dependency injection
     * usage: StudentService service=new StudentService();
     *         service.setStudentInternalService(new StudentInternalServiceImplDev());
     *         System.out.println("output 1 --> "+service.getStudentInteger()); //
     *         service.setStudentInternalService(new StudentInternalServiceImpl());
     *         System.out.println("output 2 -->"+service.getStudentInteger()); //
     * */
      @Autowired
      public void setStudentInternalService(StudentInternalService service){
          this.studentInternalService=service;
      }





    Map<Integer,Student> studentMap=new HashMap<>();
    Logger log= LoggerFactory.getLogger(StudentController.class);

    public Student updateStudent(Student student){
        if(student.getId()==0 || !studentMap.containsKey(student.getId()))
            return null;
        else{
            studentMap.put(student.getId(),student);
            return student;
        }
    }

    public Student addStudent(Student student) {
        try {
            int id = studentMap.size() + 1;
            student.setId(id);
            studentMap.putIfAbsent(id, student);
            return student;
        }
        catch (Exception ex) {
            log.error("exception while adding student");
        }
        return null;
    }

    public List<Student> getAllStudent() {

        return new ArrayList<>(studentMap.values());
    }

    public Student getStudentById(int id) {

        if(studentMap.containsKey(id))
            return studentMap.get(id);
        else
            return null;
    }

    public boolean deleteStudent(int id) {

        if(id==0 || !studentMap.containsKey(id))
            return false;
        else{
            studentMap.remove(id);
            return true;
        }
    }

    public int getStudentInteger(){
       return this.getValueFromInternalService();
    }
    public int getValueFromInternalService(){
        return studentInternalService.getStudentInteger();
    }

    /**
     * usage of @Bean : it can be used on method only.
     * */
    @Bean("mainBean")
    public Student createStudent(){
        return new Student(0,"superman",100,"abc@gmail.com");
    }
}






/**
 * @scope("prototype") // singleton
 *
 * @Autowired
 * AvgService serv;
 * list<int> 1list 50.60.50</int>
 * serv.calAvg(1list); ->
 *
 *
 *                              markslist
 *                          METHOD{
 *                              this.markslist=1list
 *                              for(){
 *                                  ///  1 thread
 *                              }
 *                              total/size
 *                          }
 *
 *
 * AvgService serv;
 *  * list<int> 1list 70.90.60,30</int>
 *  * serv.calAvg(1list);
 *
 *   {                             this.markslist
 *  *                              method{this.markslist=1list // 2nd thread
 *  *                              for(){
 *  *                                  ///
 *  *                              }
 *  *                              total/size
 *  *                          }
 * */



/*  request1
@Autowired
 * AvgService serv;
 *
 * serv.calculate(list1);
 *
 * */

/*request 2
* @Autowired
 * AvgService serv;
 *
 * serv.calculate(list2);
 *
* */










