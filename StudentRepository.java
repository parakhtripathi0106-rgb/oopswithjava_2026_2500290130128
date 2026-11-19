
package com.example.studentmanagement;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbc;

    public StudentRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Add student
    public int addStudent(Student s) {
        String sql = "INSERT INTO students VALUES (?, ?, ?, ?, ?, ?)";
        int result = jdbc.update(sql,
                s.getStudentId(),
                s.getStudentName(),
                s.getEmail(),
                s.getCourseName(),
                s.getProgrammingScore(),
                s.getMathematicsScore());

        if (s.getSkills() != null) {
            for (String skill : s.getSkills()) {
                jdbc.update(
                    "INSERT INTO student_skills VALUES (?, ?)",
                    s.getStudentId(), skill
                );
            }
        }
        return result;
    }

    // Retrieve all students
    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM students";
        return jdbc.query(sql, (rs, rowNum) -> {
            Student s = new Student();
            s.setStudentId(rs.getInt("student_id"));
            s.setStudentName(rs.getString("student_name"));
            s.setEmail(rs.getString("email"));
            s.setCourseName(rs.getString("course_name"));
            s.setProgrammingScore(rs.getDouble("programming_score"));
            s.setMathematicsScore(rs.getDouble("mathematics_score"));
            s.setSkills(getSkills(s.getStudentId()));
            return s;
        });
    }

    // Search student by ID
    public Student getStudentById(int id) {
        String sql = "SELECT * FROM students WHERE student_id = ?";
        List<Student> list = jdbc.query(sql, (rs, rowNum) -> {
            Student s = new Student();
            s.setStudentId(rs.getInt("student_id"));
            s.setStudentName(rs.getString("student_name"));
            s.setEmail(rs.getString("email"));
            s.setCourseName(rs.getString("course_name"));
            s.setProgrammingScore(rs.getDouble("programming_score"));
            s.setMathematicsScore(rs.getDouble("mathematics_score"));
            s.setSkills(getSkills(id));
            return s;
        }, id);

        return list.isEmpty() ? null : list.get(0);
    }

    // Get skills
    private String[] getSkills(int id) {
        List<String> skills = jdbc.queryForList(
            "SELECT skill FROM student_skills WHERE student_id = ?",
            String.class, id
        );
        return skills.toArray(new String[0]);
    }

    // Update scores and skills
    public int updateStudent(int id, Student s) {
        int result = jdbc.update(
            "UPDATE students SET programming_score=?, mathematics_score=? WHERE student_id=?",
            s.getProgrammingScore(),
            s.getMathematicsScore(),
            id
        );

        if (result > 0) {
            jdbc.update("DELETE FROM student_skills WHERE student_id=?", id);

            if (s.getSkills() != null) {
                for (String skill : s.getSkills()) {
                    jdbc.update(
                        "INSERT INTO student_skills VALUES (?, ?)",
                        id, skill
                    );
                }
            }
        }
        return result;
    }

    // Delete student
    public int deleteStudent(int id) {
        jdbc.update("DELETE FROM student_skills WHERE student_id=?", id);
        return jdbc.update("DELETE FROM students WHERE student_id=?", id);
    }

    // Merit list
    public List<Student> getMeritList() {
        String sql = "SELECT * FROM students ORDER BY (programming_score + mathematics_score) DESC";
        return getAllStudentsSorted(sql);
    }

    private List<Student> getAllStudentsSorted(String sql) {
        return jdbc.query(sql, (rs, rowNum) -> {
            Student s = new Student();
            s.setStudentId(rs.getInt("student_id"));
            s.setStudentName(rs.getString("student_name"));
            s.setEmail(rs.getString("email"));
            s.setCourseName(rs.getString("course_name"));
            s.setProgrammingScore(rs.getDouble("programming_score"));
            s.setMathematicsScore(rs.getDouble("mathematics_score"));
            s.setSkills(getSkills(s.getStudentId()));
            return s;
        });
    }
}
