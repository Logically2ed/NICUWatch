package nicuwatch.API;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MWMedicalItem{

	@JsonProperty("def")
	private List<DefItem> def;

	@JsonProperty("meta")
	private Meta meta;

	@JsonProperty("fl")
	private String fl;

	@JsonProperty("hwi")
	private Hwi hwi;

	@JsonProperty("shortdef")
	private List<String> shortdef;

	@JsonProperty("bios")
	private List<String> bios;

	@JsonProperty("vrs")
	private List<VrsItem> vrs;

	@JsonProperty("hom")
	private int hom;

	public void setDef(List<DefItem> def){
		this.def = def;
	}

	public List<DefItem> getDef(){
		return def;
	}

	public void setMeta(Meta meta){
		this.meta = meta;
	}

	public Meta getMeta(){
		return meta;
	}

	public void setFl(String fl){
		this.fl = fl;
	}

	public String getFl(){
		return fl;
	}

	public void setHwi(Hwi hwi){
		this.hwi = hwi;
	}

	public Hwi getHwi(){
		return hwi;
	}

	public void setShortdef(List<String> shortdef){
		this.shortdef = shortdef;
	}

	public List<String> getShortdef(){
		return shortdef;
	}

	public void setBios(List<String> bios){
		this.bios = bios;
	}

	public List<String> getBios(){
		return bios;
	}

	public void setVrs(List<VrsItem> vrs){
		this.vrs = vrs;
	}

	public List<VrsItem> getVrs(){
		return vrs;
	}

	public void setHom(int hom){
		this.hom = hom;
	}

	public int getHom(){
		return hom;
	}

	@Override
 	public String toString(){
		return 
			"MWMedicalItem{" + 
			"def = '" + def + '\'' + 
			",meta = '" + meta + '\'' + 
			",fl = '" + fl + '\'' + 
			",hwi = '" + hwi + '\'' + 
			",shortdef = '" + shortdef + '\'' + 
			",bios = '" + bios + '\'' + 
			",vrs = '" + vrs + '\'' + 
			",hom = '" + hom + '\'' + 
			"}";
		}
}