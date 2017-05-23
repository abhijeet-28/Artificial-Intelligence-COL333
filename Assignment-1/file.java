import java.util.*;
import java.io.*;


public class file
{

	public static int size1;
	public static int size2;
	public static Map<Integer,Integer> nodes1;
	public static Map<Integer,Integer>nodes2;


	public static void main(String[] args)
	{

		 int varcount=0;
			long clausecount=0;
		String filename=args[0];

		try
		{
			
			BufferedReader scan=new BufferedReader(new FileReader(filename+".graphs"));
			String str;
			ArrayList<edge> big=new ArrayList<edge>();
			ArrayList<edge> small=new ArrayList<edge>();

			

			Map<Integer,Integer> nodes1=new HashMap<Integer,Integer>();
			Map<Integer,Integer>nodes2=new HashMap<Integer,Integer>();


			Map<Integer,Integer>smallin=new HashMap<Integer,Integer>();
			Map<Integer,Integer>smallout=new HashMap<Integer,Integer>();

			Map<Integer,Integer>bigin=new HashMap<Integer,Integer>();
			Map<Integer,Integer>bigout=new HashMap<Integer,Integer>();



			int maxnode=0;
			int cn=1;
			while((str=scan.readLine())!=null && str.length()!=0) 
			{
				//System.out.println(str);
				String[] nodes=str.split(" ");
				int x=Integer.parseInt(nodes[0]);
				int y=Integer.parseInt(nodes[1]);
				maxnode=Math.max(maxnode,x);
				maxnode=Math.max(maxnode,y);
				if(x==0 && y==0) break;
				
				if(nodes1.containsKey(x)==false)
				{
					nodes1.put(x,cn);
					cn++;
				}
				if(nodes1.containsKey(y)==false)
				{
					nodes1.put(y,cn);
					cn++;
				}
				int in1=nodes1.get(x);
				int in2=nodes1.get(y);
				big.add(new edge(in1,in2));
				
				if(bigout.containsKey(in1)==true)
				{
					bigout.put(in1,bigout.get(in1)+1);
				}
				else
				{
					bigout.put(in1,1);

				}
				if(bigin.containsKey(in2))
				{
					bigin.put(in2,bigin.get(in2)+1);
				}
				else
				{
					bigin.put(in2,1);
				}

				//System.out.println(big.size());

			}
			cn=1;
			while((str=scan.readLine())!=null && str.length()!=0) 
			{
				//System.out.println(str);
				String[] nodes=str.split(" ");
				int x=Integer.parseInt(nodes[0]);
				int y=Integer.parseInt(nodes[1]);
			
				
				

				if(nodes2.containsKey(x)==false)
				{
					nodes2.put(x,cn);
					cn++;
				}
				if(nodes2.containsKey(y)==false)
				{
					nodes2.put(y,cn);
					cn++;
				}
				int int1=nodes2.get(x);
				int int2=nodes2.get(y);
				small.add(new edge(int1,int2));
				if(smallout.containsKey(int1))
				{
					smallout.put(int1,smallout.get(int1)+1);
				}
				else
				{

					smallout.put(int1,1);
				}
				if(smallin.containsKey(int2))
				{
					smallin.put(int2,smallin.get(int2)+1);
				}
				else
				{
					smallin.put(int2,1);
				}
				

			}

			Map<Integer,Integer>degrees=new HashMap<Integer,Integer>();



			
	
			Collection<Integer> c1=nodes1.values();
			//for(Integer cc:c1) System.out.println(cc);

			//	System.out.println();
			Collection<Integer> c2=nodes2.values();
			//for(Integer cc:c2) System.out.println(cc);
			size1=c1.size();
			size2=c2.size();
			
		





int i,j;
ArrayList<Integer>possible=new ArrayList<Integer>();
for(i=1;i<=size2;i++)
{
	int count=0;
	int indeg1,indeg2,outdeg1,outdeg2;
	if(smallin.containsKey(i)==false) indeg1=0;
	else indeg1=smallin.get(i);
	if(smallout.containsKey(i)==false) outdeg1=0;
	else outdeg1=smallout.get(i);
	for(j=1;j<=size1;j++)
	{
		if(bigin.containsKey(j)==false) indeg2=0;
		else indeg2=bigin.get(j);
		if(bigout.containsKey(j)==false) outdeg2=0;
		else outdeg2=bigout.get(j);
		if(indeg1>indeg2 || outdeg1>outdeg2)
		{
			int ind=(i-1)*size1+j;
			degrees.put(ind,0);
		}
		else
		{
			count++;
		}
	}
	possible.add(count);
}


// for(int kk:degrees.keySet())
// {
// 	System.out.println(kk);
// }

Writer writer = null;

try {
    writer = new BufferedWriter(new OutputStreamWriter(
          new FileOutputStream(filename+".satinput"), "utf-8"));
    writer.write("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    
   
} catch (IOException ex) {
  // report
} 









		ArrayList<Integer> smalllinks=new ArrayList<Integer>();
			int ss=size2*size2;
			for(i=0;i<ss;i++)
			{
				smalllinks.add(0);
			}
			for(edge e: small)
			{
				int index=(e.origin-1)*size2+e.des-1;
				smalllinks.set(index,1);
			}



			
			ArrayList<Integer> links=new ArrayList<Integer>();
			int maxsize=size1*size1;
			for(i=0;i<maxsize;i++)
			{
				links.add(0);
			}
			for(edge e: big)
			{
				int index=(e.origin-1)*size1+e.des-1;
				links.set(index,1);
			}
			int l=size1*size2;
			// for(i=0;i<maxsize;i++)
			// {
			// 	int n=l+i+1;
			// 	if(links.get(i)==1)
			// 	{
					
			// 		writer.write(n+" 0"+"\n");

			// 		clausecount++;
			// 	}
			// 	else
			// 	{
			// 		writer.write("-"+n+" 0"+"\n");
			// 		clausecount++;	
			// 	}
			// }
			
			//adding constraints




			//System.out.println(c1.size()+" "+c2.size());
			
			for(i=0;i<size2;i++)
			{
				for(j=1;j<=size1;j++)
				{
					int indexx=i*size1+j;
					if(degrees.containsKey(indexx)==false)
					writer.write(indexx+" ");

				}

				writer.write("0"+"\n");
				clausecount++;
			}
			// for(i=0;i<size2;i++)
			// {
			// 	for(j=i;j<=size1;j++)
			// 	{
			// 		if(i==j) continue;
			// 		int y=i*size1+j;
			// 		writer.write("-"+y+" -"+(y+j)+" 0"+"\n");
			// 		clausecount++;

					
			// 	}
			// }
			int p,q;
			for(i=0;i<size2;i++)
			{
				int st=i*size1+1;
				int end=st+size1;
				for(p=st;p<end;p++)
				{
					if(degrees.containsKey(p)==true)
					{
						continue;
					}
					for(q=p+1;q<end;q++)
					{
						if(degrees.containsKey(q)==true) continue;
						writer.write("-"+p+" -"+q+" 0"+"\n");
				 		clausecount++;
					}
				}
			}
			int tot=size1*size2;
			for(i=1;i<=tot;i++)
			{
				if(degrees.containsKey(i)==true)
					{
						continue;
					}
				for(j=i+size1;j<=tot;j+=size1)
				{
					if(degrees.containsKey(j)==true) continue;
					writer.write("-"+i+" -"+j+" 0"+"\n");
					clausecount++;
				}
			}
			
			// for(Integer key: mapper.keySet())
			// {
			// 	edge ee=mapper.get(key);
			// 	int or=ee.origin;
			// 	int des=ee.des;
			// 	int start1=(or-1)*size1+1;
			// 	int start2=(des-1)*size1+1;
			// 	int end1=start1+size1;
			// 	int end2=start2+size1;

			// 	writer.write(key+" 0"+"\n");
			// 	clausecount++;
			// 	int numcode1=size1*size2;
			// 	int strt=numcode1+1;
			// 	for(i=start1;i<end1;i++)
			// 	{
					

			// 		for(j=start2;j<end2;j++)
			// 		{
						
						
						
			// 			writer.write("-"+i+" "+"-"+j+" "+"-"+key+" "+strt+" 0"+"\n");
			// 			strt++;
			// 			clausecount++;
			// 		}
			// 	}
			// }




			int sr=size1*size2+size1*size1+1;
			int o;
			int number=0;
			int nm=size1*size2+1;

			for(o=0;o<size2;o++)
			{

				for(p=0;p<size2;p++)
				{

						
				if(o==p)
				{
					sr++;
					number++;
					continue;
				}		
			 	int start1=o*size1+1;
			 	int start2=p*size1+1;
				int end1=start1+size1;
				int end2=start2+size1;

				
				
			
				int c=0;
				for(i=start1;i<end1;i++)
				{
					if(degrees.containsKey(i)==true)
					{
						c+=size1;
						continue;
					}

					for(j=start2;j<end2;j++)
					{
						if(degrees.containsKey(j)==true)
						{
							c++; continue;
						}
						
						if(i%size1==j%size1) { c++; continue;}
						if(smalllinks.get(number)==0)
						{
							if(links.get(c)==1) {
							writer.write("-"+i+" "+"-"+j+" 0"+"\n"); clausecount++;}
						}
						else
						{
							if(links.get(c)==0){
							writer.write("-"+i+" "+"-"+j+" 0"+"\n"); clausecount++;}
						}
						
						
						c++;
					}
				}



				
					sr++;
				number++;

				}
			}



			varcount=size1*size2;
			//System.out.println(varcount);
			writer.close();
			RandomAccessFile f=new RandomAccessFile(new File(filename+".satinput"),"rw");
			f.seek(0);
			String firstline="p cnf "+Integer.toString(varcount)+" " +Long.toString(clausecount)+"\n";
			f.write(firstline.getBytes());
			f.close();



Writer writer2 = null;

try {
    writer2 = new BufferedWriter(new OutputStreamWriter(
          new FileOutputStream("size.txt"), "utf-8"));
    writer2.write(Integer.toString(size1));
    writer2.write("\n");
    writer2.write(Integer.toString(size2));
     writer2.write("\n");


    for(Integer key:nodes1.keySet())
    {
    	writer2.write(key+" "+nodes1.get(key)+"\n");
    }
    writer2.write("0"+"\n");

    for(Integer key:nodes2.keySet())
    {
    	writer2.write(key+" "+nodes2.get(key)+"\n");
    }
    

   
} catch (IOException ex) {
  // report
} 
finally {
   try {writer2.close();} catch (Exception ex) {/*ignore*/}
}



		}
		catch(IOException e)
		{
			System.out.println("Bingo");
		}
	}
}
class edge
{
	public int origin;
	public int des;
	public edge(int edge,int des)
	{
		this.origin=edge;
		this.des=des;
	}

}