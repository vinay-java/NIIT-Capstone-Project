package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;
import utility.ConnectionProvider;

public class UserDaoImpl implements UserDao
{
	private Connection connection;
	private PreparedStatement preparedstatement;
	private ResultSet resultset;
	private List<UserBean> list;
	private String query;
	public boolean flag=false;
	public String loginmsg="";
	UserBean userbean;
	
	
	//add user method of UserDao
	
	@Override
	public boolean addUser(UserBean userbean) 
	{
		try
		{
       query= "INSERT INTO CUSTOMER VALUES(?,?,?,?,?)";	
       connection =ConnectionProvider.getConnection();
       preparedstatement =connection.prepareStatement(query);
       
       preparedstatement.setString(1, userbean.getUsername());
       preparedstatement.setString(2, userbean.getPassword());
       preparedstatement.setString(3, userbean.getEmail());
       preparedstatement.setLong(4, userbean.getContact());
       preparedstatement.setString(5, userbean.getAddress());
       
       int rowinserted=preparedstatement.executeUpdate();
       {
    	  if(rowinserted>0)
    	  {
    		  flag=true;
    	  }
    	   
       }
       
		}
		catch(SQLException e)
		{
			System.out.println("--------EXCEPTION IN USER DAO IMPL---------");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if(connection!=null)
				{
					connection.close();
					
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		return flag;
	}
	
	
	// -------------------------------------------------------------------
	
	
	@Override
	public String validatebyusername(UserBean userbean) 
	{
		try
		{
			
       query="select * from customer where username=? and password=?";	
       connection =ConnectionProvider.getConnection();
       preparedstatement =connection.prepareStatement(query);
   
       
       preparedstatement.setString(1,userbean.getUsername());
       preparedstatement.setString(2, userbean.getPassword());
    
     
        resultset=preparedstatement.executeQuery();
       
    
     if(resultset.next())
     {
   
    	  loginmsg="success";
    	 userbean.setEmail(resultset.getString(3)); 
          userbean.setContact(resultset.getLong(4));
          userbean.setAddress(resultset.getString(5)); 
    
     }
     else
     {
    	 loginmsg="failure";
     }
     
       return loginmsg;
		}
		catch(SQLException e)
		{
			System.out.println("--------EXCEPTION IN USER DAO IMPL  VALIDATE EBY USER NAME---------");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if(connection!=null)
				{
					connection.close();
					
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		return loginmsg;
	}


	@Override
	public boolean delete(UserBean userbean) {
          
          try
  		{
  			connection 	      = ConnectionProvider.getConnection();
  			query	   		  = "DELETE FROM CUSTOMER WHERE USERNAME=?";
  			
  			preparedstatement = connection.prepareStatement(query);
  			preparedstatement.setString(1, userbean.getUsername());
  			
  		
  			int rowfetched = preparedstatement.executeUpdate();		
  			if( rowfetched>0)
  			{
  				flag=true;
  			}
  		}
  		
  		catch(SQLException e)
  		{
  			System.out.println("exception in userDaoimpl");
  			e.printStackTrace();
  		}
  		
  		finally
  		{
  			try
  			{
  				connection.close();
  			}
  			
  			catch(SQLException e)
  			{
  				System.out.println("--------------exception in userDaoimpl connection close---------------");
  				e.printStackTrace();
  			}
  		}
  	
  		return flag ;
  	}

          

	
	// -------------------------------------------------------------------

	@Override
	public boolean update(UserBean userbean, String email) {
		try
		{
			connection 	      = ConnectionProvider.getConnection();
			query	   		  = "UPDATE CUSTOMER SET USERNAME = ? , PASSWORD = ? , CONTACT = ? , ADDRESS = ? WHERE EMAIL = ?";
			preparedstatement = connection.prepareStatement(query);
			
			preparedstatement.setString(1, userbean.getUsername());
			preparedstatement.setString  (2, userbean.getPassword());
			preparedstatement.setLong(3, userbean.getContact());
			preparedstatement.setString(4, userbean.getAddress());
			preparedstatement.setString(5, email);
			
			
			int rowfetched = preparedstatement.executeUpdate();		
			if( rowfetched>0)
			{
				flag=true;
			}
		}
		
		catch(SQLException e)
		{
			System.out.println("exception in userDaoimpl");
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				connection.close();
			}
			
			catch(SQLException e)
			{
				System.out.println("--------------exception in userDaoimpl connection close---------------");
				e.printStackTrace();
			}
		}
	
		return flag ;
	}


	
	// -------------------------------------------------------------------
	
	@Override
	public UserBean getCustomer(String email) {
		
		try
		{
			connection 		  = ConnectionProvider.getConnection(); 
			query	   		  = "SELECT * FROM CUSTOMER WHERE EMAIL=?";
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, email);
			resultset  = preparedstatement.executeQuery();
			userbean   = new UserBean();
			
			
			while(resultset.next())
			{
				userbean.setUsername(resultset.getString(1));
				userbean.setPassword(resultset.getString(2));
				userbean.setEmail(resultset.getString(3)); 
				userbean.setContact(resultset.getLong(4));
				userbean.setAddress(resultset.getString(5));
				
			}			
		}
		
		catch(SQLException e)
		{
			System.out.println("exception from daoimpl getCustomer()");
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				connection.close();
			}
			
			catch(SQLException e)
			{
				System.out.println("exception from daoimpl getCustomer() connection closing");
				e.printStackTrace();
			}
		}
		
		return userbean;
	}


		
	

	// -------------------------------------------------------------------
	
	@Override
	public List<UserBean> getAllCustomers() 
	{
		try
		{
			connection 		  = ConnectionProvider.getConnection(); 
			query	   		  = "SELECT * FROM CUSTOMER";
			preparedstatement = connection.prepareStatement(query);
			resultset		  = preparedstatement.executeQuery();
			list = new ArrayList<UserBean>();
			
			while(resultset.next())
			{	
				UserBean userbean = new UserBean();
				
				userbean.setUsername(resultset.getString(1));
				userbean.setPassword(resultset.getString(2));
				userbean.setEmail(resultset.getString(3));
				userbean.setContact(resultset.getLong(4));  
				userbean.setAddress(resultset.getString(5));  
				
		     
					list.add(userbean);
			}			
		}
		
		catch(SQLException e)
		{
			System.out.println("exception from userdaoimpl getAllCust");
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				connection.close();
			}
			
			catch(SQLException e)
			{
				System.out.println("---------------- getAllCust Closing connection -----------------");
				e.printStackTrace();
			}
		}
		
		return list;
	}



	@Override
	public boolean updatePassword(String email, String newPassword) 
	{
		try
		{
			connection 		  = ConnectionProvider.getConnection(); 
			query	   		  = "UPDATE CUSTOMER SET PASSWORD = ? WHERE EMAIL = ?";
			preparedstatement = connection.prepareStatement(query);

			preparedstatement.setString(2, email);
			preparedstatement.setString(1, newPassword);
			

			int statuscheck = preparedstatement.executeUpdate();
		if(statuscheck>0)
		{
			flag=true;
			
		}
		}
		
		catch(SQLException e)
		{
			System.out.println("---------------- Eexception from updatePasswor() -----------------");
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				connection.close();
			}
			
			catch(SQLException e)
			{
				System.out.println("---------------- Eexception from updatePasswor()  closing connection-----------------");
				e.printStackTrace();
			}
		
		
		
		
	}
		
		return flag;
		
}
	
		
	}