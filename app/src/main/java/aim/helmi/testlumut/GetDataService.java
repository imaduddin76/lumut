package aim.helmi.testlumut;

import java.util.List;

import aim.helmi.testlumut.model.Model;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/todos")
    Call<List<Model>> getAllData();
}
