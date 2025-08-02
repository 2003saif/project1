import java.io.Serializable;

public class Psychologist extends MentalHealthProfessional implements Serializable{
	private String phd;
	
	public Psychologist(String name,String SPECIALIZATION,double salary,String phd) {
		   super(name,SPECIALIZATION,salary);
		   this.phd=phd;
		}

	@Override
	public double bonus() {
	  return salary*0.1;
	}
	
		
		public String toString() {
			return super.toString() + " , phd in:"+phd;
		}
}
