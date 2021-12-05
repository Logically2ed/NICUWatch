package nicuwatch.API;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DefItem{

	@JsonProperty("sseq")
	private List<String> sseq;

	@JsonProperty("vd")
	private String vd;

	public void setSseq(List<String> sseq){
		this.sseq = sseq;
	}

	public List<String> getSseq(){
		return sseq;
	}

	public void setVd(String vd){
		this.vd = vd;
	}

	public String getVd(){
		return vd;
	}

	@Override
 	public String toString(){
		return 
			"DefItem{" + 
			"sseq = '" + sseq + '\'' + 
			",vd = '" + vd + '\'' + 
			"}";
		}
}