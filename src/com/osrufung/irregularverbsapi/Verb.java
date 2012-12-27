package com.osrufung.irregularverbsapi;
import com.google.gson.Gson;
import javax.jdo.annotations.IdGeneratorStrategy;

import javax.jdo.annotations.IdentityType;

import javax.jdo.annotations.PersistenceCapable;

import javax.jdo.annotations.Persistent;

import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Verb {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	Long id;
	@Persistent
	int level;
	@Persistent
	String simple;	
	@Persistent
	String past;
	@Persistent
	String participle;
	@Persistent
	String translation;
	public Verb(String simple, String past, String participle, String translation,int level) {
		super();
		this.simple = simple;
		this.past = past;
		this.participle = participle;
		this.translation = translation;
		this.level = level;
	}
	public String toJson(){
		Gson gson = new Gson();
		String json = gson.toJson(this);
		return json;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSimple() {
		return simple;
	}
	public void setSimple(String simple) {
		this.simple = simple;
	}
	public String getPast() {
		return past;
	}
	public void setPast(String past) {
		this.past = past;
	}
	public String getParticiple() {
		return participle;
	}
	public void setParticiple(String participle) {
		this.participle = participle;
	}
}
