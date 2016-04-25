package Xuggler.MusalaSoftProject;

import java.util.Comparator;

public class OutgoingCallsComp implements Comparator<Entry>{
	@Override
	public int compare(Entry e1, Entry e2) {
		return e1.getOutgoingCalls()-e2.getOutgoingCalls();
	}
}
