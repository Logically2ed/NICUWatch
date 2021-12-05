package nicuwatch.API;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MWMedical{

	@JsonProperty("MWMedical")
	private List<MWMedicalItem> mWMedical;

	public void setMWMedical(List<MWMedicalItem> mWMedical){
		this.mWMedical = mWMedical;
	}

	public List<MWMedicalItem> getMWMedical(){
		return mWMedical;
	}

	@Override
 	public String toString(){
		return 
			"MWMedical{" + 
			"mWMedical = '" + mWMedical + '\'' + 
			"}";
		}
}