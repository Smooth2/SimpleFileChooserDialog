package com.filechooser.sampleapp;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;


public class MainActivity extends ActionBarActivity {
    Button dirButton;
    Button imgButton;
    Button saveButton;
    TextView pathView;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        mContext = MainActivity.this;
        saveButton.setOnClickListener(new View.OnClickListener() {
            String mChosenDir;

            @Override
            public void onClick(View v) {
                SimpleFileChooserDialog myDialog = new SimpleFileChooserDialog(mContext, SimpleFileChooserDialog.FILE_SAVE, new SimpleFileChooserDialog.SimpleFileDialogListener() {
                    @Override
                    public void onPositiveButton(String chosenDir) {
                        pathView.setText(chosenDir);
                        Toast.makeText(mContext, "Path to save file: " + chosenDir, Toast.LENGTH_LONG).show();
                    }
                });
                ArrayList<String> myExts = new ArrayList<>();
                myExts.add(".jpg");
                myExts.add(".jpeg");
                myExts.add(".png");
                myDialog.mAllowedFileExtsList = myExts;
                myDialog.chooseFile_or_Dir();
            }
        });
        imgButton.setOnClickListener(new View.OnClickListener() {
            String mChosenDir;

            @Override
            public void onClick(View v) {
                SimpleFileChooserDialog myDialog = new SimpleFileChooserDialog(mContext, SimpleFileChooserDialog.FILE_SELECT, new SimpleFileChooserDialog.SimpleFileDialogListener() {
                    @Override
                    public void onPositiveButton(String chosenDir) {
                        pathView.setText(chosenDir);
                        Toast.makeText(mContext, "Chosen file: " + chosenDir, Toast.LENGTH_SHORT).show();
                    }
                });
                ArrayList<String> myExts = new ArrayList<>();
                myExts.add(".jpg");
                myExts.add(".jpeg");
                myExts.add(".png");
                myDialog.mAllowedFileExtsList = myExts;
                myDialog.chooseFile_or_Dir();
            }
        });
        dirButton.setOnClickListener(new View.OnClickListener() {
            String mChosenDir;

            @Override
            public void onClick(View v) {
                SimpleFileChooserDialog myDialog = new SimpleFileChooserDialog(MainActivity.this, SimpleFileChooserDialog.FOLDER_SELECT, new SimpleFileChooserDialog.SimpleFileDialogListener() {
                    @Override
                    public void onPositiveButton(String chosenDir) {
                        pathView.setText(chosenDir);
                        Toast.makeText(mContext, "ChosenDir: " + chosenDir, Toast.LENGTH_SHORT).show();
                    }
                });
                myDialog.chooseFile_or_Dir();
            }
        });
    }


    private void findViews() {
        pathView = (TextView) findViewById(R.id.path);
        dirButton = (Button) findViewById(R.id.btnDir);
        imgButton = (Button) findViewById(R.id.btnImg);
        saveButton = (Button) findViewById(R.id.btnFileSave);
    }
}
