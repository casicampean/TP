package tema5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Requirements {
	public List<MonitoredData> readFromFile() {
		String fileName="D:\\Casi\\Activities.txt";
		
		List<MonitoredData> data=new ArrayList<>();
	    try(Stream<String> stream=Files.lines(Paths.get(fileName)))
	    {
	    	data=stream.map(line->{
	    	String[] splits=line.split("\t\t");
	         return new MonitoredData(splits[0],splits[1],splits[2]);
	         }).collect(Collectors.toList());
	    }catch(IOException e) {
	    	e.printStackTrace();
	    }
	    //data.forEach(System.out::println);
	    return data;
	
	}
	
	
	//Count the distinct days that appear in the monitoring data
	public void countDays(List<MonitoredData> data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		Map<Object, Long> counting= data.stream().collect(
				Collectors.groupingBy(p->(LocalDateTime.parse(p.getStart_time(),formatter)).getDayOfMonth(),Collectors.counting()));
		//System.out.println(counting);
		System.out.println("countDays:");
		System.out.println(counting.size());
		
	}
	
	//Determine a map of type <String, Integer> 
	//that maps to each distinct action type the number of
	//occurrences in the log. Write the resulting map into a text file
	public void mapActivityOccurence(List<MonitoredData> data) {
		
		Map<String, Long> counting = data.stream().collect(
                Collectors.groupingBy(MonitoredData::getActivity,Collectors.counting()));

        System.out.println("\nmapActivityOccurence:");
        String fileName="D:\\Casi\\ActivitiesOccurence.txt";
        counting.forEach((k,v)->System.out.println(k + " Count : " + v));
        PrintWriter outputStream;
		try {
			outputStream = new PrintWriter(fileName);
			counting.forEach((k,v)->outputStream.println(k + " Count : " + v));
		    outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//Generates a data structure of type Map<Integer, Map<String, Integer>> 
	//that contains the activity count for each day of the log (task number 2 applied for each day of the log)
	//and writes the result in a text file
	public void ActivityOccurencePerDay(List<MonitoredData> data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		Map<Object, Map<String, Long>> counting=data.stream().collect(
				Collectors.groupingBy(p->(LocalDateTime.parse(p.getStart_time(),formatter)).getDayOfMonth(),Collectors.groupingBy(MonitoredData::getActivity, Collectors.counting())));
		System.out.println("\nActivityOccurencePerDay:");
		counting.forEach((k,v)->System.out.println(k +" " + v));
		 String fileName="D:\\Casi\\ActivityOccurencePerDay.txt";
	     PrintWriter outputStream;
			try {
				outputStream = new PrintWriter(fileName);
				counting.forEach((k,v)->outputStream.println(k +" " + v));
			    outputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

	}
	
	
	//Determine a data structure of the form Map<String, DateTime> that maps
	//for each activity the total duration computed over the 
	//monitoring period. Filter the activities with total duration larger
	//than 10 hours. Write the result in a text file.
	public void durationPerActivity(List<MonitoredData> data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		Map<String, Integer> sum = data.stream().collect(
                Collectors.groupingBy(MonitoredData::getActivity, Collectors.summingInt(p->{
		LocalDateTime d1=LocalDateTime.parse(p.getStart_time(), formatter);
		LocalDateTime d2=LocalDateTime.parse(p.getEnd_time(), formatter);
		return (int) ChronoUnit.HOURS.between(d1, d2);}
	)));

        System.out.println("\ndurationPerActivity:");
        sum.forEach((k,v)->{ if(v > 10) {System.out.println(k +" " + v);}});
        
        String fileName="D:\\Casi\\durationPerActivity.txt";
        PrintWriter outputStream;
		try {
			outputStream = new PrintWriter(fileName);
			sum.forEach((k,v)->{ if(v > 10) {outputStream.println(k +" " + v);}});
		    outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//Filter the activities that have 90% of the monitoring samples with duration less than 5 minutes,
	//collect the results in a List<String> containing only the distinct activity names 
	//and write the result in a text file.
	public void lessThanFiveMinutesActivities(List<MonitoredData> data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		Map<String, Long> countingTotal = data.stream().collect(
                Collectors.groupingBy(MonitoredData::getActivity,Collectors.counting()));
		Map<String, Long> counting5Min = data.stream().filter(p->{
			LocalDateTime d1=LocalDateTime.parse(p.getStart_time(), formatter);
			LocalDateTime d2=LocalDateTime.parse(p.getEnd_time(), formatter);
			if(ChronoUnit.MINUTES.between(d1, d2) < 5)
				return true;
			else
				return false;
		}
				).collect(
                Collectors.groupingBy(MonitoredData::getActivity,Collectors.counting()));
		//countingTotal.forEach((k,v)->System.out.println(k + " Count : " + v));
		//counting5Min.forEach((k,v)->System.out.println(k + " Count : " + v));
		List<String> shortActivities=counting5Min.keySet().stream()
		.filter(x -> {
			for(String s :countingTotal.keySet()) {
				if(s.equals(x)) {
					if((double)90/100*countingTotal.get(s) <= (double)counting5Min.get(x))
						return true;
				}
			}
			return false;
		})
		.collect(Collectors.toList());
		
		 String fileName="D:\\Casi\\shortActivities.txt";
	        PrintWriter outputStream;
			try {
				outputStream = new PrintWriter(fileName);
				shortActivities.forEach(item->outputStream.println(item));
			        outputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			System.out.println("\nShort activities:");
		shortActivities.forEach(item->System.out.println(item));
		
	}
	
	public static void main(String[] args) {
		Requirements r =new Requirements();
		
		List<MonitoredData> data=r.readFromFile();
		
		r.countDays(data);
		r.mapActivityOccurence(data);
		r.durationPerActivity(data);
		r.ActivityOccurencePerDay(data);
		r.lessThanFiveMinutesActivities(data);
		
		
	}

}
