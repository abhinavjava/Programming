package com.jdsroom.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReverseKOcurance {

	public static void testcase() {
List<Integer> numbers = Arrays.asList(10,15,20,25,30,35,40,45,50);
		
		List<Integer> numberSquare = numbers.stream().filter(number->number%2==0).map(number->number*number).collect(Collectors.toList());
		System.out.println(numberSquare);
		
		
		String string= "abcdef";
        String[] array=string.split("(?<=\\G.{3})");
 
        System.out.println(Arrays.toString(array));   
        
		List<String> list = new ArrayList<>();
		String s = "1,2,3,4,5,6";
		//s.length();
		int next = 3;
		int previous=0;
		while(next<s.length()) {
			list.add(s.substring(previous,next));
			previous = next+1;
			next +=4;
		}
		list.add(s.substring(previous,s.length()));
		
		StringBuilder temp = new StringBuilder();
		StringBuilder result = new StringBuilder();
		list.forEach(str->{
			result.append(temp.append(str).reverse()+",");
			temp.delete(0,temp.length());
		});
		System.out.println("result::::::::::::"+result);
		result.setLength(result.length()-1);
		System.out.println("result::::::::::::"+result);
		
		list.forEach(stri->{
			
			System.out.println("split::::::::::::"+stri);
		});
//		Stream<String> str = Stream.of(splits);
//		str.forEach(stri->{
//			
//			System.out.println("split::::::::::::"+stri);
//		});
		List<String> splitAtNthOccurrence = ReverseKOcurance.splitAtNthOccurrence("1,2,3,4,5,6",3,",");
		System.out.println("splitAtNthOccurrence::::::::::::"+splitAtNthOccurrence);
		
		System.out.println("ReverseKOcurance::::::::::::"+ReverseKOcurance.reverseKthOccurence("1,2,3,4,5,6",2));
		System.out.println("ReverseKOcurance::::::::::::"+ReverseKOcurance.reverseKthOccurence("1,2,3,4,5,6",3));
		System.out.println("ReverseKOcurance::::::::::::"+ReverseKOcurance.reverseKthOccurence("1,2,3,4,5,6,7,8",2));
		System.out.println("ReverseKOcurance::::::::::::"+ReverseKOcurance.reverseKthOccurence("1,2,3,4,5,6,7,8",3));
	}
	public static String reverseKthOccurence(String content,int occurance) {
		int next = occurance;
		int previous = 0;
		StringBuilder sb = new StringBuilder();
		List<String> arr = new ArrayList<>();
		content = content.replaceAll(",", "");
	//	System.out.println("::::::::::::::::str:::::>>>>"+content);
		while(next<content.length()) {
			arr.add(content.substring(previous,next));
			previous = next;
			next +=occurance;
		}
		arr.add(content.substring(previous,content.length()));
		
		// System.out.println("::::::::::::::::arr:::::>>>>"+arr);
		 StringBuilder result = new StringBuilder();
		 arr.forEach(string->{
			 if(string.length()==occurance)
			 result.append(sb.append(string).reverse());
			 else
			 result.append(sb.append(string));	
			 sb.setLength(0);
		 });
		 String reg = result.toString();
		 result.setLength(0);
		 char[] charArray = reg.toCharArray();
		 for(char c:charArray) {
			 result.append(c+","); 
		 }
		 result.setLength(result.length()-1);
		return result.toString();
	}
	
	public static List<String> splitAtNthOccurrence(String input, int n, String delimiter) {
	    List<String> pieces = new ArrayList<>();
	    // *? is the reluctant quantifier
	    String regex = repeat(".*?" + delimiter, n);
	    System.out.println("::::::::::::::::regex:::::>>>>"+regex);
	    StringBuilder sb = new StringBuilder();
//	    sb.append(".*?");
//	    for(int i=1;i<=n;i++) {
//	    	sb.append(delimiter);
//	    	if(i!=n)
//	    		sb.append(".*?");
//	    }
	    for(int i=0;i<n;i++) {
	    		sb.append(".*?,");
	    }
	    System.out.println("::::::::::::::::regex:::::>>>>"+sb.toString());
	    System.out.println("::::::::::::::::regex:::::>>>>"+repeat(".*?" + delimiter, n));
	    Matcher matcher = Pattern.compile(regex).matcher(input);

	    int lastEndOfMatch = -1;
	    while (matcher.find()) {
	        pieces.add(matcher.group());
	        lastEndOfMatch = matcher.end();
	    }
	    if (lastEndOfMatch != -1) {
	        pieces.add(input.substring(lastEndOfMatch));
	    }
	    return pieces;
	}
	
	 public static String repeat(final String str, final int count) {
			/*
			 * Objects.requireNonNull(str, "str"); if (count < 0) { throw new
			 * IllegalArgumentException("count"); }
			 */
	        StringBuilder sb = new StringBuilder();
	        try {
	            for (int index = 0; index < count; index++) {
	                sb.append(str);
	            }
	            return sb.toString();
	        } finally {
	            sb.setLength(0);
	        }
	    }

}
