package bd6.entity;
// Generated 27/02/2020 17:09:21 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Partidas generated by hbm2java
 */
public class Partidas  implements java.io.Serializable {


     private Integer id;
     private Date fechaInicio;
     private String ganador;
     private int numMovimientos;
     private Set movimientoses = new HashSet(0);

    public Partidas() {
    }

	
    public Partidas(Date fechaInicio, int numMovimientos) {
        this.fechaInicio = fechaInicio;
        this.numMovimientos = numMovimientos;
    }
    public Partidas(Date fechaInicio, String ganador, int numMovimientos, Set movimientoses) {
       this.fechaInicio = fechaInicio;
       this.ganador = ganador;
       this.numMovimientos = numMovimientos;
       this.movimientoses = movimientoses;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public String getGanador() {
        return this.ganador;
    }
    
    public void setGanador(String ganador) {
        this.ganador = ganador;
    }
    public int getNumMovimientos() {
        return this.numMovimientos;
    }
    
    public void setNumMovimientos(int numMovimientos) {
        this.numMovimientos = numMovimientos;
    }
    public Set getMovimientoses() {
        return this.movimientoses;
    }
    
    public void setMovimientoses(Set movimientoses) {
        this.movimientoses = movimientoses;
    }

    @Override
    public String toString() {
        return "ID:"+id+" fecha:"+fechaInicio+" numMovimi:"+numMovimientos+" ganador:"+ganador; //To change body of generated methods, choose Tools | Templates.
    }
    

}

