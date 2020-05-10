/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood_donation_system;

/**
 *
 * @author Abdelrahman Hossam
 */
class Request {
    private String Hospital, BloodType;
    private int NoOfBags;
    private Double ID;
    public Request (String Hospital, String BloodType, int NoOfBags, Double ID)
    {
     this.BloodType=BloodType;
     this.Hospital=Hospital;
     this.NoOfBags=NoOfBags;
     this.ID=ID;
    }
    String getHospital ()
    {
     return this.Hospital;
    }
    String getBloodType ()
    {
     return this.BloodType;
    }
    int getBags ()
    {
     return this.NoOfBags;
    }
    Double getID ()
    {
     return this.ID;
    }
}
