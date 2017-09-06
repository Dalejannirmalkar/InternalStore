package app.abhijeet.mrdhwaj.internalstore;

import android.content.Context;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
EditText editText;
    Button save,get;
    TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= (EditText) findViewById(R.id.message);
        save= (Button) findViewById(R.id.save);
        get= (Button) findViewById(R.id.get);
        show= (TextView) findViewById(R.id.showdata);
    }
    public void savedata(View view){
        String Message=editText.getText().toString();
        String file_name="hello";
        try {
            FileOutputStream fileOutputStream=openFileOutput(file_name, Context.MODE_PRIVATE);
            fileOutputStream.write(Message.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Showdataitem(View view){
        String message="";
        try {
            FileInputStream fileInputStream=openFileInput("hello");
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer=new StringBuffer();
            while ((message=bufferedReader.readLine())!=null){
                stringBuffer.append(message);
            }
            show.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
