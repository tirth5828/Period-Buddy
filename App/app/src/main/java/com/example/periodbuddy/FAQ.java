package com.example.periodbuddy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FAQ extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    TextView mainMessage;
    Button button;

    TextView T16,T17,T18,T19,T20,T21,T22,T23;


    String[] S = {
            "Emotional and behavioral signs and symptoms",
            "Physical signs and symptoms",
            "What can I do about cramps? ",
            "Should I use a pad, tampon, or menstrual cup?",
            "Why is menstrual hygiene important?",
            "What is Menstrual Hygiene Management (MHM) ",
            "Steps for menstrual hygiene",
            "When to contact doctors",

    };

    String[] T = {
            "Tension or anxiety\n" +
                    "Depressed mood\n" +
                    "Crying spells\n" +
                    "Mood swings and irritability or anger\n" +
                    "Appetite changes and food cravings\n" +
                    "Trouble falling asleep (insomnia)\n" +
                    "Social withdrawal\n" +
                    "Poor concentration\n" +
                    "Change in libido\n",
            "Joint or muscle pain\n" +
                    "Headache\n" +
                    "Fatigue\n" +
                    "Weight gain related to fluid retention\n" +
                    "Abdominal bloating\n" +
                    "Breast tenderness\n" +
                    "Acne flare-ups\n" +
                    "Constipation or diarrhea\n" +
                    "Alcohol intolerance\n",
            "During the menstrual cycle, your uterus helps expel its lining. A warm heating bag over your belly or taking ibuprofen can help.",
            "You have many choices about how to deal with period blood. You may need to experiment a bit to find which works best for you. Some girls use only one method and others switch between different methods.",
            "Poor menstrual hygiene can pose physical health risks and has been linked to reproductive and urinary tract infections.",
            "Women and adolescent girls are using clean menstrual management materials to absorb or collect blood that can be changed in privacy as often as necessary for the duration of the menstruation period, using soap and water for washing the body as required, and having access to facilities to dispose of used menstrual management materials",
            "Change your sanitary napkin every 4-6 hours\nWash properly\nDon't use soaps or vagina hygiene products\nDiscard the sanitary napkin properly\n Stick to one method of sanitation",
            "are 15 and haven't started your period have had your period for more than 2 years and it still doesn't come regularly (about every 4–5 weeks) have bleeding between periods have severe cramps that don't get better with ibuprofen or naproxen have very heavy bleeding (bleeding that goes through a pad or tampon faster than every 1 hour) have periods that last more than about a week have severe PMS that gets in the way of your everyday activities"
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);


        T16 = findViewById(R.id.textView16);
        T17 = findViewById(R.id.textView17);
        T18 = findViewById(R.id.textView18);
        T19 = findViewById(R.id.textView19);
        T20 = findViewById(R.id.textView20);
        T21 = findViewById(R.id.textView21);
        T22 = findViewById(R.id.textView22);
        T23 = findViewById(R.id.textView23);


        TextView[] T = {T16,T17,T18,T19,T20,T21,T22,T23};

        int i=0;
        for(TextView A : T){
            A.setText(S[i]);
            i++;
        }
    }

    public void CreateMessage(int a){
        dialogBuilder = new AlertDialog.Builder(this);
        final View messagePopupView = getLayoutInflater().inflate(R.layout.popup,null);
        mainMessage = (TextView) messagePopupView.findViewById(R.id.textView16);
        mainMessage.setText(T[a]);

        dialogBuilder.setView(messagePopupView);
        dialog = dialogBuilder.create();
        dialog.show();
    }

    public void TV16(View view) {
        CreateMessage(0);
    }

    public void TV17(View view) {
        CreateMessage(1);
    }

    public void TV18(View view) {
        CreateMessage(2);
    }

    public void TV19(View view) {
        CreateMessage(3);
    }

    public void TV20(View view) {
        CreateMessage(4);
    }

    public void TV21(View view) {
        CreateMessage(5);
    }

    public void TV22(View view) {
        CreateMessage(6);
    }

    public void TV23(View view) {
        CreateMessage(7);
    }
}