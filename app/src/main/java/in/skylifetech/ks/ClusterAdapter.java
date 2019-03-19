package in.skylifetech.ks;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ClusterAdapter extends RecyclerView.Adapter<ClusterAdapter.ClusterHolder> implements CallbackInterface {

    ArrayList<String> clusterNames = new ArrayList<>();
    ArrayList<Drawable> clusterIcon = new ArrayList<>();
    Context mContext;
    ProgressDialog progressDialog;
    int day;
    private ClusterAdapter callback;

    public ClusterAdapter(Context mContext, int d) {
        this.mContext = mContext;
        this.callback = this;
        day = d;

        progressDialog = new ProgressDialog(mContext);
        progressDialog.setTitle("Loading...");
        progressDialog.setMessage("Downloading Data.....Please Wait");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setIndeterminate(true);

        clusterNames.add("TAMIL LITS");
        clusterNames.add("TELUGU LITS");
        clusterNames.add("ENGLISH LITS");
        clusterNames.add("HINDI LITS");
        clusterNames.add("ARTS");
        clusterNames.add("STUDIO");
        clusterNames.add("MUSIC");
        clusterNames.add("DANCE");
        clusterNames.add("OAT");

        clusterIcon.add(new ColorDrawable(Color.parseColor("#ffffff")));
        clusterIcon.add(new ColorDrawable(Color.parseColor("#ffff00")));
        clusterIcon.add(new ColorDrawable(Color.parseColor("#ff00ff")));
        clusterIcon.add(new ColorDrawable(Color.parseColor("#00ffff")));
        clusterIcon.add(new ColorDrawable(Color.parseColor("#ff0000")));
        clusterIcon.add(new ColorDrawable(Color.parseColor("#00ff00")));
        clusterIcon.add(new ColorDrawable(Color.parseColor("#0000ff")));
        clusterIcon.add(new ColorDrawable(Color.parseColor("#ccccff")));
        clusterIcon.add(new ColorDrawable(Color.parseColor("#000000")));
    }

    @NonNull
    @Override
    public ClusterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cluster_card, parent, false);
        return new ClusterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ClusterHolder holder, final int listPosition) {
        final String clusterName = clusterNames.get(listPosition);

        holder.clusterName.setText(clusterName);
        holder.clusterIcon.setImageDrawable(clusterIcon.get(listPosition));
        holder.rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                if (day == 1)
                    Day1.getInstance().getSchedule(getQueryWord(clusterName), callback, holder);
                else if (day == 2)
                    Day2.getInstance().getSchedule(getQueryWord(clusterName), callback, holder);
                else
                    Day3.getInstance().getSchedule(getQueryWord(clusterName), callback, holder);
            }
        });
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull ClusterHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.hideRecyclerView();
    }

    private String getQueryWord(String gameName) {
        if (gameName.equals("TAMIL LITS")) {
            return "TAMIL LITS";
        } else if (gameName.equals("TELUGU LITS")) {
            return "TELUGU LITS";
        } else if (gameName.equals("ENGLISH LITS")) {
            return "ENGLISH LITS";
        } else if (gameName.equals("HINDI LITS")) {
            return "HINDI LITS";
        } else if (gameName.equals("ARTS")) {
            return "ARTS";
        } else if (gameName.equals("STUDIO")) {
            return "STUDIO";
        } else if (gameName.equals("MUSIC")) {
            return "MUSIC";
        } else if (gameName.equals("DANCE")) {
            return "DANCE";
        } else if (gameName.equals("OAT")) {
            return "OAT";
        } else {
            return gameName;
        }
    }


    @Override
    public int getItemCount() {
        return clusterIcon.size();
    }

    @Override
    public void callback(String queryGame) {

    }

    @Override
    public void setScheduleData(ArrayList<Schedule> data, ClusterHolder clusterHolder, boolean isEmpty) {
        if (isEmpty) {
            progressDialog.cancel();
            Toast.makeText(mContext, "Sorry! Unfortunate Error occurred.", Toast.LENGTH_SHORT).show();
        } else {
            clusterHolder.setRecyclerView(data);
        }
    }

    public class ClusterHolder extends RecyclerView.ViewHolder {
        ConstraintLayout rootLayout;
        TextView clusterName;
        ImageView clusterIcon;
        RecyclerView scheduleRecyclerView;
        ScheduleAdapter adapter;

        public ClusterHolder(@NonNull View itemView) {
            super(itemView);
            rootLayout = itemView.findViewById(R.id.root_layout);
            clusterName = itemView.findViewById(R.id.clusterName);
            clusterIcon = itemView.findViewById(R.id.clusterIcon);
            scheduleRecyclerView = itemView.findViewById(R.id.ScheduleRecyclerView);
            adapter = new ScheduleAdapter(mContext);
            scheduleRecyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
            scheduleRecyclerView.setAdapter(adapter);
        }

        public void setRecyclerView(ArrayList<Schedule> data) {
            scheduleRecyclerView.setVisibility(View.VISIBLE);
            adapter.setData(data);
            progressDialog.cancel();
        }

        public void hideRecyclerView() {
            scheduleRecyclerView.setVisibility(View.GONE);
        }

    }
}

