package homework;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_S3_1244_스위치켜고끄기{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int map[] = new int[n+1];

        String s1[] = br.readLine().split(" ");
        for(int i=0;i<map.length-1;i++){
            map[i+1] = Integer.parseInt(s1[i]);
        }

        int m = Integer.parseInt(br.readLine());

        for(int i=0;i<m;i++){
            String s[] = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            if(x==1){
                for(int j=1;j*y<=n;j++){
                    if( map[j*y] == 1){
                        map[j*y] = 0;
                    }
                    else{
                        map[j*y] = 1;
                    }
                }
            }
            else{
                int index = 0 ;

                while(y-(index+1)>=1 && y+(index+1)<=n){
                    if(map[y-(index+1)]!=map[y+(index+1)]){
                        break;
                    }
                    else{
                        index++;
                    }
                }

                for(int j=y-index;j<=y+index;j++){
                    if(map[j]==0){
                        map[j] = 1;
                    }
                    else{
                        map[j] = 0;
                    }
                }
            }

        }
        
        StringBuilder sb = new StringBuilder(50);
        for(int i=1;i<map.length;i++){
            sb.append(map[i]).append(" ");
            if(i%20==0){
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());

    }

}
