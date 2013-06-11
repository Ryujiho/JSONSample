package com.example.jsonsample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import android.content.Context;
import android.os.Environment;

public class FileUtils {
  private static String loadStringFromInputStream(InputStream inputStream) {
    BufferedReader br = null;
    String result = null;
    try {
      InputStreamReader isr = new InputStreamReader(inputStream);
      br = new BufferedReader(isr);
      String line = null;
      StringBuffer sb = new StringBuffer();
      while((line = br.readLine()) != null) {
        sb.append(line);
      } 
      result = sb.toString();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      try { br.close(); } catch(Exception e) { e.printStackTrace(); }
    }
    return result;
  }
  
  private static void saveStringToOutputStream(OutputStream outputStream, String data) {
    OutputStreamWriter osw = null;
    try {
      osw = new OutputStreamWriter(outputStream);
      osw.write(data);
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      try {
        osw.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
  
  public static String loadStringFromLocalStorage(Context context, String filename) {
    try {
      InputStream in = context.openFileInput(filename);
      return loadStringFromInputStream(in);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return null; 
  }
  
  public static void saveStringToLocalStorage(Context context, String filename, String data) {
    try {
      OutputStream outputStream = context.openFileOutput(filename, context.MODE_PRIVATE);
      saveStringToOutputStream(outputStream, data);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
  public static String loadStringFromSDCard(Context context, String filename) {
    try {
      File sdfile = Environment.getExternalStorageDirectory();
      File file = new File(sdfile, filename);
      InputStream in = new FileInputStream(file);
      return loadStringFromInputStream(in);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
  public static void saveStringToSDCard(Context context, String filename,
                                 String data) {
    try {
      File sdfile = Environment.getExternalStorageDirectory();
      File file = new File(sdfile, filename);
      OutputStream outputStream = new FileOutputStream(file);
      saveStringToOutputStream(outputStream, data);
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  public static String loadStringFromResource(Context context, int resourceId) {
    InputStream in = context.getResources().openRawResource(resourceId);
    return loadStringFromInputStream(in);
  }
}








