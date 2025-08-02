import java.io.*;

public class MentalHealthCenter implements Serializable {
	 private String name;
	 private MentalHealthProfessional[] professionals;
	 private int count;

		 public MentalHealthCenter(String name) {
		     this.name = name;
		     this.professionals = new MentalHealthProfessional[20];
		     count=0;
		 } 

		 public boolean addProfessional(MentalHealthProfessional professional) {
			 if (professionals.length==count) {
				 throw new IllegalStateException("Cannot add professional. The MentalHealthCenter is full."); // unchecked				
			 }
			 else if(professional.salary < 9000 || professional.salary > 30000 )
				 throw new IllegalStateException("Salary is not within the appropriate range");
			 
			 for (int i =0 ; i <count; i++) 
					if (professionals[i].equals(professional))
						return false;			 
		     professionals[count++] = professional;
		     return true;		     
		 }
		
		 public int searchProfessional(MentalHealthProfessional m) throws ProfessionalNotFoundException {  // checked exception
		        for (int i = 0; i < count; i++) {
		            if (professionals[i].equals(m)) {    
		                return i;
		            }
		        }
		        throw new ProfessionalNotFoundException("Professional not found.");
		    }

		 public boolean removeProfessional(MentalHealthProfessional m) throws ProfessionalNotFoundException {   // checked exception
			 int index= searchProfessional(m);
				if (index==-1) {
					throw new ProfessionalNotFoundException("Professional not found.");					
					}
							
					 professionals[index]=professionals[count-1];
					 professionals[count-1]=null;
					 count--;
					 return true;
				
		 }
		 
		 public boolean updateSpecialization(String professionalName, String newSpecialization) {
		        for (int i = 0; i < count; i++) {
		            if (professionals[i].name.equalsIgnoreCase(professionalName)) {
		                professionals[i].specialization = newSpecialization;
		                return true;
		            }
		        }
		        return false;
		    }
		 public double getTotalBonus() {
		        double total = 0;

		        for (int i = 0; i < count; i++) 
		          total +=professionals[i].bonus();
		        
		        return total;
		    }
		
		 public double getAverageBonus() {
		        double total = 0;
		        for (int i = 0; i < count; i++) {
		          total += professionals[i].bonus(); 
		        }
		        return total/count;
		    }  
		 
		@Override
		public String toString() {
			
			String s = name+":"+"("+count+")" + "\n ";			
			 for (int i=0; i<count;i++) {
				 s+="\n"+professionals[i].toString()+"\n";
			 }
			 return s;
			
		}
		
		 public void  savetofile(String file) throws IOException{  
		        File f=new File(file);;  
		        FileOutputStream s1=new FileOutputStream(f);  
		        ObjectOutputStream s2= new ObjectOutputStream(s1);  
		        for(int i=0;i<count;i++)  
		        s2.writeObject(professionals[i]);  
		          
		        s1.close();  
		        s2.close();  
		    }  
		      
		    //Write-->output  
//		public void savetofile(String name,String file) throws IOException{  
//		    File f=new File(file);;  
//		    FileOutputStream s1=new FileOutputStream(f);  
//		    ObjectOutputStream s2= new ObjectOutputStream(s1);  
//		    for(int i=0;i<count;i++)  
//		        if(professionals[i] instanceof FullTime && professionals[i].getName().equalsIgnoreCase(name))  
//		            s2.writeObject(professionals[i]);  
//		      
//		    s1.close();  
//		    s2.close();  
//		  
//		    }  
		
		 public void LoadFromfile(String filename,MentalHealthProfessional[] arr) throws IOException{  
			    int index=0;  
			    File f=new File(filename);  
			    FileInputStream read= new FileInputStream(f);  
			    ObjectInputStream readObject=new ObjectInputStream(read);  
			    try {  
			    while(true) {  
			    try {  
			    MentalHealthProfessional E= (MentalHealthProfessional) readObject.readObject();  
			      
			        arr[index++]= E; 
			      
			    }catch(ClassNotFoundException e) {  
			        System.out.println(e);  
			      
			    }}  
			      
			}catch(EOFException e) {  
			    System.out.println("End of read");  
			    read.close();  
			    readObject.close();  
			}  
			      
			}  
		
		 
		 

	
}