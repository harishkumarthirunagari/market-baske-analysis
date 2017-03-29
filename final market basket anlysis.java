package com.major;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Major
 */
public class Major extends HttpServlet {
	private static final long serialVersionUID = 1L;
      public Connection conn;
	   public PreparedStatement ps=null;
	   public PreparedStatement ps1=null;
	   public PreparedStatement psleft=null;
	   public PreparedStatement psright=null;
	   public int ilength;
	   public int[] suport= new int[20];
	   public int[] suport2= new int[20];
	   public char[][] b =  new char[300][20];
	   public int[] sb = new int[300];
	   public int[] sb2 = new int[300];
	   public char[][] b1 =  new char[300][20];
	   public char[][] c =  new char[300][20];
	   public int[] sc = new int[300];
	   public int[] sc2 = new int[300];
	   public char[][] c1 =  new char[300][20];
	   public char[][] d =  new char[300][20];
	   public int[] sd = new int[300];
	   public int[] sd2 = new int[300];
	   public char[][] d1 =  new char[300][20];
	   public char[][] e =  new char[300][20];
	   public int[] se = new int[300];
	   public int[] se2 = new int[300];
	   public char[][] e1 =  new char[300][300];
	   public char[][][] Aa= new char[900][900][3];
	   public char[][][] Aa2= new char[900][900][3];
	   public char[][][] Aat= new char[900][900][3];
	   public int[] Aa2len =new int[100];
	   public char[][][] Ab= new char[100][900][3];
	   public char[][][] Ac= new char[100][900][3];
	   public char[][][] Aa3= new char[900][900][3];
	   public char[][][] Ab3= new char[100][900][3];
	   public char[][][] Ac3= new char[100][900][3];
	   public char[][][] Aaf= new char[100][900][3];
	   public char[][][] Ab4= new char[100][900][3];
	   public char[][][] Ac4= new char[100][900][3];
	   public char[][][] Ad4= new char[100][900][3];
	   public int[] Aa3len =new int[100];
	   public int[] Ablen =new int[100];
	   public int[] Aaflen =new int[100];
	   public int[] Ab4len =new int[100];
	   public int[] Ac4len =new int[100];
	   public int[] Ad4len =new int[100];
	   public int[] Aclen =new int[100];
	   public int[] Ab3len =new int[100];
	   public int[] Ac3len =new int[100];
	   public char[][][] NAb= new char[100][100][3];
	   public char[][][] NAc= new char[100][100][3];
	   public char[][][] NAa3= new char[100][100][3];
	   public char[][][] NAb3= new char[100][100][3];
	   public char[][][] NAc3= new char[100][100][3];
	   public int[] NAblen =new int[100];
	   public int[] NAclen =new int[100];
	   public int[] NAa3len =new int[100];
	   public int[] NAb3len =new int[100];
	   public int[] NAc3len =new int[100];
	   public int[][] flag =new int[100][100];
	   public int[][] flagt =new int[100][100];
	   public int[][] flag1 =new int[100][100];
	   public int[][] flag3 =new int[100][100];
	   public int[][] flag4 =new int[100][100];
	   public int[][] flagf =new int[100][100];
	   public char[][] Ad= new char[100][3];
	   public int asb=0;
	   public int asc=0;
	   public int asd=0;
	   public int length;
	   public int Al=0;
	   public String strAssleft;
	   public String strAssright;
	   public char[][][] remain = new char[300][300][30];
	   public char[][][] remainf = new char[300][300][30];
	   public char[][][] remainf4 = new char[300][300][30];
	   public char[][][] remaint = new char[300][300][30];
	   public char[][][] remain3 = new char[300][300][30];
	   public char[][][] remain4 = new char[300][300][30];
	   public char[][][] remain5 = new char[300][300][30];
	   public char[][][] remain1 = new char[300][300][30];
	   char a[] ={'a','b','c','d','e','f','g',};
	   char a1[]={'a','b','c','d','e','f','g',};
	   char sample[]={'a','b','c','d','e','f','g',};
	   int[] sa = new int[100];
	   PrintWriter out;
	   public int k=0;
	   public int AAA=1;
	   public int minsup=-1;
	   public int x=-1;
	   public String str;
	   public  BufferedWriter writer;
	   public double minconf=0.0;
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AAA=1;
		 out = response.getWriter();
		 writer =  new BufferedWriter(new FileWriter("C:/Users/harish/Desktop/Associationrule.txt"));
		   try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			String url ="jdbc:mysql://localhost:3306/";
		    try {
				conn = DriverManager.getConnection(url,"root","root");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    String str = "use  ma";
			
			try {
				ps1 = conn.prepareStatement(str);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				ps1.executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		k=0;
		length=a1.length;
		ilength=a1.length;
	try {
		
		 
			generatefset();
			
		}
	    catch (Exception e)
	     {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		
	writer.flush();
	writer.close();
	Runtime runtime = Runtime.getRuntime();
	runtime.exec("notepad.exe C:/Users/harish/Desktop/Associationrule.txt");
	}

	
	
	
	
	
	
	
	
	// function for frequent item set genearation::::::::::::::::::::::::::::::::::::::::::
	
	public void generatefset() throws Exception
	{
		k=0;
      out.println("One frequent itemsets----><br>");
       for(int i=0;i<a1.length;i++)
       {  out.println("<br>");
    	  out.println(i+1+" "+String.valueOf(a1[i]));
    	  out.println("<br>");
       }
       //generating Two frequent item set
       
       for(int i=0;i<fact(length,1);i++)
    	   for(int j=i+1;j<fact(length,1);j++)
    	   {
               if(a[i]!=a1[j])
               {
            	   b[k][0]=a1[i];
                   b[k][1]=a1[j];
                   b1[k][0]=a1[i];
                   b1[k][1]=a1[j];
                   k++;
               }
    	   }
      			
       
      //printing Two fequent item sets
       out.println("<br>::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::<br><br><br>");
		out.println("ALL 2-FREQUENT item sets----------><br>");
			for(int i=0;i<k;i++)
			{
				sb[i]=result(b[i],2);
				sb2[i]=result2(b[i],2);
				if(sb[i]>minsup&&sb[i]>minsup)
				{
				out.println(i+" "+String.copyValueOf(b[i]));
				out.println("------->"+String.valueOf(sb[i]));
				out.println("<br>");
				}
				
			}
		
			k=0;
    //generating three frequent item sets
			out.println("<br>::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::<br><br><br>");
			out.println("ALL 3-FREQUENT item sets----------><br>");
			 for(int i=0;i<fact(length,2);i++)
		    	   for(int j=i+1;j<fact(length,2);j++)
		    	   {
		               if(b1[i][0]==b[j][0]&&b1[i][1]!=b[j][1])
		               {
		            	   c[k][0]=b1[i][0];
		                   c[k][1]=b1[i][1];
		                   c[k][2]=b1[j][1];
		                   c1[k][0]=b1[i][0];
		                   c1[k][1]=b1[i][1];
		                   c1[k][2]=b1[j][1];
		                   k++;
		               }
		    	   }
			 
			 for(int i=0;i<k;i++)
				{   
				    sc[i]=result(c[i],3);
				    sc2[i]=result2(c[i],3);
				    if(sc[i]>minsup&&sc2[i]>minsup)
				    {
					out.println(i+""+String.copyValueOf(c[i]));
					out.println("------->"+String.valueOf(sc[i]));
					out.println("<br>");
				    }
				    
				}
			 
	        k=0;
			 //generating four frequent item sets
				out.println("<br>::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::<br><br><br>");
				out.println("ALL 4-FREQUENT item sets-----><br>");
				 for(int i=0;i<fact(length,3);i++)
			    	   for(int j=i+1;j<fact(length,3);j++)
			    	   {
			               if(c1[i][0]==c[j][0]&&c1[i][1]==c[j][1]&&c1[i][2]!=c[j][2])
			               {
			            	   d[k][0]=c1[i][0];
			                   d[k][1]=c1[i][1];
			                   d[k][2]=c1[i][2];
			                   d[k][3]=c1[j][2];
			                   d1[k][0]=c1[i][0];
			                   d1[k][1]=c1[i][1];
			                   d1[k][2]=c1[i][2];
			                   d1[k][3]=c1[j][2];
			                   k++;
			               }
			    	   }
				 
				 for(int i=0;i<k;i++)
					{
					 sd[i]=result(d[i],4);
					 sd2[i]=result2(d[i],4);
					 if(sd[i]>minsup&&sd2[i]>minsup)
					 {
					 out.println(i+""+String.copyValueOf(d[i]));
					 out.println("------->"+String.valueOf(sd[i]));
					 out.println("<br>");
					 }
					 
					}
				/* for(int i=0;i<fact(ilength,4);i++)
				 {
					    
						association(d[i],i,4);
						
				 }*/
				 
				 
				 k=0;
				 //generating five frequent item sets
					out.println("<br>::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::<br><br><br>");
					out.println("ALL 5-FREQUENT item sets------><br>");
					 for(int i=0;i<fact(length,4);i++)
				    	   for(int j=i+1;j<fact(length,4);j++)
				    	   {
				               if(d1[i][0]==d[j][0]&&d[i][1]==d[j][1]&&d1[i][2]==d[j][2]&&d1[i][3]!=d[j][3])
				               {
				            	   e[k][0]=d[i][0];
				                   e[k][1]=d[i][1];
				                   e[k][2]=d[i][2];
				                   e[k][3]=d[i][3];
				                   e[k][4]=d[j][3];
				                   e1[k][0]=d[i][0];
				                   e1[k][1]=d[i][1];
				                   e1[k][2]=d[i][2];
				                   e1[k][3]=d[i][3];
				                   e1[k][4]=d[j][3];
				                   k++;
				               }
				    	   }
				
					 
					 for(int i=0;i<k;i++)
						{
						 se[i]=result(e[i],5);
						 se2[i]=result2(e[i],5);
						 if(se[i]>minsup&&se2[i]>minsup)
						 {
						 
						 out.println(i+""+String.copyValueOf(e[i]));
						 out.println("------->"+String.valueOf(se[i]));
						 out.println("<br>");
						 }
						
						}
					 out.println("number of 5 frequent temsets"+k);
					 out.println("<br>");
					 out.println("<br>");
					 out.println("<br>");
					 out.println("<br>");
					 out.println("<br>");
					 out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
					 out.println("Subsets of All Frequent Item sets<br>");
					// int m=0;
					 for(int i=0;i<fact(ilength,2);i++)
					 {
						   if(sb[i]>minsup&&sb2[i]>minsup)
						   associationtwo(b[i],i,2);
							
					 }
					 
					 for(int i=0;i<fact(ilength,3);i++)
					 {
						   if(sc[i]>minsup&&sc2[i]>minsup)
						   association3(c[i],i,3);
							
					 }
					 
					 for(int i=0;i<fact(ilength,4);i++)
					 {
						   if(sd[i]>minsup&&sd2[i]>minsup)
						   associationfour(d[i],i,4);
							
					 }
					 
					 for(int i=0;i<fact(ilength,5);i++)
				   {
						  if(se[i]>minsup&&se2[i]>minsup)
						association(e[i],i,5);
						
				   }
				//printing all subsets of frequent 3 item sets	
					 
		      for(int j=0;j<fact(ilength,2);j++) 
				   {
				        out.println("subsets of frequent 3 item set---->"+String.valueOf(b[j]));
					  	  for(int i=0;i<Aa2len[j];i++)
							 {    
							     out.println("<br>");
								 out.println(i+" "+String.valueOf(Aat[j][i]));
							     out.println("<br>");
							 }
				    	}
	      for(int j=0;j<fact(ilength,3);j++) 
		    	{
		        out.println("subsets of frequent 3 item set---->"+String.valueOf(c[j]));
			  	  for(int i=0;i<Aa3len[j];i++)
					 {    
					     out.println("<br>");
						 out.println(i+" "+String.valueOf(Aa3[j][i]));
					     out.println("<br>");
					 }
			  	  for(int i=0;i<Ab3len[j];i++)
				 {
			  		 out.println("<br>");
					 out.println(i+" "+String.valueOf(Ab3[j][i]));
				     out.println("<br>");
				 }
			}
		/*	for(int j=0;j<fact(ilength,3);j++) 
			{
			
				out.println("subsets of frequent 3 item set--->"+String.valueOf(c[j]));
				for(int i=0;i<Ab3len[j];i++)
					 {
						 out.println(i+" "+String.valueOf(Ab3[j][i]));
					     out.println("<br>");
					 }
			}*/
			
	      for(int j=0;j<fact(ilength,4);j++) 
	    	{
	        out.println("subsets of frequent 4 item set--->"+String.valueOf(d[j]));
		  	  for(int i=0;i<Ab4len[j];i++)
				 {    
		  		     out.println("<br>");    
				  	 out.println(i+" "+String.valueOf(Ab4[j][i]));
				     out.println("<br>");
				 }
		  	for(int i=0;i<Ac4len[j];i++)
			 {
		  		out.println("<br>");
				 out.println(i+" "+String.valueOf(Ac4[j][i]));
			     out.println("<br>");
			 }
	    	}
			 for(int j=0;j<fact(ilength,5);j++) 
		    	{
		        out.println("subsets of frequent 5 item set--->"+String.valueOf(e[j]));
			  	  for(int i=0;i<Ablen[j];i++)
					 {    
			  		     out.println("<br>");    
					  	 out.println(i+" "+String.valueOf(Ab[j][i]));
					     out.println("<br>");
					 }
			  	for(int i=0;i<Aclen[j];i++)
				 {
			  		out.println("<br>");
					 out.println(i+" "+String.valueOf(Ac[j][i]));
				     out.println("<br>");
				 }
			}
		/*	for(int j=0;j<fact(ilength,5);j++) 
			{
			
				out.println("subsets of frequent 5 item set"+String.valueOf(e[j]));
				out.println("<br>");
				for(int i=0;i<Aclen[j];i++)
				 {
			  		out.println("<br>");
					 out.println(i+" "+String.valueOf(Ac[j][i]));
				     out.println("<br>");
				 }
			}*/
					 
					 
//printing only common frequent item sets for 3 item set
		//-------> code for generating association rule for 3 frequent ite set		 
			//	out.println("all common subset of frequent item set 3<br>"); 
						//int length=Ab.length;
								//	 int p=0;
			/*	for(int level=0;level<fact(ilength,3);level++)
					{
								p=0; 
					 for(int i=0;i<3;i++)
							{
											
								  x=1;
							    for(int j=0;j<level;j++)
									{
										for(int k=0;k<NAa3len[j];k++)
											{
											if(Aa3[level][i][0]==NAa3[j][k][0])
											  {
												 x=0; 
											  }
											  }
											}
								           if(x==1)
										  { 
											  
											  NAa3[level][p][0]=Aa3[level][i][0];
											  p++;
									   	 }
									}
									     NAa3len[level]=p;
								}
									 
									 int prin=0;  
									for(int i=0;i<fact(ilength,3);i++)
										for(int j=0;j<NAa3len[i];j++)
									 {
										out.println(" "+String.valueOf(c[i]));
										 out.println(prin+" "+String.valueOf(NAa3[i][j]));
										 out.println("<br>");
										 prin++;
									 }
									 
		/*	out.println("all common subset of frequent item set 3<br>"); 
			//int length=Ab.length;
			 p=0;
			 for(int level=0;level<fact(ilength,3);level++)
				{
					p=0; 
				  for(int i=0;i<Ab3len[level];i++)
						{
								
							 x=1;
							for(int j=0;j<level;j++)
								{
									for(int k=0;k<NAb3len[j];k++)
									{
								       if(Ab3[level][i][0]==NAb3[j][k][0]&&Ab3[level][i][1]==NAb3[j][k][1])
								  {
									 x=0; 
								  }
								  }
								}
					           if(x==1)
							  { 
								  
								  NAb3[level][p][0]=Ab3[level][i][0];
								  NAb3[level][p][1]=Ab3[level][i][1];
					              p++;
							 }
							}
						     NAb3len[level]=p;
							}
						 
						 prin=0;  
						 for(int i=0;i<fact(ilength,3);i++)
							 for(int j=0;j<NAb3len[i];j++)
						 {
							out.println(" "+String.valueOf(c[i]));
							 out.println(prin+" "+String.valueOf(NAb3[i][j]));
							 out.println("<br>");
							 prin++;
						 }*/
						
						
						 
						 //applying triming functions for generation of association rules;
			           out.println("ASSOCIATION RULE FOR 2 frequet item sets <br> ");
			              for(int i=0;i<fact(ilength,2);i++)
			          {     
				      out.println("ASSOCIATION RULE FOR ITEM SET-->"+String.valueOf(b[i])+"<br>");
				       trimt(b[i],i);
				   
		          	 }
			 
			 
	
						 out.println("ASSOCIATION RULE FOR 3 frequet item sets <br> ");
						 for(int i=0;i<fact(ilength,3);i++)
						 {     
							   out.println("ASSOCIATION RULE FOR ITEM SET-->"+String.valueOf(c[i])+"<br>");
							    trim3(c[i],i);
							    trim4(c[i],i);
						 }
						// out.println("ASSOCIATION RULE FOR 3 frequet item sets<br> ");
						// for(int i=0;i<fact(ilength,3);i++)
						//	 out.println(Ab3len[i]);
						 
						/* for(int i=0;i<fact(ilength,3);i++)
						 {
							    trim4(c[i],i);
							   
						 }*/
					 out.println("ASSOCIATION RULE FOR 4 frequet item sets<br> ");
						 for(int i=0;i<fact(ilength,4);i++)
						 { 
							 out.println("ASSOCIATION RULE FOR ITEM SET-->"+String.valueOf(d[i])+"<br>");
							   trimfour(d[i],i);
							   trimfour3(d[i],i);
						 }
						 
						 out.println("ASSOCIATION RULE FOR 5 frequet item sets<br> ");
						 for(int i=0;i<fact(ilength,5);i++)
						 { 
							 out.println("ASSOCIATION RULE FOR ITEM SET-->"+String.valueOf(e[i])+"<br>");
							   trim(e[i],i);
							   trim1(e[i],i);
						 }
						// out.println("ASSOCIATION RULE FOR 5 frequet item sets<br> ");
					/*	for(int i=0;i<fact(ilength,5);i++)
						{
							   trim1(e[i],i);
						}*/
			// <----------- code for generating all association rules for 3 frequent item set			 
						 
						 
						 //length=Ab.length;
					  //    p=0;
					      //---------------->code that generates only common subsets which is wrong idea
					/*	 for(int level=0;level<fact(ilength,3);level++)
						 {
							 p=0; 
							for(int i=0;i<Ab3len[level];i++)
								{
								
								 x=1;
								for(int j=0;j<level;j++)
								{
									for(int k=0;k<NAb3len[j];k++)
									{
								       if(Ab3[level][i][0]==NAb3[j][k][0]&&Ab3[level][i][1]==NAb3[j][k][1])
								  {
									 x=0; 
								  }
								  }
								}
					           if(x==1)
							  { 
								  
								  NAb3[level][p][0]=Ab3[level][i][0];
								  NAb3[level][p][1]=Ab3[level][i][1];
					              p++;
							 }
							}
						     NAb3len[level]=p;
							}
						 
						 prin=0;  
						 for(int i=0;i<fact(ilength,3);i++)
							 for(int j=0;j<NAb3len[i];j++)
						 {
							out.println(" "+String.valueOf(c[i]));
							 out.println(prin+" "+String.valueOf(NAb3[i][j]));
							 out.println("<br>");
							 prin++;
						 }
						 */
						 // finding association rules
						// for(int i=0;i<fact(ilength,3);i++)
						 //  trim(c[i],i);
						//<----------------code that generates only common subsets which is wrong idea
						 
		//----------->code that finds all common subsets for 5 frequent itemse		
		 //printing only common frequent item sets for 5 item set
					//out.println("all common subset of frequent item set<br>"); 
					 //length=Ab.length;
					 //p=0;
				/* for(int level=0;level<fact(ilength,5);level++)
					 {
						 p=0; 
						for(int i=0;i<Ablen[level];i++)
							{
							
							 x=1;
							for(int j=0;j<level;j++)
							{
								for(int k=0;k<Ablen[j];k++)
								{
							       if(Ab[level][i][0]==NAb[j][k][0]&&Ab[level][i][1]==NAb[j][k][1])
							  {
								 x=0; 
							  }
							  }
							}
				           if(x==1)
						  { 
							  
							  NAb[level][p][0]=Ab[level][i][0];
							  NAb[level][p][1]=Ab[level][i][1];
				              p++;
						 }
						}
					     NAblen[level]=p;
							}
					 
					 prin=0;  
					 for(int i=0;i<fact(ilength,5);i++)
						 for(int j=0;j<NAblen[i];j++)
					 {
						out.println(" "+String.valueOf(e[i]));
						 out.println(prin+" "+String.valueOf(NAb[i][j]));
						 out.println("<br>");
						 prin++;
					 }
					 
					 
					 
					*/ //<-----------code that finds all common subsets for 5 frequent itemse	
					 
					// finding association rules
					
					 
					/* p=0;
					 for(int level=0;level<fact(ilength,5);level++)
					 {
						 p=0; 
						for(int i=0;i<Aclen[level];i++)
							{
							
							 x=1;
							for(int j=0;j<level;j++)
							{
								for(int k=0;k<NAclen[j];k++)
								{
							       if(Ac[level][i][0]==NAc[j][k][0]&&Ac[level][i][1]==NAc[j][k][1]&&Ac[level][i][2]==NAc[j][k][2])
							  {
								 x=0; 
							  }
							  }
							}
				           if(x==1)
						  { 
							  
							  NAc[level][p][0]=Ac[level][i][0];
							  NAc[level][p][1]=Ac[level][i][1];
							  NAc[level][p][2]=Ac[level][i][2];
				              p++;
						 }
						}
					     NAclen[level]=p;
							}
					 
					 prin=0;  
					 for(int i=0;i<fact(ilength,5);i++)
						 for(int j=0;j<NAclen[i];j++)
					 {
						out.println(" "+String.valueOf(e[i]));
						 out.println(prin+" "+String.valueOf(NAc[i][j]));
						 out.println("<br>");
						 prin++;
					 }*/
					 
	
	} 
					
	
	//code for finding most frequent association rules and display them into file
	//association rules for two frequent item sets
	
	public void trimt(char[] a1,int fset) throws SQLException, IOException
	{
   
	
		for(int j=0;j<Aa2len[fset];j++)
	    for(int i=0;i<a1.length;i++)
	    	flagt[j][i]=1;
		
		for(int i=0;i<Aa2len[fset];i++)
		{  
		for(int j=0;j<Aa2[fset][i].length;j++)
		{
		  for(int k=0;k<a1.length;k++)
				{
					if(Aat[fset][i][j]==a1[k])
					{
						flagt[i][k]=0;
					}
					
				}
		     
		     }
		}
		int rem;
		for(int i=0;i<Aa2len[fset];i++)
		{
		
			rem=0;
			for(int j=0;j<a1.length;j++)
			{
				
				if(flagt[i][j]==1)
				{
				remaint[fset][i][rem]=a1[j];
				rem++;
				}
			}
			
		}
		
		for(int i=0;i<Aa2len[fset];i++)
		{
			
		   double x=0.0;
		   x=(resultfull(Aat[fset][i],remaint[fset][i],1,1)/resultbottom(Aat[fset][i],1));
		   
		   double x1=0.0;
		   x1=(resultfull2(Aat[fset][i],remaint[fset][i],1,1)/resultbottom2(Aat[fset][i],1));
		   if(x>minconf && x1>minconf) 
		   {
		   out.println(String.valueOf(Aat[fset][i])+"-->"+String.valueOf(remaint[fset][i])+"------------------>"+x+"---->for cluster 1<br>");
		   out.println(String.valueOf(Aat[fset][i])+"-->"+String.valueOf(remaint[fset][i])+"------------------>"+x1+"---->for cluster 2<br>");
		  // out.println(charset(Aat[fset][i][0])+"-->"+charset(remaint[fset][i][0])+"------------------>"+x+"---->for cluster 1<br>");
		  //out.println(charset(Aat[fset][i][0])+"-->"+charset(remaint[fset][i][0])+"------------------>"+x1+"---->for cluster 2<br>");
		   if(resultbottom2(Aat[fset][i],1)!=0)
		   { writer.write(AAA+".If customer is buying ["+charset(Aat[fset][i][0])+"] item then he may also buy-->["+charset(remaint[fset][i][0])+"] with confidence ----->["+x+"]---->");
		   writer.newLine();
		   AAA++;
		   }
		   // if(resultbottom2(Aat[fset][i],1)!=0)
			//   writer.write(AAA+".If customer is buying ["+charset(Aat[fset][i][0])+"] item then he may also buy-->["+charset(remaint[fset][i][0])+"] with confidence ----->["+x1+"]---->for cluster 2");
		  // AAA++;
		   writer.newLine();
		   out.println("<br>");
		   }
		   
		   }
	}

	// get right side of associating rule
	public void trim3(char[] a1,int fset) throws SQLException, IOException
	{
   
	
		for(int j=0;j<Aa3len[fset];j++)
	    for(int i=0;i<a1.length;i++)
	    	flag3[j][i]=1;
		
		for(int i=0;i<Aa3len[fset];i++)
		{  
		for(int j=0;j<Aa3[fset][i].length;j++)
		{
		  for(int k=0;k<a1.length;k++)
				{
					if(Aa3[fset][i][j]==a1[k])
					{
						flag3[i][k]=0;
					}
					
				}
		     
		     }
		}
		int rem;
		for(int i=0;i<Aa3len[fset];i++)
		{
		
			rem=0;
			for(int j=0;j<a1.length;j++)
			{
				
				if(flag3[i][j]==1)
				{
				remain3[fset][i][rem]=a1[j];
				rem++;
				}
			}
			
		}
		for(int i=0;i<Aa3len[fset];i++)
		{
			
		   double x=0.0;
		   x=(resultfull(Aa3[fset][i],remain3[fset][i],1,2)/resultbottom(Aa3[fset][i],1));
		   
		   double x1=0.0;
		   x1=(resultfull2(Aa3[fset][i],remain3[fset][i],1,2)/resultbottom2(Aa3[fset][i],1));
		   if(x>minconf && x1>minconf) 
		   {
		 out.println(String.valueOf(Aa3[fset][i])+"-->"+String.valueOf(remain3[fset][i])+"------------------>"+x+"---->for cluster 1<br>");
		   out.println(String.valueOf(Aa3[fset][i])+"-->"+String.valueOf(remain3[fset][i])+"------------------>"+x1+"---->for cluster 2<br>");
		 //  out.println(charset(Aa3[fset][i][0])+"-->"+charset(remain3[fset][i][0])+"&"+charset(remain3[fset][i][1])+"------------------>"+x+"---->for cluster 1<br>");
		  // out.println(charset(Aa3[fset][i][0])+"-->"+charset(remain3[fset][i][0])+"&"+charset(remain3[fset][i][1])+"------------------>"+x1+"---->for cluster 2<br>");
		   if(resultbottom2(Aa3[fset][i],1)!=0)
		   { writer.write(AAA+".If a customer is buyiung ["+charset(Aa3[fset][i][0])+"] items then he may also buy -->["+charset(remain3[fset][i][0])+"&"+charset(remain3[fset][i][1])+"] with confidence --->["+x+"]---->");
		   AAA++;
		   writer.newLine();
		   }
		   //  if(resultbottom2(Aa3[fset][i],1)!=0)
		//	   writer.write(AAA+".If a customer is buyiung ["+charset(Aa3[fset][i][0])+"] items then he may also buy -->["+charset(remain3[fset][i][0])+"&"+charset(remain3[fset][i][1])+"] with confidence --->["+x1+"]---->for cluster 2");
		  // AAA++;
		   writer.newLine();
		   out.println("<br>");
		   }
		   
		   }
     
	}
	
	//which generates association rule for 3 frequent item sets
	public void trim4(char[] a1,int fset) throws SQLException, IOException
	{
	   for(int j=0;j<Ab3len[fset];j++)
	       for(int i=0;i<a1.length;i++)
	    	flag4[j][i]=1;
		
		for(int i=0;i<Ab3len[fset];i++)
		{  
		for(int j=0;j<Ab3[fset][i].length;j++)
		{
		  for(int k=0;k<a1.length;k++)
				{
					if(Ab3[fset][i][j]==a1[k])
					{
						flag4[i][k]=0;
					}
					
				}
		     
		     }
		}
		int rema;
		for(int i=0;i<Ab3len[fset];i++)
		{
			rema=0;
		
			for(int j=0;j<a1.length;j++)
			{
				
				if(flag4[i][j]==1)
				{
					remain4[fset][i][rema]=a1[j];
				    rema++;
				}
				
			}
		}	
		
		for(int i=0;i<Ab3len[fset];i++)
		{
			//out.println("working bfore double");
		 double y=0.0;
		 y=(resultfull(Ab3[fset][i],remain4[fset][i],2,1)/resultbottom(Ab3[fset][i],2));  
		 // out.println("working after double");
		 
		 double y1=0.0;
		 y1=(resultfull(Ab3[fset][i],remain4[fset][i],2,1)/resultbottom(Ab3[fset][i],2)); 
		 if(y>minconf && y1>minconf) 
		 {
		 out.println(" "+String.valueOf(Ab3[fset][i])+"-->"+String.valueOf(remain4[fset][i])+"------------------>"+y+"---> for cluster 1<br>");
		 out.println(" "+String.valueOf(Ab3[fset][i])+"-->"+String.valueOf(remain4[fset][i])+"------------------>"+y1+"---> for cluster 2<br>");
		// out.println(charset(Aa3[fset][i][0])+"&"+charset(Aa3[fset][i][1])+"-->"+charset(remain3[fset][i][0])+"------------------>"+y+"---->for cluster 1<br>");
		 //out.println(charset(Aa3[fset][i][0])+"&"+charset(Aa3[fset][i][1])+"-->"+charset(remain3[fset][i][0])+"------------------>"+y1+"---->for cluster 1<br>");
		 
		 if(resultbottom2(Ab3[fset][i],2)!=0)
		 {
			 writer.write(AAA+".If customer is buying ["+charset(Ab3[fset][i][0])+"&"+charset(Ab3[fset][i][1])+"] items he may also buy-->["+charset(remain4[fset][i][0])+"] with confidence ---->["+y+"]---> ");
		 
		 AAA++;
		 writer.newLine();
		 }
		 // if(resultbottom2(Ab3[fset][i],2)!=0)
		//	 writer.write(AAA+".If customer is buying ["+charset(Ab3[fset][i][0])+"&"+charset(Ab3[fset][i][1])+"] items he may also buy-->["+charset(remain4[fset][i][0])+"] with confidence ---->["+y1+"]---> for cluster 2");
		// AAA++;
		 writer.newLine();
		 out.println("<br>");
		 } 
		
		}
		out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
     
	}
					 
// geting association rule for four item set
	public void trimfour(char[] a1,int fset) throws SQLException, IOException
	{
		for(int j=0;j<Ab4len[fset];j++)
	    for(int i=0;i<a1.length;i++)
	    	flagf[j][i]=1;
		
		for(int i=0;i<Ab4len[fset];i++)
		{  
		for(int j=0;j<Ab4[fset][i].length;j++)
		{
		  for(int k=0;k<a1.length;k++)
				{
					if(Ab4[fset][i][j]==a1[k])
					{
						flagf[i][k]=0;
					}
					
				}
		     
		     }
		}
		int rem;
		for(int i=0;i<Ab4len[fset];i++)
		{
			rem=0;
		
			for(int j=0;j<a1.length;j++)
			{
				if(flagf[i][j]==1)
				{
				remainf[fset][i][rem]=a1[j];
				rem++;
				}
				
			}
			
		}
		
		for(int i=0;i<Ab4len[fset];i++)
		{
		   double x=0.0;
		   x=(resultfull(Ab4[fset][i],remainf[fset][i],2,2)/resultbottom(Ab4[fset][i],2));
		   double x1=0.0;
		   x1=(resultfull2(Ab4[fset][i],remainf[fset][i],2,2)/resultbottom2(Ab4[fset][i],2));
		   if(x>minconf && x1>minconf) 
		   {
		   out.println(" "+String.valueOf(Ab4[fset][i])+"-->"+String.valueOf(remainf[fset][i])+"----->"+x+"----> for cluster 1<br>");
		   out.println(" "+String.valueOf(Ab4[fset][i])+"-->"+String.valueOf(remainf[fset][i])+"----->"+x1+"----> for cluster 2<br>");
		   //out.println(" "+charset(Ab4[fset][i][0])+"&"+charset(Ab4[fset][i][1])+"-->"+charset(remainf[fset][i][0])+"&"+charset(remainf[fset][i][1])+"----->"+x+"----> for cluster 1<br>");
		   //out.println(" "+charset(Ab4[fset][i][0])+"&"+charset(Ab4[fset][i][1])+"-->"+charset(remainf[fset][i][0])+"&"+charset(remainf[fset][i][1])+"----->"+x1+"----> for cluster 2<br>");
		   if(resultbottom2(Ab4[fset][i],2)!=0)
		   {
		   writer.write(AAA+". If a customer is buying ["+charset(Ab4[fset][i][0])+"&"+charset(Ab4[fset][i][1])+"] items he may also buy-->["+charset(remainf[fset][i][0])+"&"+charset(remainf[fset][i][1])+"] items with confidence --->["+x+"]----> ");
		   AAA++;
		   writer.newLine();
		   }
		   //  if(resultbottom2(Ab4[fset][i],2)!=0)
			 //  writer.write(AAA+". If a customer is buying ["+charset(Ab4[fset][i][0])+"&"+charset(Ab4[fset][i][1])+"] items he may also buy-->["+charset(remainf[fset][i][0])+"&"+charset(remainf[fset][i][1])+"] items with confidence --->["+x1+"]----> for cluster 2");
		  // AAA++;
		   writer.newLine();
		   out.println("<br>");
		   }
		  
		   }
     
	}
				
	
// trim1 function for 3 item set
	
	public void trimfour3(char[] a1,int fset) throws SQLException, IOException
	{
		for(int j=0;j<Ac4len[fset];j++)
	    for(int i=0;i<a1.length;i++)
	    	flag1[j][i]=1;
		
		for(int i=0;i<Ac4len[fset];i++)
		{  
		for(int j=0;j<3;j++)
		{
		  for(int k=0;k<a1.length;k++)
				{  //out.println("<br>");
			       //out.println("comparing"+String.valueOf(NAc[fset][i][j])+"with"+String.valueOf(a1[k]));
					if(Ac4[fset][i][j]==a1[k])
					{
						flag1[i][k]=0;
					}
					
				}
		     
		     }
		}
		int rem;
		for(int i=0;i<Ac4len[fset];i++)
		{
			rem=0;
		
			for(int j=0;j<a1.length;j++)
			{
				if(flag1[i][j]==1)
				{
				remainf4[fset][i][rem]=a1[j];
				rem++;
				}
			}
		}	
		//out.println("--------------------------------------------------------------<br>");
		

		for(int i=0;i<Ac4len[fset];i++)
		{
		   double y=0.0;
		   y=(resultfull(Ac4[fset][i],remainf4[fset][i],3,1)/resultbottom(Ac4[fset][i],3));
		   double y1=0.0;
		   y1=(resultfull2(Ac4[fset][i],remainf4[fset][i],3,1)/resultbottom2(Ac4[fset][i],3));
		   if(y>minconf && y1>minconf) 
		   {
		   out.println(" "+String.valueOf(Ac4[fset][i])+"-->"+String.valueOf(remainf4[fset][i])+"------>"+y+"---->for cluster1<br>");
		   out.println(" "+String.valueOf(Ac4[fset][i])+"-->"+String.valueOf(remainf4[fset][i])+"------>"+y1+"---->for cluster2<br>");
		  // out.println(" "+charset(Ac4[fset][i][0])+"&"+charset(Ac4[fset][i][1])+"&"+charset(Ac4[fset][i][2])+"-->"+charset(remainf4[fset][i][0])+"------>"+y+"---->for cluster1<br>");
		  // out.println(" "+charset(Ac4[fset][i][0])+"&"+charset(Ac4[fset][i][1])+"&"+charset(Ac4[fset][i][2])+"-->"+charset(remainf4[fset][i][0])+"------>"+y1+"---->for cluster2<br>");
		   if(resultbottom2(Ac4[fset][i],3)!=0)
		   {
			   writer.write(AAA+".If customer is buys ["+charset(Ac4[fset][i][0])+"&"+charset(Ac4[fset][i][1])+"&"+charset(Ac4[fset][i][2])+"] items he may also buy -->["+charset(remainf4[fset][i][0])+"]items with confidence --->["+y+"]---->");
		   
		   AAA++;
		   writer.newLine();
		   }
		   //  if(resultbottom2(Ac4[fset][i],3)!=0)
			  // writer.write(AAA+".If customer is buys ["+charset(Ac4[fset][i][0])+"&"+charset(Ac4[fset][i][1])+"&"+charset(Ac4[fset][i][2])+"] items he may also buy -->["+charset(remainf4[fset][i][0])+"]items with confidence --->["+y1+"]---->for cluster2");
		 //  AAA++;
		   writer.newLine();
		   out.println("<br>");
		}
		   
		}
	}
					 
					

	
	// get right side of associating rule
	public void trim(char[] a1,int fset) throws SQLException, IOException
	{
		for(int j=0;j<Ablen[fset];j++)
	    for(int i=0;i<a1.length;i++)
	    	flag[j][i]=1;
		
		for(int i=0;i<Ablen[fset];i++)
		{  
		for(int j=0;j<Ab[fset][i].length;j++)
		{
		  for(int k=0;k<a1.length;k++)
				{
					if(Ab[fset][i][j]==a1[k])
					{
						flag[i][k]=0;
					}
					
				}
		     
		     }
		}
		int rem;
		for(int i=0;i<Ablen[fset];i++)
		{
			rem=0;
		
			for(int j=0;j<a1.length;j++)
			{
				if(flag[i][j]==1)
				{
				remain[fset][i][rem]=a1[j];
				rem++;
				}
				
			}
			
		}
		
		for(int i=0;i<Ablen[fset];i++)
		{
		   double x=0.0;
		   x=(resultfull(Ab[fset][i],remain[fset][i],2,3)/resultbottom(Ab[fset][i],2));
		   double x1=0.0;
		   x1=(resultfull(Ab[fset][i],remain[fset][i],2,3)/resultbottom(Ab[fset][i],2));
		   if(x>minconf && x1>minconf) 
		   {
		  out.println(" "+String.valueOf(Ab[fset][i])+"-->"+String.valueOf(remain[fset][i])+"----->"+x+"----> for cluster 1<br>");
		  out.println(" "+String.valueOf(Ab[fset][i])+"-->"+String.valueOf(remain[fset][i])+"----->"+x1+"----> for cluster 2<br>");
		 //  out.println(" "+charset(Ab[fset][i][0])+"&"+charset(Ab[fset][i][1])+"-->"+charset(remain[fset][i][0])+"&"+charset(remain[fset][i][1])+"----->"+x+"----> for cluster 1<br>");
		  // out.println(" "+charset(Ab[fset][i][0])+"&"+charset(Ab[fset][i][1])+"-->"+charset(remain[fset][i][0])+"&"+charset(remain[fset][i][1])+"----->"+x1+"----> for cluster 2<br>");
		   if(resultbottom2(Ab[fset][i],2)!=0)
		   {
			   
			   writer.write(AAA+".If a customer is buying ["+charset(Ab[fset][i][0])+"&"+charset(Ab[fset][i][1])+"]items he may also buy-->["+charset(remain[fset][i][0])+"&"+charset(remain[fset][i][1])+"&"+charset(remain[fset][i][2])+"]items with confidence----->["+x+"]----> ");
		       writer.newLine();
		       AAA++;
		   }
		//   if(resultbottom2(Ab[fset][i],2)!=0)
		  // writer.write(AAA+".If a customer is buying ["+charset(Ab[fset][i][0])+"&"+charset(Ab[fset][i][1])+"]items he may also buy-->["+charset(remain[fset][i][0])+"&"+charset(remain[fset][i][1])+"&"+charset(remain[fset][i][2])+"]items with confidence----->["+x1+"]----> for cluster 2");
		 //  AAA++;
		   writer.newLine();
		   out.println("<br>");
		}
		  
		}
     
	}
				
	
// trim1 function for 3 item set
	
	public void trim1(char[] a1,int fset) throws SQLException, IOException
	{
		for(int j=0;j<Aclen[fset];j++)
	    for(int i=0;i<a1.length;i++)
	    	flag1[j][i]=1;
		
		for(int i=0;i<Aclen[fset];i++)
		{  
		for(int j=0;j<3;j++)
		{
		  for(int k=0;k<a1.length;k++)
				{  //out.println("<br>");
			       //out.println("comparing"+String.valueOf(NAc[fset][i][j])+"with"+String.valueOf(a1[k]));
					if(Ac[fset][i][j]==a1[k])
					{
						flag1[i][k]=0;
					}
					
				}
		     
		     }
		}
		int rem;
		for(int i=0;i<Aclen[fset];i++)
		{
			rem=0;
		
			for(int j=0;j<a1.length;j++)
			{
				if(flag1[i][j]==1)
				{
				remain1[fset][i][rem]=a1[j];
				rem++;
				}
			}
		}	
		//out.println("--------------------------------------------------------------<br>");
		

		for(int i=0;i<Aclen[fset];i++)
		{
		   double y=0.0;
		   y=(resultfull(Ac[fset][i],remain1[fset][i],3,2)/resultbottom(Ac[fset][i],3));
		   double y1=0.0;
		   y1=(resultfull(Ac[fset][i],remain1[fset][i],3,2)/resultbottom(Ac[fset][i],3));
		   if(y>minconf && y1>minconf) 
		   {
		   out.println(" "+String.valueOf(Ac[fset][i])+"-->"+String.valueOf(remain1[fset][i])+"------>"+y+"---->for cluster1<br>");
		   out.println(" "+String.valueOf(Ac[fset][i])+"-->"+String.valueOf(remain1[fset][i])+"------>"+y1+"---->for cluster2<br>");
		  // out.println(" "+charset(Ac[fset][i][0])+"&"+charset(Ac[fset][i][1])+"&"+charset(Ac[fset][i][2])+"-->"+charset(remain1[fset][i][0])+"------>"+y+"---->for cluster1<br>");
		   //out.println(" "+charset(Ac[fset][i][0])+"&"+charset(Ac[fset][i][1])+"&"+charset(Ac[fset][i][2])+"-->"+charset(remain1[fset][i][0])+"------>"+y1+"---->for cluster2<br>");
		   if(resultbottom2(Ac[fset][i],3)!=0)
		   {
			   writer.write(AAA+".If a customer is buying ["+charset(Ac[fset][i][0])+"&"+charset(Ac[fset][i][1])+"&"+charset(Ac[fset][i][2])+"]items he may also buy-->["+charset(remain1[fset][i][0])+"&"+charset(remain1[fset][i][1])+"]items with confidence --->["+y+"]---->");
		   
		   AAA++;
		   writer.newLine();
		   
		   } // if(resultbottom2(Ac[fset][i],3)!=0)
			 //  writer.write(AAA+".If a customer is buying ["+charset(Ac[fset][i][0])+"&"+charset(Ac[fset][i][1])+"&"+charset(Ac[fset][i][2])+"]items he may also buy-->["+charset(remain1[fset][i][0])+"&"+charset(remain1[fset][i][1])+"]items with confidence --->["+y1+"]---->for cluster2");
		 //  AAA++;
		   writer.newLine();
		   out.println("<br>");
		}
		  
		}
		

	}
					
	

		

	
 public void   association(char[] ass,int level,int flength)  throws Exception
 {
   x=-1;
  for(int i=0;i<fact(flength,1);i++)
  {   x++;
	  Aa[level][x][0]=ass[i];
	  
  }
   asb=0;
  for(int i=0;i<fact(flength,1);i++)
  {
	  for(int j=i+1;j<fact(flength,1);j++)
	     {
		  if(Aa[level][i][0]!=Aa[level][j][0])
		  {
		  x++;
		 
		//  Aa[level][x][0]=Aa[level][i][0];
		 // Aa[level][x][1]=Aa[level][j][0];
		  Ab[level][asb][0]=Aa[level][i][0];
		  Ab[level][asb][1]=Aa[level][j][0];
		  asb++;
		  
		  }
	     }
	  Ablen[level]=asb;
	     }
  asc=0;
  for(int i=0;i<fact(flength,2);i++)
  {
	  for(int j=i+1;j<fact(flength,2);j++)
	  {
		  
		  if(Ab[level][i][0]==Ab[level][j][0]&&Ab[level][i][1]!=Ab[level][j][1])
		  {
		  x++;
		  //Aa[level][x][0]=Aa[level][i][0];
		  //Aa[level][x][1]=Aa[level][i][1];
          //Aa[level][x][2]=Aa[level][j][1];
          Ac[level][asc][0]=Ab[level][i][0];
		  Ac[level][asc][1]=Ab[level][i][1];
          Ac[level][asc][2]=Ab[level][j][1];
         asc++;
		  }
	  }
     Aclen[level]=asc;
		  
	 }
		
		
	
 }

 //association rule for 4 items
 
 public void   associationfour(char[] ass,int level,int flength)  throws Exception
 {
	 int asbf;
   x=-1;
  for(int i=0;i<fact(flength,1);i++)
  {   x++;
	  Aaf[level][x][0]=ass[i];
	  
  }
   Aaflen[level]=x;
   asbf=0;
  for(int i=0;i<fact(flength,1);i++)
  {
	  for(int j=i+1;j<fact(flength,1);j++)
	     {
		  if(Aaf[level][i][0]!=Aaf[level][j][0])
		  {
		  x++;
		 
		//  Aa[level][x][0]=Aa[level][i][0];
		 // Aa[level][x][1]=Aa[level][j][0];
		  Ab4[level][asbf][0]=Aaf[level][i][0];
		  Ab4[level][asbf][1]=Aaf[level][j][0];
		  asbf++;
		  
		  }
	     }
	  Ab4len[level]=asbf;
	     }
  int ascf=0;
  for(int i=0;i<fact(flength,2);i++)
  {
	  for(int j=i+1;j<fact(flength,2);j++)
	  {
		  
		  if(Ab4[level][i][0]==Ab4[level][j][0]&&Ab4[level][i][1]!=Ab4[level][j][1])
		  {
		  x++;
		  //Aa[level][x][0]=Aa[level][i][0];
		  //Aa[level][x][1]=Aa[level][i][1];
          //Aa[level][x][2]=Aa[level][j][1];
          Ac4[level][ascf][0]=Ab4[level][i][0];
		  Ac4[level][ascf][1]=Ab4[level][i][1];
          Ac4[level][ascf][2]=Ab4[level][j][1];
         ascf++;
		  }
	  }
     Ac4len[level]=ascf;
		  
	 }
		
}
	
 
 // association rule for 3 items
	
public void   association3(char[] ass,int level,int flength)  throws Exception
{
x=0;
for(int i=0;i<fact(flength,1);i++)
{  
	  Aa3[level][x][0]=ass[i];
	  x++;
}
Aa3len[level]=x;
asb=0;
for(int i=0;i<fact(flength,1);i++)
{
	  for(int j=i+1;j<fact(flength,1);j++)
	     {
		  if(Aa3[level][i][0]!=Aa3[level][j][0])
		  {
		  x++;
		 
		  //Aa3[level][x][0]=Aa[level][i][0];
		 // Aa[level][x][1]=Aa[level][j][0];
		  Ab3[level][asb][0]=Aa3[level][i][0];
		  Ab3[level][asb][1]=Aa3[level][j][0];
		  asb++;
		  
		  }
	     }
	 
}
Ab3len[level]=asb;
		
		
}
		



//association rule for two sets
public void   associationtwo(char[] ass,int level,int flength)  throws Exception
{
x=0;
for(int i=0;i<fact(flength,1);i++)
{  
  Aat[level][x][0]=ass[i];
  x++;
}
Aa2len[level]=x;

}
	//factorial function
	
	public int fact(int n,int c)
	{
		int result=1;int temp=1;
		for(int i=n;i>n-c;i--)
			result=result*i;
		for(int i=c;i>0;i--)
			temp=temp*i;
		
		return (result/temp);
		
	}
	
	
	
	
	
	
	
	
	
	// all database operatons;;;;;;;;;;;;;;;;;;;;;;
	public int result(char[] sr,int x)throws SQLException, ClassNotFoundException
	{
	   
	   
	     System.out.println("level of search"+x);
	    if(x==1)
		    {
	        str = "select count(*) from harish where "+sr[0]+"=1"; // are needed to be changed for k frequent item set
		    }
		
	    if(x==2)
	    {
        str = "select count(*) from harish where "+sr[0]+"=1 and "+sr[1]+"=1"; // are needed to be changed for k frequent item set
	    }
	    else if(x==3)
	    {
	    str = "select count(*) from harish where "+sr[0]+"=1 and "+sr[1]+"=1 and "+sr[2]+"=1 ";
	    }
	    else if(x==4)
	    {
	     str = "select count(*) from harish where "+sr[0]+"=1 and "+sr[1]+"=1 and "+sr[2]+"=1 and "+sr[3]+"=1";
	    }
	    else if(x==5)
	    {
	    str = "select count(*) from harish where "+sr[0]+"=1 and "+sr[1]+"=1 and "+sr[2]+"=1 and "+sr[3]+"=1 and "+sr[4]+"=1";
	    }
	    ps1= conn.prepareStatement(str);
	    ResultSet rs =  ps1.executeQuery(str);
	     int f = 0;
		while(rs.next())
	     f = rs.getInt(1);
		return f;
	   
		
		
	}
	
// finding support from cluster 2 
	public int result2(char[] sr,int x)throws SQLException, ClassNotFoundException
	{
	   
	   
	     System.out.println("level of search"+x);
	    if(x==1)
		    {
	        str = "select count(*) from harish1 where "+sr[0]+"=1"; // are needed to be changed for k frequent item set
		    }
		
	    if(x==2)
	    {
        str = "select count(*) from harish1 where "+sr[0]+"=1 and "+sr[1]+"=1"; // are needed to be changed for k frequent item set
	    }
	    else if(x==3)
	    {
	    str = "select count(*) from harish1 where "+sr[0]+"=1 and "+sr[1]+"=1 and "+sr[2]+"=1 ";
	    }
	    else if(x==4)
	    {
	     str = "select count(*) from harish1 where "+sr[0]+"=1 and "+sr[1]+"=1 and "+sr[2]+"=1 and "+sr[3]+"=1";
	    }
	    else if(x==5)
	    {
	    str = "select count(*) from harish1 where "+sr[0]+"=1 and "+sr[1]+"=1 and "+sr[2]+"=1 and "+sr[3]+"=1 and "+sr[4]+"=1";
	    }
	    ps1= conn.prepareStatement(str);
	    ResultSet rs =  ps1.executeQuery(str);
	     int f = 0;
		while(rs.next())
	     f = rs.getInt(1);
		return f;
	   
		
		
	}
	
	
	
public double resultfull(char[] leftside,char[] rightside,int xleft,int xright) throws SQLException
{

char[] temp = new char[100];
int x=0;
for(int i=0;i<xleft;i++)
{

temp[x]=leftside[i];
x++;
}
for(int i=0;i<xright;i++ )
{

temp[x]=rightside[i];
x++;
}
double left=0;
xleft=xleft+xright;
for(int i=0;i<xleft;i++)
	

if(xleft==1)
{

strAssleft = "select count(*) from harish where "+temp[0]+"=1"; // are needed to be changed for k frequent item set
}

else if(xleft==2)
{

	strAssleft = "select count(*) from harish where "+temp[0]+"=1 and "+temp[1]+"=1"; // are needed to be changed for k frequent item set
}
else if(xleft==3)
{
	
	try
	{
	strAssleft = "select count(*) from harish where "+temp[0]+" and "+temp[1]+" and  "+temp[2]+"=1";
	}
	catch(Exception e)
	{
	out.println(e);
	}
}
else if(xleft==4)
{
	
	strAssleft = "select count(*) from harish where "+temp[0]+"=1 and "+temp[1]+"=1 and "+temp[2]+"=1 and "+temp[3]+"=1";
}
else if(xleft==5)
{
	
	strAssleft = "select count(*) from harish where "+temp[0]+"=1 and "+temp[1]+"=1 and "+temp[2]+"=1 and "+temp[3]+"=1 and "+temp[4]+"=1";
}
else if(xleft==6)
{
	
	strAssleft = "select count(*) from harish where "+temp[0]+"=1 and "+temp[1]+"=1 and "+temp[2]+"=1 and "+temp[3]+"=1 and "+temp[4]+"=1 and "+temp[5]+"=1";
}
else
{
	out.println("single error result full");

}


psleft=conn.prepareStatement(strAssleft);
ResultSet rs1 = psleft.executeQuery();

while(rs1.next())
{
	left = rs1.getInt(1);
}

return left;

}




// code for result right
public int resultbottom(char[] leftside,int xleft) throws SQLException
{

int left=0;



//for right side association rules
if(xleft==1)
{

strAssright = "select count(*) from harish where "+leftside[0]+"=1" ; // are needed to be changed for k frequent item set
}

else if(xleft==2)
{

strAssright = "select count(*) from harish where "+leftside[0]+"=1 and "+leftside[1]+"=1"; // are needed to be changed for k frequent item set
}
else if(xleft==3)
{
	
	strAssright = "select count(*) from harish where "+leftside[0]+"=1 and "+leftside[1]+"=1 and "+leftside[2]+"=1 ";
}
else if(xleft==4)
{
	
	strAssright = "select count(*) from harish where "+leftside[0]+"=1 and "+leftside[1]+"=1 and "+leftside[2]+"=1 and "+leftside[3]+"=1";
}
else if(xleft==5)
{

	strAssright = "select count(*) from harish where "+leftside[0]+"=1 and "+leftside[1]+"=1 and "+leftside[2]+"=1 and "+leftside[3]+"=1 and "+leftside[4]+"=1";
}
else if(xleft==6)
{

	strAssright = "select count(*) from harish where "+leftside[0]+"=1 and "+leftside[1]+"=1 and "+leftside[2]+"=1 and "+leftside[3]+"=1 and "+leftside[4]+"=1 and "+leftside[5]+"=1";
}
else
{
	out.println("single error result bottom");
}
psright=conn.prepareStatement(strAssright);

ResultSet rs2 = psright.executeQuery();
while(rs2.next())
{
	left = rs2.getInt(1);
}

return left;

}










//data base confidence extraction for cluster two top

public double resultfull2(char[] leftside,char[] rightside,int xleft,int xright) throws SQLException
{

char[] temp = new char[100];
int x=0;
for(int i=0;i<xleft;i++)
{

temp[x]=leftside[i];
x++;
}
for(int i=0;i<xright;i++ )
{

temp[x]=rightside[i];
x++;
}
double left=0;
xleft=xleft+xright;
for(int i=0;i<xleft;i++)
	

if(xleft==1)
{

strAssleft = "select count(*) from harish1 where "+temp[0]+"=1"; // are needed to be changed for k frequent item set
}

else if(xleft==2)
{

	strAssleft = "select count(*) from harish1 where "+temp[0]+"=1 and "+temp[1]+"=1"; // are needed to be changed for k frequent item set
}
else if(xleft==3)
{
	
	try
	{
	strAssleft = "select count(*) from harish1 where "+temp[0]+" and "+temp[1]+" and  "+temp[2]+"=1";
	}
	catch(Exception e)
	{
	out.println(e);
	}
}
else if(xleft==4)
{
	
	strAssleft = "select count(*) from harish1 where "+temp[0]+"=1 and "+temp[1]+"=1 and "+temp[2]+"=1 and "+temp[3]+"=1";
}
else if(xleft==5)
{
	
	strAssleft = "select count(*) from harish1 where "+temp[0]+"=1 and "+temp[1]+"=1 and "+temp[2]+"=1 and "+temp[3]+"=1 and "+temp[4]+"=1";
}
else if(xleft==6)
{
	
	strAssleft = "select count(*) from harish1 where "+temp[0]+"=1 and "+temp[1]+"=1 and "+temp[2]+"=1 and "+temp[3]+"=1 and "+temp[4]+"=1 and "+temp[5]+"=1";
}
else
{
	out.println("single error result full");

}


psleft=conn.prepareStatement(strAssleft);
ResultSet rs1 = psleft.executeQuery();

while(rs1.next())
{
	left = rs1.getInt(1);
}

return left;

}








//data base confidence for cluster two for bottom


public int resultbottom2(char[] leftside,int xleft) throws SQLException
{

int left=0;



//for right side association rules
if(xleft==1)
{

strAssright = "select count(*) from harish1 where "+leftside[0]+"=1" ; // are needed to be changed for k frequent item set
}

else if(xleft==2)
{

strAssright = "select count(*) from harish1 where "+leftside[0]+"=1 and "+leftside[1]+"=1"; // are needed to be changed for k frequent item set
}
else if(xleft==3)
{
	
	strAssright = "select count(*) from harish1 where "+leftside[0]+"=1 and "+leftside[1]+"=1 and "+leftside[2]+"=1 ";
}
else if(xleft==4)
{
	
	strAssright = "select count(*) from harish1 where "+leftside[0]+"=1 and "+leftside[1]+"=1 and "+leftside[2]+"=1 and "+leftside[3]+"=1";
}
else if(xleft==5)
{

	strAssright = "select count(*) from harish1 where "+leftside[0]+"=1 and "+leftside[1]+"=1 and "+leftside[2]+"=1 and "+leftside[3]+"=1 and "+leftside[4]+"=1";
}
else if(xleft==6)
{

	strAssright = "select count(*) from harish1 where "+leftside[0]+"=1 and "+leftside[1]+"=1 and "+leftside[2]+"=1 and "+leftside[3]+"=1 and "+leftside[4]+"=1 and "+leftside[5]+"=1";
}
else
{
	out.println("single error result bottom");
}
psright=conn.prepareStatement(strAssright);

ResultSet rs2 = psright.executeQuery();
while(rs2.next())
{
	left = rs2.getInt(1);
}

return left;

}


public static String charset(char a)
{
	if(a=='a')
	  return "Egg";
	else if(a=='b')
		return "Milk";
	else if(a=='c')
		return "Butter";
	else if(a=='d')
		return "Bread";
	else if(a=='e')
		return "Chicken";
	else if(a=='f')
		return "Chocolate";
	else if(a=='g')
		return "Jam";
	else if(a=='h')
		return "Oil";
	
	else 
		return "NULL";
	
	
}
}
