import java.io.Serializable;

public class Psychiatrist extends MentalHealthProfessional implements Serializable{
	
	private String prescription;
	
	public Psychiatrist(String name,String SPECIALIZATION,double salary,String prescription) {
	        super(name,SPECIALIZATION,salary);
	        this.prescription=prescription;	       
	    }

	@Override
	public double bonus() {
	  return salary*0.5;
	}
		

public String toString() {
	return super.toString() + " , prescription:"+prescription;
}



}
