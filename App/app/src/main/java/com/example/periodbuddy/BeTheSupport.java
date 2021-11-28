package com.example.periodbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;



public class BeTheSupport extends AppCompatActivity {

    String[] messages = {"You are the most beautiful girl I’ve ever known.",
            "My thoughts and prayers are with you every second, sweetheart.",
            "I love you through thick and thin, during ups and downs, and forever and beyond.",
            "I am right here for whatever you need, my love.",
            "I am on my way to bring you your favorite sweets and ice cream, baby. ",
            "I miss you, love you, and care about you deeply. ",
            "You are the strongest woman I know, and you amaze me every day.",
            "I cannot even imagine what you are going through, sweetie. I’m sorry you are in pain.",
            "I am thinking of you and praying for strength as you go through this pain and discomfort.",
            "I am here for you whenever you need me for anything that comes up.",
            "I am here to listen to you - whatever you want to talk about, my love.",
            "I know you will persevere through these cramps and pain because you are amazing."};

    TextView Message;
    ImageView I1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_be_the_support);

        Message = findViewById(R.id.textView3);
        I1 = findViewById(R.id.imageView2);

        //I1.setImageDrawable(getDrawable(R.drawable.red));
    }

    public void Message(View view) {
        Random random = new Random();
        int x = random.nextInt(messages.length);
        Message.setText(messages[x]);

    }

    public void Send(View view) {
        String message
                = Message
                .getText()
                .toString();
        sendMessage(message);
    }


    private void sendMessage(String message)
    {

        Intent intent
                = new Intent(
                Intent.ACTION_SEND);

        intent.setType("text/plain");
        intent.setPackage("com.whatsapp");

        intent.putExtra(
                Intent.EXTRA_TEXT,
                message);

        if (intent
                .resolveActivity(
                        getPackageManager())
                == null) {
            Toast.makeText(
                    this,
                    "Please install whatsapp first.",
                    Toast.LENGTH_SHORT)
                    .show();
            return;
        }
        startActivity(intent);
    }

    public void SomethingMore(View view) {
        startActivity(new Intent(BeTheSupport.this,DoSomethingMore.class));

    }
}