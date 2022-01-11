package com.wengge.study.service;

import com.wengge.study.enums.SexEnum;
import com.wengge.study.mapper.StudentMapper;
import com.wengge.study.po.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhouwen
 * @date
 */
@Service
public class StudentService {

    @Resource
    private StudentMapper studentMapper;

    public void saveStudent(Student student) {
        if (!SexEnum.checkCode(student.getSex())) {
            throw new RuntimeException("性别校验不通过");
        }
        studentMapper.insert(student);
    }

    public void updateStudent(Student student) {
        if (!SexEnum.checkCode(student.getSex())) {
            throw new RuntimeException("性别校验不通过");
        }
        studentMapper.updateByPrimaryKeySelective(student);
    }

    public Student findStudentById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        studentMapper.deleteByPrimaryKey(id);
    }

    public List<Student> findAllStudent() {
        return studentMapper.findAll();
    }

}
