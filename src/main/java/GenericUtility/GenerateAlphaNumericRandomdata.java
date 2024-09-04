package GenericUtility;

import org.testng.annotations.Test;

public class GenerateAlphaNumericRandomdata {

    @Test
    public void generateAlphaNumericRandomdata() {

        int n=20;
        String alphaNum="ABCDEFGHIJKLMNOPQRSTUVWYZ123456789abcdefghijklmnopqrstuvwxyz";

        StringBuilder sb=new StringBuilder(n);

        for(int i=0 ; i<n ; i++){

            int index=(int)(alphaNum.length()*Math.random());
            sb.append(alphaNum.charAt(index));
        }

        System.out.println(sb);
    }
}
