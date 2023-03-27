package NIM.Mian;

public class judge implements Ijudge {
    public int step;
    private String name;

    public judge(String name) {
        this.name=name;
    }


    @Override
    public String getName() {

        return this.name;
    }

    @Override
    public int step() {
        return step;
    }


    public int setStep(int step){
        if(step>=1){
            this.step =step;
        }else{
            this.step =0;
        }
        return step;
    }
    public int getStep(){
        if (setStep(step)== 0){
        getStep();
        }else{
            this.step = step;
        }
        return step;
    }
}
