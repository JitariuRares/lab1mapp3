import java.util.Arrays;
public class Main{
    public static int[]suma(int[]numar1, int[]numar2){
        int c=0;
        int n=numar1.length;
        int[]rezultat = new int[n];
        for(int i=n-1; i>=0; i--){
            int sumaCifrelor=numar1[i]+numar2[i]+c;
            rezultat[i]=sumaCifrelor%10;
            c=sumaCifrelor/10;
        }
        return rezultat;
    }
    public static int[]diferenta(int []numar1, int[] numar2){
        int imprumut=0;
        int n=numar1.length;
        int[] rezultat = new int[n];
        for(int i=n-1; i>=0; i--){
            int difCifre=numar1[i]-numar2[i]-imprumut;
            if(difCifre<0){
                difCifre+=10;
                imprumut=1;
            }else {
                imprumut=0;
            }
            rezultat[i]=difCifre;
        }
        return rezultat;
    }
    public static int[] inmultire(int[]numar, int cifra){
        int n=numar.length;
        int c=0;
        int[]rezultat=new int[n];
        for(int i=n-1; i>=0; i--){
            int produs = numar[i] * cifra+c;
            rezultat[i]=produs%10;
            c=produs/10;
        }
        return rezultat;
    }
    public static int[] impartire(int[] numar, int cifra){
        int n=numar.length;
        int r=0;
        int[] rezultat=new int[n];
        for (int i=0; i<n; i++){
            int curent=r*10+numar[i];
            rezultat[i]=curent/cifra;
            r=curent%cifra;
        }
        return Arrays.copyOfRange(rezultat, 1, rezultat.length);
    }
    public static void testSuma(){
        int[] numar1={1,3,0,0,0,0,0,0,0};
        int[] numar2={8,7,0,0,0,0,0,0,0};
        int[]expected={0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[]result=suma(numar1, numar2);
        assert Arrays.equals(expected, result);

        int[] numar3={1,3,0,0,0,0,0,0,0};
        int[]numar4={0,0,0,0,0,0,0,0,0};
        int[]unexpected={0,0,0,0,0,0,0,0,0};
        int[]resultUnexpected=suma(numar3, numar4);
        assert !Arrays.equals(unexpected, resultUnexpected);
    }
    public static void testDiferenta(){
        int[] numar1={1,3,0,0,0,0,0,0,0};
        int[] numar2={8,7,0,0,0,0,0,0,0};
        int[]expected={2, 5, 0, 0, 0, 0, 0, 0, 0};
        int[]result=diferenta(numar1, numar2);
        assert Arrays.equals(expected, result);

        int[] numar3={1,3,0,0,0,0,0,0,0};
        int[]numar4={0,0,0,0,0,0,0,0,0};
        int[]unexpected={0,0,0,0,0,0,0,0,0};
        int[]resultUnexpected=diferenta(numar3, numar4);
        assert !Arrays.equals(unexpected, resultUnexpected);
    }
    public static void testInmultire(){
        int[] numar1={0,0,0,0,0,0,0,0,9};
        int numar2=2;
        int[]expected={2, 6, 0, 0, 0, 0, 0, 0, 0};
        int[]result=inmultire(numar1, numar2);
        assert Arrays.equals(expected, result);

        int[] numar3={1,3,0,0,0,0,0,0,0};
        int numar4=2;
        int[]unexpected={0,0,0,0,0,0,0,0,0};
        int[]resultUnexpected=inmultire(numar3, numar4);
        assert !Arrays.equals(unexpected, resultUnexpected);
    }
    public static void testImpartire(){
        int[] numar1={1,3,0,0,0,0,0,0,0};
        int numar2=2;
        int[]expected={6, 5, 0, 0, 0, 0, 0, 0};
        int[]result=impartire(numar1, numar2);
        assert Arrays.equals(expected, result);

        int[] numar3={1,3,0,0,0,0,0,0,0};
        int numar4=2;
        int[]unexpected={0,0,0,0,0,0,0,0,0};
        int[]resultUnexpected=inmultire(numar3, numar4);
        assert !Arrays.equals(unexpected, resultUnexpected);
    }
    public static void main(String[] args){
        int[] numar1={1, 3, 0, 0, 0, 0, 0, 0 ,0};
        int[] numar2={8, 7, 0, 0, 0, 0, 0, 0, 0};
        int[]sumaRezultat=suma(numar1, numar2);
        int[]diferentaRezultat=diferenta(numar1, numar2);
        int[]produsRezultat=inmultire(numar1, 2);
        int[]impartireRezultat=impartire(numar1, 2);
        testSuma();
        testDiferenta();
        testInmultire();
        testImpartire();
        System.out.println("Suma: " + Arrays.toString(sumaRezultat));
        System.out.println("Diferenta: " + Arrays.toString(diferentaRezultat));
        System.out.println("Produsul: " + Arrays.toString(produsRezultat));
        System.out.println("Impartirea: " + Arrays.toString(impartireRezultat));

    }
}