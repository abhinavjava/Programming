package com.jdsroom.service;

import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Stream;

import com.jdsroom.bean.Student;

public class ComparableWithComparatorAndStream {

	public void distinctStudent() {
		
		System.out.println("Priniting Distinct Students--------------------->>>");
		Stream<Student> studentStream = Stream.of(new Student("Abhinav",1)
											,new Student("Abhinav",2)
											,new Student("Kumar",3)
											,new Student("Abhinav",1)
											,new Student("Abhinav",2));
		
		studentStream.distinct().forEach(System.out::println);
	}
	
	public void naturalSortStudent() {
		
		System.out.println("Priniting Sorted Students In Natural Shorting Order--------------------->>>");
		Stream<Student> studentSortStream = Stream.of(new Student("Kumar",1),
														new Student("Abhishek",2),
														new Student("Kumar",3),
														new Student("Jyoti",4),
														new Student("Jyoti",4),
														new Student("Abhinav",5));

		studentSortStream.sorted().forEach(System.out::println);
	}
	
	public void customSortStudent() {
		
		System.out.println("Priniting Sorted Students In custom Shorting Order--------------------->>>");
		Stream<Student> studentSortStream = Stream.of(new Student("Kumar",1),
														new Student("Abhishek",2),
														new Student("Kumar",3),
														new Student("Jyoti",4),
														new Student("Jyoti",4),
														new Student("Abhinav",5));

		studentSortStream.sorted((s1,s2)->s2.compareTo(s1)).forEach(System.out::println);
	}
	
	public void reverseSortStudent() {
		
		System.out.println("Priniting Sorted Students In reverse Shorting Order--------------------->>>");
		Stream<Student> studentSortStream = Stream.of(new Student("Kumar",1),
														new Student("Abhishek",2),
														new Student("Kumar",3),
														new Student("Jyoti",4),
														new Student("Jyoti",4),
														new Student("Abhinav",5));

		studentSortStream.sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}
	
	public void notNullSafeComparatorStudent() {
		
		System.out.println("Priniting Sorted Students In notNullSafeComparator Shorting Order--------------------->>>");
		Stream<Student> studentSortStream = Stream.of(new Student("Kumar",1),
														new Student("Abhishek",2),
														new Student("Kumar",3),
														new Student("Jyoti",4),
														new Student("Jyoti",4),
														new Student("Abhinav",5),
														null);

		//Comparator is not null safe so above operation will throw nullPointerException
		studentSortStream.sorted().forEach(System.out::println);
	}
	
	public void nullSafeComparatorStudent() {
		
		System.out.println("Priniting Sorted Students In nullSafeComparatorStudent Shorting Order--------------------->>>");
		Stream<Student> studentSortStream = Stream.of(new Student("Kumar",1),
														new Student("Abhishek",2),
														new Student("Kumar",3),
														new Student("Jyoti",4),
														new Student("Jyoti",4),
														new Student("Abhinav",5),
														null);

		//Making Comparator Null safe using Comparator nullsLast and nullFirst
		studentSortStream.sorted(Comparator.nullsLast(Comparator.comparing(Student::getName))).forEach(System.out::println);
	}
	
	public void manualPassingFunctionComparatorStudent() {
		
		System.out.println("Priniting Sorted Students In manualPassingFunctionComparator Shorting Order--------------------->>>");
		Stream<Student> studentSortStream = Stream.of(new Student("Kumar",1),
														new Student("Abhishek",2),
														new Student("Kumar",3),
														new Student("Jyoti",4),
														new Student("Jyoti",4),
														new Student("Abhinav",5),
														null);

		Function<Student,String> fn = (s)->s.getName(); 
		studentSortStream.sorted(Comparator.nullsLast(Comparator.comparing(fn))).forEach(System.out::println);
		//Method refrence and this function approach is similar
		//Comparator.comparing(Student::getName) equal Comparator.comparing(fn)
	}
	
	public void usingComparatorCompationAndThenComparionStudent() {
		
		System.out.println("Priniting Sorted Students ComparatorCompationAndThenComparion Shorting Order--------------------->>>");
		Stream<Student> studentSortStream = Stream.of(new Student("Kumar",1),
														new Student("Abhishek",2),
														new Student("Kumar",3),
														new Student("Jyoti",4),
														new Student("Jyoti",4),
														new Student("Abhinav",5),
														null);

		//first applying comparator on name and then applying on roll no
		studentSortStream.sorted(Comparator.nullsLast(Comparator.comparing(Student::getName).thenComparing(Student::getRollNo))).forEach(System.out::println);
	}
}
