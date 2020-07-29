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
public class StudentInfo2 implements Serializable {

    
    public StudentInfo2(String string, String string0) {
        Nazev=string;
        Zkouska = string0;
        
        
    }
    private static final long serialVersionUID = 1L;
    
    private String Nazev;

    public String getNazev() {
        return Nazev;
    }

    public void setNazev(String Nazev) {
        this.Nazev = Nazev;
    }

    public String getZkouska() {
        return Zkouska;
    }

    public void setZkouska(String Zkouska) {
        this.Zkouska = Zkouska;
    }
    private String Zkouska;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        if (!(object instanceof StudentInfo2)) {
            return false;
        }
        StudentInfo2 other = (StudentInfo2) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.StudentInfo2[ id=" + id + " ]";
    }
    
}
