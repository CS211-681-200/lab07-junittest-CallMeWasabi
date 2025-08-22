package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {
    @Test
    void testReadData() {
        StudentHardCodeDatasource datasource = new StudentHardCodeDatasource();
        StudentList studentList = datasource.readData();

        assertEquals("6710400001", studentList.findStudentById("6710400001").getId());
        assertEquals("6710400002", studentList.findStudentById("6710400002").getId());
        assertEquals("6710400003", studentList.findStudentById("6710400003").getId());
        assertEquals("6710400004", studentList.findStudentById("6710400004").getId());
        assertNull(studentList.findStudentById("6710400005"));
    }
}