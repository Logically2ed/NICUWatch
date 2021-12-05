package nicuwatch.API;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sound{

	@JsonProperty("audio")
	private String audio;

	public void setAudio(String audio){
		this.audio = audio;
	}

	public String getAudio(){
		return audio;
	}

	@Override
 	public String toString(){
		return 
			"Sound{" + 
			"audio = '" + audio + '\'' + 
			"}";
		}
}