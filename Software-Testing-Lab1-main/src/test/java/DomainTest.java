import ClassesForTask3.SpecialPeople;
import ClassesForTask3.WitnessFuture;
import ClassesForTask3.SciencesAcademy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static ClassesForTask3.Gender.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class DomainTest {

    SpecialPeople sp1;
    SpecialPeople sp2;


    WitnessFuture witnessFuture;
    SciencesAcademy academy;

    @BeforeEach
    void init() throws Exception {
        sp1 = new SpecialPeople("A", MALE,17 ,"calm");
        sp2 = new SpecialPeople("B", FEMALE,18, "calm");


        academy = new SciencesAcademy();
        academy.setName("AandB");
        academy.addMember(sp1);
        academy.addMember(sp2);


        witnessFuture = new WitnessFuture();
        witnessFuture.initAcademy(academy);
        witnessFuture.Witness();
    }

    @Nested
    class HBTest {

        @Test
        @DisplayName("Tests for illegal Argument of setter in SpecialPeople class")
        void testForSetter() throws Exception {

            SpecialPeople testObj = new SpecialPeople();

            Exception e1 = assertThrows(IllegalArgumentException.class, () -> testObj.setName(null));
            assertEquals("Name shouldn't be null.", e1.getMessage());

            Exception e2 = assertThrows(IllegalArgumentException.class, () -> testObj.setGender(null));
            assertEquals("Gender shouldn't be null.", e2.getMessage());

            Exception e3 = assertThrows(IllegalArgumentException.class, () -> testObj.setState(null));
            assertEquals("State shouldn't be null", e3.getMessage());

            Exception e4 = assertThrows(IllegalArgumentException.class, () -> testObj.setAge(-1));
            assertEquals("Age should lager than 0", e4.getMessage());

        }

        @Test
        @DisplayName("Tests for illegal Argument of Constructor in SpecialPeople class")
        void testConstructor() {
            Exception e1 = assertThrows(IllegalArgumentException.class, () -> new SpecialPeople(null, MALE, 0, ""));
            assertEquals("Name shouldn't be null.", e1.getMessage());

            Exception e2 = assertThrows(IllegalArgumentException.class, () -> new SpecialPeople("A", null, 0, ""));
            assertEquals("gender shouldn't be null.", e2.getMessage());

            Exception e3 = assertThrows(IllegalArgumentException.class, () -> new SpecialPeople("A", MALE, -1, ""));
            assertEquals("gender shouldn't be null.", e3.getMessage());

            Exception e4 = assertThrows(IllegalArgumentException.class, () -> new SpecialPeople("A", MALE, 0, null));
            assertEquals("state shouldn't be null", e4.getMessage());

        }
    }

    @Nested
    class Test_SAcademy {

        @Test
        @DisplayName("Check deleteMembers function")
        void checkDeleteMember(){
            SciencesAcademy academy_test;
            academy_test = new SciencesAcademy();
            Exception e = assertThrows(IllegalArgumentException.class, () -> academy_test.deleteMember(sp1));
            assertEquals("There are no people to delete", e.getMessage());
        }

        @Test
        @DisplayName("Check addMember function")
        void checkAddMemberToNullArrayList() throws Exception {
             SciencesAcademy academy_test;
             academy_test = new SciencesAcademy();
             SpecialPeople sp_test = new SpecialPeople("A", FEMALE, 0, "");
             ArrayList<SpecialPeople> testArrayList = new ArrayList<>();
             testArrayList.add(sp_test);
             academy_test.addMember(sp_test);

            assertEquals(testArrayList, academy_test.getMembers());
        }
    }

    @Nested
    class WitnessFutureTest {

        @Test
        @DisplayName("Check checkAcademy function")
        void checkAcademy(){
            WitnessFuture witnessFuture_test;
            witnessFuture_test = new WitnessFuture();
            Exception e = assertThrows(RuntimeException.class, ()-> witnessFuture_test.checkAcademy());
            assertEquals("Academy need two people", e.getMessage());
        }

        @Test
        @DisplayName("Test for checkAcademy_num1")
        void checkNum1(){
            WitnessFuture witnessFuture_test;
            witnessFuture_test = new WitnessFuture();
            academy.deleteMember(sp1);
            witnessFuture_test.initAcademy(academy);

            Exception e = assertThrows(RuntimeException.class, ()-> witnessFuture_test.checkAcademy());
            assertEquals("It must be two people!", e.getMessage());
        }

        @Test
        @DisplayName("Test for checkAcademy_num2")
        void checkNum0(){
            WitnessFuture witnessFuture_test;
            witnessFuture_test = new WitnessFuture();
            academy.deleteMember(sp2);
            academy.deleteMember(sp1);
            witnessFuture_test.initAcademy(academy);

            Exception e = assertThrows(RuntimeException.class, ()-> witnessFuture_test.checkAcademy());
            assertEquals("We need two people.", e.getMessage());
        }


    }
}
