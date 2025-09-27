package lesson4.animals.organism.musculoskeletalSystem;

import lesson4.animals.organism.stomach.IStomachObserver;

public class NormalMusculoskeletalSystem implements IMusculoskeletalSystem, IStomachObserver {
    private int _glycogen;
    private int _maxGlycogen;
    private int _spendGlycogenByRun;
    private int _spendGlycogenBySwim;

    public NormalMusculoskeletalSystem(int maxGlycogen, int spendGlycogenByRun, int spendGlycogenBySwim) {
        this._maxGlycogen = maxGlycogen > 0 ? maxGlycogen : 100;
        this._spendGlycogenByRun = spendGlycogenByRun > 0 ? spendGlycogenByRun : 1;
        this._spendGlycogenBySwim = spendGlycogenBySwim > 0 ? spendGlycogenBySwim : 1;
    }

    @Override
    public void tryToRun(int distance) {
        if (distance > 0) {
            if (_glycogen > 0) {
                if (_glycogen >= distance * _spendGlycogenByRun) {
                    _glycogen -= distance * _spendGlycogenByRun;
                    System.out.printf("Бежим %d ед. дистанции,потратили %d энергии\n", distance, distance * _spendGlycogenByRun);
                } else {
                    System.out.printf("Нет столько энергии, но можем пробежать %d ед. дистанции,потратили всю энергию\n", _glycogen / _spendGlycogenByRun);
                    _glycogen = 0;
                }
            } else {
                System.out.println("Никуда не бежим, нет энергии");
            }
        } else if (distance == 0) {
            System.out.println("Стоим и не бежим");
        }
    }

    @Override
    public void tryToSwim(int distance) {
        if (distance > 0) {
            if (_glycogen > 0) {
                if (_glycogen >= distance * _spendGlycogenBySwim) {
                    _glycogen -= distance * _spendGlycogenBySwim;
                    System.out.printf("Плывём %d ед. дистанции,потратили %d энергии\n", distance, distance * _spendGlycogenBySwim);
                } else {
                    System.out.printf("Нет столько энергии, но можем проплыть %d ед. дистанции,потратили всю энергию\n", _glycogen / _spendGlycogenBySwim);
                    _glycogen = 0;
                }
            } else {
                System.out.println("Не можем поплавать, нет энергии");
            }
        } else if (distance == 0) {
            System.out.println("Не плывём");
        }
    }

    @Override
    public void updateNewFood(int countNewGlucose) {
        if (_glycogen + countNewGlucose / 2 <= _maxGlycogen)
            _glycogen += countNewGlucose / 2;
        else
            _glycogen = _maxGlycogen;
        System.out.printf("Получили энергию,теперь энергии:[%d/%d]\n",_glycogen,_maxGlycogen);
    }

}
