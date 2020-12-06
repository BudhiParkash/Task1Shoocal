package com.example.shoocal_task_1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoocal_task_1.R;
import com.example.shoocal_task_1.databinding.DemodataBinding;
import com.example.shoocal_task_1.model.MainPojo;

import java.util.List;

public class ShowDataAdapter extends RecyclerView.Adapter<ShowDataAdapter.DataViewHolder> {
    Context context;
    List<MainPojo> mainPojoList;


    public ShowDataAdapter(Context context, List<MainPojo> mainPojoList) {
        this.context = context;
        this.mainPojoList = mainPojoList;
    }

    @NonNull
    @Override
    public ShowDataAdapter.DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DemodataBinding itemBinding = DemodataBinding .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new DataViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowDataAdapter.DataViewHolder holder, int position) {
        MainPojo mainPojo = mainPojoList.get(position);

        holder.demodataBinding.login.setText(mainPojo.getUser().getLogin());
        holder.demodataBinding.loginid.setText(mainPojo.getUser().getId()+"");
        holder.demodataBinding.reprositurl.setText(mainPojo.getRepositoryUrl());
        holder.demodataBinding.statecheck.setText(mainPojo.getState());
        if(mainPojo.getState().equals("open")){
            holder.demodataBinding.statecheck.setChecked(true);
        }
        else {
            holder.demodataBinding.statecheck.setChecked(false);

        }


    }

    @Override
    public int getItemCount() {
        return mainPojoList.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {
        DemodataBinding demodataBinding;
        public DataViewHolder(DemodataBinding demodataBinding) {
            super(demodataBinding.getRoot());
            this.demodataBinding =demodataBinding;


        }
    }
}
