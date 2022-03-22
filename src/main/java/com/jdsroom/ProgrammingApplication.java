package com.jdsroom;

import java.util.Arrays;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StopWatch;

import com.jdsroom.sorting.MergeSort;

@SpringBootApplication
public class ProgrammingApplication implements CommandLineRunner{

	private static Logger logger = LoggerFactory.getLogger(ProgrammingApplication.class); 
	public static void main(String[] args) {
		SpringApplication.run(ProgrammingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	}
	
	
}
