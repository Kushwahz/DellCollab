package com.dell.zealthinkers.dellcollab;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.MyViewHolder> {

    private List<DropRequest> dropRequestList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView personName, contactName, routeName;

        public MyViewHolder(View view) {
            super(view);
            personName = (TextView) view.findViewById(R.id.drop_person);
            contactName = (TextView) view.findViewById(R.id.drop_contact);
            routeName = (TextView) view.findViewById(R.id.drop_route);
        }
    }


    public SecondAdapter(List<DropRequest> dropRequests) {
        this.dropRequestList = dropRequests;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.drop_request_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DropRequest movie = dropRequestList.get(position);
        holder.personName.setText(movie.getPerson());
        holder.contactName.setText(movie.getContact());
        holder.routeName.setText(movie.getRoute());
    }

    @Override
    public int getItemCount() {
        return dropRequestList.size();
    }
}