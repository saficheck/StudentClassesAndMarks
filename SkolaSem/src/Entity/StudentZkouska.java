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
public class StudentZkouska implements Serializable {

    private static final long serialVersionUID = 1L;
   private int Student_ID;
   private int Zkouska_ID;
   
   public StudentZkouska ( int Student_ID, int Zkouska_ID) {
       this.Student_ID = Student_ID;
       this.Zkouska_ID = Zkouska_ID;

      
   
   }

    public int getStudent_ID() {
        return Student_ID;
    }

    public void setStudent_ID(int Student_ID) {
        this.Student_ID = Student_ID;
    }

    public int getPredmet_ID() {
        return Zkouska_ID;
    }

    public void setPredmet_ID(int Predmet_ID) {
        this.Zkouska_ID = Predmet_ID;
    }
   
    
    
    
    
    
    
    
    
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
        if (!(object instanceof StudentZkouska)) {
            return false;
        }
        StudentZkouska other = (StudentZkouska) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.StudentZkouska[ id=" + id + " ]";
    }
    public int Student_ID()
    {
        return Student_ID;      }
    public int Zkouska_ID()
    {
        return Zkouska_ID;      }
}
