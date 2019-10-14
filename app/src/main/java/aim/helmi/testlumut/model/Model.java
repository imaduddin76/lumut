package aim.helmi.testlumut.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Model implements Parcelable {
	private String id;
	private String  completed;
	private String title;
	private String userId;

	public void setId(String  id){
		this.id = id;
	}

	public String  getId(){
		return id;
	}

	public void setCompleted(String  completed){
		this.completed = completed;
	}

	public String getCompleted(){
		return completed;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setUserId(String  userId){
		this.userId = userId;
	}

	public String  getUserId(){
		return userId;
	}

	@Override
 	public String toString(){
		return 
			"Model{" +
			"id = '" + id + '\'' + 
			",completed = '" + completed + '\'' + 
			",title = '" + title + '\'' + 
			",userId = '" + userId + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.id);
		dest.writeString(this.completed);
		dest.writeString(this.title);
		dest.writeString(this.userId);
	}

	public Model() {
	}

	protected Model(Parcel in) {
		this.id = in.readString();
		this.completed = in.readString();
		this.title = in.readString();
		this.userId = in.readString();
	}

	public static final Parcelable.Creator<Model> CREATOR = new Parcelable.Creator<Model>() {
		@Override
		public Model createFromParcel(Parcel source) {
			return new Model(source);
		}

		@Override
		public Model[] newArray(int size) {
			return new Model[size];
		}
	};
}
