package modelo;

import java.util.HashSet;
import java.util.Set;

public class Grupo  implements java.io.Serializable {


     private String cveGru;
     private String nomGru;
     private Set alumnos = new HashSet(0);

    public Grupo() {
    }

	
    public Grupo(String cveGru, String nomGru) {
        this.cveGru = cveGru;
        this.nomGru = nomGru;
    }
    public Grupo(String cveGru, String nomGru, Set alumnos) {
       this.cveGru = cveGru;
       this.nomGru = nomGru;
       this.alumnos = alumnos;
    }
   
    public String getCveGru() {
        return this.cveGru;
    }
    
    public void setCveGru(String cveGru) {
        this.cveGru = cveGru;
    }
    public String getNomGru() {
        return this.nomGru;
    }
    
    public void setNomGru(String nomGru) {
        this.nomGru = nomGru;
    }
    public Set getAlumnos() {
        return this.alumnos;
    }
    
    public void setAlumnos(Set alumnos) {
        this.alumnos = alumnos;
    }
}


