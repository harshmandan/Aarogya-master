/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arogya;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Karan-PC
 */
@XmlRootElement
public class SurveyFormData {
    private String district,phc,health_centre,asha_member;
    private String village,hof_name,bhamasha;
    private int f_members;
    private boolean food_plan,status;
    private long form_num,mobile,rashan_id,health_insurance;

    public SurveyFormData(){}
    
   
          
    @XmlElement
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @XmlElement
    public String getPhc() {
        return phc;
    }

    public void setPhc(String phc) {
        this.phc = phc;
    }
    
    @XmlElement
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlElement
    public String getHealth_centre() {
        return health_centre;
    }

    public void setHealth_centre(String health_centre) {
        this.health_centre = health_centre;
    }

    @XmlElement
    public String getAsha_member() {
        return asha_member;
    }

    public void setAsha_member(String asha_member) {
        this.asha_member = asha_member;
    }

    @XmlElement
    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

   
    @XmlAttribute
    public String getHof_name() {
        return hof_name;
    }

    public void setHof_name(String hof_name) {
        this.hof_name = hof_name;
    }

    

    @XmlElement
    public int getF_members() {
        return f_members;
    }

    public void setF_members(int f_members) {
        this.f_members = f_members;
    }

    
   

    @XmlElement
    public String getBhamasha() {
        return bhamasha;
    }

    public void setBhamasha(String bhamasha) {
        this.bhamasha = bhamasha;
    }

   

    @XmlElement
    public boolean isFood_plan() {
        return food_plan;
    }

    public void setFood_plan(boolean food_plan) {
        this.food_plan = food_plan;
    }

   
    @XmlElement
    public long getForm_num() {
        return form_num;
    }

    public void setForm_num(long form_num) {
        this.form_num = form_num;
    }

    @XmlElement
    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    @XmlAttribute
    public long getRashan_id() {
        return rashan_id;
    }

    public void setRashan_id(long rashan_id) {
        this.rashan_id = rashan_id;
    }

    @XmlElement
    public long getHealth_insurance() {
        return health_insurance;
    }

    public void setHealth_insurance(long health_insurance) {
        this.health_insurance = health_insurance;
    }

    

    
    
}
