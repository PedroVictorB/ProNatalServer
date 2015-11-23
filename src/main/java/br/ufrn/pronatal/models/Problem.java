package br.ufrn.pronatal.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
 
@Entity
@Table(name="marker", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Problem {
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true, length=11)
    private int id;
     
    @Column(name="name", length=20, nullable=true)
    private String titulo;
     
    @Column(name="role", length=20, nullable=true)
    private String tipo;
    
    @Column(name="description", length=20, nullable=true)
    private String descricao;
     
    @Column(name="date", nullable=true)
    private Date date;
    
    @Column(name="latitude", nullable=true)
    private double latitude;
    
    @Column(name="longitude", nullable=true)
    private double longitude;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
    
}
