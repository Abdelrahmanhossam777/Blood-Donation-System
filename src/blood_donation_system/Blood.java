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
class Blood {
    private int Apos,Aneg,Bpos,Bneg,Opos,Oneg,ABpos,ABneg;
    private String Hospital;
    public Blood(int Apos,int Aneg,int Bpos,int Bneg,int Opos,int Oneg,int ABpos,int ABneg,String Hospital)
    {
    this.Apos=Apos;
    this.Aneg=Aneg;
    this.Bpos=Bpos;
    this.Bneg=Bneg;
    this.Opos=Opos;
    this.Oneg=Oneg;
    this.ABpos=ABpos;
    this.ABneg=ABneg;
    this.Hospital=Hospital;
    }
    int getApos()
    {
        return this.Apos;
    }
    int getAneg()
    {
        return this.Aneg;
    }
    int getBpos()
    {
        return this.Bpos;
    }
    int getBneg()
    {
        return this.Bneg;
    }
    int getOpos()
    {
        return this.Opos;
    }
    int getOneg()
    {
        return this.Oneg;
    }
    int getABpos()
    {
        return this.ABpos;
    }
    int getABneg()
    {
        return this.ABneg;
    }
    String getHospiatl()
    {
        return this.Hospital;
    }
}
