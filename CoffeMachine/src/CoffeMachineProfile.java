public class CoffeMachineProfile {
    final String name;
    final int capsEspresso;
    final int capsCapuchino;
    public CoffeMachineProfile(String name, int capsEspresso, int capsCapuchino){
        this.name = name;
        this.capsCapuchino = capsCapuchino;
        this.capsEspresso = capsEspresso;
    }
    public String getName(){
        return name;
    }
    public int getCapsEspresso(){
        return capsEspresso;
    }
    public int getCapsCapuchino(){
        return capsCapuchino;
    }
}