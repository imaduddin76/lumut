package aim.helmi.testlumut;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import aim.helmi.testlumut.model.Model;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.MyViewHolder> {
    private List<Model> modelList;
    private Context context;


    public TodoAdapter(List<Model> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public TodoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.items,viewGroup,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoAdapter.MyViewHolder myViewHolder, int i) {
//        myViewHolder.title.setText(modelList.get(i).getTitle());
//        myViewHolder.id.setText(modelList.get(i).getId());
        myViewHolder.bind(modelList.get(i));
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, id;
        View v;
        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.TvTitle);
            id= itemView.findViewById(R.id.TvId);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Model model = modelList.get(position);

            Intent details = new Intent(context, DetailActivity.class);
            details.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            details.putExtra(DetailActivity.EXTRA, model);
            context.startActivity(details);
        }

        public void bind(Model model) {

            title.setText(model.getTitle());
            id.setText(model.getId());
        }
    }
}
