package com.eoe.iArmoire;  
import java.io.File;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import android.annotation.SuppressLint;
import android.app.Activity;  
import android.content.Intent;  
import android.net.Uri;  
import android.os.Bundle;  
import android.provider.MediaStore;  
import android.view.View;  
import android.widget.Button;  
import android.widget.ImageView;  
import android.content.Context; 
import android.graphics.drawable.Drawable;
import android.view.ViewGroup; 
import android.widget.BaseAdapter; 
import android.widget.Gallery;
  
@SuppressWarnings("deprecation")
public class MainActivity extends Activity {  
	    private Button mButton,cButton;  
	    public ImageView mImageView;  
	    public File mPhotoFile;  
	    public String name,mPhotoPath;
	    public final static int CAMERA_RESULT=8888;  
	    public final static String TAG="xx";  
	    private Gallery gallery,gallery2;
		public Drawable b11;
   
	@Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
        mButton = (Button) findViewById(R.id.button);  
        mButton.setOnClickListener(new ButtonOnClickListener()); 
        cButton = (Button) findViewById(R.id.buttonbase);  
        cButton.setOnClickListener(new cButtonOnClickListener()); 
        gallery = (Gallery)findViewById(R.id.gallery);
        gallery2 = (Gallery)findViewById(R.id.gallery2);
        gallery.setAdapter(new ImageAdapter(this));
        gallery2.setAdapter(new ImageAdapter2(this));//设置图片适配器
	    											}
		
		class ImageAdapter extends BaseAdapter{
		    private Context context;
	        //图片源数组
		    private Integer[] imageInteger={
	            R.drawable.page1,
	            R.drawable.page2,
	            R.drawable.page3,
	            R.drawable.page4,
		    								};
		protected int position;
	    public ImageAdapter(Context c){
	        context = c;}
	    @Override
	    public int getCount() {
	        return imageInteger.length;}
	    @Override
	    public Object getItem(int position) {
	        // TODO Auto-generated method stub
	        return position;}
	    @Override
	    public long getItemId(int position) {
	        // TODO Auto-generated method stub
	        return position;}
	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	        ImageView imageView = new ImageView(context);
	        imageView.setImageResource(imageInteger[position]);
	        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	        imageView.setLayoutParams(new Gallery.LayoutParams(500,500));  
	        return imageView;
	    }  
}  
		
		class ImageAdapter2 extends BaseAdapter{
		    private Context context;
	    //图片源数组
		    private Integer[] imageInteger={
	            R.drawable.xc1,
	            R.drawable.xc2,
	            R.drawable.xc3,
	    };
		protected int position;
	    public ImageAdapter2(Context c){
	        context = c;}
	    @Override
	    public int getCount() {
	        return imageInteger.length;}
	    @Override
	    public Object getItem(int position) {
	        // TODO Auto-generated method stub
	        return position;}
	    @Override
	    public long getItemId(int position) {
	        // TODO Auto-generated method stub
	        return position;}
	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	        ImageView imageView = new ImageView(context);
	        imageView.setImageResource(imageInteger[position]);//改此处
	        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	        imageView.setLayoutParams(new Gallery.LayoutParams(700,350));
	        return imageView;
	    }
}
		
private class ButtonOnClickListener implements View.OnClickListener {  
    public void onClick(View v) {  
        try {  
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");  
            mPhotoPath="mnt/sdcard/衣服/"+getPhotoFileName();  
            mPhotoFile = new File(mPhotoPath);  
            if (!mPhotoFile.exists()) {  
                mPhotoFile.createNewFile();  
            }  
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mPhotoFile));  
            startActivityForResult(intent,CAMERA_RESULT);  
        	} catch (Exception e) {  }  
    							}  
}  

private class cButtonOnClickListener implements View.OnClickListener {  
    public void onClick(View v) {  
        try {  
        	Intent intent2=new Intent(MainActivity.this,ThumbnailsActivity.class);
			MainActivity.this.startActivity(intent2);
        	//Toast.makeText(MainActivity.this, "您已完成选择", Toast.LENGTH_LONG).show();
        	} catch (Exception e) { }  
    							}		  
}  
  
@SuppressLint("SimpleDateFormat")
	private String getPhotoFileName() {  
	    Date date = new Date(System.currentTimeMillis());  
	    SimpleDateFormat dateFormat = new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss");  
	    return dateFormat.format(date) + ".jpg";  
}  
  
@Override  
protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
    super.onActivityResult(requestCode, resultCode, data);  
    if (requestCode==CAMERA_RESULT) {  
         //Bitmap bitmap = BitmapFactory.decodeFile(mPhotoPath,null);  
         Intent intent1=new Intent(MainActivity.this,LabelActivity.class);
         intent1.putExtra("value", mPhotoPath); 
         //Bundle bundle =new Bundle();
         //bundle.putString(mPhotoPath,"mnt/sdcard/衣服/"+getPhotoFileName());
        /* try {
			intent1.putExtra("name",mPhotoPath.getBytes(mPhotoPath));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
         MainActivity.this.startActivity(intent1); 
    }    
}
}

