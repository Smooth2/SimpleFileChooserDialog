# SimpleFileChooserDialog
Sample App for a simple file and directory chooser for Android.

This repository contains a java-class called SimpleFileChooserDialog.java.
To see how to use it, you can look in the MainActivity from the sample app.
```Java
Button imgButton = (Button) findViewById(R.id.imgBtn);
imgButton.setOnClickListener(new View.OnClickListener() {
    String mChosenDir;
    @Override
    public void onClick(View v) {
        SimpleFileChooserDialog myDialog = new SimpleFileChooserDialog(mContext, SimpleFileChooserDialog.FILE_SELECT, new SimpleFileChooserDialog.SimpleFileDialogListener() {
            @Override
            public void onPositiveButton(String chosenDir) {
                Toast.makeText(mContext, "Chosen file: " + chosenDir, Toast.LENGTH_SHORT).show();
            }
        });
        myDialog.mAllowedFileExts = new String[]{".jpg", ".jpeg", ".png"};
        myDialog.chooseFile_or_Dir();
    }
});
```

You can either change the code in the java file directly, or you can change a lot of "variables" via code like so, before calling the dialog with ```myDialog.chooseFile_or_Dir();```:
```
  String mPosButtonText;               // Text for the positive Button of the Dialog (like "OK")
  String mNegButtonText;               // Text for the negative Button of the Dialog (like "Cancel")
  String mNewFileDialogTitle;          // Text for the title of the sub-Dialog for entering a file-name
  String mDialogTitle;                 // Custom Dialog Title
  int mRevertDirDrawable;              // R.id for the "back" drawable
  int mNewFolderDrawable;              // R.id for the "new Folder" drawable
  String mNewFolderPosButtonText;      // Text for the positive Button of the newDir-Dialog (like "OK")
  String mNewFolderNegButtonText;      // Text for the negative Button of the newDir-Dialog (like "Cancel")
  String mNewFolderFailText;           // Text for the Toast when creation of folder failed
  String mNewFolderDialogTitle;        // Text for the title of the sub-Dialog for entering a folder-name
  boolean mHideBackButtonInRootDir;    // boolean to hide or show the back button in the root Sd Directory
  String mDialogTitleBackgroundColorHex; // Hex Color for the background color of the title-box
  String mDialogDividerColorHex;       // Hex Color for the color of the divider between title and body
  String[] mAllowedFileExts;           // String-array of allowed file-extentions to display
  String mFileSaveNoNameFailureText;   // Text for the Toast when no filename was entered when saving a file
```
For example:  <code>myDialog.mAllowedFileExts = new String[]{".jpg", ".jpeg", ".png"};</code>

Also make sure to include the permission in the Manifest: ```<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />```


For the license, please have a look into the SimpleFileChooserDialog.java file.
Author of the original source is 'Gregory Shpitalnik' from 'codeproject.com'
http://www.codeproject.com/Articles/547636/Android-Ready-to-use-simple-directory-chooser-dial
