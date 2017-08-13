package com.cursoandroid.centralpet.centralpet.activity.PerfilPets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cursoandroid.centralpet.centralpet.R;

import java.util.ArrayList;

/**
 * Created by Quoc Nguyen on 13-Dec-16.
 */

public class FoodListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Food> foodsList;

    public FoodListAdapter(Context context, int layout, ArrayList<Food> foodsList) {
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

        Food food = foodsList.get(position);

        holder.txtName.setText(food.getName());
        holder.txtRaca.setText(food.getRaca());
        holder.txtIdade.setText(food.getIdade());

        byte[] foodImage = food.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(foodImage, 0, foodImage.length);
        holder.imageView.setImageBitmap(bitmap);

        if(food.getSexo().toString() == "Macho"){
            holder.iconesexo.setImageResource(R.drawable.iconemasc);
        }else{
            holder.iconesexo.setImageResource(R.drawable.iconefem);
        }

        if(food.getTipo().toString() == "Cão"){
            holder.iconetipo.setImageResource(R.drawable.iconecao);
        }else{
            holder.iconetipo.setImageResource(R.drawable.iconegato);
        }

        return row;
    }
}
