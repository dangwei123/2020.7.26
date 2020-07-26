合法的括号匹配序列被定义为:
1. 空串""是合法的括号序列
2. 如果"X"和"Y"是合法的序列,那么"XY"也是一个合法的括号序列
3. 如果"X"是一个合法的序列,那么"[X]"也是一个合法的括号序列
4. 每个合法的括号序列都可以由上面的规则生成
例如"", "[]", "[][][]", "[[][]]", "[[[[]]]]"都是合法的。
牛牛现在给出一个括号序列s,牛牛允许你执行的操作是:在s的开始和结尾处添加一定数量的左括号('[')或者右括号(']')使其变为一个合法的括号匹配序列。
牛牛希望你能求出添加最少的括号之后的合法的括号匹配序列是什么。

输入包括一个字符串s,s的长度length(1 ≤ length ≤ 50),s中只包含'['和']'。
输出一个字符串,表示括号完全匹配的序列。

import java.util.Scanner;
public class Main{
    public static StringBuilder valid(String str){
        int right=0;
        boolean hasLeft=false;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='['){
                right++;
                hasLeft=true;
            }else if(hasLeft&&right>0){
                right--;
            }
        }
        int left=0;
        boolean hasRight=false;
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)==']'){
                left++;
                hasRight=true;
            }else if(hasRight&&left>0){
                left--;
            }
        }
        StringBuilder sb=new StringBuilder();
        while(left>0){
            sb.append("[");
            left--;
        }
        sb.append(str);
        while(right>0){
            sb.append("]");
            right--;
        }
        return sb;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.next();
            StringBuilder sb=valid(str);
            System.out.println(sb);
        }
    }
}