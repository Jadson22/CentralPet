package com.cursoandroid.centralpet.centralpet.activity.PerfilPets;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cursoandroid.centralpet.centralpet.R;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class CadastroMeusPets extends AppCompatActivity {

    private Toolbar tb;

    EditText edtName, edtRaca, edtIdade;
    RadioGroup radioSexo, radioTipo;
    RadioButton rbSexoEscolhido, rbTipoEscolhido;
    Button btnChoose, btnList;
    ImageView imageView;

    final int REQUEST_CODE_GALLERY = 999;

    public static SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_meus_pets);

        tb = (Toolbar) findViewById(R.id.toolbar_cadastroMeusPets);
        tb.setTitle("Novo Pet");
        setSupportActionBar(tb);

        init();

        sqLiteHelper = new SQLiteHelper(this, "PetDB.sqlite", null, 4);

        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS PET (Id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, sexo VARCHAR, raca VARCHAR, tipo VARCHAR, idade VARCHAR, image BLOB)");

        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        CadastroMeusPets.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastroMeusPets.this, FoodList.class);
                startActivity(intent);
            }
        });

    }

    private void adicionar() {

        int idRbSexoEscolhido = radioSexo.getCheckedRadioButtonId();
        if(idRbSexoEscolhido > 0 ){
            rbSexoEscolhido = (RadioButton) findViewById(idRbSexoEscolhido);
        }

        int idRbTipoEscolhido = radioTipo.getCheckedRadioButtonId();
        if(idRbTipoEscolhido > 0 ){
            rbTipoEscolhido = (RadioButton) findViewById(idRbTipoEscolhido);
        }

        try {
            sqLiteHelper.insertData(
                    edtName.getText().toString().trim(),
                    rbSexoEscolhido.getText().toString().trim(),
                    edtRaca.getText().toString().trim(),
                    rbTipoEscolhido.getText().toString().trim(),
                    edtIdade.getText().toString().trim(),
                    imageViewToByte(imageView)
            );
            Toast.makeText(getApplicationContext(), "Adicionado com sucesso!", Toast.LENGTH_SHORT).show();
            edtName.setText("");
            edtRaca.setText("");
            edtIdade.setText("");
            imageView.setImageResource(R.drawable.fotoperfil);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == REQUEST_CODE_GALLERY){
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            }
            else {
                Toast.makeText(getApplicationContext(), "Você não tem permissão para acessar os arquivos!", Toast.LENGTH_SHORT).show();
            }
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);

               // Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                //imageView.setImageBitmap(bitmap);

                Glide.with(this)
                        .load(uri)
                        .asBitmap()
                        .centerCrop()
                        .into(imageView);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void init(){
        edtName = (EditText) findViewById(R.id.editartName);
        edtRaca = (EditText) findViewById(R.id.editarRaca);
        edtIdade = (EditText) findViewById(R.id.editarIdade);

        radioSexo = (RadioGroup) findViewById(R.id.radioSexo);
        radioTipo = (RadioGroup) findViewById(R.id.radioTipo);

        int idRbSexoEscolhido = radioSexo.getCheckedRadioButtonId();
        if(idRbSexoEscolhido > 0 ){
            rbSexoEscolhido = (RadioButton) findViewById(idRbSexoEscolhido);
        }

        int idRbTipoEscolhido = radioTipo.getCheckedRadioButtonId();
        if(idRbTipoEscolhido > 0 ){
            rbTipoEscolhido = (RadioButton) findViewById(idRbTipoEscolhido);
        }

        btnChoose = (Button) findViewById(R.id.btnChoose);
        btnList = (Button) findViewById(R.id.btnList);
        imageView = (ImageView) findViewById(R.id.imageView);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cadstromeuspets, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.adicionar:
                adicionar();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
