/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arogya;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Karan-PC
 */
@XmlRootElement(name = "Family_Data")
@XmlAccessorType (XmlAccessType.FIELD)
public class MembersList {
    
    @XmlElement(name = "Family_Member")
    private List<MemberData> members = null;
    private List<SurveyFormData> survey = null;
 
    public List<MemberData> getMembers() {
        return members;
    }
 
    public void setMembers(List<MemberData> members) {
        this.members = members;
    }

    public List<SurveyFormData> getSurvey() {
        return survey;
    }

    public void setSurvey(List<SurveyFormData> survey) {
        this.survey = survey;
    }
    
}
