package nicuwatch.API;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hwi{

	@JsonProperty("hw")
	private String hw;

	@JsonProperty("prs")
	private List<PrsItem> prs;

	public void setHw(String hw){
		this.hw = hw;
	}

	public String getHw(){
		return hw;
	}

	public void setPrs(List<PrsItem> prs){
		this.prs = prs;
	}

	public List<PrsItem> getPrs(){
		return prs;
	}

	@Override
 	public String toString(){
		return 
			"Hwi{" + 
			"hw = '" + hw + '\'' + 
			",prs = '" + prs + '\'' + 
			"}";
		}
}