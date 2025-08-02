import java.io.Serializable;

public class Therapist extends MentalHealthProfessional implements Serializable{
	private String behavior;
	
	 public Therapist(String name,String SPECIALIZATION,double salary,String behavior) {
	     super(name, SPECIALIZATION,salary);
	     this.behavior=behavior;
	     
	 }
	 
	 

	@Override
	 public double bonus() {
		return salary*0.05;
		}
	 
	 public String toString() {
			return super.toString() + " , behavior:"+behavior;
		}
}

