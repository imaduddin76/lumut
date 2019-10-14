package aim.helmi.testlumut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import aim.helmi.testlumut.model.Model;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetDataService service = RetrofitInstance.getInstance().create(GetDataService.class);
        Call<List<Model>> call = service.getAllData();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to fetch the data!", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
    public void generateDataList(List<Model> modelList){
        rec =findViewById(R.id.rv);
        rec.setLayoutManager(new LinearLayoutManager(this));
        TodoAdapter adapter = new TodoAdapter(modelList,getApplicationContext());
        rec.setAdapter(adapter);
    }
}