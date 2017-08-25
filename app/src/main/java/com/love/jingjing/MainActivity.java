package com.love.jingjing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.timessquare.CalendarPickerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    CalendarPickerView calendar;

    static {
        System.loadLibrary("native-lib");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.MONTH, 2);

        calendar = (CalendarPickerView) findViewById(R.id.calendar_view);
        Date today = new Date();


        calendar.init(today, nextYear.getTime()).withSelectedDate(today).withHighlightedDate(today);

        calendar.setOnInvalidDateSelectedListener(new CalendarPickerView.OnInvalidDateSelectedListener() {
            @Override
            public void onInvalidDateSelected(Date date) {
                Toast.makeText(MainActivity.this, "这个是无效的", Toast.LENGTH_SHORT).show();
            }
        });




//        calendar.setCustomDayView(new DayViewAdapter() {
//            @Override
//            public void makeCellView(CalendarCellView parent) {
//
//                View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.day_loyout, null);
//                parent.addView(layout);
//                parent.setDayOfMonthTextView((TextView) layout.findViewById(R.id.day_view));
//
//            }
//        });

        calendar.setCellClickInterceptor(new CalendarPickerView.CellClickInterceptor() {
            @Override
            public boolean onCellClicked(Date date) {

                //   Toast.makeText(MainActivity.this, date.toString(), Toast.LENGTH_SHORT).show();

                return false;
            }
        });

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();


    private void initFiler() {
        /**
         * key--type_flag          key--option_flag
         *
         * Object 选中的值
         *
         */
        Map<String, Map<String, List<LocalOptionsResEntity>>> filterMap = new HashMap<>();


        Map<String, List<LocalOptionsResEntity>> filter = new HashMap<>();
        List<LocalOptionsResEntity> entities = new ArrayList<>();
        filter.put("aa", entities);
        filterMap.put("AA", filter);


        Student s1 = new Student();
        s1.setAge(20);
        s1.setName("lee");

        Student s2 = (Student) s1.clone();

        s2.setName("lixinxin");
        s2.setAge(11);


        Log.e("lee", "s1" + s1.toString());
        Log.e("lee", "s2" + s2.toString());


        tv.setText(s1.toString() + "--" + s2.toString());
    }


}
