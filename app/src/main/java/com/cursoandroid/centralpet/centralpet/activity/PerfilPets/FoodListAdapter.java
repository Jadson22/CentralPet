package com.cursoandroid.centralpet.centralpet.activity.PerfilPets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cursoandroid.centralpet.centralpet.R;

import java.util.ArrayList;

/**
 * Created by Quoc Nguyen on 13-Dec-16.
 */

public class FoodListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Pet> foodsList;

    public FoodListAdapter(Context context, int layout, ArrayList<Pet> foodsList) {
        this.context = context;
        this.layout = layout;
        this.foodsList = foodsList;
    }

    @Override
    public int getCount() {
        return foodsList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView, iconesexo, iconetipo;
        TextView txtName, txtRaca, txtIdade;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtName = (TextView) row.findViewById(R.id.textoName);
            holder.txtRaca = (TextView) row.findViewById(R.id.textoRaca);
            holder.txtIdade = (TextView) row.findViewById(R.id.textoIdade);
            holder.imageView = (ImageView) row.findViewById(R.id.imgPerfil);

            holder.iconesexo = (ImageView) row.findViewById(R.id.iconeSexo);
            holder.iconetipo = (ImageView) row.findViewById(R.id.iconeTipo);

            row.setTag(holder);
        }
        else{
            holder = (ViewHolder) row.getTag();
        }

        Pet pet = foodsList.get(position);

        holder.txtName.setText(pet.getName());
        holder.txtRaca.setText(pet.getRaca());
        holder.txtIdade.setText(pet.getIdade());

        byte[] foodImage = pet.getImage();
        //Bitmap bitmap = BitmapFactory.decodeByteArray(foodImage, 0, foodImage.length);
        //holder.imageView.setImageBitmap(bitmap);
        Glide.with(this.context)
                .load(foodImage)
                .asBitmap()
                .centerCrop()
                .into(holder.imageView);

        if(holder.iconesexo.toString().equals("Macho")){
            holder.iconesexo.setImageResource(R.drawable.iconemasc);
        }else{
            holder.iconesexo.setImageResource(R.drawable.iconefem);
        }
        if(holder.iconetipo.equals("Fêmea")){
            holder.iconetipo.setImageResource(R.drawable.iconecao);
        }else{
            holder.iconetipo.setImageResource(R.drawable.iconegato);
        }

        return row;
    }
}
