import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ForexTradingSystem {
    private static double usdToInrRate = 66.00;//rate variable
    private static List<Trade> trades = new ArrayList<>();//store book trades
    private static Scanner scanner = new Scanner(System.in);

   
    
    public static void main(String[] args) {
       
    	while (true) {
            System.out.println("1. Book Trade");
            System.out.println("2. Print Trades");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            //scanner.nextLine(); // Consume extra line line
              
            
            switch (choice)
            {
             case "1": bookTrade();break;
             case "2": printTrades();break;
             case "3": exitProgram();break;
             default:System.out.println("Invalid choice. Please select again.");
            }
        }
    }
    private static void bookTrade() {
    	//enter the name with validation
    	System.out.print("Enter customer Name: ");
        String customerName = scanner.nextLine();
        while(!isValidName(customerName))
        {
        	System.out.println("Enter a valid Name!!");
            customerName = scanner.nextLine();
       
        }
        //enter the currency with validation
        System.out.print("Enter Currency Pair: ");
        String currencyPair = scanner.nextLine();
        //
        while(!currencyPair.equalsIgnoreCase("USDINR")) 
        {
        System.out.println("Invalid currency pair. Only USDINR is supported.");
        System.out.println("Enter a Valid currency Pair!!! ");
        currencyPair = scanner.nextLine();
        }
         //enter the amount with validation
        System.out.print("Enter amount to transfer: ");
        String amount = scanner.nextLine();
        while(amount!=null)
        {
        	if((amount.trim()).matches("[0-9]+"))
        	break;
        	else
        	{
        		System.out.println("Amount should be  a number");
        		amount=scanner.nextLine();
        	}

        }
        double amountdouble=Double.parseDouble(amount);
        while(!ValidAmount(amountdouble)) 
        {
        	System.out.println("Enter a Valid Amount!!");
        	amount=scanner.nextLine();
         }
        
        //rate 
        System.out.print("Do you want to get Rate (Yes/No): ");
        //scanner.nextLine(); // Consume newline
        
        String getRate = scanner.nextLine();
        if (getRate.equalsIgnoreCase("Yes")) {
        System.out.println("You are transferring INR " + amountdouble*usdToInrRate + " to " + customerName +
                     " (Assuming that rate was " + usdToInrRate + ")");
        }
        else 
        {
        	 System.out.println("You are transferring INR " + amountdouble*usdToInrRate + " to " + customerName );
        }
        
        System.out.print("Book/Cancel this trade? (Book/Cancel): ");
        String decision = scanner.next();

        if (decision.equalsIgnoreCase("Book")) {
            trades.add(new Trade(currencyPair, customerName, amountdouble, usdToInrRate));
            System.out.println("Trade for " + currencyPair + " has been booked with rate " + usdToInrRate +
                    ", The amount of Rs "+ amountdouble*usdToInrRate  +
                    " will be transferred in 2 working days to " + customerName + ".");
        }
        else if (decision.equalsIgnoreCase("Cancel")) 
        {
            System.out.println("Trade is Canceled.");
        }
        else 
        {
            System.out.println("Invalid choice.");
        }
    }

    //method for printing info table
    private static void printTrades() {
        System.out.println("TradeNo\tCurrencyPair\tCustomerName\tAmount\tRate");
        for (Trade trade : trades) {
            System.out.println(trade);
        }
    }
    //method for exit program
    private static void exitProgram() {
        System.out.print("Do you really want to exit (y/n): ");
        String confirmation = scanner.next();
        if (confirmation.equalsIgnoreCase("Y")) {
            System.out.println("Bye - have a good day");
            System.exit(0);
        }
    }
    //method for valid username
    public static boolean isValidName(String name) {
    	if (name == null ) {
            return false;
        }
    	for(char c : name.toCharArray())
		{
			if(!Character.isLetter(c) && c != ' ')
			{
				return false;
			}
		}
		return true;
    }
      //method for valid amount
    public static boolean ValidAmount(double amount)
	{
		if(amount<0)
		{
			return false;
		}
		if(amount==0)
		{
			return false;
		}
			
		return true;
	}
	
  }
	



