/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood_donation_system;

/**
 *
 * @author egypt2
 */
public class Donor {
   private String Name, BloodType,gender,phNo,City,Hospital;
   private int age,HeartRate,Hemoglobin,BloodPressure,BloodPressure2,Noodbags;
   private Double Temperature, weight,ID ;
   private boolean Operation,virusC,virusB,AIDS,Syphilis,states;
   public Donor (Double ID,String Name,String BloodType,String Hospital,int Noodbags)
   {
        this.ID=ID;
        this.Name=Name;
        this.BloodType=BloodType;
        this.Hospital=Hospital;
        this.Noodbags=Noodbags;

   }
   public Donor (Double ID,String Name,String BloodType,String City,String Hospital,int Noodbags,String phno, boolean states)
   {
        this.ID=ID;
        this.Name=Name;
        this.BloodType=BloodType;
        this.City=City;
        this.Hospital=Hospital;
        this.Noodbags=Noodbags;
        this.phNo=phno;
        this.states=states;
   }
   public Donor (String Name,String BloodType,String gender,String phNo,String City,String Hospital,int age,int HeartRate,int Hemoglobin,int BloodPressure,int BloodPressure2,Double Temperature,Double ID, Double weight,boolean Operation )
   {
   this.Name=Name;
   this.BloodType=BloodType;
   this.gender=gender;
   this.phNo=phNo;
   this.City=City;
   this.Hospital=Hospital;
   this.age=age;
   this.HeartRate=HeartRate;
   this.Hemoglobin=Hemoglobin;
   this.BloodPressure=BloodPressure;
   this.Temperature=Temperature;
   this.weight=weight;
   this.Operation=Operation;
   this.BloodPressure2=BloodPressure2;
   this.ID=ID;
   }
      public Double getID ()
     {
       return this.ID;     
     }
    public String getUserName ()
     {
       return this.Name;     
     }
    
    public String getCity ()
     {
       return this.City;     
     }
    public String getHospital ()
     {
       return this.Hospital;     
     }
    public String getBloodType ()
     {
       return this.BloodType;     
     }
    public int noofbags ()
     {
       return this.Noodbags;     
     }
    public String PhoneNum ()
     {
       return this.phNo;     
     }
    public boolean getStates ()
     {
       return this.states;     
     }
}
