package netology.training;

public class JvmComprehension { //jvm обнаруживает класс и запускает ClassLoader. Выполняется инициализация static полей, но в данном случае не требуется т.к. их нет
    public static void main(String[] args) { //создаётся frame в  stack memory
        int i = 1;                      // 1 //в frame добавляется переменная со своим значением
        Object o = new Object();        // 2 // Запускается classLoader, в heap создаётся обьект и в frame добавляется ссылка на обьект
        Integer ii = 2;                 // 3 // Запускается classLoader, в heap добавляется обьект подгруженного класса, в frame добавляется ссылка на созданный обьект
        printAll(o, i, ii);             // 4 // в стеке создаётся новый frame для метода
        System.out.println("finished"); // 7 // создаётся новый frame под метод print, создаётся обьект String в heap,  в новый frame передаётся ссылка на новый  String.
    }

    private static void printAll(Object o, int i, Integer ii) { //в heap создаются переданные в метод обьекты, в созданный на шаге 4 новый frame добавляются ссылки на переданные обьекты.
        Integer uselessVar = 700;                   // 5 // в heap добавляется обьект, в frame добавляется ссылка на созданный обьект
        System.out.println(o.toString() + i + ii);  // 6 // создаются два новых фрейма. один - для метода обьекта o, который сгенерирует обьект в heap и передаст ссылку на него во второй frame, который создан для метода print вместе со ссылками а обьекты остальных параметров.
    }
}