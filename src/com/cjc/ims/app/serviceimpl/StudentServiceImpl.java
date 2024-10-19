package com.cjc.ims.app.serviceimpl;

import java.util.*;

import com.cjc.ims.app.exception.BatchIdNotFoundException;
import com.cjc.ims.app.exception.CourseIdNotFoundException;
import com.cjc.ims.app.exception.FacultyIdNotFoundException;
import com.cjc.ims.app.model.Batch;
import com.cjc.ims.app.model.Course;
import com.cjc.ims.app.model.Faculty;
import com.cjc.ims.app.model.Student;
import com.cjc.ims.app.servicei.StudentServiceI;

public class StudentServiceImpl implements StudentServiceI {
	
	Scanner sc=new Scanner(System.in);
	List<Course> clist=new ArrayList<>();
	List<Faculty> flist=new ArrayList<>();
	List<Batch> blist=new ArrayList<>();
	List<Student> slist=new ArrayList<>();

	@Override
	public void addCourse() {
		Course c=new Course();
		System.out.println("Enter course ID: ");
		c.setCid(sc.nextInt());
		System.out.println("Enter course name: ");
		c.setCourseName(sc.next());
		clist.add(c);
	}

	@Override
	public void viewCourse() {
		for(Course c : clist) {
			System.out.println("Course ID: "+c.getCid()+ ", Course Name: "+c.getCourseName());
		}
		
	}

	@Override
	public void addFaculty() {
		Faculty f=new Faculty();
		System.out.println("Enter faculty ID: ");
		f.setFid(sc.nextInt());
		System.out.println("Enter faculty name: ");
		f.setFacultyName(sc.next());
		
		System.out.println("Assign anyone course to faculty.");
		viewCourse();
		System.out.println("Enter any course ID you want: ");
		int cid=sc.nextInt();
		for(Course c: clist) {
			if(c.getCid()==cid) {
				f.setC(c);
			}
			else {
				throw new CourseIdNotFoundException("Invalid Course ID");
			}
			flist.add(f);
		}
		
	}

	@Override
	public void viewFaculty() {
		for(Faculty f:flist)
		{
			System.out.println("Faculty ID: "+f.getFid()+ " Faculty name: "+f.getFacultyName()+ " Course ID:"+f.getC().getCid());
		}
		
	}

	@Override 
	public void addBatch() {
		Batch b=new Batch();
		System.out.println("Enter batch ID: ");
		b.setBid(sc.nextInt());
		System.out.println("Enter batch name: ");
		b.setBatchName(sc.next());
		
		System.out.println("Assign anyone faculty to batch.");
		viewFaculty();
		System.out.println("Enter any faculty ID you want: ");
		int fid=sc.nextInt();
		for(Faculty f:flist)
		{
			if(f.getFid()==fid)
			{
				b.setF(f);
			}
			else {
				throw new FacultyIdNotFoundException("Invalid faculty ID");
			}
			blist.add(b);
		}
		
		
	}

	@Override
	public void viewBatch() {
		for(Batch b:blist) {
			System.out.println("Batch ID: "+b.getBid()+" Batch name: "+b.getBatchName()+" Faculty ID:"+b.getF().getFid());
		}
		
	}

	@Override
	public void addStudent() {
		Student stu=new Student();
		System.out.println("Enter Student ID: ");
		stu.setSid(sc.nextInt());
		System.out.println("Enter Student name: ");
		stu.setSname(sc.next());
		
		System.out.println("Assign anyone Batch to student.");
		viewBatch();
		System.out.println("Enter any batch ID you want: ");
		int bid=sc.nextInt();
		for(Batch b:blist)
		{
			if(b.getBid()==bid)
			{
				stu.setB(b);
			}
			else {
				throw new BatchIdNotFoundException("Invalid batch ID");
			}
			slist.add(stu);
		}
		
	}

	@Override
	public void viewStudent() {
		for(Student stu:slist)
		{
			System.out.println("Student ID: "+stu.getSid()+" Student name: "+stu.getSname()+" Batch ID: "+stu.getB().getBid());
		}
		
	}

}
