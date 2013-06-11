package com.example.jsonsample;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    try { 
      String json = FileUtils.loadStringFromResource(this, R.raw.sample);
      JSONObject object = new JSONObject(json);
      JSONArray people = object.getJSONArray("people");
      for(int i = 0; i < people.length(); i++) {
        JSONObject person = people.getJSONObject(i);
        Log.e("name", person.getString("name"));
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}











