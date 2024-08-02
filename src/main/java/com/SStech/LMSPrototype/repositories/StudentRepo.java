package com.SStech.LMSPrototype.repositories;

import com.SStech.LMSPrototype.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class StudentRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM student ORDER BY id ASC";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);

        while (rows.next()){
            Student student = new Student();
            student.setId(rows.getInt("id"));
            student.setName(rows.getString("name"));
            student.setContactNo(rows.getString("contactNo"));
            student.setEmail(rows.getString("email"));
            student.setSeatNo(rows.getInt("seatNo"));
            student.setShift(rows.getString("shift"));
            student.setPaymentStatus(rows.getString("paymentStatus"));

            student.setStartDate(Objects.requireNonNull(rows.getDate("startDate")).toLocalDate());
            student.setEndDate(Objects.requireNonNull(rows.getDate("endDate")).toLocalDate());

            students.add(student);
        }
        return students;
    }

    public Student getStudent(int id){
        String sql = "SELECT * FROM student WHERE id=?";
        SqlRowSet rows =jdbcTemplate.queryForRowSet(sql,id);

        if(rows.next()){
            Student student = new Student();
            student.setId(rows.getInt("id"));
            student.setName(rows.getString("name"));
            student.setContactNo(rows.getString("contactNo"));
            student.setEmail(rows.getString("email"));
            student.setSeatNo(rows.getInt("seatNo"));
            student.setShift(rows.getString("shift"));
            student.setPaymentStatus(rows.getString("paymentStatus"));

            student.setStartDate(Objects.requireNonNull(rows.getDate("startDate")).toLocalDate());
            student.setEndDate(Objects.requireNonNull(rows.getDate("endDate")).toLocalDate());

            return student;
        }
        return  null;
    }

    public Student getStudent(String name){
        String sql = "SELECT * FROM student WHERE name=?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql,name);

        if(rows.next()){
            Student student = new Student();
            student.setId(rows.getInt("id"));
            student.setName(rows.getString("name"));
            student.setContactNo(rows.getString("contactNo"));
            student.setEmail(rows.getString("email"));
            student.setSeatNo(rows.getInt("seatNo"));
            student.setShift(rows.getString("shift"));
            student.setPaymentStatus(rows.getString("paymentStatus"));

            student.setStartDate(Objects.requireNonNull(rows.getDate("startDate")).toLocalDate());
            student.setEndDate(Objects.requireNonNull(rows.getDate("endDate")).toLocalDate());

            return student;
        }
        return  null;
    }

    public Student createStudent(Student student){
        String sql = "INSERT INTO student(name,contactNo,email,seatNo,shift,paymentStatus,startDate) VALUES (?,?,?,?,?,?,?)";

        int count = jdbcTemplate.update(sql,student.getName(),student.getContactNo(),student.getEmail(),student.getSeatNo()
                ,student.getShift(),student.getPaymentStatus(),student.getStartDate());

        if(count>0){
            int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
            return getStudent(id);
        }
        return null;
    }

    public Student updateStudent(Student student){
        String sql = "UPDATE student SET name=?, contactNo=?, email=?, seatNo=?, shift=?, paymentStatus=?, startDate=? WHERE id=?";

        jdbcTemplate.update(sql,student.getName(),student.getContactNo(),student.getEmail()
                ,student.getSeatNo(),student.getShift(),student.getPaymentStatus(),student.getStartDate(),student.getId());

    return getStudent(student.getId());
    }

    public void deleteStudent(int id){
        String sql = "DELETE FROM student WHERE id=?";
        jdbcTemplate.update(sql,id);
    }
}
