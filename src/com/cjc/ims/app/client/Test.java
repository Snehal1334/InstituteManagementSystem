package com.cjc.ims.app.client;

import java.util.*;

import com.cjc.ims.app.exception.BatchIdNotFoundException;
import com.cjc.ims.app.exception.CourseIdNotFoundException;
import com.cjc.ims.app.exception.FacultyIdNotFoundException;
import com.cjc.ims.app.servicei.StudentServiceI;
import com.cjc.ims.app.serviceimpl.StudentServiceImpl;

public class Test {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StudentServiceI ssi=new StudentServiceImpl();
		boolean flag=true;
		while(true)
		{
			System.out.println("-----WELCOME-----");
			System.out.println("Enter your choice:\n 1.AddCourse.\n 2.ViewCourse. ");
			System.out.println("3.AddFaculty.\n 4.ViewFaculty.");
			System.out.println("5.AddBatch.\n 6.ViewBatch.");
			System.out.println("7.AddStudent.\n 8.ViewStudent.\n 9.Exit\n");
			int ch=sc.nextInt();
			
			switch (ch) {
			case 1: {
				ssi.addCourse();
				break;
			}
			case 2: {
				ssi.viewCourse();
				break;
			}
			case 3: {
				try {
					ssi.addFaculty();
				} catch (CourseIdNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			case 4: {
				ssi.viewFaculty();
				break;
			}
			case 5: {
				try {
					ssi.addBatch();
				} catch (FacultyIdNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			case 6: {
				ssi.viewBatch();
				break;
			}
			case 7: {
				try {
					ssi.addStudent();
				} catch (BatchIdNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			case 8: {
				ssi.viewStudent();
				break;
			}
			case 9: {
				System.out.println("Exit Successfully...");
				flag=false;
				break;
			}
			default:
				System.out.println("Invalid Input!!!   Try Again :)");
			}
		}
	}

}
