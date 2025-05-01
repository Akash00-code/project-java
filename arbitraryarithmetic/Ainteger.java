package arbitraryarithmetic;

public class Ainteger {

    String value;

    public Ainteger() {
        this.value = "0";
    }

    public Ainteger(String s) {
        this.value = s;
    }

    public static Ainteger parse(String s) {
        return new Ainteger(s);
    }

    public Ainteger(Ainteger obj2) {
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
    

    public String add(Ainteger obj) {
        int carry = 0;
        int i = (this.value.length()) - 1;
        int j = (obj.value.length()) - 1;
        int dig1, dig2;
        StringBuilder result = new StringBuilder();

        while (i >= 0 || j >= 0 || carry != 0) {
            if (i < 0) {
                dig1 = 0;
            } else {
                dig1 = this.value.charAt(i) - '0';
            }
            if (j < 0) {
                dig2 = 0;
            } else {
                dig2 = obj.value.charAt(j) - '0';
            }

            int sum = dig1 + dig2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;

        }
        return result.reverse().toString();
    }

    public String subtract(Ainteger obj) {
        int i = (this.value.length()) - 1;
        int j = (obj.value.length()) - 1;
        StringBuilder result = new StringBuilder();
        int dig1, dig2, greater = 0, diff, borrow = 0;
        if ((i + 1) == (j + 1)) {
            for (int k = 0; k < (i + 1); k++) {
                if ((this.value.charAt(k) - '0') > (obj.value.charAt(k) - '0')) {
                    greater = 1;
                    break;
                } else if ((this.value.charAt(k)) - '0' < (obj.value.charAt(k) - '0')) {
                    greater = 2;
                    break;
                }

            }
            switch (greater) {
                case 1 -> {
                    while (i >= 0 || j >= 0) {

                        if ((this.value.charAt(i) - '0') < (obj.value.charAt(j) - '0')) {
                            diff = (((this.value.charAt(i) - '0') - borrow) + 10) - (obj.value.charAt(j) - '0');
                            borrow = 1;
                            result.append(diff);
                        } else if((this.value.charAt(i) - '0') > (obj.value.charAt(j) - '0')) {
                            diff = (((this.value.charAt(i)) - '0') - borrow) - (obj.value.charAt(j) - '0');
                            result.append(diff);
                            borrow = 0;
                        }else{
                            if(borrow==1){
                                diff=(((this.value.charAt(j)-'0')-1)+10)-(obj.value.charAt(i)-'0');
                                borrow=1;
                                result.append(diff);
                            }else{
                                diff=(this.value.charAt(i)-'0')-(obj.value.charAt(j)-'0');
                                result.append(diff);
                                borrow=0;
        
                            }
                        }

                        i--;
                        j--;

                    }
                }
                case 2 -> {
                    while (i >= 0 || j >= 0) {

                        if ((this.value.charAt(i) - '0') > (obj.value.charAt(j) - '0')) {
                            diff = (((obj.value.charAt(j) - '0') - borrow) + 10) - (this.value.charAt(i) - '0');
                            borrow = 1;
                            result.append(diff);
                        } else if((this.value.charAt(i) - '0') < (obj.value.charAt(j) - '0')){
                            diff = ((obj.value.charAt(j) - '0') - borrow) - (this.value.charAt(i) - '0');
                            result.append(diff);
                            borrow = 0;
                        }else{
                            if(borrow==1){
                                diff=(((obj.value.charAt(j)-'0')-1)+10)-(this.value.charAt(i)-'0');
                                borrow=1;
                                result.append(diff);
                            }else{
                                diff=(obj.value.charAt(j)-'0')-(this.value.charAt(i)-'0');
                                result.append(diff);
                                borrow=0;
        
                            }
                        }

                        i--;
                        j--;
                    }
                    result.append('-');
                }
                default -> {
                    diff = 0;
                    result.append(diff);
                }

            }

        } else if ((i + 1) > (j + 1)) {
            while (i >= 0 || j >= 0) {
                dig1 = this.value.charAt(i) - '0';
                dig2 = j >= 0 ? (obj.value.charAt(j) - '0') : 0;

                if (dig1 < dig2) {
                    diff = ((dig1 - borrow) + 10) - dig2;
                    borrow = 1;

                    result.append(diff);
                } else if(dig1>dig2){
                    diff = (dig1 - borrow) - dig2;
                    result.append(diff);
                    borrow = 0;
                }else{
                    if(borrow==1){
                        diff=((dig1-1)+10)-dig2;
                        borrow=1;
                        result.append(diff);
                    }else{
                        diff=dig1-dig2;
                        result.append(diff);
                        borrow=0;

                    }
                }

                i--;
                j--;

            }
        } else {
            while (j >= 0 || i >= 0) {
                dig1 = obj.value.charAt(j) - '0';
                dig2 = i >= 0 ? (this.value.charAt(i) - '0') : 0;

                if (dig1 < dig2) {
                    diff = ((dig1 - borrow) + 10) - dig2;
                    borrow = 1;
                    result.append(diff);
                } else if(dig1>dig2){
                    diff = (dig1 - borrow) - dig2;
                    result.append(diff);
                    borrow = 0;
                }else{
                    if(borrow==1){
                        diff=((dig1-1)+10)-dig2;
                        borrow=1;
                        result.append(diff);
                    }else{
                        diff=dig1-dig2;
                        result.append(diff);
                        borrow=0;

                    }
                }

                i--;
                j--;
            }
            result.append('-');

        }
        String s = result.reverse().toString();
        if (s.charAt(0) == '-') {
            s = s.substring(1);
            s = s.replaceFirst("^0+(?!$)", "");
            result = new StringBuilder(s);
            result.insert(0, '-');
        } else {
            s = s.replaceFirst("^0+(?!$)", "");
            result = new StringBuilder(s);
        }
        return result.toString();
    }

    public String multiply(Ainteger obj) {
        int carry = 0;
        int len1 = this.value.length();
        int len2 = obj.value.length();

        StringBuilder result = new StringBuilder("0");

        int min_len = len1 <= len2 ? len1 : len2;
        int k = min_len - 1;

        if (min_len == len1) {
            while (k >= 0) {
                StringBuilder s1 = new StringBuilder();
                carry = 0;
                for (int i = len2 - 1; i >= 0; i--) {
                    int mul = (this.value.charAt(k) - '0') * (obj.value.charAt(i) - '0') + (carry);
                    s1.append(mul % 10);
                    carry = mul / 10;
                }
                if (carry > 0) {
                    s1.append(carry);
                }
                s1.reverse();

                for (int j = 0; j < (len1 - (k + 1)); j++) {
                    s1.append(0);
                }

                Ainteger obj1 = Ainteger.parse(s1.toString());
                Ainteger obj2 = Ainteger.parse(result.toString());
                result = new StringBuilder(obj1.add(obj2));

                k--;
            }
        } else {
            while (k >= 0) {
                StringBuilder s1 = new StringBuilder();
                carry = 0;
                for (int i = len1 - 1; i >= 0; i--) {
                    int mul = (obj.value.charAt(k) - '0') * (this.value.charAt(i) - '0') + (carry);
                    s1.append(mul % 10);
                    carry = mul / 10;
                }
                if (carry > 0) {
                    s1.append(carry);
                }
                s1.reverse();
                for (int j = 0; j < (len2 - (k + 1)); j++) {
                    s1.append(0);
                }

                Ainteger obj1 = Ainteger.parse(s1.toString());
                Ainteger obj2 = Ainteger.parse(result.toString());
                result = new StringBuilder(obj1.add(obj2));
                k--;
            }
        }
        return result.toString().replaceFirst("^0+(?!$)","");
    }

    public String divide(Ainteger obj) {
        if (obj.value.charAt(0) - '0' == 0) {
            return "Division by zero error";
        }
        if (((this.value.length()) < (obj.value.length()) || (this.value.charAt(0) == '0'))) {
            return "0";
        }
        if (compare(this.value, obj.value) < 0) return "0";
   
        StringBuilder quotient = new StringBuilder();
        String s = "";
        for(int i=0;i<this.value.length();i++){
            s=s+this.value.charAt(i);
            
            s=s.replaceFirst("^0+(?!$)","");
            int count=0;
            
            
            while (compare(s,obj.value)>=0) {
                Ainteger curObj = new Ainteger(s);
                s = curObj.subtract(obj);
                
                count++;
                
                
            }
            quotient.append(count);
        }
        String result = quotient.toString().replaceFirst("^0+(?!$)", "");
        return result.isEmpty()?"0":result;
         

    }

}
 