package com.bootapi.bootrestapi.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootapi.bootrestapi.dao.StudentRepo;
import com.bootapi.bootrestapi.entities.Student;


@Service
public class StudentService {
    
    @Autowired
    private StudentRepo studentRepo;

    // Get All Data
    public List<Student> getAllStudent(){
      List<Student> allStudent = (List<Student>) studentRepo.findAll();
      return allStudent;
    }

    // Get Data by User ID
    public Student getStuById(int id){
      return studentRepo.findById(id);
    }

    //Add Method
    public Student addData(Student student){
      Student stu = studentRepo.save(student);
      return stu;
    }

    // Delete Method
    public void deleteStu(int id){
        studentRepo.deleteById(id);
    } 
    
    //Update Method
    public void updaStudent(Student student, int id){
        student.setId(id);
        studentRepo.save(student);
        
    }
}






















/*
 static List<Student> stuList = new ArrayList<>();

    static {
        stuList.add(new Student(13, "Shadab", "Kolkta"));
        stuList.add(new Student(14, "Zeshan", "Delhi"));
        stuList.add(new Student(15, "Moazzam", "Patna"));
        stuList.add(new Student(16, "Atul", "Noid"));
        stuList.add(new Student(17, "Saadan", "Noida"));
    }

    public List<Student> getAllStudent() {
        return stuList;
    }

    public Student getStuById(int id) {

        Student student = null;
        try {
            student = stuList.stream().filter(e -> e.getId() == id).findFirst().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    public Student addData(Student newStu) {
        
        stuList.add(newStu);
        return newStu;
    }

    public void deleteStu(int id) {
        stuList = stuList.stream().filter(stu -> stu.getId() != id).collect(Collectors.toList());
    }

    public void updaStudent(Student student, int id) {
        stuList = stuList.stream().map(stu -> {
            if (stu.getId() == id) {
                stu.setName(student.getName());
                stu.setCity(student.getCity());
            }
            return stu;
        }).collect(Collectors.toList()); //
    }
 */
