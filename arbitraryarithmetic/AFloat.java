package arbitraryarithmetic;


public class AFloat {

    String value;

    public AFloat() {
        this.value = "0.0";
    }

    public AFloat(String s) {
        this.value = s;
    }

    public static AFloat parse(String s) {
        return new AFloat(s);
    }

    public AFloat(AFloat obj2) {
        this.value = obj2.value;
    }

    public int compare(String s1, String s2) {
        
    
        if (s1.length() > s2.length()) return 1;
        if (s1.length() < s2.length()) return -1;
    
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i)-'0' > s2.charAt(i)-'0') return 1;
            if (s1.charAt(i)-'0' < s2.charAt(i)-'0') return -1;
        }
        return 0;
    }

    public String add(AFloat obj) {
        int carry = 0;
        int dig1, dig2;
        int index1 = 0, index2 = 0;
        StringBuilder s1 = new StringBuilder(this.value);

        StringBuilder s2 = new StringBuilder(obj.value);

        StringBuilder resultult = new StringBuilder();

        for (int k = 0; k < (this.value.length()); k++) {
            if (this.value.charAt(k) == '.') {
                index1 = k;
                break;
            }
        }
        for (int m = 0; m < (obj.value.length()); m++) {
            if (obj.value.charAt(m) == '.') {
                index2 = m;
                break;
            }
        }
        int len1 = (this.value.length()) - (index1 + 1);
        int len2 = (obj.value.length()) - (index2 + 1);

        if (len1 >= len2) {
            for (int n = 0; n < (len1 - len2); n++) {
                s2.append("0");
            }

        } else {
            for (int n = 0; n < (len2 - len1); n++) {
                s1.append("0");
            }
        }
        if (index1 > index2) {
            for (int n = 0; n < (index1 - index2); n++) {
                s2.insert(0, "0");
            }
        } else if (index2 > index1) {
            for (int n = 0; n < (index2 - index1); n++) {
                s1.insert(0, "0");
            }
        }

        String v1 = s1.toString();
        String v2 = s2.toString();
        int i = v1.length() - 1;
        int j = v2.length() - 1;

        while (i >= 0 || j >= 0) {
            char c1 = (i >= 0) ? v1.charAt(i) : '0';
            char c2 = (j >= 0) ? v2.charAt(j) : '0';

            if (c1 == '.' && c2 == '.') {
                resultult.append('.');
            } else {
                dig1 = (c1 != '.') ? (c1 - '0') : 0;
                dig2 = (c2 != '.') ? (c2 - '0') : 0;

                if (c1 != '.' && c2 != '.') {
                    int sum = dig1 + dig2 + carry;
                    resultult.append(sum % 10);
                    carry = sum / 10;

                }

            }
            i--;
            j--;
        }
        if (carry > 0) {
            resultult.append(carry);
        }
        return resultult.reverse().toString();
    }

    public String subtract(AFloat obj) {
        int borrow = 0;
        int dig1, dig2, diff;
        int index1 = 0, index2 = 0;
        StringBuilder s1 = new StringBuilder(this.value);
        StringBuilder s2 = new StringBuilder(obj.value);
        StringBuilder resultult = new StringBuilder();
    
        for (int k = 0; k < (this.value.length()); k++) {
            if (this.value.charAt(k) == '.') {
                index1 = k;
                break;
            }
        }
        for (int m = 0; m < (obj.value.length()); m++) {
            if (obj.value.charAt(m) == '.') {
                index2 = m;
                break;
            }
        }
    
        int len1 = (this.value.length()) - (index1 + 1);
        int len2 = (obj.value.length()) - (index2 + 1);
    
        if (len1 >= len2) {
            for (int n = 0; n < (len1 - len2); n++) {
                s2.append("0");
            }
        } else {
            for (int n = 0; n < (len2 - len1); n++) {
                s1.append("0");
            }
        }
    
        if (index1 > index2) {
            for (int n = 0; n < (index1 - index2); n++) {
                s2.insert(0, "0");
            }
        } else if (index2 > index1) {
            for (int n = 0; n < (index2 - index1); n++) {
                s1.insert(0, "0");
            }
        }
    
        String v1 = s1.toString();
        String v2 = s2.toString();
        int i = v1.length() - 1;
        int j = v2.length() - 1;
    
        int greater = 0;
        for (int k = 0; k < v1.length(); k++) {
            if ((v1.charAt(k) - '0') > (v2.charAt(k) - '0') && ((v1.charAt(k) != '.') && (v2.charAt(k) != '.'))) {
                greater = 1;
                break;
            } else if ((v1.charAt(k) - '0') < (v2.charAt(k) - '0') && ((v1.charAt(k) != '.') && (v2.charAt(k) != '.'))) {
                greater = 2;
                break;
            }
        }
    
        switch (greater) {
            case 1 -> {
                while (i >= 0 || j >= 0) {
                    char c1 = i >= 0 ? v1.charAt(i) : '0';
                    char c2 = j >= 0 ? v2.charAt(j) : '0';
    
                    if (c1 == '.' && c2 == '.') {
                        resultult.append('.');
                    } else {
                        dig1 = (c1 != '.') ? (c1 - '0') : 0;
                        dig2 = (c2 != '.') ? (c2 - '0') : 0;
    
                        dig1 -= borrow;
    
                        if (dig1 < dig2) {
                            diff = (dig1 + 10) - dig2;
                            borrow = 1;
                        } else {
                            diff = dig1 - dig2;
                            borrow = 0;
                        }
    
                        resultult.append(diff);
                    }
    
                    i--;
                    j--;
                }
            }
            case 2 -> {
                while (i >= 0 || j >= 0) {
                    char c1 = i >= 0 ? v2.charAt(i) : '0';
                    char c2 = j >= 0 ? v1.charAt(j) : '0';
    
                    if (c1 == '.' && c2 == '.') {
                        resultult.append('.');
                    } else {
                        dig1 = (c1 != '.') ? (c1 - '0') : 0;
                        dig2 = (c2 != '.') ? (c2 - '0') : 0;
    
                        dig1 -= borrow;
    
                        if (dig1 < dig2) {
                            diff = (dig1 + 10) - dig2;
                            borrow = 1;
                        } else {
                            diff = dig1 - dig2;
                            borrow = 0;
                        }
    
                        resultult.append(diff);
                    }
    
                    i--;
                    j--;
                }
                resultult.append('-');
            }
            default -> {
                diff = 0;
                resultult.append(diff);
            }
        }
    
        String s = resultult.reverse().toString();
    
        if (s.charAt(0) == '-') {
            s = s.substring(1).replaceFirst("^0+(?!$)", "");
            resultult = new StringBuilder(s);
            resultult.insert(0, '-');
        } else {
            s = s.replaceFirst("^0+(?!$)", "");
            resultult = new StringBuilder(s);
        }
    

        if (resultult.toString().equals("") || resultult.toString().equals("-")) {
            return "0";
        }
    
        return resultult.toString();
    }
    

    public String multiply(AFloat obj){
        String s1=this.value.replace(".", "");
        String s2=obj.value.replace(".","");
        int index1=0,index2=0;
        for (int k = 0; k < (this.value.length()); k++) {
            if (this.value.charAt(k) == '.') {
                index1 = k;
                break;
            }
        }
        for (int m = 0; m < (obj.value.length()); m++) {
            if (obj.value.charAt(m) == '.') {
                index2 = m;
                break;
            }
        }
        int l1=this.value.length()-(index1+1);
        int l2=obj.value.length()-(index2+1);
        Ainteger obj1=Ainteger.parse(s1);
        Ainteger obj2=Ainteger.parse(s2);

        String result=obj1.multiply(obj2);
        
        int Deciplaces=l1+l2;
        result=result.substring(0,result.length()-Deciplaces)+"."+result.substring(result.length()-Deciplaces);
        result=result.contains(".")?result.replaceAll("0+$","").replaceAll("\\.$", ""):result;  
        return result;  

    }
    public String divide(AFloat obj){
        StringBuilder s1=new StringBuilder(this.value);
        StringBuilder s2=new StringBuilder(obj.value);

        if(!s1.toString().contains(".")){
            s1.append(".0");
        }
        if(!s2.toString().contains(".")){
            s2.append(".0");
        }
        
        int index1=0,index2=0;
        for (int k = 0; k < (s1.toString().length()); k++) {
            if (s1.toString().charAt(k) == '.') {
                index1 = k;
                break;
            }
        }
        for (int m = 0; m < (s2.toString().length()); m++) {
            if (s2.toString().charAt(m) == '.') {
                index2 = m;
                break;
            }
        }
        int l1=s1.toString().length()-(index1+1);
        int l2=s2.toString().length()-(index2+1);
        if (l1 >= l2) {
            for (int n = 0; n < (l1 - l2); n++) {
                s2.append("0");
            }
        } else {
            for (int n = 0; n < (l2 - l1); n++) {
                s1.append("0");
            }
        }
        String str1=s1.toString();
        String str2=s2.toString();
        
        str1=str1.replace(".","");
        str2=str2.replace(".","");


        if (str2.charAt(0) - '0' == 0) {
            return "Division by zero error";
        }
        if (((str1.length()) < (str2.length()) || (str1.charAt(0) == '0'))) {
            return "0";
        }
        if (compare(str1, str2) < 0) return "0";
   
        StringBuilder quotient = new StringBuilder();
        String s = "";
        Ainteger o=Ainteger.parse(str2);
        for(int i=0;i<str1.length();i++){
            s=s+str1.charAt(i);
            
            s=s.replaceFirst("^0+(?!$)","");
            int count=0;
            
            
            while (compare(s,str2)>=0) {
                Ainteger curObj = new Ainteger(s);
                s = curObj.subtract(o);
                
                count++;
                
                
            }
            quotient.append(count);
        }
        String result = quotient.toString().replaceFirst("^0+(?!$)", "");
        result= result.isEmpty()?"0":result;
        StringBuilder R=new StringBuilder("");
        
        while(R.toString().length()<30){
            s=s+"0";
            int count2=0;
            s=s.replaceFirst("^0+(?!$)","");
            while (compare(s,str2)>=0) {
                Ainteger curobj = new Ainteger(s);
                s = curobj.subtract(o);
                
                count2++;
           }
           R.append(count2);

        }
        

        

        
        result=result+"."+R.toString(); 
        if(result.contains(".")){
            result=result.replaceAll("0+$","");
            result=result.replaceAll("\\.$","");
        }
        return result; 


    }
}
