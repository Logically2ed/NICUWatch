package nicuwatch.API;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VrsItem{

	@JsonProperty("vl")
	private String vl;

	@JsonProperty("va")
	private String va;

	public void setVl(String vl){
		this.vl = vl;
	}

	public String getVl(){
		return vl;
	}

	public void setVa(String va){
		this.va = va;
	}

	public String getVa(){
		return va;
	}

	@Override
 	public String toString(){
		return 
			"VrsItem{" + 
			"vl = '" + vl + '\'' + 
			",va = '" + va + '\'' + 
			"}";
		}
}