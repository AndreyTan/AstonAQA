public class Main {
    public static void main(String[] args) {
        printThreeWords(); //1
        printVisualSeparate();
        checkSumSign(); //2
        printVisualSeparate();
        printColor(); //3
        printVisualSeparate();
        compareNumbers(); //4
        printVisualSeparate();

        int a = 7, b = -9;
        System.out.printf("check sum range %d + %d: " + checkSumRange(a,b),a, b); // 5
        printVisualSeparate();

        checkNumSing(-1); // 6
        printVisualSeparate();
        int numNeg = 10;
        System.out.printf("%d " + checkNumNegSing(numNeg),numNeg); // 7
        printVisualSeparate();
        printString("sdff",3); // 8
        printVisualSeparate();

        int year = 1900;
        System.out.printf("Is %d a leap year? " + checkLeapYear(year),year); // 9
        printVisualSeparate();
        replaceAndPrint(); //10
        printVisualSeparate();

        generateNaturalsNumsArray(); //11

        checkAndChange(); //12
        printVisualSeparate();
        generateAndPrintQuadArray(7); //13
        printVisualSeparate();

        createArray(3,2); //14
    }

    private static void printVisualSeparate(){
        System.out.println("\n------------------------");
    }

    private static void printArray(int[] arr){
        for(int n : arr){
            System.out.printf("%d ",n);
        }
    }

    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign(){
        int a = -4;
        int b = 9;
        System.out.println((a+b>=0)?"Сумма положительная":"Сумма отрицательная");
    }

    public static void printColor(){
        int value = 152;
        if(value <= 0)
            System.out.println("красный");
        else if(value <= 100)
            System.out.println("жёлтый");
        else
            System.out.println("зелёный");
    }

    public static void compareNumbers(){
        int a = 5;
        int b = -30;
        System.out.println((a>=b)?"a>=b":"a<b");
    }

    public static boolean checkSumRange(int a, int b){
        return (a+b) > 10 && (a+b) <= 20;
    }

    public static void checkNumSing(int a){
        System.out.println((a>=0)?"Положительное":"Отрицательное");
    }

    public static boolean checkNumNegSing(int a){
        return a < 0;
    }

    public static void replaceAndPrint(){
        int[] arr = {1,1,0,1,0,0,1,0};
        System.out.print("before: ");
        printArray(arr);
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == 0)
                arr[i] = 1;
            else if(arr[i] == 1)
                arr[i] = 0;
        }
        System.out.print("\nafter: ");
        printArray(arr);
    }

    public static void generateNaturalsNumsArray(){
        int[] naturalsHundred = new int[100];

        for(int i = 0;i < naturalsHundred.length;i++){
            naturalsHundred[i] = i + 1;
        }
    }

    public static  void checkAndChange(){
        int[] arr = {1,5,3,2,11,4,5,2,4,8,9,1};
        System.out.print("before: ");
        printArray(arr);
        for(int i = 0;i < arr.length;i++){
            if(arr[i] < 6)
                arr[i] *= 2;
        }
        System.out.print("\nafter: ");
        printArray(arr);
    }


    public static void printString(String str, int count){
        for(int i = 0; i < count;i++){
            System.out.println(str);
        }
    }

    public static boolean checkLeapYear(int year){
        if(year % 100 == 0 && year % 400 != 0)
            return false;
        else if(year % 400 == 0 || year % 4 == 0)
            return true;
        return false;
    }

    public static void generateAndPrintQuadArray(int size){
        int[][] matrix = new int[size][size];


        for (int i = 0; i < matrix.length; i++){
            for(int j=0; j < matrix[i].length; j++){
                if(i == j || j == matrix.length-i-1)
                    matrix[i][j] = 1;
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void createArray(int len, int initialValue){
        int[] arr = new int[len];
        for(int i = 0;i < len;i++){
            arr[i] = initialValue;
        }
    }
}