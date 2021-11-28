package com.example.periodbuddy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class DoSomethingMore extends AppCompatActivity {

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    TextView mainMessage;
    Button button;

    TextView T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15;


    String[] S = {
            "Do not blame anything on her period",
            "Don t sit down to discuss menstruation",
            "Avoid telling her anything that can irritate her",
            "Answer questions with care",
            "Be as patient as you can possibly be",
            "Prepare food for her",
            "Watch a movie with her",
            "Don 't act disgusted",
            "Make her feel loved and appreciated",
            "Help her out with things",
            "Be considerate and comforting",
            "Be there for her"
    };

    String[] T = {
            "You may be right about her crankiness. terrible mood swings and bad mood being caused to her period. but NEVER say that out loud! Be sensitive. This is a biological process which affects her behaviour and pointing out her body as the troublemaker will only make things worse! You will end up making her feel blamed for hormonal upheaval. Want to pre-pone your periods? Here's how.",
            "Dear men. a woman perfectly knows what   s going on with her body. So don   t make the mistake of advising her about her condition and behaviour unless you   re a doctor. Once she starts explaining intricate details about what   s going on down there. you will be the one cringing. So. it   s best to avoid the topic altogether.",
            "Your girl may usually be a rational and easygoing person. but when she   s on her period. she may not respond with the same casualness as on a regular day. So before you tell her about your honest opinion on one of her all time favourite movies or casually mention an out of town trip with just the guys. consider telling her about it when she   s no longer as moody. Anything that might suggest the slightest hint of annoyance can turn into full-blown anger when she   s already dealing with hormones. Hence. it   s best to keep the conversation light and soothing. at least until she   s done with her period. Did you know periods could be as painful as heart attacks?",
            "If she is bombarding you with irrational questions which have no definitive answer. think twice before responding. as her reaction may range from a barrage of angry words to even break up threats. Think to yourself. is now a good time to be honest or shall I try to give her the answer she wants? Your chances of surviving the day without conflict will be higher if you let her hear what she wants to hear.",
            "Be compassionate towards her feelings. This state is temporary and she   s going to be back to her great self in a few days. When those unending word-battles ensue. simply keep in mind that you are the one she   s venting out everything to because you are her own and she feels totally at home with you. Muster up all your patience for those days of the month. and try to be some extra nice if possible. Here's how you can deal with those monthly mood swings.",
            "Losing blood and feeling bloated can be pretty exhausting. But it can drain so much of a woman   s energy that she   d be too tired to prepare a meal. One of the best things you can do for her is prepare her favorite food and keep her hydrated. Sometimes women on their period may start to have unusual cravings. Ask her what she would like and get it for her. It will not only make her feel special. but also comfort her thoroughly. All your queries about periods. answered here.",
            "Those period cramps are painful as hell. To distract her from the discomfort. spend some quality time together. Watch her favourite movie and don   t forget the popcorn! Just to be on the safe side. avoid anything too tragic or heavily emotional.",
            "Show her that you are not grossed out by the very thought of her menstrual cycle even if you don't feel comfortable with it at first. If she tries to talk to you about it. do not make faces or say 'go talk to one of your girlfriends   . This will just make her feel like you don't care. Another part of this step is to be willing to run errands for her. Go get her the supplies she is out of. (thinking of sanitary items as \"girl stuff\" is immature and unhelpful) and pick her up some chocolate or her favorite magazine while you are at it! It will make her feel like you really care.",
            "Let her know how happy you are to have her in your life. Tell her she's a great friend. girlfriend. or wife. If she's at work or away from you. call her cellphone. work phone or email them and tell her how beautiful. sweet and all-round awesome she is. It's not even describable how nice it is for a person to do this. Don't go over the top her if she's snappy and irritable from the mood swings. Here are expert tips to exercise during that time of the month.",
            "If she has any little chores or errands to do. help her out. Take the stress off of her by doing the dishes or taking her things down to the laundry. This will help lift some weight from her shoulders and give her time to relax. Keep in mind she may not just have little or chores. Women who work for a living and run a family of kids and pets and everything else have periods too and HAVE to cope. Be considerate. Here are period hygiene tips for every woman.",
            "Do NOT coerce her into getting intimate if you notice even the slightest hint of discomfort. This will not only irritate and upset her. but also showcase you as a selfish individual. Be considerate and respect her feelings. Have her sit down and give her a massage or give her a warm hug. Even a comforting arm rub might make her feel better and will at least show you care.",
            "Hold her when she wants to lean on you. Simply letting her sleep in your arms can make her feel comfortable. Just being there and being sweet makes anyone feel better. Make her realize that you are there for her through thick and thin. Engage in some foreplay to ease her up only if she   s comfortable with it. But if she wants some space and wants to be left alone. give her the privilege. Got your period early? This maybe the reason."
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_something_more);

        T4 = findViewById(R.id.textView4);
        T5 = findViewById(R.id.textView5);
        T6 = findViewById(R.id.textView6);
        T7 = findViewById(R.id.textView7);
        T8 = findViewById(R.id.textView8);
        T9 = findViewById(R.id.textView9);
        T10 = findViewById(R.id.textView10);
        T11 = findViewById(R.id.textView11);
        T12 = findViewById(R.id.textView12);
        T13 = findViewById(R.id.textView13);
        T14 = findViewById(R.id.textView14);
        T15 = findViewById(R.id.textView15);

        TextView[] T = {T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15};

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

    public void TV4(View view) {
        CreateMessage(0);
    }

    public void TV5(View view) {
        CreateMessage(1);
    }

    public void TV6(View view) {
        CreateMessage(2);
    }

    public void TV7(View view) {
        CreateMessage(3);
    }

    public void TV8(View view) {
        CreateMessage(4);
    }

    public void TV9(View view) {
        CreateMessage(5);
    }

    public void TV10(View view) {
        CreateMessage(6);
    }

    public void TV11(View view) {
        CreateMessage(7);
    }

    public void TV12(View view) {
        CreateMessage(8);
    }

    public void TV13(View view) {
        CreateMessage(9);
    }

    public void TV14(View view) {
        CreateMessage(10);
    }

    public void TV15(View view) {
        CreateMessage(11);
    }
}