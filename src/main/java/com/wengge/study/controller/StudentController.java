package com.wengge.study.controller;

import com.wengge.study.po.Student;
import com.wengge.study.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhouwen
 * @date
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @PostMapping("/save")
    public void saveStudent(Student student) {
        studentService.saveStudent(student);
    }

    @PostMapping("/update")
    public void updateStudent(Student student) {
        studentService.updateStudent(student);
    }

    @PostMapping("/deleteById")
    public void deleteById(@RequestParam("id") Integer id) {
        studentService.deleteById(id);
    }

    @PostMapping("/queryById")
    public Student queryById(@RequestParam("id") Integer id) {
        return studentService.findStudentById(id);
    }

    @PostMapping("/queryAll")
    public List<Student> queryAll() {
        return studentService.findAllStudent();
    }

}
