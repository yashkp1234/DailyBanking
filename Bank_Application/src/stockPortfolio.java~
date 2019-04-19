
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.*;
import java.io.*;


// By Yagnik Patel
public class stockPortfolio {
    String symb1 = "";
    double price = 0;
    
        stockPortfolio() {
    }
    
    /**
    * Method Name: getQuote
    * Purpose: Retrieves the stock name and quote from Google Finance website and returns the two in a combined string
    * Pre: None
    * Post: None
    * Returns: String
    * By: Yagnik
    */
    public static String getQuote(String symb) throws MalformedURLException, IOException{
         // find URL for data
         String blue = null;
         URL url = new URL("https://www.google.ca/search?q=" + symb + "&tbm=fin");
         
         StringBuilder content = new StringBuilder();
        
        // treat the webpage as a String so we can process it
        URLConnection urlConnection = url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        String line;

        // read from the urlconnection via the bufferedreader
        if (symb.equals("new")){
            return "";
        }
        else{
            while ((line = bufferedReader.readLine()) != null) {
                String banl = null;
                content.append(line + "\n");
                banl = content.toString();
                // Search for string which contains the stock quote
                if (banl.contains("[\"" + symb + "\",")) {
                    int q = 0;
                    int p = 0;
                    int w = 0;
                    int e = 0;
                    int f = 0;
                    String price = null;
                    String name = null;
                    String both = null;
                    // Find the quote inside the string and create a string wih the name and quote
                    q = banl.indexOf("[\"" + symb + "\",");
                    p = symb.length() + q + 5;
                    w = banl.indexOf("\"", p);
                    e = w + 3;
                    f = banl.indexOf("\"", e);
                    name = banl.substring(p, w);
                    price = "$" + banl.substring(e, banl.indexOf("\"", f));
                    both = name + "|" + price;
                    bufferedReader.close();
                    return both;
                }
            }
        }
        bufferedReader.close();
        return "Error";
    }    
}
   
