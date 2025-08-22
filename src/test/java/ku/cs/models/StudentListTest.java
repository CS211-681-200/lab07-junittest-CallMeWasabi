package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    StudentList studentList;

    @BeforeEach // run every time before each test
    void beforeEach() {
        studentList = new StudentList();
    }

    @Test
    void testFindStudent() {
        studentList.addNewStudent("std1", "name1");

        // find exist student should not return null
        assertNotNull(studentList.findStudentById("std1"));

        // find not exist student should return null
        assertNull(studentList.findStudentById("std2"));
    }

    @Test
    @DisplayName("test addNewStudent(id, name)")
    void testAddNewStudent1() {
        studentList.addNewStudent("std1", "name1");

        // add new student with not existing id should be fine
        assertEquals(1, studentList.getStudents().size());
        assertNotNull(studentList.findStudentById("std1"));

        studentList.addNewStudent("std2", "name2");
        assertEquals(2, studentList.getStudents().size());
        assertNotNull(studentList.findStudentById("std2"));

        studentList.addNewStudent("std3", "name3");
        assertEquals(3, studentList.getStudents().size());
        assertNotNull(studentList.findStudentById("std3"));

        // add new student with duplicate id should not add
        studentList.addNewStudent("std1", "name4");
        assertEquals(3, studentList.getStudents().size());
    }

    @Test
    @DisplayName("test addNewStudent(id, name, score)")
    void testAddNewStudent2() {
        studentList.addNewStudent("std1", "name1", 10);

        // add new student with not existing id should be fine
        assertEquals(1, studentList.getStudents().size());
        assertNotNull(studentList.findStudentById("std1"));
        assertEquals(10, studentList.findStudentById("std1").getScore());

        studentList.addNewStudent("std2", "name2", 20);
        assertEquals(2, studentList.getStudents().size());
        assertNotNull(studentList.findStudentById("std2"));
        assertEquals(20, studentList.findStudentById("std2").getScore());

        studentList.addNewStudent("std3", "name3", 80);
        assertEquals(3, studentList.getStudents().size());
        assertNotNull(studentList.findStudentById("std3"));
        assertEquals(80, studentList.findStudentById("std3").getScore());

        // add new student with duplicate id should not add
        studentList.addNewStudent("std1", "name4");
        assertEquals(3, studentList.getStudents().size());
    }


    @Test
    void testFilterByName() {
        studentList.addNewStudent("std1", "name1");
        studentList.addNewStudent("std2", "name2");
        studentList.addNewStudent("std3", "name3");

        assertEquals(3, studentList.filterByName("name").getStudents().size());

        assertEquals(1, studentList.filterByName("1").getStudents().size());
        assertEquals(1, studentList.filterByName("2").getStudents().size());
        assertEquals(1, studentList.filterByName("3").getStudents().size());

        assertEquals(3, studentList.filterByName("na").getStudents().size());
        assertEquals(3, studentList.filterByName("am").getStudents().size());
        assertEquals(3, studentList.filterByName("me").getStudents().size());

        assertEquals(1, studentList.filterByName("e1").getStudents().size());
        assertEquals(1, studentList.filterByName("e2").getStudents().size());
        assertEquals(1, studentList.filterByName("e3").getStudents().size());

        assertEquals(3, studentList.filterByName("n").getStudents().size());
        assertEquals(3, studentList.filterByName("a").getStudents().size());
        assertEquals(3, studentList.filterByName("m").getStudents().size());
        assertEquals(3, studentList.filterByName("e").getStudents().size());
    }

    @Test
    void testGiveScoreToId() {
        studentList.addNewStudent("std1", "name1");

        studentList.giveScoreToId("std1", 10);
        assertEquals(10, studentList.findStudentById("std1").getScore());

        studentList.giveScoreToId("std1", 20);
        assertEquals(30, studentList.findStudentById("std1").getScore());

        // give score to other user should not have effect to current user
        studentList.giveScoreToId("std2", 10);
        assertEquals(30, studentList.findStudentById("std1").getScore());
    }

    @Test
    void testViewGradeOfId() {
        studentList.addNewStudent("std1", "name1", 80);
        studentList.addNewStudent("std2", "name2", 70);
        studentList.addNewStudent("std3", "name3", 60);
        studentList.addNewStudent("std4", "name4", 50);
        studentList.addNewStudent("std5", "name5", 40);

        assertEquals("A",studentList.viewGradeOfId("std1"));
        assertEquals("B",studentList.viewGradeOfId("std2"));
        assertEquals("C",studentList.viewGradeOfId("std3"));
        assertEquals("D",studentList.viewGradeOfId("std4"));
        assertEquals("F",studentList.viewGradeOfId("std5"));
    }
}