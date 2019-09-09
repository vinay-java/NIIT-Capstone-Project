package utility;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Enumeration;
import java.util.Properties;

public class ConnectionProvider 
{
	private static Properties properties;
	private static FileInputStream fileInputStream;
	private static Enumeration<String> enumeration;
	private static Connection connection;
	private static String drivermanagerclass; 
	private static String url;
	private static String username;
	private static String password;
	

	public static Connection getConnection()
	{
		try 
		{
			properties = new Properties();
			fileInputStream = new FileInputStream("C:\\Users\\Vinay Kumar\\eclipse-workspace\\MobileStore\\src\\utility\\database.properties");
			properties.load(fileInputStream);
			enumeration = (Enumeration<String>) properties.propertyNames();
			
			while(enumeration.hasMoreElements())
			{
				String key   = enumeration.nextElement();
				String value = properties.getProperty(key);
				
				if(key.equals("drivermanagerclass"))
					drivermanagerclass = value;
				
				else if(key.equals("url"))
					url = value;

				else if(key.equals("username"))
					username = value;
				
				else if(key.equals("password"))
					password = value;
				
			}
			Class.forName(drivermanagerclass);
			connection = DriverManager.getConnection(url, username, password);
		
			
		}
		
		catch (Exception e) 
		{
			System.out.println("-------------- EXCEPTION FROM CONNECTIONPROVIDER.JAVA ---------------");
			e.printStackTrace();
		}
		
		return connection;
		
	}
}

