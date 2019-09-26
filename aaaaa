import java.util.*;

/**
 * Islemler sınıfı içindeki 4 metodun yazılması istenmektedir
 */
public class Islemler {
    /**
     * Yığıtın elemnlarının sırasını tersine çevirir
     * @param s Tersine çevrilecek yığıt
     * @return Tersine çevirlmiş yığıtı döndürür
     */
    public static <T> Stack<T> tersCevir(Stack<T> s){
        Stack<T> sc =(Stack<T>)s.clone();
        Stack<T> f=new Stack<>();
        while(!sc.isEmpty())
            f.push(sc.pop());
        return f;
    }

    /**
     * İki yığıtın eşit olup olmadığını kontrol eder
     * @param s1 Birinci yığıt
     * @param s2 İkinci yığıt
     * @return İki yığıtın eşit olma durumunu döndürür
     */
    public static <T> boolean esit(Stack<T> s1, Stack<T> s2)
    {
        s1.equals(s2);
        Stack<T> news1=(Stack<T>)s1.clone();
        Stack<T> news2=(Stack<T>)s2.clone();
        while (!news1.isEmpty()&&!news2.isEmpty()) {
            if (news1.pop() != news2.pop())
                return false;
        }
        if (news1.isEmpty()&&news2.isEmpty())
            return true;
        return true;
    }

    /**
     * Postfix ifadeyi değerlendirir. İşlemler tamsayılar üzerinde gerçekleşir. "7 5 /" işleminin sonucu 1'dir.
     * @param girdi Girdi ifadesi
     * @return İfadenin sonucu
     */
    public static int postfixDegerlendir(String girdi) {
        Stack<Integer> fstack=new Stack<Integer>();
        String[] gs=girdi.split(" ");
        for (String s:gs){
            if (Character.isDigit(s.charAt(0)))
                fstack.push(Integer.parseInt(s));
            else {
                int d1 = fstack.pop();
                int d2=fstack.pop();
                int sonuc=0;
                switch (s){
                    case"+":
                        sonuc=d1+d2;
                        break;
                    case"-":
                        sonuc=d2-d1;
                        break;
                    case "*":
                        sonuc=d1*d2;
                        break;
                    case"/":
                        sonuc=d2/d1;
                        break;
                    default:
                        System.out.println("Bilinmeyen işlem bulundu!");
                        break;

                }
                fstack.push(sonuc);
            }
        }
        return fstack.pop();
    }

    /**
     * Infix ifadeyi postfix'e dönüştürür.
     * @param girdi Infix girdi metni
     * @return Dönüştürülmüş postfix ifade
     */
    public static String infixToPostfix(String girdi){
        Stack<String>fstack=new Stack<String>();
        Map<String, Integer> precedence=new HashMap<>();
        precedence.put("+",2);
        precedence.put("-",2);
        precedence.put("*",3);
        precedence.put("/",3);
        precedence.put("(",1);
        precedence.put(")",1);
        String[] gs=splitToTokens(girdi);
        String postfix="";
        for(String s:gs){
            if (Character.isDigit(s.charAt(0)))
                postfix+=s+" ";
            else if(s.equals("("))
                fstack.push(s);
            else if(s.equals(")")){
                String f=fstack.pop();
                while(!f.equals("(")) {
                    postfix += f + " ";
                    f = fstack.pop();
                }
            }
            else {
                while (!fstack.isEmpty() && precedence.get(fstack.peek()) > precedence.get(s)) {
                    postfix += fstack.pop() + " ";
                }
                    fstack.push(s);
                
            }
        }
        while(!fstack.isEmpty())
            postfix+=fstack.pop()+" ";
        postfix=postfix.substring(0,postfix.length()-1);
        return postfix;
    }

    /**
     * Infix ifadeyi sembollerine ayıran metod
     * @param girdi Infix ifade
     * @return Sembol dizisi
     */
    private static String[] splitToTokens(String girdi)
    {
        StringTokenizer t=new StringTokenizer(girdi, "+-*/^() ",true);
        List<String> tokenList=new ArrayList<>();
        while (t.hasMoreTokens()){
            String s=t.nextToken().trim();
            if(!s.equals(""))
                tokenList.add(s);
        }
        String [] tl=new String[tokenList.size()];
        tokenList.toArray(tl);
        return tl;
    }
}
