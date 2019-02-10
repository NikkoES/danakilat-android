package com.luckynineapps.danakilat.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.luckynineapps.danakilat.R;
import com.luckynineapps.danakilat.models.pinjaman.Pinjaman;
import com.luckynineapps.danakilat.utils.CommonUtil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.luckynineapps.danakilat.data.Constant.WEB_URL_IMAGE_FINTECH;

public class PinjamanAdapter extends RecyclerView.Adapter<PinjamanAdapter.MyHolder> {

    Context context;
    List<Pinjaman> list;

    OnItemCheckListener onItemCheckListener;
    OnItemClickListener mOnItemClickListener;

    int position;

    public void resetListData() {
        this.list = new ArrayList<>();
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onClick(Pinjaman item);
    }

    public interface OnItemCheckListener {
        void onItemCheck(Pinjaman item);

        void onItemUncheck(Pinjaman item);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public void setOnItemCheckListener(final OnItemCheckListener mItemCheckListener) {
        this.onItemCheckListener = mItemCheckListener;
    }


    public PinjamanAdapter(Context context, List<Pinjaman> listProduk) {
        this.context = context;
        this.list = listProduk;
    }

    public PinjamanAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_pinjaman, parent, false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        final Pinjaman item = list.get(position);
        this.position = position;
        holder.txtNama.setText(item.getNamaFintech());
        holder.txtDeskripsi.setText(item.getDeskripsiSingkat());
        holder.txtNominal.setText("Rp. " + CommonUtil.currencyFormat(Long.parseLong(item.getNominalPinjaman())));

        Picasso.get().load(WEB_URL_IMAGE_FINTECH + item.getImage()).into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onClick(item);
            }
        });
        holder.cbPinjaman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.cbPinjaman.setChecked(!holder.cbPinjaman.isChecked());
                if (holder.cbPinjaman.isChecked()) {
                    onItemCheckListener.onItemCheck(item);
                } else {
                    onItemCheckListener.onItemUncheck(item);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public int getItemPosition() {
        return position;
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cb_pinjaman)
        CheckBox cbPinjaman;
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.txt_nama)
        TextView txtNama;
        @BindView(R.id.txt_deskripsi)
        TextView txtDeskripsi;
        @BindView(R.id.txt_nominal)
        TextView txtNominal;

        public MyHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            cbPinjaman.setClickable(false);
        }
    }

    public void add(Pinjaman item) {
        list.add(item);
        notifyItemInserted(list.size() + 1);
    }

    public void addAll(List<Pinjaman> listItem) {
        for (Pinjaman item : listItem) {
            add(item);
        }
    }

    public void swap(List<Pinjaman> datas) {
        if (datas == null || datas.size() == 0) list.clear();
        if (list != null && list.size() > 0)
            list.clear();
        list.addAll(datas);
        notifyDataSetChanged();

    }
}
