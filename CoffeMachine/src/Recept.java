public enum Recept {
    CAPUCHINO("50 миллилитров воды, 20 грамм кофеных зерен, 20 миллилитров молока"),
    ESPRESSO("50 миллилитров воды, 20 грамм кофеных зерен");
    private final String discription;
    Recept(String description){
        this.discription = description;
    }
    public String takeDiscriptions(){
        return discription;
    }
}
