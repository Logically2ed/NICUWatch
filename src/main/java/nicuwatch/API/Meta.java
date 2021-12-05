package nicuwatch.API;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Meta{

	@JsonProperty("stems")
	private List<String> stems;

	@JsonProperty("offensive")
	private boolean offensive;

	@JsonProperty("src")
	private String src;

	@JsonProperty("section")
	private String section;

	@JsonProperty("id")
	private String id;

	@JsonProperty("sort")
	private String sort;

	@JsonProperty("uuid")
	private String uuid;

	public void setStems(List<String> stems){
		this.stems = stems;
	}

	public List<String> getStems(){
		return stems;
	}

	public void setOffensive(boolean offensive){
		this.offensive = offensive;
	}

	public boolean isOffensive(){
		return offensive;
	}

	public void setSrc(String src){
		this.src = src;
	}

	public String getSrc(){
		return src;
	}

	public void setSection(String section){
		this.section = section;
	}

	public String getSection(){
		return section;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setSort(String sort){
		this.sort = sort;
	}

	public String getSort(){
		return sort;
	}

	public void setUuid(String uuid){
		this.uuid = uuid;
	}

	public String getUuid(){
		return uuid;
	}

	@Override
 	public String toString(){
		return 
			"Meta{" + 
			"stems = '" + stems + '\'' + 
			",offensive = '" + offensive + '\'' + 
			",src = '" + src + '\'' + 
			",section = '" + section + '\'' + 
			",id = '" + id + '\'' + 
			",sort = '" + sort + '\'' + 
			",uuid = '" + uuid + '\'' + 
			"}";
		}
}