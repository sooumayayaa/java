class Player {
    String name;
    @SuppressWarnings("unused")
    int age;
    @SuppressWarnings("unused")
    String position;

    public Player(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public void play() {
        System.out.println(name + " is playing.");
    }

    public void train() {
        System.out.println(name + " is training.");
    }
}

class Cricket_Player extends Player {
    public Cricket_Player(String name, int age, String position) {
        super(name, age, position);
    }

    @Override
    public void play() {
        System.out.println(name + " is batting or bowling.");
    }
}

class Football_Player extends Player {
    public Football_Player(String name, int age, String position) {
        super(name, age, position);
    }

    @Override
    public void play() {
        System.out.println(name + " is dribbling and shooting.");
    }
}

class Hockey_Player extends Player {
    public Hockey_Player(String name, int age, String position) {
        super(name, age, position);
    }

    @Override
    public void play() {
        System.out.println(name + " is handling the puck.");
    }
}

public class PlayerDemo {
    public static void main(String[] args) {
        Cricket_Player cp = new Cricket_Player("Virat", 34, "Batsman");
        Football_Player fp = new Football_Player("Messi", 36, "Forward");
        Hockey_Player hp = new Hockey_Player("Dhyan", 28, "Midfielder");

        cp.play();
        cp.train();

        fp.play();
        fp.train();

        hp.play();
        hp.train();
    }
}
