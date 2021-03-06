package in.skylifetech.ks;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {     //ScheduleAdapter for scheduleRecyclerView
    ArrayList<Schedule> schedules = new ArrayList<>();
    Context mContext;

    public ScheduleAdapter(Context mContext) {      //Constructor initializes mContext.
        this.mContext = mContext;
    }

    @Override
    public ScheduleAdapter.ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_card, parent, false);
        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ScheduleViewHolder holder, final int listPosition) {
        Schedule schedule = schedules.get(listPosition);
        holder.setDetails(schedule);    //To set details of each individual item.
    }

    @Override
    public int getItemCount() {     //Returns count of total items.
        if (schedules != null)
            return schedules.size();
        else
            return 0;
    }


    public void setData(ArrayList<Schedule> data) {     //Sets data of schedule and notifies the data change.
        this.schedules = data;
        notifyDataSetChanged();
    }


    public static class ScheduleViewHolder extends RecyclerView.ViewHolder {
        TextView eventName;
        TextView eventVenue;
        TextView eventTime;

        public ScheduleViewHolder(View itemView) {
            super(itemView);
            eventName = itemView.findViewById(R.id.eventName);
            eventVenue = itemView.findViewById(R.id.eventVenue);
            eventTime = itemView.findViewById(R.id.eventTime);
        }

        public void setDetails(Schedule schedule) {
            eventName.setText(schedule.getEventName());
            eventVenue.setText(schedule.getEventVenue());
            eventTime.setText(schedule.getEventTime());
        }
    }
}
