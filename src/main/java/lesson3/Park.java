package lesson3;

import java.util.ArrayList;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Objects;

public class Park {
    private ArrayList<Attraction> _attractions;
    private String _titlePark;

    public Park(String title){
        _attractions = new ArrayList<>();
        this._titlePark = Objects.requireNonNullElse(title, "default title park");
    }

    public String getTitle(){
        return _titlePark;
    }

    public void renamePark(String newTitle) {
        if (newTitle != null) {
            if (!newTitle.isBlank()) {
                _titlePark = newTitle;
                return;
            }
        }
        _titlePark = "default title park";
    }

    public void buildNewAttraction(String title,String description,int cost,LocalTime startWork,LocalTime endWork) throws IllegalArgumentException{
        if(cost < 0 || startWork == null || endWork == null)
            throw new IllegalArgumentException("Неправильные данные");
        if(title.isBlank())
            throw new IllegalArgumentException("Некорректное название");

        _attractions.add(new Attraction(title,description,cost,startWork,endWork));
    }

    public void introducePark(){
        System.out.println("park: " + _titlePark);
        System.out.println("----------attractions----------");
        for(Attraction attraction: _attractions){
            if(attraction == null) continue;
            System.out.println("attraction: " + attraction._title);
            System.out.println("description: " + (attraction._description.isBlank() || attraction._description == null?"empty":attraction._description));
            System.out.println("cost: " + attraction._cost);
            System.out.println("start work: " + attraction._startWork);
            System.out.println("end work: " + attraction._endWork);
            System.out.println("----------------------------");
        }
    }

    public HashMap<String,Object> getAttractionInfo(String titleAttraction) throws IllegalArgumentException{
        if(titleAttraction == null || titleAttraction.isBlank())
            throw new IllegalArgumentException("Некорректное название");

        Attraction attraction = null;

        for(Attraction attr: _attractions){
            if(attr._title.equals(titleAttraction)){
                attraction = attr;
                break;
            }
        }
        if(attraction != null){
            HashMap<String,Object> info = new HashMap<>();
            info.put("title",attraction._title);
            info.put("description",attraction._description);
            info.put("cost",attraction._cost);
            info.put("startWork",attraction._startWork);
            info.put("endWork",attraction._endWork);

            return info;
        }

        return null;
    }

    private static class Attraction {
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
