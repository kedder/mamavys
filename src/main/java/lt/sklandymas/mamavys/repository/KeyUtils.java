package lt.sklandymas.mamavys.repository;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public class KeyUtils {
	public static String keyToString(Key key) {
		return KeyFactory.keyToString(key);
	}
	
	public static Key stringToKey(String key) {
		return KeyFactory.stringToKey(key);
	}
}
