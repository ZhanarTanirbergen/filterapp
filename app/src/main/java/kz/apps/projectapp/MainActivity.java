package kz.apps.projectapp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import com.zomato.photofilters.SampleFilters;
import com.zomato.photofilters.imageprocessors.Filter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ThumbnailCallback {
    static {
        System.loadLibrary("NativeImageProcessor");
    }

    private Toolbar toolbar;
    private MenuItem itemDownload, itemShare;

    private Activity activity;
    private RecyclerView thumbListView;
    private ImageView placeHolderImageView;

    private RelativeLayout containerImg, containerText;

    private Bitmap currentSelBitmap, filteredBitmap;
    private Uri mCropImageUri;
    public static final String  TAG = MainActivity.class.getSimpleName();
    public static final int  WRITE_PERMISSION_REQUEST = 901;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        activity = this;
        initUIWidgets();
    }

    private void initUIWidgets() {
        containerImg = findViewById(R.id.containerImg);
        containerText = findViewById(R.id.containerText);

        if (filteredBitmap == null) {
            containerImg.setVisibility(View.GONE);
            containerText.setVisibility(View.VISIBLE);
        } else {
            containerImg.setVisibility(View.VISIBLE);
            containerText.setVisibility(View.GONE);
        }

        thumbListView = findViewById(R.id.thumbnails);
        placeHolderImageView = findViewById(R.id.place_holder_imageview);
        placeHolderImageView.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.getApplicationContext().getResources(), R.drawable.photo), 640, 640, false));
        initHorizontalList();
    }

    private void initHorizontalList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        layoutManager.scrollToPosition(0);
        thumbListView.setLayoutManager(layoutManager);
        thumbListView.setHasFixedSize(true);
    }

    private void bindDataToAdapter(final Bitmap bitmap) {
        final Context context = this.getApplication();
        Handler handler = new Handler();
        Runnable r = new Runnable() {
            public void run() {
                Bitmap thumbImage = Bitmap.createScaledBitmap(bitmap, 640, 640, false);
                ThumbnailItem t1 = new ThumbnailItem();
                ThumbnailItem t2 = new ThumbnailItem();
                ThumbnailItem t3 = new ThumbnailItem();
                ThumbnailItem t4 = new ThumbnailItem();
                ThumbnailItem t5 = new ThumbnailItem();
                ThumbnailItem t6 = new ThumbnailItem();
                ThumbnailItem t7 = new ThumbnailItem();
                ThumbnailItem t8 = new ThumbnailItem();
                ThumbnailItem t9 = new ThumbnailItem();
                ThumbnailItem t10 = new ThumbnailItem();
                ThumbnailItem t11 = new ThumbnailItem();
                ThumbnailItem t12 = new ThumbnailItem();
                ThumbnailItem t13 = new ThumbnailItem();
                ThumbnailItem t14 = new ThumbnailItem();
                ThumbnailItem t15 = new ThumbnailItem();

                t1.image = thumbImage;
                t2.image = thumbImage;
                t3.image = thumbImage;
                t4.image = thumbImage;
                t5.image = thumbImage;
                t6.image = thumbImage;
                t7.image = thumbImage;
                t8.image = thumbImage;
                t9.image = thumbImage;
                t10.image = thumbImage;
                t11.image = thumbImage;
                t12.image = thumbImage;
                t13.image = thumbImage;
                t14.image = thumbImage;
                t15.image = thumbImage;

                ThumbnailsManager.clearThumbs();
                ThumbnailsManager.addThumb(t1); // Original Image

                t2.filter = SampleFilters.getStarLitFilter();
                ThumbnailsManager.addThumb(t2);

                t3.filter = SampleFilters.getNightWhisperFilter();
                ThumbnailsManager.addThumb(t3);

                t4.filter = SampleFilters.getAweStruckVibeFilter();
                ThumbnailsManager.addThumb(t4);

                t5.filter = SampleFilters.getLimeStutterFilter();
                ThumbnailsManager.addThumb(t5);

                t6.filter = SampleFilters.getBlueMessFilter();
                ThumbnailsManager.addThumb(t6);

                t7.filter = CustomFilters.getFirstFilter();
                ThumbnailsManager.addThumb(t7);

                t8.filter = CustomFilters.getSecondFilter();
                ThumbnailsManager.addThumb(t8);

                t9.filter = CustomFilters.getThirdFilter();
                ThumbnailsManager.addThumb(t9);

                t10.filter = CustomFilters.getFifthFilter();
                ThumbnailsManager.addThumb(t10);

                t11.filter = CustomFilters.getSixthFilter();
                ThumbnailsManager.addThumb(t11);

                t12.filter = CustomFilters.getSeventhFilter();
                ThumbnailsManager.addThumb(t12);

                t13.filter = CustomFilters.getEigthFilter();
                ThumbnailsManager.addThumb(t13);

                t14.filter = CustomFilters.getNinethFilter();
                ThumbnailsManager.addThumb(t14);

                t15.filter = CustomFilters.getTenthFilter();
                ThumbnailsManager.addThumb(t15);

                List<ThumbnailItem> thumbs = ThumbnailsManager.processThumbs(context);

                ThumbnailsAdapter adapter = new ThumbnailsAdapter(thumbs, (ThumbnailCallback) activity);
                thumbListView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        };
        handler.post(r);
    }

    @Override
    public void onThumbnailClick(Filter filter) {
        if (currentSelBitmap != null) {
            filteredBitmap = filter.processFilter(Bitmap.createScaledBitmap(currentSelBitmap, 640, 640, false));
            placeHolderImageView.setImageBitmap(filteredBitmap);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onSelectImageClick() {
        if (CropImage.isExplicitCameraPermissionRequired(this)) {
            requestPermissions(
                    new String[] {Manifest.permission.CAMERA},
                    CropImage.CAMERA_CAPTURE_PERMISSIONS_REQUEST_CODE);
        } else {
            CropImage.startPickImageActivity(this);
        }
    }

    private void startCropImageActivity(Uri imageUri) {
        CropImage.activity(imageUri)
                .setFixAspectRatio(true)
                .setCropShape(CropImageView.CropShape.RECTANGLE)
                .start(this);
    }

    private void onImageChosen() {
        if (currentSelBitmap != null) {
            itemShare.setVisible(true);
            itemDownload.setVisible(true);
            containerImg.setVisibility(View.VISIBLE);
            containerText.setVisibility(View.GONE);
            bindDataToAdapter(currentSelBitmap);
        } else {
            itemShare.setVisible(false);
            itemDownload.setVisible(false);
            containerImg.setVisibility(View.GONE);
            containerText.setVisibility(View.VISIBLE);
        }
    }

    private void galleryAddPic(String imagePath) {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(imagePath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        sendBroadcast(mediaScanIntent);
    }

    private void saveToInternalStorage(Bitmap image) {
        File pictureFile = getOutputMediaFile();
        if (pictureFile == null) {
            Toast.makeText(getApplicationContext(), "Error creating media file, check storage permissions: ",
                    Toast.LENGTH_LONG).show();// e.getMessage());
            return;
        }
        String savedImagePath = pictureFile.getAbsolutePath();
        try {
            FileOutputStream fos = new FileOutputStream(pictureFile);
            image.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.close();
        } catch (FileNotFoundException e) {
            Log.d(TAG, "File not found: " + e.getMessage());
        } catch (IOException e) {
            Log.d(TAG, "Error accessing file: " + e.getMessage());
        }
        galleryAddPic(savedImagePath);
        Toast.makeText(getApplicationContext(), "Успешное сохранение", Toast.LENGTH_LONG).show();
    }

    private  File getOutputMediaFile(){
        File mediaStorageDir = new File(Environment.getExternalStorageDirectory()
                + "/DCIM/FilterApp/");
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                return null;
            }
        }
        String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
        File mediaFile;
        String mImageName="MI_"+ timeStamp +".jpg";
        mediaFile = new File(mediaStorageDir.getPath() + File.separator + mImageName);
        return mediaFile;
    }

    private void shareBitmap (Bitmap bitmap,String fileName) {
        try {
            File cachePath = new File(this.getCacheDir(), "images");
            cachePath.mkdirs();
            FileOutputStream fOut = new FileOutputStream(cachePath + "/" + fileName);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.close();

            File imagePath = new File(this.getCacheDir(), "images");
            File newFile = new File(imagePath, fileName);
            Uri contentUri = FileProvider.getUriForFile(this, "kz.apps.projectapp.fileprovider", newFile);

            if (contentUri != null) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); // temp permission for receiving app to read this file
                shareIntent.setDataAndType(contentUri, getContentResolver().getType(contentUri));
                shareIntent.putExtra(Intent.EXTRA_STREAM, contentUri);
                startActivity(Intent.createChooser(shareIntent, "Поделиться с друзьями"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        itemDownload = menu.findItem(R.id.action_download);
        itemDownload.setVisible(false);
        itemShare = menu.findItem(R.id.action_share);
        itemShare.setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_choose) {
            onSelectImageClick();
        } else if (id == R.id.action_download) {
            if (filteredBitmap != null) {
                if (isStoragePermissionGranted()) {
                    saveToInternalStorage(filteredBitmap);
                } else {
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_PERMISSION_REQUEST);
                }

            } else {
                Toast.makeText(getApplicationContext(), "Сначала выберите фото!", Toast.LENGTH_LONG).show();
            }
        } else if (id == R.id.action_share) {

            String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
            String mImageName="TMP_"+ timeStamp + ".png";
            if (filteredBitmap != null) {
                shareBitmap (filteredBitmap, mImageName);
            } else {
                Toast.makeText(getApplicationContext(), "Сначала выберите фото!", Toast.LENGTH_LONG).show();
            }
        }

        return super.onOptionsItemSelected(item);
    }

    public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG,"Разрешено!");
                return true;
            } else {

                Log.v(TAG,"Разрешение отказано!");
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_PERMISSION_REQUEST);
                return false;
            }
        }
        else {
            Log.v(TAG,"Разрешено!");
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == CropImage.CAMERA_CAPTURE_PERMISSIONS_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                CropImage.startPickImageActivity(this);
            } else {
                Toast.makeText(this, "Нет разрешения!", Toast.LENGTH_LONG)
                        .show();
            }
        }
         else if (requestCode == CropImage.PICK_IMAGE_PERMISSIONS_REQUEST_CODE) {
            if (mCropImageUri != null
                    && grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startCropImageActivity(mCropImageUri);
            } else {
                Toast.makeText(this, "Нет разрешения!", Toast.LENGTH_LONG)
                        .show();
            }
        } else if (requestCode == WRITE_PERMISSION_REQUEST) {
                if (grantResults.length > 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED) {
                    if (filteredBitmap != null) {
                        saveToInternalStorage(filteredBitmap);
                    }
                } else {
                    Toast.makeText(this, "Нет разрешения!", Toast.LENGTH_LONG)
                            .show();
                }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == CropImage.PICK_IMAGE_CHOOSER_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Uri imageUri = CropImage.getPickImageResultUri(this, data);

            if (CropImage.isReadExternalStoragePermissionsRequired(this, imageUri)) {
                // request permissions and handle the result in onRequestPermissionsResult()
                mCropImageUri = imageUri;
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},   CropImage.PICK_IMAGE_PERMISSIONS_REQUEST_CODE);
            } else {
                // no permissions required or already grunted, can start crop image activity
                startCropImageActivity(imageUri);
            }
        } else {
            if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
                CropImage.ActivityResult result = CropImage.getActivityResult(data);
                if (resultCode == RESULT_OK) {
                    Uri resultUri = result.getUri();

                    try {
                        currentSelBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), resultUri);
                        filteredBitmap = currentSelBitmap;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    onImageChosen();

                    if (currentSelBitmap != null) {
                        placeHolderImageView.setImageBitmap(currentSelBitmap);
                    }

                } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                    Exception error = result.getError();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
