package ko.alex.bedbugko;

import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Bot1Frag extends Fragment {

    TextView countdownText;
    FloatingActionButton countdownFAB, submitDataFAB;

    CountDownTimer countDownTimer;
    long timeLeftMilliseconds = 300000; // 5 mins
    boolean timerRunning;

    ProgressBar progressBar;

    public Bot1Frag(){
        // Required empty public constructor
        //Working with RecyclerView
        //https://www.androidhive.info/2016/01/android-working-with-recycler-view/

        //Custom alert dialog
        //https://www.youtube.com/watch?v=plnLs6aST1M

        //Working with Firebase and Recyclerview
        //https://www.youtube.com/watch?v=kyGVgrLG3KU&list=LLj1xIyoM3IcZs9XdwFDaJWA&index=3&t=0s

        //Simple Countdown Timer
        //https://www.youtube.com/watch?v=zmjfAcnosS0
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.bot1frag, container, false);

        progressBar = view.findViewById(R.id.progressBar);

        submitDataFAB = view.findViewById(R.id.submitDataFAB);
        submitDataFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Data Submitted!", Toast.LENGTH_SHORT).show();
            }
        });

        countdownText = view.findViewById(R.id.countdownText);
        countdownFAB = view.findViewById(R.id.countdownFAB);
        countdownFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(timerRunning == true){
                    countDownTimer.cancel();
                    countdownFAB.setImageDrawable(getResources().getDrawable(R.drawable.playicon));
                    timerRunning = false;
                } else{
                    countDownTimer = new CountDownTimer(timeLeftMilliseconds, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            timeLeftMilliseconds = millisUntilFinished;
                            updateTimer();
                        }

                        @Override
                        public void onFinish() {
                            //something something
                        }
                    }.start();
                    countdownFAB.setImageDrawable(getResources().getDrawable(R.drawable.pauseicon));
                    timerRunning = true;
                }
            }
        });

        return view;
    } //END ONCREATEVIEW

    public void updateTimer(){
        //http://www.androidtutorialshub.com/android-count-down-timer-tutorial/
        int minutes = (int) (timeLeftMilliseconds/60000); // Divide by 60 seconds
        int seconds = (int) (timeLeftMilliseconds % 60000 / 1000);
        String timeLeftText;
        timeLeftText = "" + minutes;
        timeLeftText += ":";
        if(seconds < 10) timeLeftText += "0";
        timeLeftText += seconds;
        countdownText.setText(timeLeftText);

        float timeRemaining = ((minutes*60f + seconds) / 300f)*100f;
        int intTimeRemaining = Math.round(timeRemaining);
        Toast toast = Toast.makeText(getActivity(), "Time remaining is: " + timeRemaining + " seconds", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.RIGHT, 0, 0);
        toast.show();
        progressBar.setProgress(intTimeRemaining);
    }

} //END BOT1FRAG
