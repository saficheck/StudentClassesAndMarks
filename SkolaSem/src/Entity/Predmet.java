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
public class Predmet implements Serializable {

    private static final long serialVersionUID = 1L;
    private String Nazev;
    private String Kod;
    public Predmet(int id, String Nazev, String Kod) {
       this.Nazev = Nazev;
       this.Kod = Kod;

       this.id=id;
       
    }

    public String getNazev() {
        return Nazev;
    }

    public void setNazev(String Nazev) {
        this.Nazev = Nazev;
    }

    public String getKod() {
        return Kod;
    }

    public void setKod(String Kod) {
        this.Kod = Kod;
    }
    
 
    public Predmet(String Nazev, String Kod) {
       this.Nazev = Nazev;
       this.Kod = Kod;
      
       
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
        if (!(object instanceof Predmet)) {
            return false;
        }
        Predmet other = (Predmet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Predmet[ id=" + id + " ]";
    }
    
    
    public String Nazev()
    {
        return Nazev;      }
    
    
    public String Kod()
    {
        return Kod;      }
}
