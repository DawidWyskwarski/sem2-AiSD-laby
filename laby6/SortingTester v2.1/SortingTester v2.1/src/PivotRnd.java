import java.util.Random;

public class PivotRnd extends PivotFirst{
    
    public PivotRnd(){
    }

    @Override
    public int choosePivot(int l, int r) {
        Random random = new Random();
        return l + random.nextInt(r-l);
    }

}
