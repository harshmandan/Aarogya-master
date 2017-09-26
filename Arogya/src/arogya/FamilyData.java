/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arogya;  
/**
 *
 * @author Karan-PC
 */
 
public class FamilyData {
    private String district,HOF_name,bhamasha_value;
    private String rashan_id,form_number;
    
    public FamilyData(){}
    
    public FamilyData(String district,String HOF_name,String bhamasha_value,String rashan_id,String form_number)
    {
        super();
        this.district = district;
        this.HOF_name = HOF_name;
        this.bhamasha_value=bhamasha_value;
        this.form_number = form_number;
        this.rashan_id= rashan_id;
    }
    
    
    
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    
    public String getHOF_name() {
        return HOF_name;
    }

    public void setHOF_name(String HOF_name) {
        this.HOF_name = HOF_name;
    }

    
    public String getBhamasha_value() {
        return bhamasha_value;
    }

    public void setBhamasha_value(String bhamasha_value) {
        this.bhamasha_value = bhamasha_value;
    }
    
    
    public String getRashan_id() {
        return rashan_id;
    }

    public void setRashan_id(String rashan_id) {
        this.rashan_id = rashan_id;
    }

    
    public String getForm_number() {
        return form_number;
    }

    public void setForm_number(String form_number) {
        this.form_number = form_number;
    }
    
    
    
}
