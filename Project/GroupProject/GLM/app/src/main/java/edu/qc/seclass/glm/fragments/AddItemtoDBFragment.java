package edu.qc.seclass.glm.fragments;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.qc.seclass.glm.R;
import edu.qc.seclass.glm.custom.GLMFragment;
import edu.qc.seclass.glm.datastructures.GroceryList;
import edu.qc.seclass.glm.datastructures.Item;
import edu.qc.seclass.glm.db.Converter;

public class AddItemtoDBFragment extends GLMFragment implements View.OnClickListener {
    private ImageView imageView;
    private Bitmap selectedImage;
    private String type;

    private Spinner spinner;

    public static AddItemtoDBFragment instance(){
        return new AddItemtoDBFragment();
    }

    private AddItemtoDBFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_item_to_db, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.add_newItemtoDBFragment).setOnClickListener(this);
        view.findViewById(R.id.cancel_newItemtoDBFragment).setOnClickListener(this);
        view.findViewById(R.id.selectImage_newItemtoDBFragment).setOnClickListener(this);
        imageView = (ImageView) view.findViewById(R.id.selectImage_newItemtoDBFragment);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.select_image_icon));

        List<String> lists = new ArrayList<>(this.glm.getTypeLookup().keySet());

        spinner = (Spinner) view.findViewById(R.id.spinner_addItemToDB);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, lists);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);


        this.glm.setAppTitle("Create Item");
    }

    /**
     *
     */
    private void addNewItemtoDB(View v){
        EditText itemName = (EditText) this.getView().findViewById(R.id.inputItemName_newItemtoDBFragment);

        String selected = (String) spinner.getSelectedItem();

        ArrayList<Item> items = this.glm.getTypeLookup().get(this.type);

        String name = itemName.getText().toString();
        if (name.length() == 0) {
            Toast.makeText(this.getView().getContext(), "Item Name cannot be empty", Toast.LENGTH_LONG).show();
            return;
        }


        String dir = "";
        String fileName = selected.toLowerCase()+"_"+name.toLowerCase().replace(" ", "_");

        /* Will attempt to save the selected image. If it cannot, it will select a random default list icon */
        if (this.saveImage(fileName)) {
            dir = fileName + ".png";
        }else{
            dir = "types/"+this.glm.getTypesToImage().get(selected);
        }

        Log.d("BAHTI","Directory: "+dir);

        /* Temp item that needs to be inserted to the database */
        Item item = new Item(-1, name, selected, dir, 1);

        /* The actual Item that was inserted and is recognized by the app */
        Item inserted = this.glm.createItem(item);

        if (inserted != null) {
            /* Switches over to the Search fragment */
            Converter.viewToActivity(v).switchToSearchFragment();
        }else{
            Toast.makeText(this.getView().getContext(), "Unable to Create Item", Toast.LENGTH_LONG).show();
        }
    }

    /**
     *
     * @param view
     */
    private void invokeSelectImage(View view){
        if(ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},2000);
        } else {
            Intent cameraIntent = new Intent(Intent.ACTION_GET_CONTENT);
            cameraIntent.setType("image/*");
            startActivityForResult(Intent.createChooser(cameraIntent, "Select Picture"), 1);
        }

    }

    /**
     *
     * @param name
     * @return
     */
    private boolean saveImage(String name){
        /* No image was selected */
        if (this.selectedImage == null)
            return false;

        try {
            /* Will save the image in the apps local folder */
            FileOutputStream fileOutputStream = this.getContext().openFileOutput(name+".png", Context.MODE_PRIVATE);

            selectedImage.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            Uri returnUri = data.getData();
            try {
                Bitmap bitmapImage = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), returnUri);
                imageView.setImageBitmap(bitmapImage);
                selectedImage = bitmapImage;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.selectImage_newItemtoDBFragment)
            invokeSelectImage(view);
        if (view.getId() == R.id.add_newItemtoDBFragment)
            addNewItemtoDB(view);
        if (view.getId() == R.id.cancel_newItemtoDBFragment)
            Converter.viewToActivity(view).switchToSearchFragment();
    }
}
