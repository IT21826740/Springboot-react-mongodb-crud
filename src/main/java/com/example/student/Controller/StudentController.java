package com.example.student.Controller;

import com.example.student.Entity.Student;
import com.example.student.Service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentServices studentServices;


    @PostMapping(value = "/save")
    private  String saveStudent(@RequestBody Student students){

        studentServices.saveorUpdate(students);
        return students.get_id();
    }

    @GetMapping(value = "/getAll")
    private Iterable<Student>getStudents()
    {

        return studentServices.listAll();
    }

    @PutMapping(value = "/edit/{id}")
    private Student update(@RequestBody Student student,@PathVariable(name = "id")String _id)
    {

        student.set_id(_id);
        studentServices.saveorUpdate(student);
        return student;
    }

    @DeleteMapping("delete/{id}")
    private void deleteStudent(@PathVariable("id")String _id) {
        studentServices.deleteStudent(_id);
    }

    @RequestMapping("/student/{id}")
    private Student getStudent(@PathVariable(name = "id")String studentid)
    {
        return studentServices.getStudentByID(studentid);
    }
}
