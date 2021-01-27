package com.fjbg.circularreveal.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.fjbg.circularreveal.ui.CircularRevealApp
import com.fjbg.circularreveal.ui.view.mainView

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			CircularRevealApp(
				content = mainView()
			)
		}
	}
}