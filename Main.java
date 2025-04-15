import java.math.BigInteger;

public class Main{
    public static int cont = 0;
    public static void main(String[] args){

        long startTime = System.nanoTime();
        //int value = fiboRec(32);
        BigInteger[] valueArray = new BigInteger[1001];
        BigInteger value = memoizedFibo(valueArray, 1000);
        long elapsedTime = System.nanoTime() - startTime;

        System.out.println("Counter: " + cont);
        System.out.println("Time Elapsed: " + elapsedTime);
        System.out.println("Fibonacci: " + value.toString());
    }

//     FIBO-REC (n)
//    se n ≤ 1
//    então devolva n
//    senão a ← FIBO-REC (n − 1)
//          b ← FIBO-REC (n − 2)
//          devolva a + b

// n = 4
// Counter: 9
// Time Elapsed: 2024
// Fibonacci: 3

// n = 8
// Counter: 67
// Time Elapsed: 4539
// Fibonacci: 21

// n = 16
// Counter: 3193
// Time Elapsed: 275874
// Fibonacci: 987

//n = 32
// Counter: 7049155
// Time Elapsed: 14989696
// Fibonacci: 2178309
    private static int fiboRec(int n){
        cont++;
        if (n <= 1) return n;
        
        return fiboRec(n - 1) + fiboRec(n - 2);
    }

    //     FIBO (n)
    //      f [0] ← 0 
    //  f [1] ← 1
    //  para i ← 2 até n faça
    //         f[i] ← f[i-1]+f[i-2]
    //  devolva f [n]

    // n = 4
    // Counter: 3
    // Time Elapsed: 2304
    // Fibonacci: 3

    //n = 8;
    //Counter: 7
    // Time Elapsed: 4288
    // Fibonacci: 21

    //n = 16
    // Counter: 7
    // Time Elapsed: 4288
    // Fibonacci: 21

    //n = 32
    // Counter: 31
    // Time Elapsed: 3316
    // Fibonacci: 2178309

    //n = 128
    // Counter: 127
    // Time Elapsed: 338380
    // Fibonacci: 251728825683549488150424261

    //n = 1000
//     Counter: 999
// Time Elapsed: 1345798
// Fibonacci: 43466557686937456435688527675040625802564660517371780402481729089536555417949051890403879840079255169295922593080322634775209689623239873322471161642996440906533187938298969649928516003704476137795166849228875

    //n = 10000
//     Counter: 9999
// Time Elapsed: 9187192
// Fibonacci: 33644764876431783266621612005107543310302148460680063906564769974680081442166662368155595513633734025582065332680836159373734790483865268263040892463056431887354544369559827491606602099884183933864652731300088830269235673613135117579297437854413752130520504347701602264758318906527890855154366159582987279682987510631200575428783453215515103870818298969791613127856265033195487140214287532698187962046936097879900350962302291026368131493195275630227837628441540360584402572114334961180023091208287046088923962328835461505776583271252546093591128203925285393434620904245248929403901706233888991085841065183173360437470737908552631764325733993712871937587746897479926305837065742830161637408969178426378624212835258112820516370298089332099905707920064367426202389783111470054074998459250360633560933883831923386783056136435351892133279732908133732642652633989763922723407882928177953580570993691049175470808931841056146322338217465637321248226383092103297701648054726243842374862411453093812206564914032751086643394517512161526545361333111314042436854805106765843493523836959653428071768775328348234345557366719731392746273629108210679280784718035329131176778924659089938635459327894523777674406192240337638674004021330343297496902028328145933418826817683893072003634795623117103101291953169794607632737589253530772552375943788434504067715555779056450443016640119462580972216729758615026968443146952034614932291105970676243268515992834709891284706740862008587135016260312071903172086094081298321581077282076353186624611278245537208532365305775956430072517744315051539600905168603220349163222640885248852433158051534849622434848299380905070483482449327453732624567755879089187190803662058009594743150052402532709746995318770724376825907419939632265984147498193609285223945039707165443156421328157688908058783183404917434556270520223564846495196112460268313970975069382648706613264507665074611512677522748621598642530711298441182622661057163515069260029861704945425047491378115154139941550671256271197133252763631939606902895650288268608362241082050562430701794976171121233066073310059947366875

    private static BigInteger fiboDP(int n){
        BigInteger[] f = new BigInteger[n+1];
        f[0] = new BigInteger("0");
        f[1] = new BigInteger("1");
        for (int i = 2; i <= n; i++){
            cont++;
            f[i] = f[i-1].add(f[i-2]);
        } 
        return f[n];
    }

//     MEMOIZED-FIBO (f, n)
//  para i ← 0 até n faça
//       f [i] ← −1
//  devolva LOOKUP-FIBO (f, n)

// LOOKUP-FIBO (f, n)
//  se f [n] ≥ 0
//      então devolva f [n]
//  se n ≤ 1
//  então f [n] ← n
//  senão f [n] ← LOOKUP-FIBO(f, n − 1) + LOOKUP-FIBO(f, n − 2)
//  devolva f [n]

//n = 4
// Counter: 1
// Time Elapsed: 399936
// Fibonacci: 3

//n = 8
// Counter: 15
// Time Elapsed: 473964
// Fibonacci: 21

//n = 16
// Counter: 31
// Time Elapsed: 711337
// Fibonacci: 987

//n = 32
// Counter: 63
// Time Elapsed: 914415
// Fibonacci: 2178309

//n = 128
// Counter: 255
// Time Elapsed: 6090276
// Fibonacci: 251728825683549488150424261

//n = 1000
// Counter: 1999
// Time Elapsed: 9890922
// Fibonacci: 43466557686937456435688527675040625802564660517371780402481729089536555417949051890403879840079255169295922593080322634775209689623239873322471161642996440906533187938298969649928516003704476137795166849228875

//n = 10000
//a pilha estora e o programa retorna erro

    private static BigInteger memoizedFibo(BigInteger[] f, int n){
        for (int i = 0; i <= n; i++){
            f[i] = new BigInteger("-1");
        }
        return lookUpFibo(f, n);
    }

    private static BigInteger lookUpFibo(BigInteger[] f, int n){
        cont++;
         if (f[n].compareTo(new BigInteger("-1")) > 0) {
            return f[n];
        }

        if (n <= 1) {
            f[n] = new BigInteger(String.valueOf(n));
        } else {
            f[n] = lookUpFibo(f, n - 1).add(lookUpFibo(f, n - 2));
        }

        return f[n];
    }
}