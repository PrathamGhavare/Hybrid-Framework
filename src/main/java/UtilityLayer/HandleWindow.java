package UtilityLayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import BaseLayer.BaseClass;

public class HandleWindow extends BaseClass {

	public static void hanandleWindowOrTab(int windowNumber) {
		Set<String> listnumber = getDriver().getWindowHandles();
		ArrayList<String> arrayList = new ArrayList<String>();
		Iterator<String> it = listnumber.iterator();
		while (it.hasNext()) {
			String windowId = it.next();
			arrayList.add(windowId);
		}
		String window = arrayList.get(windowNumber);
		getDriver().switchTo().window(window);
	}

	public static void handleWindowORTab(int windowNumber) {
		Iterator<String> it = getDriver().getWindowHandles().iterator();
		ArrayList<String> arraylist = new ArrayList<String>();
		while (it.hasNext()) {
			arraylist.add(it.next());
		}
		getDriver().switchTo().window(arraylist.get(windowNumber));
	}
}
