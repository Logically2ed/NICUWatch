package nicuwatch.API;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrsItem{

	@JsonProperty("sound")
	private Sound sound;

	@JsonProperty("mw")
	private String mw;

	public void setSound(Sound sound){
		this.sound = sound;
	}

	public Sound getSound(){
		return sound;
	}

	public void setMw(String mw){
		this.mw = mw;
	}

	public String getMw(){
		return mw;
	}

	@Override
 	public String toString(){
		return 
			"PrsItem{" + 
			"sound = '" + sound + '\'' + 
			",mw = '" + mw + '\'' + 
			"}";
		}
}