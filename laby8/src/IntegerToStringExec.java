public class IntegerToStringExec implements exec<Integer,String>{
    
    StringBuffer line = new StringBuffer();

    @Override
    public void execute(Integer elem) {
        line.append(elem + ", ");
    }

    public void lineNoMore(){
        line.delete(0, line.length());
    }

    @Override
    public String getResult() {
        line.delete(line.length()-2, line.length());
        return line.toString();
    }

}
