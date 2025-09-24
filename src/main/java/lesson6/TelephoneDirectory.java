package lesson6;

import java.util.HashMap;
import java.util.Map;

public class TelephoneDirectory {
    private HashMap<String, String> _subscribers;

    public TelephoneDirectory() {
        _subscribers = new HashMap<>(6);
        _subscribers.put("3756451256823", "Miller");
        _subscribers.put("3758631214845", "James");
        _subscribers.put("3751241289012", "Patterson");
        _subscribers.put("3758901213467", "Moore");
        _subscribers.put("3751641234790", "James");
        _subscribers.put("3754361217447", "Wood");
    }

    public void add(String phone, String lastName) {
        _subscribers.put(phone, lastName);
    }

    public void get(String lastName) {
        for (Map.Entry<String, String> hum : _subscribers.entrySet()) {
            if (hum.getValue().equals(lastName))
                System.out.println(hum.getKey());
        }
    }

}
