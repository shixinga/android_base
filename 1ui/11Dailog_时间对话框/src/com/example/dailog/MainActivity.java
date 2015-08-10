package com.example.dailog;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button dateBn = (Button) findViewById(R.id.dateBn);
		Button timeBn = (Button) findViewById(R.id.timeBn);
		// Ϊ���������ڡ���ť�󶨼�������
		dateBn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View source) {
				Calendar c = Calendar.getInstance();
				// ֱ�Ӵ���һ��DatePickerDialog�Ի���ʵ������������ʾ����
				new DatePickerDialog(MainActivity.this,
				// �󶨼�����
						new DatePickerDialog.OnDateSetListener() {
							@Override
							public void onDateSet(DatePicker dp, int year,
									int month, int dayOfMonth) {
								EditText show = (EditText) findViewById(R.id.show);
								show.setText("��ѡ���ˣ�" + year + "��" + month + "��"
										+ dayOfMonth + "��");
							}
						}
						// ���ó�ʼ����
						, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c
								.get(Calendar.DAY_OF_MONTH)).show();
			}
		});
		// Ϊ������ʱ�䡱��ť�󶨼�������
		timeBn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View source) {
				Calendar c = Calendar.getInstance();
				// ����һ��TimePickerDialogʵ������������ʾ������
				new TimePickerDialog(MainActivity.this,
				// �󶨼�����
						new TimePickerDialog.OnTimeSetListener() {
							@Override
							public void onTimeSet(TimePicker tp, int hourOfDay,
									int minute) {
								EditText show = (EditText) findViewById(R.id.show);
								show.setText("��ѡ���ˣ�" + hourOfDay + "ʱ" + minute
										+ "��");
							}
						}
						// ���ó�ʼʱ��
						, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE)
						// true��ʾ����24Сʱ��
						, true).show();
			}
		});
	}
}
