package lesson6;

import java.util.HashMap;
import java.util.Map;

public class TelephoneDirectory {
    private HashMap<String, String> subscribers;

    public TelephoneDirectory() {
        this.subscribers = new HashMap<>(6);
        this.subscribers.put("3756451256823", "Miller");
        this.subscribers.put("3758631214845", "James");
        this.subscribers.put("3751241289012", "Patterson");
        this.subscribers.put("3758901213467", "Moore");
        this.subscribers.put("3751641234790", "James");
        this.subscribers.put("3754361217447", "Wood");
    }

    public void add(String phone, String lastName) {
        this.subscribers.put(phone, lastName);
    }

    public void get(String lastName) {
        System.out.printf("номера по фамилии %s:\n", lastName);
        for (Map.Entry<String, String> hum : this.subscribers.entrySet()) {
            if (hum.getValue().equals(lastName))
                System.out.println(hum.getKey());
        }
        System.out.println("--------------------");
    }

}
