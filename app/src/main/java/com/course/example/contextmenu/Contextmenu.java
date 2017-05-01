package com.course.example.contextmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ImageView;
import android.widget.Toast;

public class Contextmenu extends Activity {

	private ImageView ImView1, ImView2;

	final int PICK1 = Menu.FIRST + 1;
	final int PICK2 = Menu.FIRST + 2;
	final int PICK3 = Menu.FIRST + 3;
	final int PICK4 = Menu.FIRST + 4;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ImView1 = (ImageView) findViewById(R.id.image1);
		ImView1.setImageResource(R.drawable.androidicon);
		ImView2 = (ImageView) findViewById(R.id.image2);
		ImView2.setImageResource(R.drawable.androidicon);

		registerForContextMenu(ImView1);
		registerForContextMenu(ImView2);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		switch (v.getId()) {
		case R.id.image1:
			// add a couple of options to the context menu
			menu.setHeaderTitle("Select Special Action");
			menu.add(0, PICK1, Menu.NONE, "Option-1 ONE ");
			menu.add(0, PICK2, Menu.NONE, "Option-2 TWO ");
			break;

		case R.id.image2: {
			menu.add(1, PICK1, Menu.NONE, "Option-1 ONE ");
			menu.add(1, PICK2, Menu.NONE, "Option-2 TWO ");
			menu.add(1, PICK3, Menu.NONE, "Option-3 THREE ");
			menu.add(1, PICK4, Menu.NONE, "Option-4 FOUR ");
			break;
		}

		}
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		super.onContextItemSelected(item);
		String title = item.getTitle().toString(); // get menu item title
		int itemId = item.getItemId(); // get menu item id
		switch (item.getGroupId()) {

		case 0:

			Toast.makeText(this, "Menu 1 " + title + " " + itemId,
					Toast.LENGTH_LONG).show();
			break;
		case 1:

			Toast.makeText(this, "Menu 2 " + title + " " + itemId,
					Toast.LENGTH_LONG).show();
			break;
		}
		return false;
	}
}