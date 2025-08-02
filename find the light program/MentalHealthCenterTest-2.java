import java.util.Scanner;
import java.io.*;
public class MentalHealthCenterTest{

	public static void main(String[] args) {
		MentalHealthCenter s= new MentalHealthCenter("find the light");
		
		
		Scanner input = new Scanner (System.in);
		
		System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤find the light❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
		System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤feel the light❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
		System.out.println("");
		System.out.println("Welcome to the MentalHealthCenter program,we are here to help you to find happiness and acceptance,what do you need today? (Enter your menu option)");
		System.out.println("");
		System.out.println("1. Add professional");
		System.out.println("2. update professional specialization");
		System.out.println("3. Remove professional");
		System.out.println("4. Display all professionals");
		System.out.println("5. Exit");
		System.out.println("");
		System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤hunt the light❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
		System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤be   the light❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
		System.out.println("yoir choice is:");
		
		int num = input.nextInt();
		
		do {
			if(num == 1) {
				System.out.println("is this professional a Therapist or Psychiatrist or Psychologist? (choose 1 or 2 or 3 , respectivly)");
				int num2 = input.nextInt();
				if(num2 == 1) {
					System.out.println("Please Enter name, specilazaion, Salary, behavior: ");
					s.addProfessional(new Therapist(input.next() ,input.next(),input.nextDouble() , input.next()));
				}
				else if (num2 == 2) {
					System.out.println("Please Enter name, specilazaion, Salary, prescription: ");
					s.addProfessional(new Psychiatrist(input.next() ,input.next(),input.nextDouble(),input.next()));
				}
				else if (num2 == 3) {
					System.out.println("Please Enter name, specilazaion, Salary, phd: ");
					
					s.addProfessional(new Psychologist(input.next() ,input.next(),input.nextDouble(),input.next() ));
				}
				else {
					System.out.println("Wrong input");
				}
				
			}
			else if (num == 2) {
				System.out.println("Enter the name and the specialization of the professional you want to update: ");
				s.updateSpecialization(input.next(),input.next());
			}
			else if (num == 3) {
				System.out.println("is this professional a Therapist or Psychiatrist or Psychologist? (choose 1 or 2 or 3 , respectivly)");
				int num3 = input.nextInt();
				if(num3 == 1) {
					System.out.println("Please Enter name, specilazaion, Salary, behavior: ");
					try {
						s.removeProfessional(new Therapist(input.next() ,input.next(),input.nextDouble(),input.next()));
					} catch (ProfessionalNotFoundException e) {						
						e.printStackTrace();
					}
				}
				else if (num3 == 2) {
					System.out.println("Please Enter name, specilazaion, Salary, prescription: ");
					try {
						s.removeProfessional(new Psychiatrist(input.next() ,input.next(),input.nextDouble(),input.next()));
					} catch (ProfessionalNotFoundException e) {
						e.printStackTrace();
					}
				}
				else if (num3 == 3) {
					System.out.println("Please Enter name, specilazaion, Salary, phd: ");
					try {
						s.removeProfessional(new Psychologist(input.next() ,input.next(),input.nextDouble(), input.next()));
					} catch (ProfessionalNotFoundException e) {
						e.printStackTrace();
					}
				}
				else {
					System.out.println("Wrong input");
				}
			}
			else if (num == 4) {
				System.out.println(s.toString());
			}
			else {
				System.out.println("Wrong input try again.");
			}
			
			System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤find the light❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
			System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤feel the light❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
			System.out.println("");
			System.out.println("Welcome to the MentalHealthCenter(find the light) program,we are here to help you to find happiness and acceptance,what do you need today? (Enter your menu option)");
			System.out.println("1. Add professional");
			System.out.println("2. update professional specialization");
			System.out.println("3. Remove professional");
			System.out.println("4. Display all professionals");
			System.out.println("5. Exit");
			System.out.println("");
			System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤hunt the light❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
			System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤be   the light❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
			System.out.println("yoir choice is: ");
			num = input.nextInt();
			
			
		  }while(num != 5);
		
		System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤find the light❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
		System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤feel the light❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
		System.out.println("");
		System.out.println("Remember: you are allowed to feel messed up and inside out, it doesn't mean you're defective , it means you're human.  Goodbye ❤");
		System.out.println("");
		System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤hunt the light❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
		System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤be   the light❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
		
		

		s.addProfessional(new Therapist(   "DR.Reem" ,    "PanicAttacks",11000,"conflit"));
		s.addProfessional(new Psychiatrist("DR.Sami" , "ChildhoodTrauma" ,19500,"Antidepressant"));
		s.addProfessional(new Psychologist("DR.Sara" , "SexualOrientation ",15000,"SexualOrientation & gender identity"));
		//s.addProfessional(new Therapist("DR.Abeer"   ,"Relationships",9500));
		//System.out.println(s.toString());
	    // s.removeProfessional(new Psychiatrist("DR.Abdullah" ,"Addictions" ,20000));
		//System.out.println(s.toString());
		//Therapist a= new Therapist("DR.Abeer"   ,"Relationships",9500);
		// s.updateSpecialization(a.name,"Relationships & communication");
		//System.out.println(s.toString());
		// System.out.println("THE TOTAL BONUS: "+s.getTotalBonus());
		// System.out.println("THE AVERAGE BONUS: "+s.getAverageBonus());
		
		try {
            File f = new File("MentalHealthCenter.dat");
            FileOutputStream FS = new FileOutputStream(f);
            ObjectOutputStream OS = new ObjectOutputStream(FS);
            OS.writeObject(s); 
            FS.close();
            OS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		try {
			
			
			process("MentalHealthCenter.dat", "Output.txt");
		}catch (FileNotFoundException e) {
			System.err.println(e);
		}catch (ClassNotFoundException e) {
			System.err.println(e);
		}catch(IOException e) {
			System.err.println(e);
		}
	  }
        
      
   


	public static void process(String src, String dest)throws FileNotFoundException, IOException , ClassNotFoundException{
		
		ObjectInputStream ois = null;
		PrintWriter pw = null;
		
		
		
		try {
			ois = new ObjectInputStream(new FileInputStream(src));
			
			pw = new PrintWriter(dest);
			
			
		
				MentalHealthCenter M = (MentalHealthCenter) ois.readObject();
				
					pw.println(M);
					
			
			
		}
		catch (EOFException e) {
			
	}finally {
			if(ois != null)
				ois.close();
			if(pw != null)
				pw.close();
		}
		
		
	}
}
