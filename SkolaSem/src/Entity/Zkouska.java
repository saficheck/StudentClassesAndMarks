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
public class Zkouska implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    
     public Zkouska(int id, int Predmet_ID,String Datum) {
       this.Datum = Datum;
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
    private String Datum;

    public String getDatum() {
        return Datum;
    }

    public void setDatum(String Datum) {
        this.Datum = Datum;
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
        if (!(object instanceof Zkouska)) {
            return false;
        }
        Zkouska other = (Zkouska) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Zkouska[ id=" + id + " ]";
    }
 
    
    
    public String Datum()
    {
        return Datum;      }
    public int Predmet_ID()
    {
        return Predmet_ID;      }
}
