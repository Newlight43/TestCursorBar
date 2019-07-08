package fr.smazoyer.testcursorbar;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected TextView mTextView;
    protected TextView mLeftText;
    protected TextView mRightText;
    protected SeekBar mSeekBar;
    float mFadingRatio;
    int mColorSoleValueDark=50;
    int mColorSoleValueBright=200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text_View);
        mSeekBar = (SeekBar) findViewById(R.id.seek_Bar);
        mLeftText = (TextView) findViewById(R.id.textView);
        mRightText = (TextView) findViewById(R.id.textView2);

        mSeekBar.setMax(15);
        mSeekBar.setProgress(0);
        //mSeekBar.setForeground();

        mTextView.setText("0");
        mFadingRatio = (float) mSeekBar.getProgress() / 15.F;
        mRightText.setTextColor(Color.argb(255, (int) (mFadingRatio * mColorSoleValueBright + (1 - mFadingRatio) * mColorSoleValueDark), (int) (mFadingRatio * mColorSoleValueBright + (1 - mFadingRatio) * mColorSoleValueDark), (int) (mFadingRatio * mColorSoleValueBright + (1 - mFadingRatio) * mColorSoleValueDark)));
        mLeftText.setTextColor(Color.argb(255, (int) (mFadingRatio * mColorSoleValueDark + (1 - mFadingRatio) * mColorSoleValueBright), (int) (mFadingRatio * mColorSoleValueDark + (1 - mFadingRatio) * mColorSoleValueBright), (int) (mFadingRatio * mColorSoleValueDark + (1 - mFadingRatio) * mColorSoleValueBright)));

        mSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener());
    }

    class OnSeekBarChangeListener implements SeekBar.OnSeekBarChangeListener{

        @Override
        public void onProgressChanged(SeekBar seekBar, int mProgress, boolean mFromUser){

            mTextView.setText(String.valueOf(seekBar.getProgress()));

            mFadingRatio=seekBar.getProgress()/15.F;
            mRightText.setTextColor(Color.argb(255, (int)(mFadingRatio*mColorSoleValueBright+(1-mFadingRatio)*mColorSoleValueDark), (int)(mFadingRatio*mColorSoleValueBright+(1-mFadingRatio)*mColorSoleValueDark), (int)(mFadingRatio*mColorSoleValueBright+(1-mFadingRatio)*mColorSoleValueDark)));
            mLeftText.setTextColor(Color.argb(255, (int)(mFadingRatio*mColorSoleValueDark+(1-mFadingRatio)*mColorSoleValueBright), (int)(mFadingRatio*mColorSoleValueDark+(1-mFadingRatio)*mColorSoleValueBright), (int)(mFadingRatio*mColorSoleValueDark+(1-mFadingRatio)*mColorSoleValueBright)));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

            mFadingRatio=(float) seekBar.getProgress()/15.F;
            Toast.makeText(getApplicationContext(), "SeekBar progress : "+String.valueOf((int)(mFadingRatio*mColorSoleValueBright+(1-mFadingRatio)*mColorSoleValueDark)), Toast.LENGTH_SHORT).show();

        }
    }

}
