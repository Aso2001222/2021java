import java.util.Scanner;
import java.util.Random;

public class Main{
    public static void main(String[] args){
        //入力値の取得
        Scanner scanner = new Scanner(System.in);

        //必要な変数を作成
        int count = 0;
        int bre = 1;

        //タイトル
        System.out.println("*******************");
        System.out.println("     戦艦ゲーム     ");
        System.out.println("*******************");

        //5:5の配列を作成
        int[][] a = new int[7][7];

        //ターン数
        for(int p = 1; p < 100; p++){
            if(bre == 4){

                Ship ship = new Ship();
                ship.lastdisp();
                break;

            }

            //配列内を0で初期化
            for(int i=1; i<6; i++){
                for(int j = 1; j<6; j++){
                        a[i][j] = 0;
                }
            }

            //ランダムで戦艦の配置  戦艦は1
            if(bre == 1){
                for(int x =0; x<3; x++){
                    Random rnd = new Random();
                    int b = rnd.nextInt(5) + 1;
                    int c = rnd.nextInt(5) + 1;
                    a[b][c] = 1;
                }
            }else if(bre == 2){
                for(int x =0; x<2; x++){
                    Random rnd = new Random();
                    int b = rnd.nextInt(5) + 1;
                    int c = rnd.nextInt(5) + 1;
                    a[b][c] = 1;
                }
            }else if(bre == 3){
                for(int x =0; x<1; x++){
                    Random rnd = new Random();
                    int b = rnd.nextInt(5) + 1;
                    int c = rnd.nextInt(5) + 1;
                    a[b][c] = 1;
                }
            }

            //位置を把握するため
            for(int i=1; i<6; i++){
                for(int j = 1; j<6; j++){
                    if(j !=5){
                        System.out.print(a[i][j]);
                    }else{
                        System.out.print(a[i][j]);
                        System.out.println("");

                    }
                }
            }

            for(int g = 0; g <= 100 ; g++ ){

                //ターン数の表示
                System.out.println("---ターン" + p + "---");

                //X座標とY座標を指定
                System.out.println("X座標を1~5で選んでください")
                String d = scanner.next();
                System.out.println("Y座標を1~5で選んでください")
                String e = scanner.next();

                //String型をint型に変換
                int num1 = Integer.parseInt(d);
                int num2 = Integer.parseInt(e);

                //System.out.println("ここは" + a[num1][num2]);

                //波高しの記述

                if(1 == a[num1][num2] && count == 2){

                    System.out.println("戦艦を" + bre +"艦撃退した。残り" + (3 - bre) + "艦いるぞ");
                    count = 0;
                    bre++;
                    break;

                }else if(1 == a[num1][num2]){

                    Ship ship = new Ship();
                    ship.seconddisp();
                    count++;
                    break;

                }else if(1 == a[num1][num2+1]){

                    System.out.println(a[num1][num2 + 1]);
                    System.out.println("波高し 戦艦はこの列の前にいます");
                    p++;

                }else if(1 == a[num1][num2 - 1]){

                    System.out.println(a[num1][num2 - 1]);
                    System.out.println("波高し 戦艦はこの列の後ろにいます");
                    p++;

                }else if(1 == a[num1 + 1][num2]){

                    System.out.println(a[num1 + 1][num2]);
                    System.out.println("波高し 戦艦はこの行の前にいます");
                    p++;

                }else{

                    System.out.println("敵が周りにいない");
                    p++;
                }
            }
        }
    }
}