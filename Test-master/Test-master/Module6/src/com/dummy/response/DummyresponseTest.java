package com.dummy.response;


import static org.testng.Assert.assertEquals;
import com.dummy.data.Dummyresponse;
import io.restassured.path.json.JsonPath;

public class DummyresponseTest {

	public static void main(String[] args) {
	
		String response = Dummyresponse.response;
		System.out.println(response);
		JsonPath js =Dummyresponse.getParseresponse(response);
		
		int numberofcousrse = js.getInt("courses.size()");
		System.out.println(numberofcousrse);
		
		System.out.println();
		
		int purcharseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(purcharseAmount);
		
		System.out.println();
		
		String Title = js.getString("courses[0].title");
		//int Price = js.getInt("courses[0].price");
		System.out.println(Title);
		
		System.out.println();

		
		for(int i=0; i<numberofcousrse; i++)
		{
			System.out.println("Title : "+js.getString("courses["+i+"].title")+", Price : "+js.getInt("courses["+i+"].price"));
		}
		
		System.out.println();
		
		System.out.println("RPA course copies sold : "+js.getString("courses[2].copies"));
		System.out.println();
		
		int sum =0;
		for(int i=0; i<numberofcousrse; i++)
		{
			
			int price = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");
			
			sum = sum + price*copies;
			
		}
		
		System.out.println("Sum is "+sum );
		System.out.println();
		
		assertEquals(purcharseAmount, sum);
		
		
	}

}
