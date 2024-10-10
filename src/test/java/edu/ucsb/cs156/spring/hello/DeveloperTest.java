package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Ria", Developer.getName());
    }
    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("riasinha", Developer.getGithubId());
    }
     @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("f24-15", t.getName());
    }
    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Ria"),"Team should contain Ria");
        assertTrue(t.getMembers().contains("Bhavya"),"Team should contain Bhavya");
        assertTrue(t.getMembers().contains("Sophia"),"Team should contain Sophia");
        assertTrue(t.getMembers().contains("Cooper"),"Team should contain Cooper");
        assertTrue(t.getMembers().contains("Calvin"),"Team should contain Calvin");
        assertTrue(t.getMembers().contains("Kailai"),"Team should contain Kailai");
    }
}
