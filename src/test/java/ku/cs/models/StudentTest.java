package ku.cs.models;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    String testId = "67xxxxx";
    String testName = "test";
    static Student s;

    @BeforeEach
    void beforeEach() {
        s = new Student(testId, testName);
    }

    @Test
    void testChangeName() {
        String changeNameTest = "change name test";

        s.changeName(changeNameTest);
        assertEquals(changeNameTest, s.getName());
    }

    @Test
    void testAddScore() {
        s.addScore(40);
        assertEquals(40, s.getScore());

        s.addScore(20);
        assertEquals(60, s.getScore());

        s.addScore(-10);
        assertEquals(60, s.getScore());
    }

    @Test
    void testCalculateGrade() {
        s.addScore(40);
        assertEquals("F", s.getGrade());

        s.addScore(10);
        assertEquals("D", s.getGrade());

        s.addScore(10);
        assertEquals("C", s.getGrade());

        s.addScore(10);
        assertEquals("B", s.getGrade());

        s.addScore(10);
        assertEquals("A", s.getGrade());

        s.addScore(100);
        assertEquals("A", s.getGrade());
    }

    @Test
    void testIsId() {
        assertEquals(true, s.isId(testId));
        assertEquals(false, s.isId("wrong id"));
    }

    @Test
    void testIsNameContains() {
        assertEquals(true, s.isNameContains("test"));
        assertEquals(true, s.isNameContains("tes"));
        assertEquals(true, s.isNameContains("est"));
        assertEquals(true, s.isNameContains("es"));

        assertEquals(false, s.isNameContains("tesa"));
        assertEquals(false, s.isNameContains("ttest"));
        assertEquals(false, s.isNameContains("estt"));
        assertEquals(false, s.isNameContains("ddd"));
    }
}