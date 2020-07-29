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
public class Zapocet implements Serializable {

    private static final long serialVersionUID = 1L;
    
     public Zapocet(int id,int Student_ID, int Predmet_ID, String Zapocteno) {
       this.Zapocteno = Zapocteno;
       this.Student_ID = Student_ID;
      this.Predmet_ID = Predmet_ID;
       this.id=id;
       
    }
    
     
    
    private int Predmet_ID;

    public int getPredmet_ID() {
        return Predmet_ID;
    }

    public void setPredmet_ID(int Predmet_ID) {
        this.Predmet_ID = Predmet_ID;
    }

    public int getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(int Student_ID) {
        this.Student_ID = Student_ID;
    }
    private int Student_ID;
    
    
    private String Zapocteno;

    public String getZapocteno() {
        return Zapocteno;
    }

    public void setZapocteno(String Zapocteno) {
        this.Zapocteno = Zapocteno;
    }
  
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
        if (!(object instanceof Zapocet)) {
            return false;
        }
        Zapocet other = (Zapocet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Zapocet[ id=" + id + " ]";
    }
    
     public String Zapocteno()
    {
        return Zapocteno;      }
     
      public int Student_ID()
    {
        return Student_ID;      }
    
    public int Predmet_ID()
    {
       return Predmet_ID;      }
}
