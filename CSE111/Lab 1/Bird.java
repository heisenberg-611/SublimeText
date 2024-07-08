public class Bird {
    public String name;
    public int Up;

    public void flyUp(int a) {
        Up = a;
        System.out.println(name + " has flown up " + Up + " feet.");
    }

    public void makeNoise(){
        if(name.equals("Parrot")){
            System.out.println("Squawk");
        }
        if(name.equals("Eagle")){
            System.out.println("Squee");
        }
    }

    public void flyDown(int a) {
        if (a>Up) {
            System.out.println(name + " cannot fly down " + a + " feet.");
        }
        else if(a<Up){
            System.out.println(name + " has flown down " + a + " feet.");
            Up -= a;
        }
        if(Up == a){
            System.out.println(name+" has flown down "+a+" feet and landed.");
        }
    }
}
