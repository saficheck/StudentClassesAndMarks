/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author Filip
 */
@Entity
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String Jmeno;
    private String Prijmeni;
    private String Adresa;
    private String RC;

    public Student(int id, String Jmeno, String Prijmeni, String Adresa, String RC) {
       this.Jmeno = Jmeno;
       this.Prijmeni = Prijmeni;
       this.Adresa = Adresa;
       this.RC = RC;
       this.id=id;
       
    }

  

    public String getJmeno() {
        return Jmeno;
    }

    public void setJmeno(String Jmeno) {
        this.Jmeno = Jmeno;
    }

    public String getPrijmeni() {
        return Prijmeni;
    }

    public void setPrijmeni(String Prijmeni) {
        this.Prijmeni = Prijmeni;
    }

    public String getAdresa() {
        return Adresa;
    }

    public void setAdresa(String Adresa) {
        this.Adresa = Adresa;
    }

    public String getRC() {
        return RC;
    }

    public void setRC(String RC) {
        this.RC = RC;
    }

 

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.NewEntity[ id=" + id + " ]";
    }

    
    public String Jmeno()
    {
        return Jmeno;      }
    
    
    public String Prijmeni()
    {
        return Prijmeni;      }
    
    public String Adresa()
    {
        return Adresa;      }
    
    public String RC()
    {
        return RC;      }

               
    
    
}
