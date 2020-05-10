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
class USER {
    private Double ID;
    private String UserName, City, Hospital, Name,Phone,Email;
    public USER(double ID, String UserName,String City,String Hospital, String Name, String phone, String Email)
    {
    this.ID=ID;
    this.UserName=UserName;
    this.City=City;
    this.Hospital=Hospital;
    this.Name=Name;
    this.Phone=phone;
    this.Email=Email;
    }
    public String getName ()
     {
       return this.Name;     
     }
    public String getEmail ()
     {
       return this.Email;     
     }
     public String getphone ()
     {
       return this.Phone;     
     }
    public USER(Double ID, String UserName)
    {
    this.ID=ID;
    this.UserName=UserName;
    }

    public Double getID ()
     {
       return this.ID;     
     }
    public String getUserName ()
     {
       return this.UserName;     
     }
    
    public String getCity ()
     {
       return this.City;     
     }
    public String getHospital ()
     {
       return this.Hospital;     
     }
    public void SetId(Double Id)
    {
    this.ID=Id;
    }
    public void SetUserName(String UserName)
    {
        this.UserName=UserName;
    }
     public void SetCity(String City)
    {
        this.City=City;
    }
    public void SetHospital(String Hospital)
    {
    this.Hospital=Hospital;
    }
}
