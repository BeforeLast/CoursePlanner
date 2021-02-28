package classes_13519074;

public class Romans_13519074 {
    // intToRomans : return string of roman number with value of given integer
    // NOTE : the given integer must have value > 0 since roman number doesn't have 0 or negative
    // input :
    //      value : int
    // output : String
    public static String intToRomans(int value){
        StringBuilder roman = new StringBuilder();
        while (value>0){
            if (value>=1000){
                roman.append("M");
                value -= 1000;
            } else if (value>=900){
                roman.append("CM");
                value -= 900;
            } else if (value>=500){
                roman.append("D");
                value -= 500;
            } else if (value>=400){
                roman.append("CD");
                value -= 400;
            } else if (value>=100){
                roman.append("C");
                value -= 100;
            } else if (value>=90){
                roman.append("XC");
                value -= 90;
            } else if (value>=50){
                roman.append("L");
                value -= 50;
            } else if (value>=40){
                roman.append("XL");
                value -= 40;
            } else if (value>=10){
                roman.append("X");
                value -= 10;
            } else if (value>=9){
                roman.append("IX");
                value -= 9;
            } else if (value>=5){
                roman.append("V");
                value -= 5;
            } else if (value>=4){
                roman.append("IV");
                value -= 4;
            } else {
                roman.append("I");
                value -= 1;
            }
        }
        return roman.toString();
    }
}
