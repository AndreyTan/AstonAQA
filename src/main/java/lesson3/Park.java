package lesson3;

import java.util.ArrayList;
import java.time.LocalTime;

public class Park {
    private ArrayList<Attraction> _attractions;
    private String _titlePark;

    public Park(String title){
        _attractions = new ArrayList<Attraction>();
        this._titlePark = title;
    }

    public void buildNewAttraction(String title,String description,int cost,LocalTime startWork,LocalTime endWork){
        if(title.isBlank() || cost < 0 || startWork == null || endWork == null) return;

        _attractions.add(new Attraction(title,description,cost,startWork,endWork));
    }

    public void introducePark(){
        System.out.println("park: " + _titlePark);
        System.out.println("----------attractions----------");
        for(Attraction attraction: _attractions){
            if(attraction == null) continue;
            System.out.println("attraction: " + attraction._title);
            System.out.println("description: " + (attraction._description.isBlank()?"empty":attraction._description));
            System.out.println("cost: " + attraction._cost);
            System.out.println("start work: " + attraction._startWork);
            System.out.println("end work: " + attraction._endWork);
            System.out.println("----------------------------");
        }
    }

    private class Attraction {
        private String _title;
        private String _description;
        private int _cost;
        private LocalTime _startWork;
        private LocalTime _endWork;

        public Attraction(String title,String description,int cost,LocalTime startWork,LocalTime endWork){
            this._title =  title;
            this._description = description;
            this._cost = cost;
            this._startWork = startWork;
            this._endWork = endWork;
        }
    }
}
