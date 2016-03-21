package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {
	Course MarvelPairs101 = new Course(UUID.randomUUID(), "MarvelPairs101", 3);
    Course StandAlones110 = new Course(UUID.randomUUID(), "StandAlones110", 3);
    Course NewComers102 = new Course(UUID.randomUUID(), "NewComers102", 3);
    ArrayList<Course> Course = new ArrayList<Course>(Arrays.asList(MarvelPairs101, StandAlones110, NewComers102));
    
    Semester Fall = new Semester(UUID.randomUUID(), new GregorianCalendar(2015, 8, 28).getTime(), new GregorianCalendar(2015, 12, 15).getTime());
    Semester Spring = new Semester(UUID.randomUUID(), new GregorianCalendar(2016, 2, 8).getTime(), new GregorianCalendar(2016, 5, 30).getTime());
    ArrayList<Semester> Semester = new ArrayList<Semester>(Arrays.asList(Fall, Spring));
    
    Section MarvelPairs101011 = new Section(MarvelPairs101.getCourseID(), Fall.getSemesterID(), UUID.randomUUID(), 011);
    Section MarvelPairs101012 = new Section(MarvelPairs101.getCourseID(), Spring.getSemesterID(), UUID.randomUUID(), 012);
    Section StandAlones110032 = new Section(StandAlones110.getCourseID(), Fall.getSemesterID(), UUID.randomUUID(), 032);
    Section StandAlones110033 = new Section(StandAlones110.getCourseID(), Spring.getSemesterID(), UUID.randomUUID(), 033);
    Section NewComers102111 = new Section(NewComers102.getCourseID(), Fall.getSemesterID(), UUID.randomUUID(), 111);
    Section NewComers102112 = new Section(NewComers102.getCourseID(), Spring.getSemesterID(), UUID.randomUUID(), 112);
    ArrayList<Section> Section = new ArrayList<Section>(Arrays.asList(MarvelPairs101011, MarvelPairs101012, StandAlones110032, StandAlones110033, NewComers102111, NewComers102112));
    
	Student WinterSoldier = new Student("James","Buchanan" , "Barnes", new GregorianCalendar(1941, 3, 1).getTime(), eMajor.PHYSICS, "Team Cap", "1234567890", null);
	Student CaptainAmerica = new Student("Steve", null, "Rogers", new GregorianCalendar(1941, 3, 1).getTime(), eMajor.PHYSICS, "Team Cap", "1111111111", null);
	Student Hawkeye = new Student("Clinton", "Francis", "Barton", new GregorianCalendar(1964, 9, 1).getTime(), eMajor.BUSINESS, "Team Cap", "3333333333", null);
	Student BlackWidow = new Student("Natalia", "Alianovna", "Romanova", new GregorianCalendar(1964, 4, 1).getTime(), eMajor.BUSINESS, "Team Iron", "2222222222", null);
	Student IronMan = new Student("Anthony", "Edward", "Stark", new GregorianCalendar(1963, 3, 1).getTime(), eMajor.COMPSI, "Team Iron", "4444444444", null);
	Student ScarletWitch = new Student("Wanda", null, "Maximoff", new GregorianCalendar(1964, 3, 1).getTime(), eMajor.CHEM, "Team Cap", "555-555-5555", null);
	Student BlackPanther = new Student("T'Challa", null, null, new GregorianCalendar(1966, 7, 1).getTime(), eMajor.CHEM, "Team Iron", "6666666666", null);
	Student Vision = new Student("Edward", null, "Jarvis", new GregorianCalendar(1964, 3, 1).getTime(), eMajor.COMPSI, "Team Iron", "7777777777", null);
	Student AntMan = new Student("Henry", "Jonathan", "Pym", new GregorianCalendar(1962, 1, 1).getTime(), eMajor.COMPSI, "Team Iron", "8888888888", null);
	Student Falcon = new Student("Samuel", "Thomas", "Wilson", new GregorianCalendar(1969, 9, 1).getTime(), eMajor.PHYSICS, "Team Cap", "9999999999", null);
	ArrayList<Student> Student = new ArrayList<Student>(Arrays.asList(WinterSoldier, CaptainAmerica, Hawkeye, BlackWidow, IronMan, ScarletWitch, BlackPanther, Vision, AntMan, Falcon));

	@BeforeClass
	public static void setup() {
	}
	
	@Test
	public void testEnrollment() throws PersonException {
		
	    
	    Enrollment WS = new Enrollment(MarvelPairs101011.getSectionID(), WinterSoldier.getStudentID());
	    Enrollment CA = new Enrollment(MarvelPairs101011.getSectionID(), CaptainAmerica.getStudentID());
	    Enrollment H = new Enrollment(MarvelPairs101012.getSectionID(), Hawkeye.getStudentID());
	    Enrollment BW = new Enrollment(MarvelPairs101012.getSectionID(), BlackWidow.getStudentID());
	    Enrollment IM = new Enrollment(StandAlones110032.getSectionID(), IronMan.getStudentID());
	    Enrollment F = new Enrollment(StandAlones110032.getSectionID(), Falcon.getStudentID());
	    Enrollment AM = new Enrollment(StandAlones110033.getSectionID(), AntMan.getStudentID());
	    Enrollment SW = new Enrollment(StandAlones110033.getSectionID(), ScarletWitch.getStudentID());
	    Enrollment BP = new Enrollment(NewComers102111.getSectionID(), BlackPanther.getStudentID());
	    Enrollment V = new Enrollment(NewComers102112.getSectionID(), Vision.getStudentID());
	    
	    WS.setGrade(100);
	    CA.setGrade(100);
	    H.setGrade(100);
	    BW.setGrade(100);
	    IM.setGrade(100);
	    F.setGrade(100);
	    AM.setGrade(100);
	    SW.setGrade(100);
	    BP.setGrade(100);
	    V.setGrade(100);
	    
	    assertEquals((WS.getGrade()+CA.getGrade())/2, 100, 0.01);
	    assertEquals((H.getGrade()+BW.getGrade())/2, 100, 0.01);
	    assertEquals((IM.getGrade()+F.getGrade())/2, 100, 0.01);
	    assertEquals((AM.getGrade()+SW.getGrade())/2, 100, 0.01);
	    assertEquals(BP.getGrade(), 100, 0.01);
	    assertEquals(V.getGrade(), 100, 0.01);
	}
	
	@Test
	public void testMajor() throws PersonException {
		Student.get(5).setMajor(eMajor.NURSING);
	    assertEquals(Student.get(5).getMajor(),eMajor.NURSING);
	}
	
}