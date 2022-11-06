package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());

    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job.getName() instanceof String);
        assertEquals(job.getName(), "Product tester");
        assertTrue(job.getEmployer() instanceof Employer);
        assertEquals(job.getEmployer().getValue(), "ACME");
        assertTrue(job.getLocation() instanceof Location);
        assertEquals(job.getLocation().getValue(), "Desert");
        assertTrue(job.getPositionType() instanceof PositionType);
        assertEquals(job.getPositionType().getValue(), "Quality control");
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(job.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Web Developer", new Employer (""), new Location("StL"), new PositionType(""), new CoreCompetency("Java"));
        char firstChar = job.toString().charAt(0);
        char lastChar = job.toString().charAt(job.toString().length()-1);
        assertEquals(firstChar,'\n');
        assertEquals(lastChar, '\n');

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Web Developer", new Employer (""), new Location("StL"), new PositionType(""), new CoreCompetency("Java"));

        String exampleString = String.format("\nID: %d\n"  +  "Name: %s\n" + "Employer: Data not available\n" + "Location: %s\n" +
                "Position Type: Data not available\n" + "Core Competency: %s\n", job.getId(), job.getName(), job.getLocation(), job.getCoreCompetency());

        assertEquals(exampleString, job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Web Developer", new Employer (""), new Location("StL"), new PositionType(""), new CoreCompetency("Java"));

        String exampleString = String.format("\nID: %d\n"  +  "Name: %s\n" + "Employer: Data not available\n" + "Location: %s\n" +
                "Position Type: Data not available\n" + "Core Competency: %s\n", job.getId(), job.getName(), job.getLocation(), job.getCoreCompetency());

        assertEquals(exampleString, job.toString());

    }

}
