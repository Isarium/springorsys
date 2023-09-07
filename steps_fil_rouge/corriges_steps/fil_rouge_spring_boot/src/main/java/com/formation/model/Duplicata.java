package com.formation.model;

public class Duplicata {

	private String id;
	private String userid;
	private Integer montant;
	private String pdfurl;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Integer getMontant() {
		return montant;
	}

	public void setMontant(Integer montant) {
		this.montant = montant;
	}

	public String getPdfurl() {
		return pdfurl;
	}

	public void setPdfurl(String pdfurl) {
		this.pdfurl = pdfurl;
	}

	@Override
	public String toString() {
		return "Duplicata [id=" + id + ", userid=" + userid + ", montant=" + montant + ", pdfurl=" + pdfurl + "]";
	}

}