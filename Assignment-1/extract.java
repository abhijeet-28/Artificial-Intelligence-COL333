import java.util.*;
import java.io.*;

public class extract
{
	public static void main(String[] args)
	{
		String name=args[0];
		try{
		BufferedReader sc=new BufferedReader(new FileReader("size.txt"));
		String s1=sc.readLine();
		String s2=sc.readLine();
		int si1=Integer.parseInt(s1);
		int si2=Integer.parseInt(s2);
		int si=si1*si2;

		int i,j;

		String str;
		Map<Integer,Integer> nodes1=new HashMap<Integer,Integer>();
		Map<Integer,Integer>nodes2=new HashMap<Integer,Integer>();
		while((str=sc.readLine())!=null && str.length()!=1) 
		{
			
			String[] nums=str.split(" ");
			int x1=Integer.parseInt(nums[0]);
			int x2=Integer.parseInt(nums[1]);
			nodes1.put(x2,x1);


		}


		while((str=sc.readLine())!=null && str.length()!=0) 
		{
			
			String[] nums=str.split(" ");
			int x1=Integer.parseInt(nums[0]);
			int x2=Integer.parseInt(nums[1]);
			nodes2.put(x2,x1);


		}
		//System.out.println(nodes1.size());
		//System.out.println(nodes2.size());

		Scanner scan=new Scanner(new File(name+".satoutput"));
		String st=scan.nextLine();


		int count1=1,count2=1;



		Writer writer = null;

try {
    writer = new BufferedWriter(new OutputStreamWriter(
          new FileOutputStream(name+".mapping"), "utf-8"));
   
} catch (IOException ex) {
  // report
} 

if(st.equals("UNSAT"))
		{
			writer.write("0");
		}
		else
		{
		for(i=1;i<=si2;i++)
		{
			for(j=1;j<=si1;j++)
			{
				if(scan.hasNext()){
				int c=scan.nextInt();
				if(c>0)
				{
					//System.out.println(i+" "+j);
					writer.write(nodes2.get(i)+" "+nodes1.get(j)+"\n");
				}
			}
				
			}

		}
	}
		writer.close();
	}
	catch(IOException e)
	{
		System.out.println("Oops error");
	}

	}

}