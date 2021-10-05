/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMSGateway;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mianh
 */
public class SMSGatewayEZEE {
   
    
    public static void sendSMS(String message, String recieverNumber) throws IOException {
        String userName = "03334217818";
        String password = "03334217818";
        String sender = "MMT";
        
        try {
            message = URLEncoder.encode(message, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(SMSGatewayEZEE.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String SMS_API_URL = "http://my.ezeee.pk/sendsms_url.html?Username="+userName+"&Password="+password+"&From="+sender+"&To="+recieverNumber+"&Message="+message;
        
        try {
            URL url = new URL(SMS_API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            //connection.setRequestProperty("User-Agent", "Mozila/5.0");
            //connection.setRequestProperty("cache-control", "no-cache");
            
            int code = connection.getResponseCode();
            /*System.out.println("Response Code : " +code);
            
            StringBuffer response = new StringBuffer();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            
            while (true) {                
                String line = br.readLine();
                if(line == null)
                {
                    break;
                }
                response.append(line);
            }
            System.out.println("Response Message");
            System.out.println(response);*/
        } catch (MalformedURLException ex) {
            Logger.getLogger(SMSGatewayEZEE.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }
    public static void main(String[] args)  {
        /*try {
            SMSGatewayEZEE.sendSMS("tu baz aya, tu bari haram mout marna ay ..", "03214312919");
        } catch (IOException ex) {
            Logger.getLogger(SMSGatewayEZEE.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        System.out.println("SM-SGateway.SMSGatewayEZEE.main()".replace("-", "LL"));
    }
}
