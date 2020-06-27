package com.dell.zealthinkers.dellcollab;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<AvailableRides> availableRides;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView vehicle, time, seat, route;

        public MyViewHolder(View view) {
            super(view);
            vehicle = (TextView) view.findViewById(R.id.av_vehicle_type);
            time = (TextView) view.findViewById(R.id.av_leaving_time);
            seat = (TextView) view.findViewById(R.id.av_seats);
            route = (TextView) view.findViewById(R.id.av_route_match);
        }
    }


    public Adapter(List<AvailableRides> availableRidesList) {
        this.availableRides = availableRidesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.available_owner_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        AvailableRides movie = availableRides.get(position);
        holder.vehicle.setText(movie.getVehicle());
        holder.time.setText(movie.getHour());
        holder.seat.setText(movie.getSeats());
        holder.route.setText(movie.getMin());
    }

    @Override
    public int getItemCount() {
        return availableRides.size();
    }
}