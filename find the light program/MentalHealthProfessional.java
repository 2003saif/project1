import java.io.Serializable;

public abstract class MentalHealthProfessional implements Serializable{
	 protected String name;
	 protected String specialization;
	 protected double salary;

	 public MentalHealthProfessional(String name,String  specialization,double salary) {
	     this.name = name;
	    this.specialization=specialization;
	     this.salary=salary;
	      
	    
	 }
	 
	 public boolean equals(Object obj) {  
		    if(obj instanceof MentalHealthProfessional) {  
		        if(this.name.equalsIgnoreCase(((MentalHealthProfessional) obj).name))
		                return true; 
		}
		    return false;  
	 }

	 public abstract double bonus();

	@Override
	public String toString() {
		return "name: " + name +",  "+ "specialization: "+specialization +",  salary:"+salary;
	}
	 
}
