package repactoring.dto;

import java.util.ArrayList;
import java.util.List;

public class Customer {
       private String name;
       private List<Rental> rentals;
	
       public Customer(String name, List<Rental> rentals) {
		super();
		this.name = name;
		this.rentals = new ArrayList<>();
	}

	public String getName() {
		return name;
	}
       
       public void addRental (Rental aRental){
    	   this.rentals.add(aRental);
       }
       
       public String statement(){
    	   //대여료와 적립포인트 출력
    	   double totalAmount = 0;//대여료
    	   int frequentRenerPoints =0;//적립포인트
    	   StringBuilder sb = new StringBuilder();
    	   sb.append("<h1><Em>"+getName() + "고객님의 대여기록</Em></h1><br>\n");
    	   
    	   for(Rental each : rentals){
    		   double thisAmount = amountFor(each);//비디오물당 대여료
  			//1. 일반물(2일) 1500원, 일일 초과 1500, 적립포인트1 ==> (2일, 3000원 )일일 초과 2000, 적립0.5
 			//2. 아동물(3일) 1500원, 일일 초과 1500, 적립1 ==>(2일, 2000원) 일일 초과1500, 적립1
   			//3. 최신물(1일) 3000원, 일일 초과 3000, 적립 1+1 ==>(2일, 4000원) 일일초과 4000. 적립 1+1
    		   //html형식을 출력 원함.
    		  
    	   
    	    frequentRenerPoints++;
    	    if (each.getMovie().getPriceCode()==Movie.NEW_RELEASE&& each.getDaysRented()>1){
    	    	frequentRenerPoints++;
    	    }
    	    
    	    sb.append(String.format("nbsp;nsbp;%s nbsp;nsbp;%s<br>", each.getMovie().getTitle(),thisAmount));
    	   
    	     totalAmount += thisAmount;
    	   }//for loop
    	   
    	   sb.append(String.format("<p>누적대여료 : <em>%s</em><br><p>적립 포인트: %s%n", totalAmount, frequentRenerPoints));   
    	   
    	   return sb.toString();
    	   
       }

	private double amountFor(Rental aRental) {
		double result = 0;
		Movie movie = aRental.getMovie();
		   int priceCode = movie.getPriceCode();
		   int daysRented = aRental.getDaysRented();//해당 비디오물 대여시간
		   
		   switch(priceCode){
		   case Movie.REGULAR:
			   result = 3000;
			   if (daysRented >2){
				   result += (daysRented-2) * 2000;
			   }
		   break;
		   case Movie.NEW_RELEASE:
			   result = 4000;
			   if (daysRented >3){
				   result = daysRented + 3000;
			   }
			   
		   break;
		   case Movie.CHILDREN:
			   result = 300;
			   if(daysRented >3){
				   result += (daysRented-3)* 1500;
			   }
		   break;
		   }
		return 0;
	}
}
