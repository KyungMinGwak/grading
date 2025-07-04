package com.cookandroid.finalexam_2022158056;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("명화 선호도 투표");

        final int[] voteCount = new int[9];
        for(int i=0; i<voteCount.length;i++){
            voteCount[i] =0;
        }
        ImageView[] image = new ImageView[9];
        Integer imageID[] = {R.id.iv1,R.id.iv2,R.id.iv3,R.id.iv4,R.id.iv5,
                R.id.iv6,R.id.iv7,R.id.iv8,R.id.iv9};
        String[] imgName = {"독서하는 소년","꽃장식 모자 소년","부재를 든 소년",
                "이레느깡 단 베루양","잠자는 소년","데라스의 두 자매",
                "피아노 레슨","피아노 앞에 소년들","해변에서"};

        for (int i=0; i<imageID.length;i++){
            final int index;
            index = i;
            image[index] = (ImageView) findViewById(imageID[i]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(MainActivity.this, imgName[index]+": 총"+
                            voteCount[index]+"표", Toast.LENGTH_SHORT).show();
                }
            });
        }
        btnResult = (Button) findViewById(R.id.btnResult);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                intent.putExtra("VoteCount", voteCount);
                intent.putExtra("ImageName", imgName);
                startActivity(intent);
            }
        });

    }
}