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
       
       public String htmlstatement(){
    	   //�뿩��� ��������Ʈ ���
    	   double totalAmount = 0;//�뿩��
    	   int frequentRenerPoints =0;//��������Ʈ
    	   StringBuilder sb = new StringBuilder();
    	   sb.append("<h1><Em>"+getName() + "������ �뿩���</Em></h1><br>\n");
    	   
    	   for(Rental each : rentals){
    		   double thisAmount = 0;//�������� �뿩��
  			//1. �Ϲݹ�(2��) 1500��, ���� �ʰ� 1500, ��������Ʈ1 ==> (2��, 3000�� )���� �ʰ� 2000, ����0.5
 			//2. �Ƶ���(3��) 1500��, ���� �ʰ� 1500, ����1 ==>(2��, 2000��) ���� �ʰ�1500, ����1
   			//3. �ֽŹ�(1��) 3000��, ���� �ʰ� 3000, ���� 1+1 ==>(2��, 4000��) �����ʰ� 4000. ���� 1+1
    		   //html������ ��� ����.
    		   Movie movie = each.getMovie();
    		   int priceCode = movie.getPriceCode();
    		   int daysRented = each.getDaysRented();//�ش� ������ �뿩�ð�
    		   
    		   switch(priceCode){
    		   case Movie.REGULAR:
    			   thisAmount = 3000;
    			   if (daysRented >2){
    				   thisAmount += (daysRented-2) * 2000;
    			   }
    		   break;
    		   case Movie.NEW_RELEASE:
    			   thisAmount = 4000;
    			   if (daysRented >3){
    				   thisAmount = daysRented + 3000;
    			   }
    			   
    		   break;
    		   case Movie.CHILDREN:
    			   thisAmount = 300;
    			   if(daysRented >3){
    				   thisAmount += (daysRented-3)* 1500;
    			   }
    		   break;
    		   }
    	   
    	    frequentRenerPoints++;
    	    if (each.getMovie().getPriceCode()==Movie.NEW_RELEASE&& each.getDaysRented()>1){
    	    	frequentRenerPoints++;
    	    }
    	    
    	    sb.append(String.format("nbsp;nsbp;%s nbsp;nsbp;%s<br>", each.getMovie().getTitle(),thisAmount));
    	   
    	     totalAmount += thisAmount;
    	   }//for loop
    	   
    	   sb.append(String.format("<p>�����뿩�� : <em>%s</em><br><p>���� ����Ʈ: %s%n", totalAmount, frequentRenerPoints));   
    	   
    	   return sb.toString();
    	   
       }
}
