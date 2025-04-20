package functionalprogrammimg;

public interface TestRunner {

    public static void main(String[] args) {

        // IPrintable objPrint = new HPprintImpl();

        // objPrint.print();


        IPrintable obj = new IPrintable() {
            @Override

            public void print(){

                System.out.println("anonmus calling ...");

            }

        };
        obj.print();

        
    }
    
}
