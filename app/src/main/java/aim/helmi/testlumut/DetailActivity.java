package aim.helmi.testlumut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import aim.helmi.testlumut.model.Model;

public class DetailActivity extends AppCompatActivity {

    private TextView userid;
    private TextView id;
    private TextView title;
    private TextView completed;
    public static final String EXTRA ="helmi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        userid = findViewById(R.id.TvUserIdDetail);
        id = findViewById(R.id.TvIdDetail);
        title = findViewById(R.id.TvTitleDetail);
        completed = findViewById(R.id.TvCompletedDetail);

        Model model = getIntent().getParcelableExtra(EXTRA);

        userid.setText(model.getUserId());
        id.setText(model.getId());
        title.setText(model.getTitle());
        completed.setText(model.getCompleted());
    }
}
