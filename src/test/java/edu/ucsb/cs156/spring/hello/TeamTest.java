package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }
    @Test
    public void hash_code_correct() {
        Team t = new Team("team15");
        int result = t.hashCode();
        int expectedResult = -877714111;
        assertEquals(expectedResult, result);
    }
    @Test
    // equals case 1
    public void test_same_obeject_equals() {
        Team t = new Team("test-team");
        t.addMember("John");
        t.addMember("Jay");
        assert(t.equals(t));
    }
    @Test
    // equals case 2
    public void test_diff_class_equals() {
        Team t = new Team("test-team");
        t.addMember("John");
        t.addMember("Jay");
        String wrongTeam = "wrongTeam";
        assertNotEquals(t, wrongTeam);
    }
    @Test
    //equals case 3.1
    public void equal_case_tt() {
        Team t1 = new Team("test-team");
        t1.addMember("John");
        t1.addMember("Jay");
        Team t2 = new Team("test-team");
        t2.addMember("John");
        t2.addMember("Jay");
        assert(t1.equals(t2));
    }
    @Test
    //equals case 3.2
    public void equal_case_tf() {
        Team t1 = new Team("test-team");
        t1.addMember("John");
        t1.addMember("Jay");
        Team t2 = new Team("test-team");
        t2.addMember("John");
        t2.addMember("Jane");
        assertNotEquals(t1, t2);
    }
    @Test
    //equals case 3.3
    public void equal_case_ft() {
        Team t1 = new Team("test-team1");
        t1.addMember("John");
        t1.addMember("Jay");
        Team t2 = new Team("test-team2");
        t2.addMember("John");
        t2.addMember("Jay");
        assertNotEquals(t1, t2);
    }
    @Test
    //equals case 3.4
    public void equal_case3_ff() {
        Team t1 = new Team("test-team1");
        t1.addMember("John");
        t1.addMember("Jay");
        Team t2 = new Team("test-team2");
        t2.addMember("John");
        t2.addMember("Jane");
        assertNotEquals(t1, t2);
    }
    @Test
    public void check_hash_equals() {
        Team t1 = new Team("test-team");
        t1.addMember("foo");
        t1.addMember("bar");
        Team t2 = new Team("test-team");
        t2.addMember("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }
    @Test
    public void check_hash_not_equals() {
        Team t1 = new Team("test-team");
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team("test-team");
        t2.setName("fob");
        t2.addMember("bat");
        assertNotEquals(t1.hashCode(), t2.hashCode());
    }
}
