package code.bloomberg;

public class IntegerToRoman {

    class Numeral{
        public String symbol;
        public int value;
        Numeral(String symbol,int value){
            this.symbol = symbol;
            this.value = value;
        }
    }
    public Numeral numerals[] = {
            new Numeral("M",1000),
            new Numeral("CM",900),
            new Numeral("D",500),
            new Numeral("CD",400),
            new Numeral("C",100),
            new Numeral("XC",90),
            new Numeral("L",50),
            new Numeral("XL",40),
            new Numeral("X",10),
            new Numeral("IX",9),
            new Numeral("V",5),
            new Numeral("IV",4),
            new Numeral("I",1)
    };

    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();

        while(num!=0){

            for(int i=0;i<numerals.length;i++){

                if(num>=numerals[i].value){

                    int digit = num/numerals[i].value;
                    num = num % numerals[i].value;

                    while(digit!=0){
                        sb.append(numerals[i].symbol);
                        digit--;
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String args[]){

        IntegerToRoman obj = new IntegerToRoman();

        System.out.println(obj.intToRoman(2345));
    }
}
